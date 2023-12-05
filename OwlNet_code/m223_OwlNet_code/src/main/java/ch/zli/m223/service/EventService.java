package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Event;

@ApplicationScoped
public class EventService {
        @Inject
    private EntityManager entityManager;

    @Transactional
    public Event create(Event event) {
        entityManager.persist(event);
        return event;
    }

    public List<Event> findAll() {
        var query = entityManager.createQuery("FROM Event", Event.class);
        return query.getResultList();
    }

    @Transactional
    public Response delete(Long id){
        Event event = entityManager.find(Event.class, id);
        entityManager.remove(event);
        return Response.status(204).build();
    }

    public Event getEvent(Long id){
        return entityManager.find(Event.class, id);
    }

    public Event update(Long id, Event event){
        event.setId(id);
        return entityManager.merge(event);
    }
}
