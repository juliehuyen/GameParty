package com.dauphine.juliejoelle.eventmanager.repositories;

import com.dauphine.juliejoelle.eventmanager.entities.Registration;
import com.dauphine.juliejoelle.eventmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, String> {
    @Query ("SELECT u FROM User u, Registration r WHERE r.event.eventId = :eventId AND r.user = u")
    List<User> getAllUsersRegisteredByEvent(@Param("eventId") String eventId);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Registration r WHERE r.user.userId = :userId AND r.event.eventId = :eventId")
    boolean isUserRegisteredToEvent(String userId, String eventId);
}
