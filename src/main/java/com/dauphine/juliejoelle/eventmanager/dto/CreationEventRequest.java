package com.dauphine.juliejoelle.eventmanager.dto;

import java.sql.Time;
import java.util.Date;

public class CreationEventRequest {
    private String title;
    private String description;
    private Date eventDate;
    private String location;
    private String categoryId;
    private String typeId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getTypeId() {
        return typeId;
    }
}
