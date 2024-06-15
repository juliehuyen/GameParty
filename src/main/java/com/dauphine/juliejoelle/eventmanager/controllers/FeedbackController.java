package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.FeedbackNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.services.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackService;
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Operation(summary = "To get all feedbacks")
    @GetMapping("")
    public ResponseEntity<List<Feedback>> getFeedbacks(){
        List<Feedback> feedbacks =feedbackService.getAll();
        return ResponseEntity.ok(feedbacks);
    }
    @Operation(summary = "To get a feedback by its id")
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(
            @Parameter(description = "The id of the feedback to get")
            @PathVariable String id) throws FeedbackNotFoundByIdException {
        Feedback feedback = feedbackService.getFeedbackById(id);
        return ResponseEntity.ok(feedback);
    }

    @Operation(summary = "To create a new feedback")
    @PostMapping("")
    public ResponseEntity<Feedback> createFeedback(
            @Parameter(description = "The feedback to create")
            @RequestBody CreationFeedbackRequest feedback) throws EventNotFoundByIdException {
        Feedback FB = feedbackService.createFeedback(feedback);
        return ResponseEntity
                .created(URI.create("/v1/feedbacks/" +FB.getFeedbackId() ))
                .body(FB);

    }

    @Operation(summary = "To delete a feedback")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFeedback(
            @Parameter(description = "Id of the feedback to delete")
            @PathVariable String id) throws FeedbackNotFoundByIdException {
        feedbackService.getFeedbackById(id);
        feedbackService.deleteFeedbackById(id);
        return ResponseEntity.ok().build();

    }

    @Operation(summary = "To get all feedbacks from an event")
    @GetMapping("/event/eventId")
    public ResponseEntity<List<Feedback>> getFeedbacksByEventId(
            @Parameter(description = "Event's id")
            @RequestParam String eventId){
        //TODO
        List<Feedback> feedbacks = feedbackService.getFeedbacksByEvent(eventId);
        return ResponseEntity.ok(feedbacks);
    }

    @Operation(summary = "To get a feedback by its user and event")
    @GetMapping("/user/{userId}/event/{eventId}")
    public ResponseEntity<Feedback> getFeedbackByUserAndEvent(
            @Parameter(description = "User's id")
            @PathVariable String userId,
            @Parameter(description = "Event's id")
            @PathVariable String eventId){
        //TODO
        Feedback feedback = feedbackService.getFeedbackByUserAndEvent(userId, eventId);
        return ResponseEntity.ok(feedback);
    }
}
