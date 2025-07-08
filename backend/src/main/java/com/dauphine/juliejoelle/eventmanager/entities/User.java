package com.dauphine.juliejoelle.eventmanager.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "'user'")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    public User() {

    }

    public User(String username) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

