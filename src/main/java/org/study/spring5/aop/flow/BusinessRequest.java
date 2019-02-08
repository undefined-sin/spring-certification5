package org.study.spring5.aop.flow;

public interface BusinessRequest<T> {
    T getPayload();

    BusinessContext getContext();
}
