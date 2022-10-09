package org.jteam.anyway.interfaces.web.data;

import org.jteam.anyway.domain.model.PersonId;

import java.util.List;

public class CommunityData {

    private String id;

    private String title;

    private String description;

    private PersonId administrator;

    private List<PersonId> members;

    public CommunityData() {
        this.id = id;
        this.title = title;
        this.description = description;
        this.administrator = administrator;
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonId getAdministrator() {
        return administrator;
    }

    public void setAdministrator(PersonId administrator) {
        this.administrator = administrator;
    }

    public java.util.List<PersonId> getMembers() {
        return members;
    }

    public void setMembers(java.util.List<PersonId> members) {
        this.members = members;
    }
}
