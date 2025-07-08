package com.dauphine.juliejoelle.eventmanager.repositories;

import com.dauphine.juliejoelle.eventmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsernameIgnoreCase(String username);
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByExactUsername(String username);
}
