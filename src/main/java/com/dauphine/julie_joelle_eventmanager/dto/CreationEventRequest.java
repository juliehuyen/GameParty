package com.dauphine.julie_joelle_eventmanager.dto;

import java.sql.Time;
import java.util.Date;

public class CreationEventRequest {
    String title;
    String description;
    Date eventDate;
    Time eventTime;
    String location;

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
