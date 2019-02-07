package org.study.spring5.container.dependencies;

import org.study.spring5.StudyBean;

public abstract class CommandManager extends StudyBean {


    public void send(String command) {
        DispatcherSource source = getDispatcherSource();
        source.send("Start");
        source.send(command);
        source.send("End");
    }

    protected abstract DispatcherSource getDispatcherSource();
}
