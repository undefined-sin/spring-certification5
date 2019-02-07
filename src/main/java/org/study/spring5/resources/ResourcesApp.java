package org.study.spring5.resources;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class ResourcesApp extends StudyApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.setConfigLocations(getXML(ResourcesApp.class, "resources"));
        ctx.refresh();
        PoemLoader loader = ctx.getBean("poems", PoemLoader.class);
        loader.printContent();
        ctx.close();
        ctx.close();
    }
}
