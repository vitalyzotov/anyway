package org.jteam.anyway.domain.model;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.List;

/**
 * личные данные
 */
public class Person {

    /**
     * Список событий
     */
    private List<EventsCommunity> events;

    /**
     * Идентификатор
     */
    private PersonId id;

    /**
     * Имя
     */
    private String firstName;

    /**
     * Дата рождения
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
    private String lastName;

    /**
     * Место работы
     */
    private String placeOfWork;

    /**
     * Языки
     */
    private List<String> languages;

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
    private List<CommunityId> groups;

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

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getEducation() {
        return education;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<CommunityId> getGroups() {
        return groups;
    }

    public void setGroups(List<CommunityId> groups) {
        this.groups = groups;
    }

    public List<EventsCommunity> getEvents() {
        return events;
    }

    public void setEvents(List<EventsCommunity> events) {
        this.events = events;
    }
}
