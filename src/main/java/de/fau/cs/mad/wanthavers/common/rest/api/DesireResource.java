package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.Chat;
import de.fau.cs.mad.wanthavers.common.Desire;
import de.fau.cs.mad.wanthavers.common.DesireFlag;
import de.fau.cs.mad.wanthavers.common.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/desires")
@Api(value = "v1/Desires", description = "Operations on Desires")
public interface DesireResource {
    @GET
    @Path("/filters")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Filter desires by several options",
            notes = "Provides a list of all filtered desires",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved list of desires (may be empty)"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Desire> getByFilters(@QueryParam("category") Long category,
                              @QueryParam("price_min") Double price_min,
                              @QueryParam("price_max") Double price_max,
                              @QueryParam("reward_min") Double reward_min,
                              @QueryParam("rating_min") Float rating_min,
                              @QueryParam("lat") Double lat,
                              @QueryParam("lon") Double lon,
                              @QueryParam("radius") Double radius,
                              @QueryParam("status") List<Integer> status,
                              @QueryParam("last_creation_time") Long lastCreationTime,
                              @QueryParam("limit") Integer limit,
                              @QueryParam("creator_id") Long creatorId,
                              @QueryParam("haver_id") Long haverId,
                              @QueryParam("haver_status") List<Integer> haverStatus);

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find all desires",
            notes = "Provides a list of all desires",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved list of desires (may be empty)"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Desire> get();

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
    Desire createDesire(@Auth User user, @ApiParam(value = "Desire to create", required = true) Desire newDesire);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing Desire",
            notes = "Updates the details of an existing Desire. Returns the updated Desire object.",
            response = Desire.class)
    Desire updateDesire(@Auth User user,
            @ApiParam(value = "id of the Desire", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new details of the specified Desire", required = true) Desire Desire);

    @PUT
    @Path("/{id}/status")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing Desire",
            notes = "Updates the details of an existing Desire. Returns the updated Desire object.",
            response = Desire.class)
    Desire updateDesireStatus(@Auth User user,
            @ApiParam(value = "id of the Desire", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new status of the specified Desire", required = true) @QueryParam("status") int status);

    @GET
    @Path("/{id}/chat/{user2}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns or creates a chat between two users",
            notes = "Returns or creates a chat between two users",
            response = Chat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved chat"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Chat getChat(@Auth User user, @PathParam("user2") long user2, @PathParam("id") long desireId);

    @GET
    @Path("/dummy")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Add some dummy desires",
            notes = "creates dummy desires")
    void createDummies();

}
