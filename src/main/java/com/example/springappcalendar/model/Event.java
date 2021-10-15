package com.example.springappcalendar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nameEvent")
    private String name;

    @Column(name = "date")
    private Integer date;
}
