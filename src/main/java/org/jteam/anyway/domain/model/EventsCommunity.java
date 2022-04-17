package org.jteam.anyway.domain.model;

import java.time.LocalDate;

public class EventsCommunity {
    /**
     * Дата встречи
     */
    private LocalDate meetingtime;
    /**
     * Учавствующие в мероприятии
     */
    private PersonId membersmetingtime;
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
    private String hmevents;

    public String getHmevents() {
        return hmevents;
    }

    public void setHmevents(String hmevents) {
        this.hmevents = hmevents;
    }

    public LocalDate getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(LocalDate meetingtime) {
        this.meetingtime = meetingtime;
    }

    public PersonId getMembersmetingtime() {
        return membersmetingtime;
    }

    public void setMembersmetingtime(PersonId membersmetingtime) {
        this.membersmetingtime = membersmetingtime;
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
