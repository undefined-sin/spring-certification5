package org.study.spring5.container.scopes;

import org.study.spring5.StudyBean;

public class ThreadService extends StudyBean {

    @Override
    public void setBeanName(String s) {
        log(String.format("Creating bean %s from thread %s", s, Thread.currentThread().getName()));
        this.name = s;
    }

    public void displayThread() {
        log("Thread: " + Thread.currentThread().getName());
    }
}
