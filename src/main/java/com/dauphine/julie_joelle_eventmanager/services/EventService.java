package com.dauphine.julie_joelle_eventmanager.services;

import com.dauphine.julie_joelle_eventmanager.dto.CreationEventRequest;
import com.dauphine.julie_joelle_eventmanager.entity.Event;

import java.util.List;
import java.util.UUID;

public interface EventService {
    List<Event> getAll();
    Event getEventById(UUID userId);
    Event createUser(CreationEventRequest event);
    //update?
    boolean deleteEventById(UUID eventId);
}
