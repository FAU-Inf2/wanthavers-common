package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.User;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("v1/users")
@Api(value = "v1/users", description = "Operations on users")
public interface UserResource {

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find user by id",
            notes = "Returns a user if it exists.",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved user in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    User get(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("id")long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new user",
            notes = "Inserts a new user into the database. Returns the new user object including id.",
            response = User.class)
    User createUser(@ApiParam(value = "User to create", required = true)User newUser);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing user",
            notes = "Updates the details of an existing user. Returns the updated user object.",
            response = User.class)
    User updateUser(
            @ApiParam(value = "id of the user", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new details of the specified user", required = true) User user);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Delete a user",
            notes = "Removes a user from the database.")
    void deleteUser(
            @ApiParam(value = "id of the to be deleted user", required = true)
            @PathParam("id") long id);

}
