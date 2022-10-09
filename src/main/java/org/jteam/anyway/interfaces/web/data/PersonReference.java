package org.jteam.anyway.interfaces.web.data;

public class PersonReference {
    private String id;
    private String firstName;
    private String lastName;

    public PersonReference() {
    }

    public PersonReference(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
