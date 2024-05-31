package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAll();
    Feedback getFeedbackById(String feedId);
    Feedback createFeedback(CreationFeedbackRequest feed);
    //update?
    boolean deleteFeedbackById(String feedId);

    List<Feedback> getFeedbacksByEvent(String eventId);
}
