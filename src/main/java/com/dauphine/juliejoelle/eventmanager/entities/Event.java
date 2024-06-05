package com.dauphine.juliejoelle.eventmanager.entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String eventId;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "event_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @Column(name = "location", nullable = false, length = 255)
    private String location;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Event(String title, String description, Date eventDate, String location, Category category, Type type) {
        this.eventId = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.location = location;
        this.category = category;
        this.type = type;
        this.createdAt = new java.util.Date();
    }

    public Event(String title, String description, Date eventDate, Category category, Type type) {
        this.eventId = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.category = category;
        this.type = type;
        this.createdAt = new java.util.Date();
    }

    public Event() {

    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

