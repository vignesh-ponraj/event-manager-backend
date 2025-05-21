package com.tiny.demo.controller;

import com.tiny.demo.entity.Event;
import com.tiny.demo.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin // allow frontend access
public class EventController {

    private final EventRepository repo;

    public EventController(EventRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{date}")
    public List<Event> getEventsByDate(@PathVariable String date) {
        return repo.findByEventDate(LocalDate.parse(date));
    }
}