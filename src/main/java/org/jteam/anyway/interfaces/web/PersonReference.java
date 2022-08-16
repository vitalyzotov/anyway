package org.jteam.anyway.interfaces.web;

public class PersonReference {
    private String id;
    private String fistName;
    private String lastName;

    public PersonReference() {
    }

    public PersonReference(String id, String fistName, String lastName) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
    }

    public void setDescription(String description) {
    }
}
