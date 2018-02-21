package pl.isa.raportmodule.rest;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.raportmodule.domain.AdminPreferences;
import pl.isa.raportmodule.domain.ClientKey;
import pl.isa.raportmodule.domain.Log;
import pl.isa.raportmodule.repository.AdminPreferencesRepository;
import pl.isa.raportmodule.repository.ClientKeysRepository;
import pl.isa.raportmodule.repository.LogRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;


@Path("/")
public class ApiService {
    @Inject
    ClientKeysRepository clientKeysRepository;
    @Inject
    LogRepository logRepository;
    @Inject
    AdminPreferencesRepository adminPreferencesRepository;

    Logger logger = LoggerFactory.getLogger(ApiService.class);
    private KeyVerifier keyVerifier;

    @GET
    @Path("/servicestatus")
    public Response serviceState() {
        return Response.ok("Service online").build();
    }

    @POST
    @Path("/addlog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLog(Log log) {
        log.setLocalDateTime(LocalDateTime.now());

        for (ClientKey clientKey : clientKeysRepository.getAllKeys()) {
            if (clientKey.getClientKey().equals(log.getKey())) {
                logRepository.addSingleLog(log);
                return Response.ok(log).build();
            }
        }
//        if (keyVerifier.checkKey(log)) {
//            logRepository.addSingleLog(log);
//            return Response.ok(log).build();
//
//        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @GET
    @Path("/getlogs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlogs() {
        logger.info("logs returned in api");
        return Response.ok(new Gson().toJson(logRepository.getLogs())).build();
    }

    @POST
    @Path("/addkey")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addkey(ClientKey clientKey) {
        clientKeysRepository.addKey(clientKey);
        return Response.ok(clientKey).build();
    }

    @GET
    @Path("/getkeys")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getkeys() {
        return Response.ok(new Gson().toJson(clientKeysRepository.getAllKeys())).build();
    }

    @POST
    @Path("/updatepreferences")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePreferences(AdminPreferences adminPreferences) {
        adminPreferencesRepository.updatePreferences(adminPreferences);
        return Response.ok(adminPreferences).build();
    }
}
