package org.study.spring5.aop.flow;

import org.study.spring5.aop.message.SystemMessage;

public class DefaultBusinessRequest<T> extends SystemMessage<T> implements BusinessRequest<T> {

    private final BusinessContext ctx;

    public DefaultBusinessRequest(BusinessContext ctx, T payload) {
        super(payload);
        this.ctx = ctx;
    }

    public static <E> DefaultBusinessRequest of(BusinessContext ctx, E payload) {
        return new DefaultBusinessRequest(ctx, payload);
    }

    public BusinessContext getContext() {
        return ctx;
    }
}
