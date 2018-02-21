package pl.isa.autopartsJee.raportModule.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.raportModule.domain.AdminPreferences;
import pl.isa.autopartsJee.raportModule.domain.Log;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class LogRequest {
    private Logger logger = LoggerFactory.getLogger(LogRequest.class);

    private void sendLog(Log log) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputFile = classloader.getResourceAsStream("config.properties");
            prop.load(inputFile);
        } catch (java.io.IOException e) {
            logger.warn("Properties file not found");
        }
        try {
            log.setKey(prop.getProperty("clientkey"));
//        log.setKey("2137");
            String address = prop.getProperty("addlogaddress");
            logger.info(address);
//        String address = "http://localhost:8081/raportmodule/addlog";
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
