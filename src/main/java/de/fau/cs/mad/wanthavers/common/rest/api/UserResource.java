package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("users")
@Api(value = "users", description = "Operations on users")
public interface UserResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    User get();

}
