package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAll();
    Registration getRegistrationById(String regId);
    Registration createRegistration(CreationRegistrationRequest reg);
    //update?
    boolean deleteRegistrationById(String regId);
    List<User> getAllUserRegisteredByEvent(String eventId);
}
