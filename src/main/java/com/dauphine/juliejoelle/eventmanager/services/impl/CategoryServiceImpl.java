package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
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
    public List<Category> getCategoriesByName(String name, boolean desc) {
        if(desc){
            return categoryRepository.getCategoriesByNameByEventsCountDESC(name);
        }
        return categoryRepository.getCategoriesByNameByEventsCountASC(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String id) throws CategoryNotFoundByIdException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundByIdException(id));
    }

    @Override
    public List<Category> getCategoriesByEventsCountASC() {
        return categoryRepository.getCategoriesByEventsCountASC();
    }

    @Override
    public List<Category> getCategoriesByEventsCountDESC() {
        return categoryRepository.getCategoriesByEventsCountDESC();
    }
}
