package com.dauphine.julie_joelle_eventmanager.services;

import com.dauphine.julie_joelle_eventmanager.dto.CreationUserRequest;
import com.dauphine.julie_joelle_eventmanager.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getAll();
    User getUserById(UUID userId);
    User createUser(CreationUserRequest user);
    boolean deleteUserById(UUID userId);
}
