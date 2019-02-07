package org.study.spring5.container.overview;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class OverviewMain extends StudyApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();

        String location = getXML(OverviewMain.class, "creatingBeans");
        ctx.setConfigLocation(location);
        ctx.refresh();

        HelloWorldService helloService = ctx.getBean("helloService", HelloWorldService.class);
        System.out.println(helloService.getMessage());
        ctx.close();
    }
}
