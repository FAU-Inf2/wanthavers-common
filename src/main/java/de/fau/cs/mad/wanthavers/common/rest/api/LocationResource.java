package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.*;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/locations")
@Api(value = "v1/locations", description = "Operations on locations")
public interface LocationResource {

    @GET
    @Path("/geocoder")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "reverse geocode ",
            notes = "reverse geocode ",
            response = Location.class)
    Location reverse(@Auth User user, @QueryParam("lat") double lat, @QueryParam("lon") double lon);

}
