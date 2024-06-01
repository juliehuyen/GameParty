package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.dto.CreationUserRequest;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import com.dauphine.juliejoelle.eventmanager.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @Operation(summary = "Get user by its id")
    @GetMapping("/{userId}")
    public User getUserById(
    @Parameter (description = "User's id")
    @PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @Operation(summary = "To create a user")
    @PostMapping("")
    public User createUser(
            @Parameter (description = "The user to create")
            @RequestBody CreationUserRequest user) {
        return userService.createUser(user);
    }

    @Operation(summary = "To delete a user")
    @DeleteMapping("/{id}")
    public boolean deleteUserbyId(
            @Parameter(description = "User's id to delete")
            @PathVariable String userId){
        return userService.deleteUserById(userId);
    }
}
