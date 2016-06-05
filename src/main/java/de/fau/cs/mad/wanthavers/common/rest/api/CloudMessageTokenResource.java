package de.fau.cs.mad.wanthavers.common.rest.api;


import de.fau.cs.mad.wanthavers.common.CloudMessageToken;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/users/{user-id}/tokens")
@Api(value = "v1/users/{user-id}/tokens", description = "Operations on CloudMessageTokens")
public interface CloudMessageTokenResource {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find tokens by user's id",
            notes = "Returns tokens of an existing user.",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved tokens of user"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<CloudMessageToken> getAllTokens(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Adds a new token",
            notes = "Inserts a new token into the database. Returns the new CloudMessageToken object including id.",
            response = CloudMessageToken.class)
    CloudMessageToken createToken(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "Token to create", required = true)CloudMessageToken newToken
    );

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find token by id",
            notes = "Returns a token if it exists.",
            response = CloudMessageToken.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved token in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Token not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    CloudMessageToken get(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "id of the token", required = true)
            @PathParam("id") long id);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing token",
            notes = "Updates the details of an existing token. Returns the updated CloudMessageToken object.",
            response = CloudMessageToken.class)
    CloudMessageToken updateToken(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "id of the token", required = true)
            @PathParam("id") long id,
            @ApiParam(value = "new details of the specified token", required = true) CloudMessageToken token);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "Delete a CloudMessageToken",
            notes = "Removes a token from the database.")
    void deleteToken(
            @ApiParam(value = "id of the desired user", required = true)
            @PathParam("user-id")long userId,
            @ApiParam(value = "id of the to be deleted token", required = true)
            @PathParam("id") long id);

}
