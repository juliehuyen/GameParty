package com.dauphine.julie_joelle_eventmanager.controllers;

import com.dauphine.julie_joelle_eventmanager.entity.Feedback;
import com.dauphine.julie_joelle_eventmanager.services.FeedbackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackService;
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    @GetMapping("/{id}")
    public Feedback feedbackById(@PathVariable UUID id){
        return feedbackService.getFeedbackById(id);
    }
}
