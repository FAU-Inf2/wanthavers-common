package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.Desire;
import de.fau.cs.mad.wanthavers.common.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v1/desires")
@Api(value = "v1/Desires", description = "Operations on Desires")
public interface DesireResource {

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find Desire by id",
            notes = "Returns a Desire if it exists.",
            response = Desire.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved Desire in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Desire not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Desire get(
            @ApiParam(value = "id of the desired Desire", required = true)
            @PathParam("id") long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new Desire",
            notes = "Inserts a new Desire into the database. Returns the new Desire object including id.",
            response = Desire.class)
    Desire createDesire(@ApiParam(value = "Desire to create", required = true) Desire newDesire, @Auth User user);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing Desire",
            notes = "Updates the details of an existing Desire. Returns the updated Desire object.",
            response = Desire.class)
    Desire updateDesire(
            @ApiParam(value = "id of the Desire", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new details of the specified Desire", required = true) Desire Desire);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Delete a Desire",
            notes = "Removes a Desire from the database.")
    void deleteDesire(
            @ApiParam(value = "id of the to be deleted Desire", required = true)
            @PathParam("id") long id);

    @GET
    @Path("/dummy")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Add some dummy desires",
            notes = "creates dummy desires",
            response = Desire.class)
    void createDummies();

}
