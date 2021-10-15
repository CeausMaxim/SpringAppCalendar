package com.example.springappcalendar.controller;

import com.example.springappcalendar.model.Event;
import com.example.springappcalendar.repository.EventRepository;
import com.example.springappcalendar.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return new ResponseEntity<Event>(eventService.save(event), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Event> get() {
        return eventService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> get(@PathVariable("id") int id) {
        return new ResponseEntity<Event>(eventService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        eventService.delete(id);
        return new ResponseEntity<String>("Event deleted", HttpStatus.OK);
    }
}
