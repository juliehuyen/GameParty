package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.FeedbackNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.FeedbackRepository;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import com.dauphine.juliejoelle.eventmanager.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FeedbackServiceImplTest {
    @Mock
    private FeedbackRepository feedbackRepository;

    @Mock
    private UserService userService;

    @Mock
    private EventService eventService;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Feedback> expectedFeedbacks = Arrays.asList(new Feedback(), new Feedback());
        when(feedbackRepository.findAll()).thenReturn(expectedFeedbacks);

        List<Feedback> actualFeedbacks = feedbackService.getAll();

        assertEquals(expectedFeedbacks, actualFeedbacks);
    }

    @Test
    void testGetFeedbackById() throws FeedbackNotFoundByIdException {
        String feedbackId = "feed123";
        Feedback expectedFeedback = new Feedback();
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(expectedFeedback));

        Feedback actualFeedback = feedbackService.getFeedbackById(feedbackId);

        assertEquals(expectedFeedback, actualFeedback);
    }

    @Test
    void testGetFeedbackById_NotFound() {
        String feedbackId = "feed123";
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.empty());

        assertThrows(FeedbackNotFoundByIdException.class, () -> feedbackService.getFeedbackById(feedbackId));
    }

    @Test
    void testDeleteFeedbackById() throws FeedbackNotFoundByIdException {
        String feedbackId = "feed123";
        Feedback feedback = new Feedback();
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(feedback));

        feedbackService.deleteFeedbackById(feedbackId);
    }

    @Test
    void testDeleteFeedbackById_NotFound() {
        String feedbackId = "feed123";
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.empty());

        assertThrows(FeedbackNotFoundByIdException.class, () -> feedbackService.deleteFeedbackById(feedbackId));
    }

    @Test
    void testGetFeedbacksByEvent() throws EventNotFoundByIdException {
        String eventId = "event123";
        Event event = new Event();
        List<Feedback> expectedFeedbacks = Arrays.asList(new Feedback(), new Feedback());
        when(eventService.getEventById(eventId)).thenReturn(event);
        when(feedbackRepository.findFeedbacksByEvent_EventId(eventId)).thenReturn(expectedFeedbacks);

        List<Feedback> actualFeedbacks = feedbackService.getFeedbacksByEvent(eventId);

        assertEquals(expectedFeedbacks, actualFeedbacks);
    }

    @Test
    void testGetFeedbackByUserAndEvent() throws UserNotFoundByIdException, EventNotFoundByIdException {
        String userId = "user123";
        String eventId = "event123";
        User user = new User();
        Event event = new Event();
        Feedback expectedFeedback = new Feedback();
        when(userService.getUserById(userId)).thenReturn(user);
        when(eventService.getEventById(eventId)).thenReturn(event);
        when(feedbackRepository.findFeedbackByUser_UserIdAndEvent_EventId(userId, eventId)).thenReturn(expectedFeedback);

        Feedback actualFeedback = feedbackService.getFeedbackByUserAndEvent(userId, eventId);

        assertEquals(expectedFeedback, actualFeedback);
    }
}
