package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationFeedbackRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import com.dauphine.juliejoelle.eventmanager.services.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

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
    public List<Feedback> getFeedbacks(){
        return feedbackService.getAll();
    }
    @Operation(summary = "To get a feedback by its id")
    @GetMapping("/{id}")
    public Feedback getFeedbackById(
            @Parameter(description = "The id of the feedback to get")
            @PathVariable String id){
        return feedbackService.getFeedbackById(id);
    }

    @Operation(summary = "To create a new feedback")
    @PostMapping("")
    public Feedback createFeedback(
            @Parameter(description = "The feedback to create")
            @RequestBody CreationFeedbackRequest feedback){
        return feedbackService.createFeedback(feedback);
    }

    @Operation(summary = "To delete a feedback")
    @DeleteMapping("{id}")
    public boolean deleteFeedback(
            @Parameter(description = "Id of the feedback to delete")
            @PathVariable String id){
        return feedbackService.deleteFeedbackById(id);
    }

    @Operation(summary = "To get all feedbacks from an event")
    @GetMapping("/event/{eventId}")
    public List<Feedback> getFeedbacksByEventId(
            @Parameter(description = "Event's id")
            @PathVariable String eventId){
        return feedbackService.getFeedbacksByEvent(eventId);
    }
}
