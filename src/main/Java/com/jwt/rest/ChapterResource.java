package com.jwt.rest;

import com.google.inject.Inject;
import models.Chapter;

import services.ChapterService;
import utils.HeaderUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("user/{userId}/story/{storyId}/chapter")
public class ChapterResource {

    private ChapterService chapterService = new ChapterService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChapter(@PathParam("userId") String userId, @PathParam("storyId") int storyId ){
        List<Chapter> chapters = chapterService.getChapters(userId, storyId);

         return HeaderUtil.StoryResponse.createResponse(Response.Status.OK, chapters).build();
    }



}