package org.study.spring5.aop.message;

public class SystemMessage<T> {

    private final T payload;

    public SystemMessage(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return this.payload;
    }

}
