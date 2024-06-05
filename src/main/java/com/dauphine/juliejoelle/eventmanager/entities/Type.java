package com.dauphine.juliejoelle.eventmanager.entities;

import jakarta.persistence.*;

@Entity
public class Type {
    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String typeId;

    @Column
    private String name;

    public String getId() {
        return typeId;
    }

    public String getName() {
        return name;
    }
}
