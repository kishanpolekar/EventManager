package io.project.eventmanagement.Repository;

import io.project.eventmanagement.DAO.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EventRepo extends CrudRepository<Event , Integer> { }
