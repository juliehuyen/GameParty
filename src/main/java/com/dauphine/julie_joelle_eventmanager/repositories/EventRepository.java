package com.dauphine.julie_joelle_eventmanager.repositories;

import com.dauphine.julie_joelle_eventmanager.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
