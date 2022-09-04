package org.jteam.anyway.domain.model;

import java.time.Instant;
import java.util.Objects;

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

    public Message(MessageId id) {
        Objects.requireNonNull(id, "MessageId is required");
        this.messageId = id;
    }

    public Message(MessageId id,
                   PersonId authorId,
                   MessageType messageType,
                   Instant created,
                   PersonId recipientId,
                   String text,
                   byte[] data
    ) {
        this(id);
        this.authorId = authorId;
        this.messageType = messageType;
        this.created = created;
        this.recipientId = recipientId;
        this.text = text;
        this.data = data;
    }

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

    public void setMessageId(String messageId) {
    }
}
