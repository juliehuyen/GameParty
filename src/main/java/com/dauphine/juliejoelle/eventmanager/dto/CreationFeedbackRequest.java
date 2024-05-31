package com.dauphine.juliejoelle.eventmanager.dto;

import java.util.UUID;

public class CreationFeedbackRequest {
    private String userId;
    private String eventId;
    private int rating;
    private String comments;

    public String getUserId() {
        return userId;
    }

    public String getEventId() {
        return eventId;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }
}
