package pl.isa.autopartsJee.adminPanel.raportModule.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.adminPanel.raportModule.domain.Log;
import pl.isa.autopartsJee.adminPanel.raportModule.domain.Logs;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Properties;

@Singleton
public class GetAllLogsRequest {

    private PropertiesLoader propertiesLoader = new PropertiesLoader();
    private Logger logger = LoggerFactory.getLogger(GetAllLogsRequest.class);

    public List<Log> getAllLogs() {

        Properties prop = propertiesLoader.loadProperties();
       try {
           String address = prop.getProperty("getAllLogsAddress" + "?clientKey=" + prop.getProperty("clientkey"));
           address = "http://localhost:8081/raportmodule/getalllogs?clientKey=2137";
           logger.info(address);
           Client client = ClientBuilder.newClient();
           WebTarget webTarget = client.target(address);
           Response response = webTarget.request().get();
           List<Log> logs = response.readEntity(Logs.class).getLogs();

           return logs;
       }
       catch (Exception e){}
       return null;
    }
}
