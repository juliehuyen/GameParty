package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.entities.Type;
import com.dauphine.juliejoelle.eventmanager.services.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/types")
public class TypeController {

    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "To get all types")
    @GetMapping("")
    public ResponseEntity<List<Type>> getTypes() {
        List<Type> types = typeService.getAllTypes();
        return ResponseEntity.ok(types);
    }
}
