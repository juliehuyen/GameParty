package com.dauphine.juliejoelle.eventmanager.dto;

import java.util.Date;
import java.util.UUID;

public class CreationRegistrationRequest {
    private String userId;
    private String eventId;
    private Date registrationDate;

    public String getUserId() {
        return userId;
    }

    public String getEventId() {
        return eventId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
}
