package org.study.spring5.container.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.study.spring5.StudyApp;

@ComponentScan
@Configuration
public class EventsApp extends StudyApp {


    static class LogEvent extends ApplicationEvent {
        public LogEvent(String source) {
            super(source);
        }
    }


    @Component
    class EventLogger implements ApplicationListener<LogEvent> {

        @Override
        public void onApplicationEvent(LogEvent evt) {
            log((String) evt.getSource());
        }
    }

    @Component
    class EventLoggerConfig {

        @EventListener
        public void onApplicationEvent(LogEvent evt) {
            log((String) evt.getSource());
        }
    }


    public static void main(String args[]) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EventsApp.class);
        ctx.publishEvent(new LogEvent("Hello World"));
        ctx.close();
    }
}
