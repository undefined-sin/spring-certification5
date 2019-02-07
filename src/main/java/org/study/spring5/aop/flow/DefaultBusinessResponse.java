package org.study.spring5.aop.flow;

import org.study.spring5.aop.message.Message;
import org.study.spring5.aop.message.Messages;
import org.study.spring5.aop.message.SystemMessage;

public class DefaultBusinessResponse<T> extends SystemMessage<T> implements BusinessResponse<T> {

    private final Messages messages;

    public DefaultBusinessResponse(T payload) {
        super(payload);
        this.messages = new Messages();
    }

    @Override
    public Messages getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.addMessage(message);
    }

    public static <E> DefaultBusinessResponse of(E payload) {
        return new DefaultBusinessResponse(payload);
    }
}
