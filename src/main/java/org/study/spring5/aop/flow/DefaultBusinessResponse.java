package org.study.spring5.aop.flow;

import org.study.spring5.aop.message.Message;
import org.study.spring5.aop.message.Messages;

public class DefaultBusinessResponse<T> extends SystemMessage<BusinessContext, T> implements BusinessResponse<T> {

    private final Messages messages;

    public DefaultBusinessResponse(BusinessContext ctx, T payload) {
        super(ctx, payload);
        this.messages = new Messages();
    }

    @Override
    public Messages getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.addMessage(message);
    }

    public static <E> DefaultBusinessResponse<E> of(BusinessContext ctx, E payload) {
        return new DefaultBusinessResponse(ctx, payload);
    }
}
