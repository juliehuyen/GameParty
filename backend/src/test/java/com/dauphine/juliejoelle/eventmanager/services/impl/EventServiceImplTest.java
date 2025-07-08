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
import com.dauphine.juliejoelle.eventmanager.services.TypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class EventServiceImplTest {
    @Mock
    private EventRepository eventRepository;

    @Mock
    private CategoryService categoryService;

    @Mock
    private TypeService typeService;

    @InjectMocks
    private EventServiceImpl eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEvents() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.findAll()).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEvents();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventById_Found() throws EventNotFoundByIdException {
        String eventId = "123";
        Event expectedEvent = new Event();
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(expectedEvent));

        Event actualEvent = eventService.getEventById(eventId);

        assertEquals(expectedEvent, actualEvent);
    }

    @Test
    void testGetEventById_NotFound() {
        String eventId = "123";
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        assertThrows(EventNotFoundByIdException.class, () -> eventService.getEventById(eventId));
    }

    @Test
    void testGetEventsAlreadyPassed() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsAlreadyPassed(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsAlreadyPassed();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsNotPassed() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsNotPassed(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsNotPassed();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsAlreadyPassedByCategoryId() {
        String categoryId = "cat123";
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsAlreadyPassedByCategory_CategoryId(eq(categoryId), any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsAlreadyPassedByCategoryId(categoryId);

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsNotPassedByCategoryId() {
        String categoryId = "cat123";
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsNotPassedByCategory_CategoryId(eq(categoryId), any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsNotPassedByCategoryId(categoryId);

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsByCategoryId() {
        String categoryId = "cat123";
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsByCategory_CategoryId(categoryId)).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsByCategoryId(categoryId);

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsNotPassedSortedByDateDESC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsNotPassedSortedByDateDESC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsNotPassedSortedByDateDESC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsNotPassedSortedByDateASC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsNotPassedSortedByDateASC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsNotPassedSortedByDateASC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsNotPassedSortedByParticipantsCountDESC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsNotPassedSortedByParticipantsCountDESC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsNotPassedSortedByParticipantsCountDESC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsNotPassedSortedByParticipantsCountASC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsNotPassedSortedByParticipantsCountASC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsNotPassedSortedByParticipantsCountASC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsPassedSortedByDateDESC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsPassedSortedByDateDESC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsPassedSortedByDateDESC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsPassedSortedByDateASC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsPassedSortedByDateASC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsPassedSortedByDateASC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsPassedSortedByParticipantsCountDESC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsPassedSortedByParticipantsCountDESC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsPassedSortedByParticipantsCountDESC();

        assertEquals(expectedEvents, actualEvents);
    }

    @Test
    void testGetEventsPassedSortedByParticipantsCountASC() {
        List<Event> expectedEvents = Arrays.asList(new Event(), new Event());
        when(eventRepository.getEventsPassedSortedByParticipantsCountASC(any(Date.class))).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEventsPassedSortedByParticipantsCountASC();

        assertEquals(expectedEvents, actualEvents);
    }


}
