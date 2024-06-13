package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.dto.CreationUserRequest;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserAlreadyExistsException;
import com.dauphine.juliejoelle.eventmanager.repositories.UserRepository;
import com.dauphine.juliejoelle.eventmanager.services.UserService;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(CreationUserRequest user) throws UserAlreadyExistsException {
        if(userRepository.findUserByUsernameIgnoreCase(user.getUsername()) != null){
            throw new UserAlreadyExistsException(user.getUsername());
        }
        User u = new User(user.getUsername());
        return userRepository.save(u);
    }

    @Override
    public boolean deleteUserById(String userId) {
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public User findUserByName(String username) {
        return userRepository.findUserByUsernameIgnoreCase(username);
    }
}
