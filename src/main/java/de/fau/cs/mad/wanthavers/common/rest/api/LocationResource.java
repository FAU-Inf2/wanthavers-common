package de.fau.cs.mad.wanthavers.common.rest.api;

import de.fau.cs.mad.wanthavers.common.Location;
import de.fau.cs.mad.wanthavers.common.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Creates a new location",
            notes = "Inserts a new location into the database. Returns the new location object including id.",
            response = Location.class)
    Location createLocation(
            @Auth User user,
            @ApiParam(value = "Location to create", required = true) Location location
    );

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Get an existing location",
            notes = "Gets the details of an existing location.",
            response = Location.class)
    Location get(@Auth User user, @PathParam("id") long id);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Update an existing location",
            notes = "Updates the details of an existing location. Returns the updated location object.",
            response = Location.class)
    Location updateLocation(@Auth User user,
                            @ApiParam(value = "id of the location", required = true) @PathParam("id") long id,
                            @ApiParam(value = "Location to create", required = true) Location location);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @ApiOperation(
            value = "",
            notes = "")
    void deleteLocation(@Auth User user, @ApiParam(value = "id of the location", required = true) @PathParam("id") long id);

}
