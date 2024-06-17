package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationEventRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Operation(summary = "To get all events")
    @GetMapping("")
    public ResponseEntity<List<Event>> getEvents() {
        List<Event> events = eventService.getEvents();
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get an event by its id")
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(
            @Parameter(description = "The id of the event to get")
            @PathVariable String id) throws EventNotFoundByIdException {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @Operation(summary = "To create a new event")
    @PostMapping("")
    public ResponseEntity<Event> createEvent(
            @Parameter(description = "The event to create")
            @RequestBody CreationEventRequest eventRequest) throws CategoryNotFoundByIdException, TypeNotFoundByIdException {
        Event event = eventService.createEvent(eventRequest);
        return ResponseEntity
                .created(URI.create("/v1/events/" + event.getEventId()))
                .body(event);
    }

    @Operation(summary = "To delete an event")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEventById(
            @Parameter(description = "Id of the event to delete")
            @PathVariable String id) throws EventNotFoundByIdException {
        eventService.getEventById(id);
        eventService.deleteEventById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "The list of events given a category")
    @GetMapping("/category/categoryId")
    public ResponseEntity<List<Event>> getEventsByCategoryId(
            @Parameter(description = "Category's id")
            @RequestParam String categoryId) {
        List<Event> events = eventService.getEventsByCategoryId(categoryId);
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "The list of passed events given a category")
    @GetMapping("/passed/category/categoryId")
    public ResponseEntity<List<Event>> getEventsAlreadyPassedByCategoryId(
            @Parameter(description = "Category's id")
            @RequestParam String categoryId) {
        List<Event> events = eventService.getEventsAlreadyPassedByCategoryId(categoryId);
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "The list of unpassed events given a category")
    @GetMapping("/notPassed/category/categoryId")
    public ResponseEntity<List<Event>> getEventsNotPassedByCategoryId(
            @Parameter(description = "Category's id")
            @RequestParam String categoryId) {
        List<Event> events = eventService.getEventsNotPassedByCategoryId(categoryId);
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get all events that have already passed")
    @GetMapping("/passed")
    public ResponseEntity<List<Event>> getEventsAlreadyPassed() {
        List<Event> events = eventService.getEventsAlreadyPassed();
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get all events that have not passed yet")
    @GetMapping("/notPassed")
    public ResponseEntity<List<Event>> getEventsNotPassed() {
        List<Event> events = eventService.getEventsNotPassed();
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get all events that have not passed yet sorted by date")
    @GetMapping("/notPassed/sorted-by-date")
    public ResponseEntity<List<Event>> getEventsNotPassedSortedByDate(
            @Parameter(description = "true = ASC, false = DESC")
            @RequestParam boolean sorted) {
        List<Event> events;
        if (sorted) {
            events = eventService.getEventsNotPassedSortedByDateASC();
        } else {
            events = eventService.getEventsNotPassedSortedByDateDESC();
        }
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get all events that have not passed yet sorted by participants count")
    @GetMapping("/notPassed/sorted-by-participants")
    public ResponseEntity<List<Event>> getEventsNotPassedSortedByParticipantsCount(
            @Parameter(description = "true = DESC, false = ASC")
            @RequestParam boolean sorted) {
        List<Event> events;
        if (sorted) {
            events = eventService.getEventsNotPassedSortedByParticipantsCountDESC();
        } else {
            events = eventService.getEventsNotPassedSortedByParticipantsCountASC();
        }
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get all events that have passed sorted by date")
    @GetMapping("/passed/sorted-by-date")
    public ResponseEntity<List<Event>> getEventsPassedSortedByDate(
            @Parameter(description = "true = ASC, false = DESC")
            @RequestParam boolean sorted) {
        List<Event> events;
        if (sorted) {
            events = eventService.getEventsPassedSortedByDateASC();
        } else {
            events = eventService.getEventsPassedSortedByDateDESC();
        }
        return ResponseEntity.ok(events);
    }

    @Operation(summary = "To get all events that have passed sorted by participants count")
    @GetMapping("/passed/sorted-by-participants")
    public ResponseEntity<List<Event>> getEventsPassedSortedByParticipantsCount(
            @Parameter(description = "true = DESC, false = ASC")
            @RequestParam boolean sorted) {
        List<Event> events;
        if (sorted) {
            events = eventService.getEventsPassedSortedByParticipantsCountDESC();
        } else {
            events = eventService.getEventsPassedSortedByParticipantsCountASC();
        }
        return ResponseEntity.ok(events);
    }

}
