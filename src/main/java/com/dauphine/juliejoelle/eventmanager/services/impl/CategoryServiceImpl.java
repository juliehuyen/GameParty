package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.CategoryRepository;
import com.dauphine.juliejoelle.eventmanager.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
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
            return categoryRepository.getCategoriesByNameByEventsCountDESC(name, new Date());
        }
        return categoryRepository.getCategoriesByNameByEventsCountASC(name, new Date());
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
    public List<Category> getCategoriesByEventsNotPassedCountASC() {
        return categoryRepository.getCategoriesByEventsNotPassedCountASC(new java.util.Date());
    }

    @Override
    public List<Category> getCategoriesByEventsNotPassedCountDESC() {
        return categoryRepository.getCategoriesByEventsNotPassedCountDESC(new java.util.Date());
    }

}
