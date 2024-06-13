package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.RegistrationNotFoundByIdException;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAll();
    Registration getRegistrationById(String regId) throws RegistrationNotFoundByIdException;
    Registration createRegistration(CreationRegistrationRequest reg) throws EventNotFoundByIdException;
    //update?
    boolean deleteRegistrationById(String regId) throws RegistrationNotFoundByIdException;
    List<User> getAllUserRegisteredByEvent(String eventId);
    boolean isUserRegisteredToEvent(String username, String eventId);
}
