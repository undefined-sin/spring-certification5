package org.study.spring5.container.beanfactory;

import org.springframework.stereotype.Component;
import org.study.spring5.StudyBean;

@Component
class AnotherBean extends StudyBean {


    public void print() {
        log("Hi there.");
    }
}
