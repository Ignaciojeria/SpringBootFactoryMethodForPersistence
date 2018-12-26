package com.example.persistencefactory.domain;


import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Event {

    private LocalDateTime localDateTime;

    private String eventDescription;

    private String classNameEvent;

    private Long eventId;

    public Event(){}

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getClassNameEvent() {
        return classNameEvent;
    }

    public void setClassNameEvent(String classNameEvent) {
        this.classNameEvent = classNameEvent;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }


}
