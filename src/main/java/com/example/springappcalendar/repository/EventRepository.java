package com.example.springappcalendar.repository;

import com.example.springappcalendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
