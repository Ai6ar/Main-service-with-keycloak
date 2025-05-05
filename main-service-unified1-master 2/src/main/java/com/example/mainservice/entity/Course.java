package com.example.mainservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter @Setter
public class Course extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 1000)
    private String description;
}
