package org.jteam.anyway.domain.model;

import java.time.LocalDate;
import java.util.List;

public class EventsCommunity {
    /**
     * Дата встречи
     */
    private LocalDate meetingtime;
    /**
     * Учавствующие в мероприятии
     */
    private List<PersonId> membersmetingtime;
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

    public List<PersonId> getMembersmetingtime() {
        return membersmetingtime;
    }

    public void setMembersmetingtime(List<PersonId> membersmetingtime) {
        this.membersmetingtime = membersmetingtime;
    }

    public List<String> getHmevents() {
        return hmevents;
    }

    public void setHmevents(List<String> hmevents) {
        this.hmevents = hmevents;
    }

    public LocalDate getMeetingtime() {
        return meetingtime;
    }

    public void setMeetingtime(LocalDate meetingtime) {
        this.meetingtime = meetingtime;
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
