package org.study.spring5.container.inheritance;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

public class BeanInheritanceMain extends StudyApp {

    public static void main(String[] args) {
        creatingTemplateHierarchyBeans();
    }

    private static void creatingTemplateHierarchyBeans() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.registerShutdownHook();
        String location = getXML(BeanInheritanceMain.class, "inheritance");
        ctx.setConfigLocation(location);
        ctx.refresh();

        AbstractService service = ctx.getBean("simpleQueue", AbstractService.class);
        AbstractService service2 = ctx.getBean("simpleQueue2", AbstractService.class);
        service.postToQueue("Hello world");
        service2.postToQueue("Hello world");

        ctx.close();
    }
}
