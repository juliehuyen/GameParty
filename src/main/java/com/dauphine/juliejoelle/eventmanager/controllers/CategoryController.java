package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "To get all categories from a given string")
    @GetMapping("/{name}")
    public ResponseEntity<List<Category>> getCategoriesByName(
            @Parameter(description = "Category's name")
            @PathVariable String name){
        //TODO
        List<Category> categories = categoryService.getCategoriesByName(name);
        return ResponseEntity.ok(categories);
    }

    @Operation(summary = "To get all categories")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        //TODO
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }
}
