package utils;


import javax.ws.rs.core.Response;

public class HeaderUtil {

    public static class StoryResponse {

        public static Response.ResponseBuilder createResponse(Response.Status status){
            Response.ResponseBuilder rb = Response.status(status);
            String url = System.getenv("STORIES_UI_URL");
            return rb.header("Access-Control-Allow-Origin", url);


        }

        public static Response.ResponseBuilder createResponse(Response.Status status, Object entity){
            Response.ResponseBuilder rb = Response.status(status);
            rb.entity(entity);
            String url = System.getenv("STORIES_UI_URL");
            return rb.header("Access-Control-Allow-Origin", url);
            
        }
    }
}
