package org.jteam.anyway.domain.model;

import java.util.List;

public class Community {
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
    private CommunityId description;
    /**
     * Название сообщества
     */
    private CommunityId title;
    /**
     * Тематика сообщества
     */
    private CommunityId Subject;

    public CommunityId getTitle() {
        return title;
    }

    public void setTitle(CommunityId title) {
        this.title = title;
    }

    public CommunityId getSubject() {
        return Subject;
    }

    public void setSubject(CommunityId subject) {
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

    public CommunityId getDescription() {
        return description;
    }

    public void setDescription(CommunityId description) {
        this.description = description;
    }
}
