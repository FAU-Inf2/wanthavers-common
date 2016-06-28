package de.fau.cs.mad.wanthavers.common.rest.api;


import de.fau.cs.mad.wanthavers.common.DesireFlag;
import de.fau.cs.mad.wanthavers.common.User;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/desires/{id}/flags")
@Api(description = "Operations for flagging")
public interface FlagResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Get all DesireFlags of a Desire",
            notes = "Returns list of all DesireFlags for a Desire.",
            response = List.class)
    List<DesireFlag> getDesireFlags(@Auth User user,
                                    @ApiParam(value = "id of the Desire", required = true)
                                    @PathParam("id") long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Get all DesireFlags of a Desire",
            notes = "Returns list of all DesireFlags for a Desire.",
            response = DesireFlag.class)
    DesireFlag flagDesire(@Auth User user,
                          @ApiParam(value = "id of the Desire", required = true)
                          @PathParam("id") long id,
                          @ApiParam(value = "Insert new DesireFlag to Desire", required = true) DesireFlag desireFlag);

    @DELETE
    @Path("/{flagId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Deletes DesireFlag")
    void unflagDesire(@Auth User user,
                          @ApiParam(value = "id of the Desire", required = true)
                          @PathParam("id") long id,
                          @ApiParam(value = "id of the Desire", required = true)
                          @PathParam("flagId") long flagId);
}
