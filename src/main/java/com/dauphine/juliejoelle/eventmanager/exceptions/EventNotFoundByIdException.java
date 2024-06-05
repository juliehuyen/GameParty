package com.dauphine.juliejoelle.eventmanager.exceptions;

public class EventNotFoundByIdException extends Exception{
    public EventNotFoundByIdException(String id){
        super("Event with id : " + id + " not found /!\\");
    }
}
