package com.dauphine.julie_joelle_eventmanager.entity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "Feedbacks")
public class Feedback {

    @Id
    @Column(name = "feedback_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String feedbackId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comments")
    private String comments;

    @Column(name = "feedback_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date feedbackDate = new Date();

    public Feedback() {
        this.feedbackId = UUID.randomUUID().toString();
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
