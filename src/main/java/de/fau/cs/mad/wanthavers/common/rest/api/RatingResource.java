package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.Rating;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("v1/users/{user-id}/ratings")
@Api(value = "v1/users/{user-id}/ratings", description = "Operations on Ratings")
public interface RatingResource {
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find ratings by user's id",
            notes = "Returns ratings of an existing user.",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved ratings of user"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Rating> getAllRatings(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new rating",
            notes = "Inserts a new rating into the database. Returns the new rating object including id.",
            response = Rating.class)
    Rating createRating(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "Rating to create", required = true)Rating newRating
            );

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find rating by id",
            notes = "Returns a rating if it exists.",
            response = Rating.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved rating in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Rating not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Rating get(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "id of the rating", required = true)
            @PathParam("id") long id);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing rating",
            notes = "Updates the details of an existing rating. Returns the updated rating object.",
            response = Rating.class)
    Rating updateRating(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "id of the rating", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new details of the specified rating", required = true) Rating rating);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Delete a rating",
            notes = "Removes a rating from the database.")
    void deleteRating(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "id of the to be deleted rating", required = true)
            @PathParam("id") long id);

    @GET
    @Path("/avg")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Delete a rating",
            notes = "Removes a rating from the database.",
            response = Rating.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved average rating object of user"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Rating avgRating(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId);

    @GET
    @Path("/dummy")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Add some dummy ratings",
            notes = "creates dummy ratings")
    void createDummies(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId);
}
