package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.Chat;
import de.fau.cs.mad.wanthavers.common.Message;
import de.fau.cs.mad.wanthavers.common.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/chat")
@Api(value = "v1/chat", description = "Operations on chat")
public interface ChatResource {
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find all conversations for authenticated user",
            notes = "Provides a list of all conversations for authenticated user",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved list of chats (may be empty)"),
            @ApiResponse(code = 404, message = "chat does not exist"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Chat> get(@Auth User user);

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find all messages for chat id",
            notes = "Returns all messages if it exists.",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved messages in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "ParseChat not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Message> getMessages(
            @Auth User user,
            @ApiParam(value = "id of the chat", required = true)
            @PathParam("id") String id,
            @QueryParam("last_creation_time") Long lastCreationTime,
            @QueryParam("limit") Integer limit
            );


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new chat",
            notes = "creates a new chat between two users and desire",
            response = Chat.class)
    Chat createChat(@Auth User user,
                    @ApiParam(value = "new chat", required = true) Chat chat);

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "create a message",
            notes = "creates a message in given chat",
            response = Message.class)
    Message createMessage(
            @Auth User user,
            @ApiParam(value = "new message", required = true)
            @PathParam("id") String id, Message msg);

}
