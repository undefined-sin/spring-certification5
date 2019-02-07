package org.study.spring5.container.inheritance;

public class SimpleQueueService extends AbstractService {

    public SimpleQueueService(String url, int port) {
        super(url, port);
    }

    @Override
    public void setQueue(String queue) {
        this.queue = queue;
    }
}
