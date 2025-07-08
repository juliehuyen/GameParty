package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.UserRepository;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<User> expectedUsers = Arrays.asList(new User("user1"), new User("user2"));
        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userService.getAll();

        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    void testGetUserById() throws UserNotFoundByIdException {
        String userId = "user123";
        User expectedUser = new User("user1");
        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.getUserById(userId);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testGetUserById_NotFound() {
        String userId = "user123";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundByIdException.class, () -> userService.getUserById(userId));
    }

    @Test
    void testDeleteUserById() {
        String userId = "user123";
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User("user1")));

        boolean result = userService.deleteUserById(userId);

        assertTrue(result);
    }

    @Test
    void testDeleteUserById_NotFound() {
        String userId = "user123";
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        boolean result = userService.deleteUserById(userId);

        assertFalse(result);
    }

    @Test
    void testFindUserByName() {
        String username = "user1";
        User expectedUser = new User(username);
        when(userRepository.findUserByUsernameIgnoreCase(username)).thenReturn(expectedUser);

        User actualUser = userService.findUserByName(username);

        assertEquals(expectedUser, actualUser);
    }
}
