package io.project.eventmanagement.controller;

import io.project.eventmanagement.DAO.Event;
import io.project.eventmanagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value ="/")
public class Controller {

    @Autowired
    EventService eventService;

    @GetMapping("/")
    public String index() {

        return "Event Manager";
    }

    @GetMapping("/allEvents")
    public List<Event> getAll() {

        return eventService.getAll();
    }
}
