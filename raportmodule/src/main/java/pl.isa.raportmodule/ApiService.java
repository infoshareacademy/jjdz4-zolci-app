package pl.isa.raportmodule;

import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.repository.LogRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ApiService {
    @Inject
    LogRepository logRepository;

    @GET
    @Path("/addlog")
    public Response addLog() {
//        logRepository.addSingleLog(log);
        return Response.ok("test").build();
    }
}
