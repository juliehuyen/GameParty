package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import com.dauphine.juliejoelle.eventmanager.exceptions.FeedbackNotFoundByIdException;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAll();
    Feedback getFeedbackById(String feedId) throws FeedbackNotFoundByIdException;
    Feedback createFeedback(CreationFeedbackRequest feed);
    //update?
    boolean deleteFeedbackById(String feedId) throws FeedbackNotFoundByIdException;

    List<Feedback> getFeedbacksByEvent(String eventId);
}
