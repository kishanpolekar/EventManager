package io.project.eventmanagement.Service;

import io.project.eventmanagement.DAO.Event;
import io.project.eventmanagement.Repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepo repo;

    public List<Event> getAll() {
        return (List<Event>) repo.findAll();
    }

    public Event insertData(Event event) throws ParseException {
        Event newEvent = new Event();
        newEvent.setName(event.getName());
        newEvent.setStartDate(event.getStartDate());
        newEvent.setEndDate(event.getEndDate());
        newEvent.setDuration(event.getDuration());
        return repo.save(newEvent);
    }

    public Event updateData(int id, Event event) {

        Event oldEvent;
        if (repo.findById(id).isPresent())
            oldEvent = repo.findById(id).get();
        else
            oldEvent = new Event();
        oldEvent.setName(event.getName());
        oldEvent.setStartDate(event.getStartDate());
        oldEvent.setEndDate(event.getEndDate());
        oldEvent.setDuration(event.getDuration());
        return repo.save(oldEvent);
    }

    public ResponseEntity<Void> deleteData(int id) {

        if (repo.findById(id).isPresent()){

            repo.delete(repo.findById(id).get());
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
