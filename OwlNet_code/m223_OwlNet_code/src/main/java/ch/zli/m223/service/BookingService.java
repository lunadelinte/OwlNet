package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Booking create(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    public List<Booking> findAll() {
        var query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }

    @Transactional
    public Response delete(Long id){
        Booking booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
        return Response.status(204).build();
    }

    public Booking getBooking(Long id){
        return entityManager.find(Booking.class, id);
    }

    public Booking update(Long id, Booking booking){
        booking.setId(id);
        return entityManager.merge(booking);
    }
}
