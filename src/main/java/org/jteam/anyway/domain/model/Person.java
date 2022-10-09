package org.jteam.anyway.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * личные данные
 */
public class Person {
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
    private String mobilePhone;

    /**
     * Образование
     */
    private String education;

    /**
     * Хеш пароля
     */
    private String password;

    public Person(PersonId id) {
        Objects.requireNonNull(id, "Person ID is required");
        this.id = id;
    }

    public Person(PersonId id,
                  String password,
                  String firstName,
                  String lastName,
                  LocalDate birthday,
                  String country,
                  String hometown,
                  String mobilePhone,
                  String education,
                  String placeOfWork,
                  List<String> languages,
                  byte[] photo
    ) {
        this(id);
        Objects.requireNonNull(password, "Password hash required");
        Objects.requireNonNull(firstName, "First name is required");
        Objects.requireNonNull(lastName, "Last name is required");
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.hometown = hometown;
        this.country = country;
        this.photo = photo;
        this.placeOfWork = placeOfWork;
        this.languages = languages;
        this.mobilePhone = mobilePhone;
        this.education = education;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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

}
