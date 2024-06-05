package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.repositories.CategoryRepository;
import com.dauphine.juliejoelle.eventmanager.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategoriesByName(String name) {
        return categoryRepository.getCategoriesByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
