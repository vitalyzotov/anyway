package org.jteam.anyway.domain.model;

import java.time.Instant;

public class Message {

    /**
     *
     */
    private MessageId messageId;

    /**
     *
     */
    private PersonId authorId;

    /**
     *
     */
    private MessageType messageType;

    /**
     *
     */
    private Instant created;

    /**
     *
     */
    private PersonId recipientId;

    /**
     *
     */
    private String text;

    /**
     *
     */
    private byte[] data;


    public MessageId getMessageId() {
        return messageId;
    }

    public void setMessageId(MessageId messageId) {
        this.messageId = messageId;
    }

    public PersonId getAuthorId() {
        return authorId;
    }

    public void setAuthorId(PersonId authorId) {
        this.authorId = authorId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public PersonId getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(PersonId recipientId) {
        this.recipientId = recipientId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
