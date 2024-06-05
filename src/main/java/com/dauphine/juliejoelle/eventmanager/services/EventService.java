package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationEventRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event getEventById(String eventId);
    Event createUser(CreationEventRequest event);
    //update?
    boolean deleteEventById(String eventId);

    int getEventsByCategory(String categoryId);
}
