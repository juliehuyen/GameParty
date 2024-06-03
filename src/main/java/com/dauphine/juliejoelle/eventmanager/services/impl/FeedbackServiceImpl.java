package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.FeedbackNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.FeedbackRepository;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import com.dauphine.juliejoelle.eventmanager.services.FeedbackService;
import com.dauphine.juliejoelle.eventmanager.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserService userService;
    private final EventService eventService;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, UserService userService, EventService eventService) {
        this.feedbackRepository = feedbackRepository;
        this.userService = userService;
        this.eventService = eventService;
    }

    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(String feedId) throws FeedbackNotFoundByIdException {
        return feedbackRepository.findById(feedId)
                .orElseThrow(FeedbackNotFoundByIdException::new);
    }

    @Override
    public Feedback createFeedback(CreationFeedbackRequest feed) {
        //TODO throw exceptions
        User user = userService.getUserById(feed.getUserId());
        Event event = eventService.getEventById(feed.getEventId());
        Feedback feedback = new Feedback(user,event,feed.getRating(),feed.getComments());
        return feedbackRepository.save(feedback);
    }

    @Override
    public boolean deleteFeedbackById(String feedId) {
        if(feedbackRepository.findById(feedId).isPresent()){
            feedbackRepository.deleteById(feedId);
            return true;
        }return false;
    }

    @Override
    public List<Feedback> getFeedbacksByEvent(String eventId) {
        //TODO throw exceptions
        return feedbackRepository.findFeedbacksByEvent_EventId(eventId);
    }
}
