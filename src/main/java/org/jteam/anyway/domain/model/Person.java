package org.jteam.anyway.domain.model;

import javax.print.DocFlavor;
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
     * Имя
     */
    private String firstName;
    /**
     * День рождение
     */
    private LocalDate birthday;
    /**
     * Родной город
     */
    private String hometown;
    /**
     * Страна
     */
    private String country;
    /**
     * Фотография профиля
     */
    private byte[] photo;
    /**
     * Фамилия
     */
    private String lastname;
    /**
     * Место работы
     */
    private String placeofwork;
    /**
     * Языки
     */
    private String languages;
    /**
     * Моб. телефон
     */
    private String mobilephone;
    /**
     * Образование
     */
    private String education;
    /**
     * Группы
     */
    private String groups;


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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPlaceofwork() {
        return placeofwork;
    }

    public void setPlaceofwork(String placeofwork) {
        this.placeofwork = placeofwork;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}
