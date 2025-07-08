package com.dauphine.juliejoelle.eventmanager.services.impl;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import com.dauphine.juliejoelle.eventmanager.exceptions.CategoryNotFoundByIdException;
import com.dauphine.juliejoelle.eventmanager.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCategoriesByName_DESC() {
        String name = "Music";
        List<Category> expectedCategories = Arrays.asList(new Category(), new Category());
        when(categoryRepository.getCategoriesByNameByEventsCountDESC(eq(name), any(Date.class)))
                .thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getCategoriesByName(name, true);

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testGetCategoriesByName_ASC() {
        String name = "Music";
        List<Category> expectedCategories = Arrays.asList(new Category(), new Category());
        when(categoryRepository.getCategoriesByNameByEventsCountASC(eq(name), any(Date.class)))
                .thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getCategoriesByName(name, false);

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testGetAll() {
        List<Category> expectedCategories = Arrays.asList(new Category(), new Category());
        when(categoryRepository.findCategoriesByNameASC()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getAll();

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testGetCategoryById_Found() throws CategoryNotFoundByIdException {
        String id = "123";
        Category expectedCategory = new Category();
        when(categoryRepository.findById(id)).thenReturn(Optional.of(expectedCategory));

        Category actualCategory = categoryService.getCategoryById(id);

        assertEquals(expectedCategory, actualCategory);
    }

    @Test
    void testGetCategoryById_NotFound() {
        String id = "123";
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundByIdException.class, () -> categoryService.getCategoryById(id));
    }

    @Test
    void testGetCategoriesByEventsNotPassedCountASC() {
        List<Category> expectedCategories = Arrays.asList(new Category(), new Category());
        when(categoryRepository.getCategoriesByEventsNotPassedCountASC(any(Date.class)))
                .thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getCategoriesByEventsNotPassedCountASC();

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    void testGetCategoriesByEventsNotPassedCountDESC() {
        List<Category> expectedCategories = Arrays.asList(new Category(), new Category());
        when(categoryRepository.getCategoriesByEventsNotPassedCountDESC(any(Date.class)))
                .thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getCategoriesByEventsNotPassedCountDESC();

        assertEquals(expectedCategories, actualCategories);
    }
}
