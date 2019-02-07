package org.study.spring5.container.pureannotation;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.study.spring5.StudyApp;

import javax.annotation.Resource;

@Configuration
@ComponentScan
public class InjectionPointApp extends StudyApp {

    class MyService {

    }

    @Component
    public class BeanConfig {

        @Resource
        private MyService myService;

        @Bean
        @Scope(BeanDefinition.SCOPE_PROTOTYPE)
        MyService myService2(InjectionPoint p) {
            return new MyService();
        }
    }

    public static void main(String[] args) {
        injectionPointExample();
    }

    private static void injectionPointExample() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(InjectionPointApp.class);
        ctx.close();
    }
}
