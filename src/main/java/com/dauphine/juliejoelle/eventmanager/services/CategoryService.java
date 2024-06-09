package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoriesByName(String name, boolean desc);
    List<Category> getAll();
    Category getCategoryById(String id) throws CategoryNotFoundByIdException;
    List<Category> getCategoriesByEventsCountASC();
    List<Category> getCategoriesByEventsCountDESC();
}
