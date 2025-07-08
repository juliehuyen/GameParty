package com.dauphine.juliejoelle.eventmanager.exceptions;

public class RegistrationNotFoundByIdException extends Exception{
    public RegistrationNotFoundByIdException(String id){
        super("Registration with id : " + id + " not found /!\\");
    }
}
