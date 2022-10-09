package org.jteam.anyway.interfaces.web.data;

import org.jteam.anyway.domain.model.PersonId;

import java.time.LocalDate;

public class PersonData {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String hometown;
    private String country;

    public PersonData() {
    }

    public PersonData(String id, String firstName, String lastName, LocalDate birthday, String hometown, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.hometown = hometown;
        this.country = country;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
