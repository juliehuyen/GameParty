package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.RegistrationNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.RegistrationRepository;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import com.dauphine.juliejoelle.eventmanager.services.RegistrationService;
import com.dauphine.juliejoelle.eventmanager.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final UserService userService;
    private final EventService eventService;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, UserService userService, EventService eventService) {
        this.registrationRepository = registrationRepository;
        this.userService = userService;
        this.eventService = eventService;
    }

    @Override
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration getRegistrationById(String regId) throws RegistrationNotFoundByIdException {
        return registrationRepository.findById(regId).orElseThrow(() -> new RegistrationNotFoundByIdException(regId));
    }

    @Override
    public Registration createRegistration(CreationRegistrationRequest reg) throws EventNotFoundByIdException {
        //TODO throw exceptions
        User user = userService.getUserById(reg.getUserId());
        Event event = eventService.getEventById(reg.getEventId());
        Registration registration = new Registration(user,event);
        return registrationRepository.save(registration);
    }

    @Override
    public boolean deleteRegistrationById(String regId) throws RegistrationNotFoundByIdException {
        getRegistrationById(regId);
        if(registrationRepository.findById(regId).isPresent()){
            registrationRepository.deleteById(regId);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUserRegisteredByEvent(String eventId) {
        //TODO throw exceptions
        return registrationRepository.getAllUsersRegisteredByEvent(eventId);
    }
}
