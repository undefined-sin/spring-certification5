package org.study.spring5.aop.flow;

public class DefaultBusinessRequest<T> extends SystemMessage<BusinessContext, T> implements BusinessRequest<T> {

    public DefaultBusinessRequest(BusinessContext ctx, T payload) {
        super(ctx, payload);
    }

    public static <E> DefaultBusinessRequest<E> of(BusinessContext ctx, E payload) {
        return new DefaultBusinessRequest(ctx, payload);
    }


}
