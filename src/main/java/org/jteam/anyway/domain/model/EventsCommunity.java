package org.jteam.anyway.domain.model;

import java.time.LocalDate;
import java.util.List;

// TODO: класс представляет собой ОДНО мероприятие, поэтому должен называться в единственном числе - Event
// TODO: если уж хочется делать упор на то, что это мероприятие СООБЩЕСТВА, то тогда назвать CommunityEvent
public class EventsCommunity {

    /**
     * Дата и время встречи
     */
    // TODO: каждое слово с заглавной буквы. Поэтому переименовать в meetingTime.
    // TODO: так как нужно хранить не только дату, но и время, то использовать тип LocalDateTime
    private LocalDate meetingtime;

    /**
     * Участники мероприятия
     */
    // TODO: переименовать просто в members
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
    // TODO: не имеет смысла. удалить поле.
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
