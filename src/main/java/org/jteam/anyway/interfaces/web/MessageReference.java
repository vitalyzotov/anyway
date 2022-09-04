package org.jteam.anyway.interfaces.web;

import org.jteam.anyway.domain.model.MessageId;
import org.jteam.anyway.domain.model.PersonId;

public class MessageReference {
    
    private String messageid;
    
    private String text;
    
    private String authorid;

    public MessageReference(String messageid, String text, String authorid) {
        this.messageid = messageid;
        this.text = text;
        this.authorid = authorid;
    }

    public MessageReference() {
        
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

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public void setAuthorId(PersonId authorId) {
    }

    public void setMessageid(MessageId messageId) {

    }
}
