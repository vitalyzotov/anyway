package org.jteam.anyway.interfaces.web;

import java.time.Instant;

public class MessageReference {
    
    private String messageid;
    
    private String text;
    
    private String authorId;

    private Instant created;

    private String recipientId;

    public MessageReference(String messageid, String text, String authorId, Instant created, String recipientId) {
        this.messageid = messageid;
        this.text = text;
        this.authorId = authorId;
        this.created = created;
        this.recipientId = recipientId;
    }

    public MessageReference() {
        
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
