package io.project.eventmanagement.Service;

import io.project.eventmanagement.DAO.Event;
import io.project.eventmanagement.Repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo repo;

    public List<Event> getAll() {
        return (List<Event>) repo.findAll();
    }
}
