package org.jteam.anyway.domain.model;

import java.util.UUID;

public class MessageId {

    private final String value;


    public MessageId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MessageId nextId() {
        return new MessageId(UUID.randomUUID().toString());
    }


    public String getMessageId() {
        return value;
    }
}
