package de.fau.cs.mad.wanthavers.common.rest.api;


import de.fau.cs.mad.wanthavers.common.*;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("v1/langstrings")
@Api(value = "v1/langstrings", description = "Operations on langstrings")
public interface LangStringResource {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "",
            notes = "",
            response = LangString.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")})
    LangString get(@QueryParam("key") String key, @QueryParam("code") String code);

    @RolesAllowed(UserRoles.USER_ROLE_ADMIN)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "",
            notes = "",
            response = LangString.class)
    void create(@Auth User user, @QueryParam("key") String key, @QueryParam("code") String code, @QueryParam("value") String value);



}
