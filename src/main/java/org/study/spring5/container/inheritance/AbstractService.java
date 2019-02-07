package org.study.spring5.container.inheritance;

import org.study.spring5.StudyBean;

public abstract class AbstractService extends StudyBean {
    protected String queue;
    private String url;
    private int port;

    public AbstractService(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void postToQueue(String msg){
        log("Posting message %s to queue %s:%s/%s", msg, this.url, this.port, this.queue);
    }
    // Loads queue name from some imaginary location.
    public abstract void setQueue(String queue);
}
