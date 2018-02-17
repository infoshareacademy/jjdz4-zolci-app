package pl.isa.autopartsJee.raportModule.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class Api {

    @GET
    @Path("/hello")
    public Response hello(){
        return Response.ok("Elo huju").build();
    }
}
