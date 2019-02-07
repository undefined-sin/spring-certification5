package org.study.spring5.aop.message;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    private List<Message> messages = new ArrayList<>();

    public void addMessages(List<Message> messages) {
        this.messages.addAll(messages);
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public boolean hasMessages() {
        return !messages.isEmpty();
    }

    public Message getHighestPriority() {
        return messages.get(0);
    }
}
