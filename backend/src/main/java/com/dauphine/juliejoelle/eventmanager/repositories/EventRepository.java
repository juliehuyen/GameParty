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
    @Query("SELECT e FROM Event e WHERE e.eventDate > :date ORDER BY e.eventDate DESC")
    List<Event> getEventsNotPassedSortedByDateDESC(Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate > :date AND e.category.categoryId = :categoryId ORDER BY e.eventDate ASC")
    List<Event> getEventsNotPassedSortedByDateASCByCategory_CategoryId(String categoryId, Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate > :date AND e.category.categoryId = :categoryId ORDER BY e.eventDate DESC")
    List<Event> getEventsNotPassedSortedByDateDESCByCategory_CategoryId(String categoryId, Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate > :date ORDER BY e.eventDate ASC")
    List<Event> getEventsNotPassedSortedByDateASC(Date date);
    @Query("""
    SELECT e, COUNT(r) as ParticipantsCount
    FROM Event e
    LEFT JOIN Registration r ON e.eventId = r.event.eventId
    WHERE e.eventDate > :date
    AND e.category.categoryId = :categoryId
    GROUP BY e.eventId
    ORDER BY ParticipantsCount DESC
    """)
    List<Event> getEventsNotPassedSortedByParticipantsCountDESCByCategory_CategoryId(String categoryId, Date date);
    @Query("""
    SELECT e, COUNT(r) as ParticipantsCount
    FROM Event e
    LEFT JOIN Registration r ON e.eventId = r.event.eventId
    WHERE e.eventDate > :date
    AND e.category.categoryId = :categoryId
    GROUP BY e.eventId
    ORDER BY ParticipantsCount ASC
    """)
    List<Event> getEventsNotPassedSortedByParticipantsCountASCByCategory_CategoryId(String categoryId, Date date);
    @Query("""
    SELECT e, COUNT(r) as ParticipantsCount
    FROM Event e
    LEFT JOIN Registration r ON e.eventId = r.event.eventId
    WHERE e.eventDate > :date
    GROUP BY e.eventId
    ORDER BY ParticipantsCount DESC
    """)
    List<Event> getEventsNotPassedSortedByParticipantsCountDESC(Date date);
    @Query("""
    SELECT e, COUNT(r) as ParticipantsCount
    FROM Event e
    LEFT JOIN Registration r ON e.eventId = r.event.eventId
    WHERE e.eventDate > :date
    GROUP BY e.eventId
    ORDER BY ParticipantsCount ASC
    """)
    List<Event> getEventsNotPassedSortedByParticipantsCountASC(Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate <= :date ORDER BY e.eventDate DESC")
    List<Event> getEventsPassedSortedByDateDESC(Date date);
    @Query("SELECT e FROM Event e WHERE e.eventDate <= :date ORDER BY e.eventDate ASC")
    List<Event> getEventsPassedSortedByDateASC(Date date);
    @Query("""
    SELECT e, COUNT(r) as ParticipantsCount
    FROM Event e
    LEFT JOIN Registration r ON e.eventId = r.event.eventId
    WHERE e.eventDate <= :date
    GROUP BY e.eventId
    ORDER BY ParticipantsCount DESC
    """)
    List<Event> getEventsPassedSortedByParticipantsCountDESC(Date date);
    @Query("""
    SELECT e, COUNT(r) as ParticipantsCount
    FROM Event e
    LEFT JOIN Registration r ON e.eventId = r.event.eventId
    WHERE e.eventDate <= :date
    GROUP BY e.eventId
    ORDER BY ParticipantsCount ASC
    """)
    List<Event> getEventsPassedSortedByParticipantsCountASC(Date date);
}
