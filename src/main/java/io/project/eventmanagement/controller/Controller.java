package io.project.eventmanagement.controller;

import io.project.eventmanagement.DAO.Event;
import io.project.eventmanagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @RequestMapping(value = "/addEvent")
    @PostMapping
    public String addEvent(@RequestBody Event e) throws ParseException {

        eventService.insertData(e);
        return "Event added successfully!";
    }

    @PutMapping(value = "/updateEvent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") int id, @RequestBody Event e) throws ParseException {

        return new ResponseEntity<>(eventService.updateData(id, e), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEvent/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable(value = "id") int id) {

        return eventService.deleteData(id);
    }
}
