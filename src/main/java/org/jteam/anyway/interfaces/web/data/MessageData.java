package org.jteam.anyway.interfaces.web.data;

import org.jteam.anyway.domain.model.MessageId;
import org.jteam.anyway.domain.model.MessageType;
import org.jteam.anyway.domain.model.PersonId;

import java.time.Instant;

public class MessageData {
    private String messageId;

    /**
     *
     */
    private String authorId;

    /**
     *
     */
    private char messageType;

    /**
     *
     */
    private Instant created;

    /**
     *
     */
    private String recipientId;

    /**
     *
     */
    private String text;

    public MessageData(String messageId, String authorId, char messageType, Instant created, String recipientId, String text) {
        this.messageId = messageId;
        this.authorId = authorId;
        this.messageType = messageType;
        this.created = created;
        this.recipientId = recipientId;
        this.text = text;
    }

    public MessageData() {

    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public char getMessageType() {
        return messageType;
    }

    public void setMessageType(char messageType) {
        this.messageType = messageType;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthorId(PersonId authorId) {
    }
}
