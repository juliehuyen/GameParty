package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.Type;
import com.dauphine.juliejoelle.eventmanager.exceptions.TypeNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.TypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class TypeServiceImplTest {
    @Mock
    private TypeRepository typeRepository;

    @InjectMocks
    private TypeServiceImpl typeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTypes() {
        List<Type> expectedTypes = Arrays.asList(new Type(), new Type());
        when(typeRepository.findAll()).thenReturn(expectedTypes);

        List<Type> actualTypes = typeService.getAllTypes();

        assertEquals(expectedTypes, actualTypes);
    }

    @Test
    void testGetTypeById() throws TypeNotFoundByIdException {
        String typeId = "type123";
        Type expectedType = new Type();
        when(typeRepository.findById(typeId)).thenReturn(Optional.of(expectedType));

        Type actualType = typeService.getTypeById(typeId);

        assertEquals(expectedType, actualType);
    }

    @Test
    void testGetTypeById_NotFound() {
        String typeId = "type123";
        when(typeRepository.findById(typeId)).thenReturn(Optional.empty());

        assertThrows(TypeNotFoundByIdException.class, () -> typeService.getTypeById(typeId));
    }
}
