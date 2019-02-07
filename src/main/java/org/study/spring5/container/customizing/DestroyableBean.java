package org.study.spring5.container.customizing;

import org.study.spring5.StudyBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DestroyableBean extends StudyBean {

    @PostConstruct
    public void init() {
        log("@PostConstruct bean");
    }

    @PreDestroy
    public void destroy() {
        log("@PreDestroy bean");
    }
}
