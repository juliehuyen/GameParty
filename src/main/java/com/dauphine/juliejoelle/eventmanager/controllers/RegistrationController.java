package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.services.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

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
    public List<Registration> getRegistrations(){
        return registrationService.getAll();
    }

    @Operation(summary = "To get a registration by its id")
    @GetMapping("/{id}")
    public Registration getRegistrationById(
            @Parameter (description = "The id of the registration to get")
            @PathVariable String id){
        return registrationService.getRegistrationById(id);
    }

    @Operation(summary = "To create a new registration")
    @PostMapping("")
    public Registration createRegistration(
            @Parameter (description = "The registration to create")
            @RequestBody CreationRegistrationRequest registration) {
        return registrationService.createRegistration(registration);
    }

    @Operation(summary = "To delete a registration")
    @DeleteMapping("{id}")
    public boolean deleteRegistration(
            @Parameter(description = "Id of the registration to delete")
            @PathVariable String id) {
        return registrationService.deleteRegistrationById(id);
    }

    @Operation(summary = "To get all users registered to a given event")
    @GetMapping("/event/{eventId}")
    public List<User> getUsersRegisteredByEvent(
            @Parameter(description = "The event's id")
            @PathVariable String eventId) {
        return registrationService.getAllUserRegisteredByEvent(eventId);
    }

}
