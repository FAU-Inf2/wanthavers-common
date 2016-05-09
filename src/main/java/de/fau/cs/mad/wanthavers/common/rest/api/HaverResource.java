package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.Haver;
import de.fau.cs.mad.wanthavers.common.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("v1/desires/{desire-id}/havers")
@Api(value = "v1/desires/{desire-id}/havers", description = "Operations on Havers")
public interface HaverResource {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find havers by desire's id",
            notes = "Returns havers of an existing desire.",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved havers"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Desire not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Haver> getAllHavers(
            @ApiParam(value = "id of the desire", required = true)
            @PathParam("desire-id") long desireId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new haver",
            notes = "Inserts a new haver into the database. Returns the new haver object including id.",
            response = Haver.class)
    Haver createHaver(
            @ApiParam(value = "id of the desire", required = true)
            @PathParam("desire-id") long desireId,
            @ApiParam(value = "Haver to create", required = true) Haver newHaver,
            @Auth User user
    );

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find haver by id",
            notes = "Returns a haver if it exists.",
            response = Haver.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved haver in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Haver not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Haver get(
            @ApiParam(value = "id of the desired desire", required = true)
            @PathParam("desire-id")long desireId,
            @ApiParam(value = "id of the haver", required = true)
            @PathParam("id") long id);
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing haver relation",
            notes = "Updates the details of an existing haver relation. Returns the updated object.",
            response = Haver.class)
    Haver updateHaver(
            @ApiParam(value = "id of the desire", required = true)
            @PathParam("desire-id") long desireId,
            @ApiParam(value = "id of the haver relation", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new details of the specified haver", required = true) Haver haver);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Delete a haver",
            notes = "Removes a haver from the database.")
    void deleteHaver(
            @ApiParam(value = "id of the desire", required = true)
            @PathParam("desire-id") long desireId,
            @ApiParam(value = "id of the to be deleted haver", required = true)
            @PathParam("id") long id);


}
