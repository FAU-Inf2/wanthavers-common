package de.fau.cs.mad.wanthavers.common.rest.api;


import de.fau.cs.mad.wanthavers.common.Category;
import de.fau.cs.mad.wanthavers.common.User;
import de.fau.cs.mad.wanthavers.common.UserRoles;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.*;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("v1/categories")
@Api(value = "v1/categories", description = "Operations on categories")
public interface CategoryResource {

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Find Category by id",
            notes = "Returns Category if it exists.",
            response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved Category in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    Category get(
            @ApiParam(value = "id of the desired Category", required = true)
            @PathParam("id") long id);

    @GET
    @Path("/{id}/subcategories")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Finds all Subcategories for id",
            notes = "Returns categories if it exists.",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved Category in body"),
            @ApiResponse(code = 400, message = "Invalid id supplied"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 500, message = "Server broken, please contact administrator")})
    List<Category> getSub(
            @ApiParam(value = "id of the desired Category", required = true)
            @PathParam("id") long id);

    @RolesAllowed(UserRoles.USER_ROLE_ADMIN)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Create a new category object",
            notes = "uploads a new category object",
            response = Category.class)
    Category create(@Auth User user, @ApiParam(value = "Category to create", required = true) Category newCategory);


}
