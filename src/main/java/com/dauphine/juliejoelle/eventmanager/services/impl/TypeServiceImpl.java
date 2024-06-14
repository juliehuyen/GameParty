package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.Type;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.TypeRepository;
import com.dauphine.juliejoelle.eventmanager.services.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(String typeId) throws TypeNotFoundByIdException {
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new TypeNotFoundByIdException(typeId));
    }
}
