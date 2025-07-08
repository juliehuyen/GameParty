package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.FeedbackNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAll();
    Feedback getFeedbackById(String feedId) throws FeedbackNotFoundByIdException;
    Feedback createFeedback(CreationFeedbackRequest feed) throws EventNotFoundByIdException, UserNotFoundByIdException;
    //update?
    void deleteFeedbackById(String feedId) throws FeedbackNotFoundByIdException;

    List<Feedback> getFeedbacksByEvent(String eventId) throws EventNotFoundByIdException;
    Feedback getFeedbackByUserAndEvent(String userId, String eventId) throws UserNotFoundByIdException, EventNotFoundByIdException;
}
