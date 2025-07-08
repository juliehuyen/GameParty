package com.dauphine.juliejoelle.eventmanager.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @Column(name = "registration_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String registrationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "registration_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    public Registration() {

    }

    public Registration(User user, Event event) {
        this.registrationId = UUID.randomUUID().toString();
        this.user = user;
        this.event = event;
        this.registrationDate = new Date();
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

