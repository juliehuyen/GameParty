package com.dauphine.juliejoelle.eventmanager.exceptions;

public class FeedbackNotFoundByIdException extends Exception{
    public FeedbackNotFoundByIdException(String id){
        super("Feedback with id : " + id + " not found /!\\");
    }
}
