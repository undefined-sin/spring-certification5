package org.study.spring5.container.dependencies;

import org.study.spring5.StudyBean;

public class DispatcherSource extends StudyBean {

    public void send(String m){
        log(String.format("Dispatching message %s to source %s", m, getName()));
    }
}
