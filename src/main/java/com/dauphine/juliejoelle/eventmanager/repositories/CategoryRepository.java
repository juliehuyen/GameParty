package com.dauphine.juliejoelle.eventmanager.repositories;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,String> {

    @Query("""
    SELECT DISTINCT c, count(e) as EventsCount
    FROM Category c
    LEFT JOIN c.events e
    WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.eventDate > :date
    GROUP BY c
    ORDER BY EventsCount ASC
    """)
    List<Category> getCategoriesByNameByEventsCountASC(String name, Date date);

    @Query("""
    SELECT DISTINCT c, count(e) as EventsCount
    FROM Category c
    LEFT JOIN c.events e
    WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) AND e.eventDate > :date
    GROUP BY c
    ORDER BY EventsCount DESC
    """)
    List<Category> getCategoriesByNameByEventsCountDESC(String name, Date date);

    @Query("SELECT c FROM Category c LEFT JOIN c.events e ON e.eventDate > :date GROUP BY c.categoryId ORDER BY COUNT(e) ASC")
    List<Category> getCategoriesByEventsNotPassedCountASC(Date date);
    @Query("SELECT c FROM Category c LEFT JOIN c.events e ON e.eventDate > :date GROUP BY c.categoryId ORDER BY COUNT(e) DESC")
    List<Category> getCategoriesByEventsNotPassedCountDESC(Date date);

}
