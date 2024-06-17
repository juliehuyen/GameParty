package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationEventRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;

import java.util.List;

public interface EventService {
    List<Event> getEvents();
    Event getEventById(String eventId) throws EventNotFoundByIdException;
    Event createEvent(CreationEventRequest eventRequest) throws CategoryNotFoundByIdException, TypeNotFoundByIdException;
    //update?
    void deleteEventById(String eventId) throws EventNotFoundByIdException;
    List<Event> getEventsAlreadyPassed();
    List<Event> getEventsNotPassed();
    List<Event> getEventsAlreadyPassedByCategoryId(String categoryId);
    List<Event> getEventsNotPassedByCategoryId(String categoryId);
    List<Event> getEventsByCategoryId(String categoryId);
    List<Event> getEventsNotPassedSortedByDateDESC();
    List<Event> getEventsNotPassedSortedByDateASC();
}
