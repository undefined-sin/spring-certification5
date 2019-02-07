package org.study.spring5.container.overview;

import org.study.spring5.StudyBean;

public class HelloWorldService extends StudyBean {

    private NestedBeanService nested;

    public static class NestedBeanService {
        public NestedBeanService() {
        }
    }


    public void setNested(NestedBeanService nested) {
        this.nested = nested;
    }


    public String getMessage() {
        return getMessage(this.name);
    }


    private String getMessage(String name) {
        return String.format("Hello, world from %s.", name);
    }

    public static HelloWorldService factoryMethod(){
        return new HelloWorldService();
    }


}
