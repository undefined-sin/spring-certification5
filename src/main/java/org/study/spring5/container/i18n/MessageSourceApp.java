package org.study.spring5.container.i18n;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.study.spring5.StudyApp;
import org.study.spring5.StudyBean;

import java.time.LocalDate;
import java.util.Locale;

@ComponentScan
@Configuration
public class MessageSourceApp extends StudyApp {


    @Configuration
    class BundleConfig extends StudyBean {

        @Bean
        public ResourceBundleMessageSource messageSource() {
            ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
            bundle.setBasenames("spring5/container/i18n/application");
            bundle.setFallbackToSystemLocale(false);
            return bundle;
        }

    }


    public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MessageSourceApp.class);
        ctx.refresh();
        log(ctx.getMessage("title", new Object[]{LocalDate.now()}, Locale.GERMAN));
        ctx.close();
    }
}
