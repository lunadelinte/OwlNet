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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Event;
import ch.zli.m223.service.EventService;

@Path("/event")
@Tag(name = "Events", description = "Handling of events")
public class EventController {
      @Inject
    EventService eventService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Events.", description = "Returns a list of all events.")
    public List<Event> getEvents() {
        return eventService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Show an Event.", description = "Returns a single event.")
    public Event show(Long id) {
        return eventService.getEvent(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Event.", description = "Creates a new event and returns the newly added Event.")
    public Event create(Event event) {
       return eventService.create(event);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes an event", description = "Deletes a event and returns status code")
    public Response delete(Long id){
        return eventService.delete(id);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update an event", description = "Updates a event and returns event")
    @Transactional
    public Event updatePut(Long id, Event event){
        return eventService.update(id, event);
    }
}
