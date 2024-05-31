package com.dauphine.juliejoelle.eventmanager.dto;

import java.sql.Time;
import java.util.Date;

public class CreationEventRequest {
    private String title;
    private String description;
    private Date eventDate;
    private Time eventTime;
    private String location;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public String getLocation() {
        return location;
    }
}
