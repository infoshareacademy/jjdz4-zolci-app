package pl.isa.autopartsJee.adminPanel.raportModule.rest;

import org.hibernate.Incubating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.adminPanel.raportModule.domain.Log;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class LogRequest {
    PropertiesLoader propertiesLoader = new PropertiesLoader();
    private Logger logger = LoggerFactory.getLogger(LogRequest.class);

    private void sendLog(Log log) {

        Properties prop = propertiesLoader.loadProperties();
        try {
            log.setKey(prop.getProperty("clientkey"));
            String address = prop.getProperty("addlogaddress");
            logger.info(address);
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(address);

            Response response = webTarget.request().post(Entity.json(log));
        } catch (Exception e) {
            return;
        }
    }

    public void createLog(String message, Long userId, String logLevel) {
        Log log = new Log();
        log.setLogLevel(logLevel);
        log.setUserId(userId);
        log.setMessage(message);

        sendLog(log);
    }


}
