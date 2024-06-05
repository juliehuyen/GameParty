package com.dauphine.juliejoelle.eventmanager.services;

import com.dauphine.juliejoelle.eventmanager.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoriesByName(String name);
    List<Category> getAll();
}
