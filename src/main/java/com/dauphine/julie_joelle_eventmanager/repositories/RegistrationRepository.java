package com.dauphine.julie_joelle_eventmanager.repositories;

import com.dauphine.julie_joelle_eventmanager.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
}
