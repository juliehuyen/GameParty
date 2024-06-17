package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.RegistrationNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.services.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Operation(summary = "To get all registrations")
    @GetMapping("")
    public ResponseEntity<List<Registration>> getRegistrations(){
        List<Registration> registrations = registrationService.getAll();
        return ResponseEntity.ok(registrations);
    }

    @Operation(summary = "To get a registration by its id")
    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(
            @Parameter (description = "The id of the registration to get")
            @PathVariable String id) throws RegistrationNotFoundByIdException {
        Registration registration = registrationService.getRegistrationById(id);
        return ResponseEntity.ok(registration);
    }

    @Operation(summary = "To create a new registration")
    @PostMapping("")
    public ResponseEntity<Registration> createRegistration(
            @Parameter (description = "The registration to create")
            @RequestBody CreationRegistrationRequest registration) throws EventNotFoundByIdException, UserNotFoundByIdException {
        Registration registration1 = registrationService.createRegistration(registration);
        return ResponseEntity.created(URI.create("/v1/registrations/" + registration1.getRegistrationId()))
                .body(registration1);
    }

    @Operation(summary = "To delete a registration")
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRegistration(
            @Parameter(description = "Id of the registration to delete")
            @PathVariable String id) throws RegistrationNotFoundByIdException {
        registrationService.getRegistrationById(id);
        registrationService.deleteRegistrationById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "To get all users registered to a given event")
    @GetMapping("/events/eventId")
    public ResponseEntity<List<User>> getUsersRegisteredByEvent(
            @Parameter(description = "The event's id")
            @RequestParam String eventId) throws EventNotFoundByIdException {
        List<User> users = registrationService.getAllUserRegisteredByEvent(eventId);
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "To check if a user is registered to an event")
    @GetMapping("/events/{eventId}/users/{userId}")
    public ResponseEntity<Boolean> isUserRegisteredToEvent(
            @Parameter(description = "The event's id")
            @PathVariable String eventId,
            @Parameter(description = "The user's id")
            @PathVariable String userId) throws EventNotFoundByIdException, UserNotFoundByIdException {
        boolean isRegistered = registrationService.isUserRegisteredToEvent(userId, eventId);
        return ResponseEntity.ok(isRegistered);
    }

}
