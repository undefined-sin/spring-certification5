package org.study.spring5;

import org.springframework.beans.factory.BeanNameAware;

public class StudyBean implements BeanNameAware {

    protected String name;

    @Override
    public void setBeanName(String s) {
        log(String.format("Creating bean with name <%s>", s));
        this.name = s;
    }

    public String getName() {
        return this.name;
    }

    public void log(String msg, Object ...args) {
        System.out.println(String.format(msg, args));
    }


}
