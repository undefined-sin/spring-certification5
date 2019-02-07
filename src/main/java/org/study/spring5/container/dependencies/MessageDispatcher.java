package org.study.spring5.container.dependencies;

import org.study.spring5.StudyBean;

import java.util.ArrayList;
import java.util.List;

public class MessageDispatcher extends StudyBean {


    private List<DispatcherSource> sources = new ArrayList<>();


    public MessageDispatcher(DispatcherSource source) {
        this.sources.add(source);
    }

    public MessageDispatcher(List<DispatcherSource> sources) {
        this.sources.addAll(sources);
    }


    public void send(String msg) {
        String location = String.format("Originator bean: %s, sending payload [%s]", getName(), msg);
        sources.forEach(source -> source.send(location));
    }
}
