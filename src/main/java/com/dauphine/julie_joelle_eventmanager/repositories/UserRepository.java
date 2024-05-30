package com.dauphine.julie_joelle_eventmanager.repositories;

import com.dauphine.julie_joelle_eventmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
