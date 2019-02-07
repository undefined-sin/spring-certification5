package org.study.spring5.container.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.study.spring5.StudyApp;

import java.util.stream.IntStream;

public class ScopesMain extends StudyApp {

    public static void main(String args[]) {
        customScope();
    }

    private static void customScope() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        String location = getXML(ScopesMain.class, "customScope");
        ctx.setConfigLocations(location);
        ctx.refresh();

        IntStream.range(0, 10)
                .parallel()
                .boxed()
                .map(e -> ctx.getBean(ThreadService.class))
                .forEach(ThreadService::displayThread);


        ctx.close();
    }
}
