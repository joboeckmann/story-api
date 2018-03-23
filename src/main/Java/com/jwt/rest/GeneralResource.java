package com.jwt.rest;

import models.Genre;
import models.Story;
import services.StoryService;
import utils.HeaderUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/general")
public class GeneralResource {

    private StoryService storyService = new StoryService();

    @Path("/genre")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGenre() {

        List<Genre> genres = storyService.getGenres();
        return HeaderUtil.StoryResponse.createResponse(Response.Status.OK, genres).build();
    }


}