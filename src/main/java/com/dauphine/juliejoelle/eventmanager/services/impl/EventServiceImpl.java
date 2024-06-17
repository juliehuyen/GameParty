package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationEventRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.entities.Type;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.EventRepository;
import com.dauphine.juliejoelle.eventmanager.services.CategoryService;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import com.dauphine.juliejoelle.eventmanager.services.TypeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CategoryService categoryService;
    private final TypeService typeService;


    public EventServiceImpl(EventRepository eventRepository, CategoryService categoryService, TypeService typeService) {
        this.eventRepository = eventRepository;
        this.categoryService = categoryService;
        this.typeService = typeService;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(String eventId) throws EventNotFoundByIdException {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundByIdException(eventId));
    }

    @Override
    public Event createEvent(CreationEventRequest eventRequest) throws CategoryNotFoundByIdException, TypeNotFoundByIdException {
        Category category = categoryService.getCategoryById(eventRequest.getCategoryId());
        Type type = typeService.getTypeById(eventRequest.getTypeId());
        Event event = new Event(eventRequest.getTitle(), eventRequest.getDescription(), eventRequest.getEventDate(), eventRequest.getLocation(), category, type);
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(String eventId) throws EventNotFoundByIdException {
        getEventById(eventId);
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getEventsAlreadyPassed() {
        return eventRepository.getEventsAlreadyPassed(new java.util.Date());
    }

    @Override
    public List<Event> getEventsNotPassed() {
        return eventRepository.getEventsNotPassed(new java.util.Date());
    }

    @Override
    public List<Event> getEventsAlreadyPassedByCategoryId(String categoryId) {
        return eventRepository.getEventsAlreadyPassedByCategory_CategoryId(categoryId, new java.util.Date());
    }

    @Override
    public List<Event> getEventsNotPassedByCategoryId(String categoryId) {
        return eventRepository.getEventsNotPassedByCategory_CategoryId(categoryId, new java.util.Date());
    }

    @Override
    public List<Event> getEventsByCategoryId(String categoryId) {
        return eventRepository.getEventsByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Event> getEventsNotPassedSortedByDateDESC() {
        return eventRepository.getEventsNotPassedSortedByDateDESC(new Date());
    }

    @Override
    public List<Event> getEventsNotPassedSortedByDateASC() {
        return eventRepository.getEventsNotPassedSortedByDateASC(new Date());
    }

    @Override
    public List<Event> getEventsNotPassedSortedByParticipantsCountDESC() {
        return eventRepository.getEventsNotPassedSortedByParticipantsCountDESC(new Date());
    }

    @Override
    public List<Event> getEventsNotPassedSortedByParticipantsCountASC() {
        return eventRepository.getEventsNotPassedSortedByParticipantsCountASC(new Date());
    }

    @Override
    public List<Event> getEventsPassedSortedByDateDESC() {
        return eventRepository.getEventsPassedSortedByDateDESC(new Date());
    }

    @Override
    public List<Event> getEventsPassedSortedByDateASC() {
        return eventRepository.getEventsPassedSortedByDateASC(new Date());
    }

    @Override
    public List<Event> getEventsPassedSortedByParticipantsCountDESC() {
        return eventRepository.getEventsPassedSortedByParticipantsCountDESC(new Date());
    }

    @Override
    public List<Event> getEventsPassedSortedByParticipantsCountASC() {
        return eventRepository.getEventsPassedSortedByParticipantsCountASC(new Date());
    }

}
