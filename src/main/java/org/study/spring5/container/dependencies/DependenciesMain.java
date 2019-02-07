package org.study.spring5.container.dependencies;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class DependenciesMain extends StudyApp {

    public static void main(String[] args) {
        // autowiringExample();
        methodInjectionExample();
    }

    private static void methodInjectionExample() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        String location = getXML(DependenciesMain.class, "methodInjection");
        ctx.setConfigLocation(location);
        ctx.refresh();
        // ApplicationContext aware command manager.
        CommandManager cmd = ctx.getBean("simpleCommandManager", CommandManager.class);
        cmd.send("Hello world");
        cmd.send("Another hello world...");

        // Lookup method based example.
        CommandManager cmd2 = ctx.getBean("lookupCmd", CommandManager.class);
        cmd2.send("Hello world from lookup based.");

        ctx.close();
    }

    private static void autowiringExample() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        String location = getXML(DependenciesMain.class, "autowiring");
        ctx.setConfigLocation(location);
        ctx.refresh();

        MessageDispatcher bean = ctx.getBean("messageDispatcher", MessageDispatcher.class);
        MessageDispatcher bean2 = ctx.getBean("messageDispatcher2", MessageDispatcher.class);
        bean.send("Hello");
        bean2.send("World");

        ctx.close();
    }


}
