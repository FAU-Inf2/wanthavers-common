package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.*;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/users")
@Api(value = "v1/users", description = "Operations on users")
public interface UserResource {
    @RolesAllowed(UserRoles.USER_ROLE_ADMIN)
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find all users",
            notes = "Provides a list of all users",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved list of users (may be empty)"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<User> get();

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
    User createUser(@ApiParam(value = "User to create", required = true)User newUser, @QueryParam("password")String password);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing user",
            notes = "Updates the details of an existing user. Returns the updated user object.",
            response = User.class)
    User updateUser(
            @Auth User user,
            @ApiParam(value = "new details of the specified user", required = true) User newUser);

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Delete a user",
            notes = "Removes a user from the database.")
    void deleteUser(@Auth User user);

    @GET
    @Path("/locations")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Get all desires of user as a haver",
            notes = "Returns all desires for which user is a haver",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved desires in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Location> getSavedLocations(@Auth User user);


    @POST
    @Path("/password")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.WILDCARD)
    @ApiOperation(
            value = "reset user password",
            notes = "reset user password",
            response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "reset password"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    void resetPassword(@FormParam("token") String token, @FormParam("password") String password);

    @POST
    @Path("/passwordtoken")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.WILDCARD)
    @ApiOperation(
            value = "sends token",
            notes = "sends token to user",
            response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "sent token"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    void sendToken(@FormParam("email") String email);

    @POST
    @Path("/{id}/flag")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "flags an user",
            notes = "flags an user",
            response = UserFlag.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    UserFlag flagUser(@Auth User user, @PathParam("id") long userId);


}
