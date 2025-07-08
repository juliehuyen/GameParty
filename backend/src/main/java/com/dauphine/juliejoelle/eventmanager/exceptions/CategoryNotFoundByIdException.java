package com.dauphine.juliejoelle.eventmanager.exceptions;

public class CategoryNotFoundByIdException extends Exception{

    public CategoryNotFoundByIdException(String id) { super("Category with id : " + id + " not found /!\\"); }
}
