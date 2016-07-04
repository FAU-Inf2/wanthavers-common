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
            @Auth User user,
            @ApiParam(value = "id of the desire", required = true)
            @PathParam("desire-id") long desireId,
            @ApiParam(value = "Haver to create", required = true) Haver newHaver
    );

    @GET
    @Path("/accepted")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find accepted haver",
            notes = "Returns a haver if it exists.",
            response = Haver.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved haver in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Haver not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Haver getAccepted(
            @ApiParam(value = "id of the desired desire", required = true)
            @PathParam("desire-id")long desireId);

    @GET
    @Path("/{user-id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find haver by user-id",
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
            @ApiParam(value = "id of the user", required = true)
            @PathParam("user-id") long userId);

    @PUT
    @Path("/{user-id}")
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
            @PathParam("user-id") long userId,
            @ApiParam(value = "new details of the specified haver", required = true) Haver haver);

    @PUT
    @Path("/{user-id}/status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing haver status",
            notes = "Updates the status of an existing haver relation. Returns the updated object.",
            response = Haver.class)
    Haver updateHaverStatus(
            @ApiParam(value = "id of the desire", required = true)
            @PathParam("desire-id") long desireId,
            @ApiParam(value = "id of the haver relation", required = true)
            @PathParam("user-id") long userId,
            int status);
}
