package com.jwt.rest;

import com.google.inject.Inject;
import models.Story;
import services.ChapterService;
import services.StoryService;
import utils.HeaderUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user/{userId}/story")
public class StoryResource {

    private StoryService storyService=new  StoryService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStory(@PathParam("userId") String userId){

        List<Story> stories = storyService.getStoriesByUser(userId);
         return HeaderUtil.StoryResponse.createResponse(Response.Status.OK, stories).build();
    }



}