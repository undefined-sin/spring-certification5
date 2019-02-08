package org.study.spring5.aop.flow;

public class SystemMessage<CONTEXT, T> {

    private final T payload;
    private final CONTEXT ctx;

    public SystemMessage(CONTEXT ctx, T payload) {
        this.ctx = ctx;
        this.payload = payload;
    }

    public T getPayload() {
        return this.payload;
    }

    public CONTEXT getContext() {
        return ctx;
    }

}
