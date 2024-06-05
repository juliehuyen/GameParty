package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.entities.Type;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;

public interface TypeService {
    Type getTypeById(String typeId) throws TypeNotFoundByIdException;
}
