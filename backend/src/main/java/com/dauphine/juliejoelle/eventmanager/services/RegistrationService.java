package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.RegistrationNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAll();
    Registration getRegistrationById(String regId) throws RegistrationNotFoundByIdException;
    Registration createRegistration(CreationRegistrationRequest reg) throws EventNotFoundByIdException, UserNotFoundByIdException;
    //update?
    boolean deleteRegistrationById(String regId) throws RegistrationNotFoundByIdException;
    List<User> getAllUserRegisteredByEvent(String eventId) throws EventNotFoundByIdException;
    boolean isUserRegisteredToEvent(String username, String eventId) throws UserNotFoundByIdException, EventNotFoundByIdException;
}
