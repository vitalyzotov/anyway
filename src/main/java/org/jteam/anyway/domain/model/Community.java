package org.jteam.anyway.domain.model;

public class Community {
    /**
     * Администратор сообщества
     */
    private PersonId Administrator;
    /**
     * Участники сообщества
     */
    private PersonId Members;
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
        return Administrator;
    }

    public void setAdministrator(PersonId administrator) {
        Administrator = administrator;
    }

    public PersonId getMembers() {
        return Members;
    }

    public void setMembers(PersonId members) {
        Members = members;
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
