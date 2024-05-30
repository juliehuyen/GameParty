package com.dauphine.julie_joelle_eventmanager.services;

import com.dauphine.julie_joelle_eventmanager.dto.CreationEventRequest;
import com.dauphine.julie_joelle_eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.julie_joelle_eventmanager.entity.Event;
import com.dauphine.julie_joelle_eventmanager.entity.Registration;

import java.util.List;
import java.util.UUID;

public interface RegistrationService {
    List<Registration> getAll();
    Registration getRegistrationById(UUID regId);
    Registration createRegistration(CreationRegistrationRequest reg);
    //update?
    boolean deleteRegistrationById(UUID regId);
}
