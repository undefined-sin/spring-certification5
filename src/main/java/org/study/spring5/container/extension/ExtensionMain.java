package org.study.spring5.container.extension;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class ExtensionMain extends StudyApp {

    public static void main(String args[]) {
        //beanPostProcessorExample();
        beanFactoryPostProcessorExample();
        //factoryBeanExample();
    }

    private static void factoryBeanExample() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.registerShutdownHook();
        String location = getXML(ExtensionMain.class, "factory-bean");
        ctx.setConfigLocation(location);
        ctx.refresh();
        Credentials c = ctx.getBean("secret3", Credentials.class);
        log("password: " + String.valueOf(c.getPassword()));
        ctx.close();
    }

    private static void beanFactoryPostProcessorExample() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.registerShutdownHook();
        String location = getXML(ExtensionMain.class, "factory-extension");
        ctx.setConfigLocation(location);
        ctx.refresh();
        Credentials c = ctx.getBean("secret2", Credentials.class);
        log("password: " + String.valueOf(c.getPassword()));
        ctx.start();
        ctx.close();
    }

    private static void beanPostProcessorExample() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.registerShutdownHook();
        String location = getXML(ExtensionMain.class, "extension");
        ctx.setConfigLocation(location);
        ctx.refresh();
        Credentials c = ctx.getBean("secret2", Credentials.class);
        log("password: " + String.valueOf(c.getPassword()));
        ctx.close();
    }

}
