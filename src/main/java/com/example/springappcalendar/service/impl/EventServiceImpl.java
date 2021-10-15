package com.example.springappcalendar.service.impl;

import com.example.springappcalendar.exception.ResourceNotFoundException;
import com.example.springappcalendar.model.Event;
import com.example.springappcalendar.repository.EventRepository;
import com.example.springappcalendar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event get(int id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            return event.get();
        } else {
            throw new ResourceNotFoundException("Id", "Event", id);
        }
    }

    @Override
    public void delete(int id) {
        eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", "ID", id));
        eventRepository.deleteById(id);
    }
}
