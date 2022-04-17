package org.jteam.anyway.domain.model;

import java.util.List;

public class Community {
    /**
     * Уникальный код сообщества
     */
    private CommunityId id;
    /**
     * Администратор сообщества
     */
    private PersonId administrator;
    /**
     * Участники сообщества
     */
    private List<PersonId> members;
    /**
     * Фото сообщества
     */
    private byte[] photo;
    /**
     * Описание сообщества
     */
    private String description;
    /**
     * Название сообщества
     */
    private String title;
    /**
     * Тематика сообщества
     */
    private String Subject;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public PersonId getAdministrator() {
        return administrator;
    }

    public void setAdministrator(PersonId administrator) {
        this.administrator = administrator;
    }

    public List<PersonId> getMembers() {
        return members;
    }

    public void setMembers(List<PersonId> members) {
        this.members = members;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
