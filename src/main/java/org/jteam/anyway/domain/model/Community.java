package org.jteam.anyway.domain.model;

import java.util.List;
import java.util.Objects;

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
    private String subject;

    /**
     * Список мероприятий сообщества
     */
    private List<EventCommunity> events;

    public Community(CommunityId id) {
        Objects.requireNonNull(id, "Community ID is required");
        this.id = id;
    }

    public Community(
            CommunityId id,
            String description,
            String title,
            String subject,
            PersonId administrator,
            List<PersonId> members,
            List<EventCommunity> events,
            byte[] photo
    ) {


        this(id);
        Objects.requireNonNull(administrator, "Administrator is required");
        this.administrator = administrator;
        this.members = members;
        this.photo = photo;
        this.description = description;
        this.title = title;
        this.subject = subject;
        this.events = events;
    }

    public List<EventCommunity> getEvents() {
        return events;
    }

    public void setEvents(List<EventCommunity> events) {
        this.events = events;
    }

    public CommunityId getId() {
        return id;
    }

    public void setId(CommunityId id) {
        this.id = id;
    }

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
        return subject;
    }

    public void setSubject(String subject) {
        subject = subject;
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
