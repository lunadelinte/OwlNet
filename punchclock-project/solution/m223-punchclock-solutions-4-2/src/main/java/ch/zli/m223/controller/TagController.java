package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Tag;
import ch.zli.m223.service.TagService;

@Path("/tags")
// Überlegen Sie sich, weshalb das notwendig ist.
@org.eclipse.microprofile.openapi.annotations.tags.Tag(name = "Tags", description = "Handling of tags")
@RolesAllowed({ "User", "Admin" })
public class TagController {

    @Inject
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all tags.", 
        description = "Returns a list of all tags."
    )
    public List<Tag> index() {
        return tagService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new tag.", 
        description = "Creates a new tag and returns the newly added tag."
    )
    public Tag create(Tag tag) {
       return tagService.createTag(tag);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes an tag.",
        description = "Deletes an tag by its id."
    )
    public void delete(@PathParam("id") Long id) {
        tagService.deleteTag(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates an tag.",
        description = "Updates an tag by its id."
    )
    public Tag update(@PathParam("id") Long id, Tag tag) {
        return tagService.updateTag(id, tag);
    }

}
