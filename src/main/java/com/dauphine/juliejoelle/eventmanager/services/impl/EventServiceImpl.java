package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationEventRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.repositories.EventRepository;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return null;
    }

    @Override
    public Event getEventById(String eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public Event createUser(CreationEventRequest event) {
        return null;
    }

    @Override
    public boolean deleteEventById(String eventId) {
        return false;
    }
}
