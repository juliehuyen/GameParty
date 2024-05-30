package com.dauphine.julie_joelle_eventmanager.dto;

import java.util.UUID;

public class CreationFeedbackRequest {
    UUID userId;
    UUID eventId;
    int rating;
    String comments;
}
