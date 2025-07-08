package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationUserRequest;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserAlreadyExistsException;
import com.dauphine.juliejoelle.eventmanager.exceptions.UserNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Get user by its id")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(
    @Parameter (description = "User's id")
    @PathVariable String userId) throws UserNotFoundByIdException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "To create a user")
    @PostMapping("")
    public ResponseEntity<User> createUser(
            @Parameter (description = "The user to create")
            @RequestBody CreationUserRequest user) throws UserAlreadyExistsException {
        User userCreated = userService.createUser(user);
        return ResponseEntity.ok(userCreated);
    }

    @Operation(summary = "To delete a user")
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(
            @Parameter(description = "User's id to delete")
            @PathVariable String userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "To find a user by its name")
    @GetMapping("/name/{username}")
    public ResponseEntity<User> findUserByUsername(
            @Parameter(description = "User's name")
            @PathVariable String username){
        User user = userService.findUserByName(username);
        return ResponseEntity.ok(user);
    }
}
