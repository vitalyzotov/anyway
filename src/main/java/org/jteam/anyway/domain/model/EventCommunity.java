package org.jteam.anyway.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class EventCommunity {

    /**
     * Дата и время встречи
     */
    private LocalDateTime meetingTime;


    /**
     * Участники мероприятия
     */
    private List<PersonId> members;


    /**
     * Название мероприятия
     */
    private String title;

    /**
     * Описание мероприятия
     */
    private String description;

    /**
     * Сколько всего мероприятий на данный момент
     * Такое же поле есть в Community
     */
    private List<String> hmevents;

    public EventCommunity(
            LocalDateTime meetingTime,
            List<PersonId> members,
            String title,
            String description,
            List<String> hmevents
    ){

        Objects.requireNonNull(title,"title is required");
        Objects.requireNonNull(description, "description is required");
        this.meetingTime = meetingTime;
        this.members = members;
        this.title = title;
        this.description = description;
        this.hmevents = hmevents;
    }

    public List<PersonId> getMembers() {
        return members;
    }

    public void setMembers(List<PersonId> members) {
        this.members = members;
    }

    public List<String> getHmevents() {
        return hmevents;
    }

    public void setHmevents(List<String> hmevents) {
        this.hmevents = hmevents;
    }

    public LocalDateTime getMeetingtime() {
        return meetingTime;
    }

    public void setMeetingtime(LocalDateTime meetingtime) {
        this.meetingTime = meetingtime;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
