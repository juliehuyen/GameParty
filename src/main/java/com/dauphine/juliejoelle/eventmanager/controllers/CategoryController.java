package com.dauphine.juliejoelle.eventmanager.controllers;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "To get all categories from a given string")
    @GetMapping("name")
    public ResponseEntity<List<Category>> getCategoriesByName(
            @Parameter(description = "Category's name")
            @RequestParam String name){
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

    @Operation(summary = "To get a category by its id")
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(
            @Parameter(description = "Id of the category")
            @PathVariable String id) throws CategoryNotFoundByIdException {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
}
