package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "Booking", description = "Handling of bookings")
public class BookingController {
    @Inject
    BookingService bookingService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all bookings.", description = "Returns a list of all bookings.")
    public List<Booking> getMemberBookings() {
        return bookingService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Show a booking.", description = "Returns a single booking.")
    public Booking show(Long id) {
        return bookingService.getBooking(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new booking and returns the newly added booking.")
    public Booking create(Booking booking) {
       return bookingService.create(booking);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes a booking", description = "Deletes a booking and returns status code")
    public Response delete(Long id){
        return bookingService.delete(id);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update a booking", description = "Updates a booking and returns booking")
    @Transactional
    public Booking updatePut(Long id, Booking booking){
        return bookingService.update(id, booking);
    }
}
