package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CategoryService {

    List<Category> getCategoriesByName(String name, boolean desc);
    List<Category> getAll();
    Category getCategoryById(String id) throws CategoryNotFoundByIdException;
    List<Category> getCategoriesByEventsNotPassedCountASC();
    List<Category> getCategoriesByEventsNotPassedCountDESC();
}
