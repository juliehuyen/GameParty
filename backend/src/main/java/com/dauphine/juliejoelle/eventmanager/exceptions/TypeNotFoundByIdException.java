package com.dauphine.juliejoelle.eventmanager.exceptions;

public class TypeNotFoundByIdException extends Exception {

    public TypeNotFoundByIdException(String id) { super("Type with id : " + id + " not found /!\\"); }
}
