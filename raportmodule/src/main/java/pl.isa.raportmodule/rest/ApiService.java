package pl.isa.raportmodule.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.raportCreator.ClientKeyOperator;
import pl.isa.raportmodule.repository.LogRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("/")
public class ApiService {
    @Inject
    LogRepository logRepository;
    Logger logger = LoggerFactory.getLogger(ApiService.class);

    @POST
    @Path("/addlog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLog(Log log) {
        log.setLocalDateTime(LocalDateTime.now());
        if (ClientKeyOperator.checkKey(log)) {
            logRepository.addSingleLog(log);
            logger.info("log added in api");
            return Response.ok(log).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/servicestatus")
    public Response serviceState() {
        return Response.ok("Service online").build();
    }


    @GET
    @Path("/getlogs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlogs() {
        logger.info("logs returned in api");
        return Response.ok(logRepository.getLogs()).build();
    }

}
