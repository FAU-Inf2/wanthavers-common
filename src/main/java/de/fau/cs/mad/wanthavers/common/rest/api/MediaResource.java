package de.fau.cs.mad.wanthavers.common.rest.api;



import de.fau.cs.mad.wanthavers.common.Media;
import io.swagger.annotations.*;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.util.List;


@Path("v1/media")
@Api(value = "v1/media", description = "Operations on media")
public interface MediaResource {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find all media",
            notes = "Returns all media",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved media"),
            @ApiResponse(code = 404, message = "media not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Media> getAll();

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find Media by id",
            notes = "Returns Media if it exists.",
            response = Media.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved Media in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Media not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Media get(
            @ApiParam(value = "id of the desired Media", required = true)
            @PathParam("id") long id);

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new media object",
            notes = "uploads a new media object",
            response = Media.class)
    Media createMedia(@FormDataParam("file") InputStream fileInputStream,
                       @FormDataParam("file") FormDataContentDisposition contentDispositionHeader);


}
