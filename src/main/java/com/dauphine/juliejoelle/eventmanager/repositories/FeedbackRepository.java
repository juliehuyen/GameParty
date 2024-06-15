package com.dauphine.juliejoelle.eventmanager.repositories;

import com.dauphine.juliejoelle.eventmanager.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
    List<Feedback> findFeedbacksByEvent_EventId(String eventId);

    Feedback findFeedbackByUser_UserIdAndEvent_EventId(String userId, String eventId);
}
