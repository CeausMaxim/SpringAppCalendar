package com.example.springappcalendar.service;

import com.example.springappcalendar.model.Event;

import java.util.List;

public interface EventService {
    Event save(Event event);

    List<Event> getAll();

    Event get(int id);

    void delete(int id);
}
