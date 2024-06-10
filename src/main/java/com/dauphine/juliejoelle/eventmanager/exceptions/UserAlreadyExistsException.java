package com.dauphine.juliejoelle.eventmanager.exceptions;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String username) {
        super("L'utilisateur " + username + " existe déjà");
    }
}
