package org.jteam.anyway.domain.model;

import java.time.LocalDate;
/**
 * личные данные
 */
public class Person {
    /**
     * id
     */
    private PersonId id;
    /**
     * имя
     */
    private String firstName;
    /**
     * день рождение
     */
    private LocalDate birthday;
    /**
     * родной город
     */
    private String hometown;
    /**
     * страна
     */
    private String country;
    /**
     * фотография профиля
     */
    private byte[] photo;
    /**
     * фамилия
     */
    private String lastname;

    public String getName() {
        return lastname;
    }

    public void setName(String name) {
        this.lastname = name;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }
}
