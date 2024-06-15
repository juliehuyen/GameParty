package com.dauphine.juliejoelle.eventmanager.repositories;

import com.dauphine.juliejoelle.eventmanager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, String> {

    List<Event> getEventsByCategory_CategoryId(String categoryId);

    @Query("SELECT e FROM Event e WHERE e.eventDate <= :date")
    List<Event> getEventsAlreadyPassed(Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate > :date")
    List<Event> getEventsNotPassed(Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate > :date AND e.category.categoryId = :categoryId")
    List<Event> getEventsNotPassedByCategory_CategoryId(String categoryId, Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate <= :date AND e.category.categoryId = :categoryId")
    List<Event> getEventsAlreadyPassedByCategory_CategoryId(String categoryId, Date date);
}
