package pl.isa.autopartsJee.raportModule.rest;

import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.raportModule.domain.Log;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Singleton
public class LogRequest {
    private void sendLog(Log log){
        final String address = "http://localhost:8081/raportmodule/addlog";
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);

        Response response = webTarget.request().post(Entity.json(log));
    }
    public void createLog(String message, Long userId, String logLevel) {
        Log log = new Log();
        log.setLogLevel(logLevel);
        log.setUserId(userId);
        log.setMessage(message);
        log.setKey(2137);
        sendLog(log);
    }
}
