package com.dauphine.julie_joelle_eventmanager.services;

import com.dauphine.julie_joelle_eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.julie_joelle_eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.julie_joelle_eventmanager.entity.Feedback;
import com.dauphine.julie_joelle_eventmanager.entity.Registration;

import java.util.List;
import java.util.UUID;

public interface FeedbackService {
    List<Feedback> getAll();
    Feedback getFeedbackById(UUID feedId);
    Feedback createFeedback(CreationFeedbackRequest feed);
    //update?
    boolean deleteFeedbackById(UUID feedId);
}
