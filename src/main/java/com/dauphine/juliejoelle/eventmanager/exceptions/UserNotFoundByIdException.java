package com.dauphine.juliejoelle.eventmanager.exceptions;

public class UserNotFoundByIdException extends Exception{
    public UserNotFoundByIdException(String id) {
        super("User with id " + id + " not found");
    }
}
