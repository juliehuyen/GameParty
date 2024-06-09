package com.dauphine.juliejoelle.eventmanager.repositories;

import com.dauphine.juliejoelle.eventmanager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,String> {

    @Query("""
    SELECT DISTINCT c, count(e) as EventsCount
    FROM Category c
    LEFT JOIN c.events e
    WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))
    GROUP BY c
    ORDER BY EventsCount ASC
    """)
    List<Category> getCategoriesByNameByEventsCountASC(String name);

    @Query("""
    SELECT DISTINCT c, count(e) as EventsCount
    FROM Category c
    LEFT JOIN c.events e
    WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))
    GROUP BY c
    ORDER BY EventsCount DESC
    """)
    List<Category> getCategoriesByNameByEventsCountDESC(String name);

    @Query("""
    SELECT DISTINCT c, count(e) as EventsCount
    FROM Category c
    LEFT JOIN c.events e
    GROUP BY c
    ORDER BY EventsCount ASC
    """)
    List<Category> getCategoriesByEventsCountASC();

    @Query("""
    SELECT DISTINCT c, count(e) as EventsCount
    FROM Category c
    LEFT JOIN c.events e
    GROUP BY c
    ORDER BY EventsCount DESC
    """)
    List<Category> getCategoriesByEventsCountDESC();

}
