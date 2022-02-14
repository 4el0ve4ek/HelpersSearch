package com.example.tasker.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String information;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Person author;

    @Column(name="free_workplace")
    private int freeWorkplace;


}
