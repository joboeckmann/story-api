package com.jwt.rest;

import com.google.common.base.Preconditions;
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

    @PUT
    @Path("/{storyId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStory(@PathParam("userId") String userId, @PathParam("storyId") String storyId, Story story){
        Preconditions.checkArgument(storyId.equals(""+story.getId()),"Invalid story id");
        int rowUpdated = storyService.updateStory(userId, storyId, story);
        if (rowUpdated>0) {
            return HeaderUtil.StoryResponse.createResponse(Response.Status.OK).build();
        }
        return HeaderUtil.StoryResponse.createResponse(Response.Status.NOT_FOUND).build();
    }



}