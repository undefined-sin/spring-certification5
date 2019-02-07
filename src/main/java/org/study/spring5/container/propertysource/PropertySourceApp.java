package org.study.spring5.container.propertysource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.study.spring5.StudyApp;
import org.study.spring5.StudyBean;

@ComponentScan
@Configuration
@PropertySource("classpath:spring5/container/propertysource/index.properties")
public class PropertySourceApp extends StudyApp {


    @Configuration
    class BundleConfig extends StudyBean {

        @Autowired
        private Environment env;

        @Autowired
        public void printEnvironment() {
            log(env.getProperty("title"));
        }

    }


    public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PropertySourceApp.class);
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.refresh();
        ctx.close();
    }
}
