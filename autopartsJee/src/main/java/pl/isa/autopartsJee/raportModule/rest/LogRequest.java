package pl.isa.autopartsJee.raportModule.rest;

import pl.isa.autopartsJee.raportModule.domain.Log;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Singleton
public class LogRequest {
    public void sendLog(Log log){
        final String address = "http://localhost:8080/raportmodule/addlog";
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);

        Response response = webTarget.request().post(Entity.json(log));
    }
}
