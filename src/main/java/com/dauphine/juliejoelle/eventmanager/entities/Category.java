package com.dauphine.juliejoelle.eventmanager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String categoryId;

    @Column
    private String name;

    @Column
    private String url;

    public Category(String uuid, String name, String url) {
        this.categoryId = uuid;
        this.name = name;
        this.url = url;
    }

    public Category() {

    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
}