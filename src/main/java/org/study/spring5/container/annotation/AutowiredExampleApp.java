package org.study.spring5.container.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class AutowiredExampleApp extends StudyApp {


    public static void main(String... args) {
        //exampleAutowiredAndInject();
        //exampleAutowirePrimary();
        exampleCustomAutowireConfigurer();
    }

    private static void exampleCustomAutowireConfigurer() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.setConfigLocations(getXML(AutowiredExampleApp.class, "custom-autowired"));
        ctx.refresh();
        YetAnotherMovieFinder f = ctx.getBean("finder", YetAnotherMovieFinder.class);
        f.list();
        ctx.close();

    }

    private static void exampleAutowirePrimary() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.setConfigLocations(getXML(AutowiredExampleApp.class, "primary-autowired"));
        ctx.refresh();
        AnotherMovieFinder finder = ctx.getBean(AnotherMovieFinder.class);
        finder.listMovies();
        ctx.close();
    }

    private static void exampleAutowiredAndInject() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.setConfigLocations(getXML(AutowiredExampleApp.class, "annotation-autowired"));
        ctx.refresh();
        MovieFinder finder = ctx.getBean(MovieFinder.class);
        finder.listMovies();
        ctx.close();
    }
}
