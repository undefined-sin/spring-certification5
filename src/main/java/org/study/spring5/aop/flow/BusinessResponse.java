package org.study.spring5.aop.flow;

import org.study.spring5.aop.message.Messages;

public interface BusinessResponse<T> {

    T getPayload();

    Messages getMessages();
}
