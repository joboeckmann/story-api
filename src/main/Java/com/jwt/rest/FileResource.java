package com.jwt.rest;

import models.Genre;
import services.FileService;
import services.StoryService;
import utils.HeaderUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;

@Path("/file")
public class FileResource {

    private FileService fileService = new FileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFile() {

        File file  = fileService.getFile();
        return HeaderUtil.StoryResponse.createResponse(Response.Status.OK, file).build();
    }


}