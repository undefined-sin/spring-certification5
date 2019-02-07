package org.study.spring5.container.customizing;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class CustomizingMain extends StudyApp {

    public static void main(String args[]) {
        // creatingLifeCycles();
        // inferredDestroyBean();
    }

    private static void inferredDestroyBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.registerShutdownHook();
        String location = getXML(CustomizingMain.class, "destroy");
        ctx.setConfigLocation(location);
        ctx.refresh();
        ctx.close();
    }

    private static void creatingLifeCycles() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.registerShutdownHook();
        String location = getXML(CustomizingMain.class, "customizing");
        ctx.setConfigLocation(location);
        ctx.refresh();
        ctx.start();
        ctx.close();
    }
}
