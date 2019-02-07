package org.study.spring5.container.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.study.spring5.StudyApp;
import org.study.spring5.StudyBean;

import java.util.Set;

@Configuration
public class BeanFactoryApp extends StudyApp {


    @Autowired
    private AnotherBean bean;

    @Configuration
    public class Teste extends StudyBean {
        Teste() {
            log("test");
        }
    }


    public static void main(String[] args) {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();

        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setBeanFactory(bf);
        bf.addBeanPostProcessor(beanPostProcessor);

        ClassPathScanningCandidateComponentProvider scan = new ClassPathScanningCandidateComponentProvider(true);


        Set<BeanDefinition> candidates = scan.findCandidateComponents(BeanFactoryApp.class.getPackage().getName());
        candidates.stream().forEach(b -> {
            log("Registering %s", b);
            BeanNameGenerator gen = new DefaultBeanNameGenerator();
            bf.registerBeanDefinition(gen.generateBeanName(b, bf), b);
        });

        ConfigurationClassPostProcessor cfgPostProcessor = new ConfigurationClassPostProcessor();
        cfgPostProcessor.postProcessBeanDefinitionRegistry(bf);
        cfgPostProcessor.postProcessBeanFactory(bf);

        BeanFactoryApp app = bf.getBean(BeanFactoryApp.class);
        Teste teste = bf.getBean(Teste.class);
        app.bean.print();


    }
}
