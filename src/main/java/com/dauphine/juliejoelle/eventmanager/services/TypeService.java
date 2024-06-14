package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.entities.Type;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;

import java.util.List;

public interface TypeService {
    List<Type> getAllTypes();
    Type getTypeById(String typeId) throws TypeNotFoundByIdException;
}
