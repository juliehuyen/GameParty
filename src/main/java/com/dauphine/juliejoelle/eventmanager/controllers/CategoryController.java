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
    @GetMapping("name/sorted")
    public ResponseEntity<List<Category>> getCategoriesByName(
            @Parameter(description = "Category's name")
            @RequestParam String name,
            @Parameter(description = "true = desc, false = asc")
            @RequestParam boolean sorted){
        List<Category> categories = categoryService.getCategoriesByName(name, sorted);
        return ResponseEntity.ok(categories);
    }

    @Operation(summary = "To get all categories")
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
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

    @Operation(summary = "To get sorted categories")
    @GetMapping("/sorted")
    public ResponseEntity<List<Category>> getSortedCategories(
            @Parameter(description = "true = DESC, false = ASC")
            @RequestParam boolean sorted) {
        List<Category> categories;
        if(sorted){
             categories = categoryService.getCategoriesByEventsNotPassedCountDESC();
        } else{
             categories = categoryService.getCategoriesByEventsNotPassedCountASC();
        }
        return ResponseEntity.ok(categories);
    }
}
