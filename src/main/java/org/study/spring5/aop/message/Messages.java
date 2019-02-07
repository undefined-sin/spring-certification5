package org.study.spring5.aop.message;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    private List<Message> message = new ArrayList<>();

    public void addMessages(List<Message> messages) {
        this.message.addAll(messages);
    }

    public void addMessage(Message message) {
        this.message.add(message);
    }

    public List<Message> getMessage() {
        return message;
    }
}
