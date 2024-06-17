package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.dto.CreationUserRequest;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserAlreadyExistsException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(String userId) throws UserNotFoundByIdException;
    User createUser(CreationUserRequest user) throws UserAlreadyExistsException;
    boolean deleteUserById(String userId);
    User findUserByName(String username);
}
