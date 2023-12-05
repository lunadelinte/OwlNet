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

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.Workspace;
import ch.zli.m223.service.BookingService;
import ch.zli.m223.service.WorkspaceService;

@Path("/workspace")
@Tag(name = "Workspace", description = "Handling of workspaces")
public class WorkspaceController {
      @Inject
    WorkspaceService workspaceService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all workspaces.", description = "Returns a list of all workspaces.")
    public List<Workspace> getWorkspaces() {
        return workspaceService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Show a workspace.", description = "Returns a single workspace.")
    public Workspace show(Long id) {
        return workspaceService.getWorkspace(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new booking.", description = "Creates a new workspace and returns the newly added workspace.")
    public Workspace create(Workspace workspace) {
       return workspaceService.create(workspace);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes a workspace", description = "Deletes a workspace and returns status code")
    public Response delete(Long id){
        return workspaceService.delete(id);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update a workspace", description = "Updates a workspace and returns workspace")
    @Transactional
    public Workspace updatePut(Long id, Workspace workspace){
        return workspaceService.update(id, workspace);
    }
}
