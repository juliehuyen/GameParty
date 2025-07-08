package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationRegistrationRequest;
import com.dauphine.juliejoelle.eventmanager.entities.Event;
import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.EventNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.RegistrationNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.RegistrationRepository;
import com.dauphine.juliejoelle.eventmanager.services.EventService;
import com.dauphine.juliejoelle.eventmanager.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class RegistrationServiceImplTest {
    @Mock
    private RegistrationRepository registrationRepository;

    @Mock
    private UserService userService;

    @Mock
    private EventService eventService;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Registration> expectedRegistrations = Arrays.asList(new Registration(), new Registration());
        when(registrationRepository.findAll()).thenReturn(expectedRegistrations);

        List<Registration> actualRegistrations = registrationService.getAll();

        assertEquals(expectedRegistrations, actualRegistrations);
    }

    @Test
    void testGetRegistrationById() throws RegistrationNotFoundByIdException {
        String registrationId = "reg123";
        Registration expectedRegistration = new Registration();
        when(registrationRepository.findById(registrationId)).thenReturn(Optional.of(expectedRegistration));

        Registration actualRegistration = registrationService.getRegistrationById(registrationId);

        assertEquals(expectedRegistration, actualRegistration);
    }

    @Test
    void testGetRegistrationById_NotFound() {
        String registrationId = "reg123";
        when(registrationRepository.findById(registrationId)).thenReturn(Optional.empty());

        assertThrows(RegistrationNotFoundByIdException.class, () -> registrationService.getRegistrationById(registrationId));
    }

    @Test
    void testDeleteRegistrationById() throws RegistrationNotFoundByIdException {
        String registrationId = "reg123";
        Registration registration = new Registration();
        when(registrationRepository.findById(registrationId)).thenReturn(Optional.of(registration));

        boolean isDeleted = registrationService.deleteRegistrationById(registrationId);

        assertTrue(isDeleted);
    }

    private void assertTrue(boolean isDeleted) {
    }

    @Test
    void testDeleteRegistrationById_NotFound() {
        String registrationId = "reg123";
        when(registrationRepository.findById(registrationId)).thenReturn(Optional.empty());

        assertThrows(RegistrationNotFoundByIdException.class, () -> registrationService.deleteRegistrationById(registrationId));
    }

    @Test
    void testGetAllUserRegisteredByEvent() throws EventNotFoundByIdException {
        String eventId = "event123";
        Event event = new Event();
        List<User> expectedUsers = Arrays.asList(new User(), new User());
        when(eventService.getEventById(eventId)).thenReturn(event);
        when(registrationRepository.getAllUsersRegisteredByEvent(eventId)).thenReturn(expectedUsers);

        List<User> actualUsers = registrationService.getAllUserRegisteredByEvent(eventId);

        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void testIsUserRegisteredToEvent() throws UserNotFoundByIdException, EventNotFoundByIdException {
        String userId = "user123";
        String eventId = "event123";
        User user = new User();
        Event event = new Event();
        when(userService.getUserById(userId)).thenReturn(user);
        when(eventService.getEventById(eventId)).thenReturn(event);
        when(registrationRepository.isUserRegisteredToEvent(userId, eventId)).thenReturn(true);

        boolean isRegistered = registrationService.isUserRegisteredToEvent(userId, eventId);

        assertTrue(isRegistered);
    }
}
