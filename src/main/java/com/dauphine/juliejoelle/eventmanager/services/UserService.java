package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationUserRequest;
import com.dauphine.juliejoelle.eventmanager.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(String userId);
    User createUser(CreationUserRequest user);
    boolean deleteUserById(String userId);

}
