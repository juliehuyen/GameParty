package com.dauphine.julie_joelle_eventmanager.repositories;

import com.dauphine.julie_joelle_eventmanager.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
}
