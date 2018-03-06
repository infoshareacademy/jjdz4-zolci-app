package pl.isa.autopartsJee.adminPanel.raportModule.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.adminPanel.raportModule.domain.AdminPreferences;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Properties;

@Singleton
public class PreferencesRequest {
    private Logger logger = LoggerFactory.getLogger(PreferencesRequest.class);

    PropertiesLoader propertiesLoader = new PropertiesLoader();


    public void updatePreferences(AdminPreferences adminPreferences) {
        Properties prop = propertiesLoader.loadProperties();
        try {

            adminPreferences.setClientKey(prop.getProperty("clientkey"));
            adminPreferences.setEmail(prop.getProperty("email"));
            String address = prop.getProperty("updatepreferencesaddress");
            logger.info(address);
            logger.info(prop.getProperty("email"));
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(address);

            Response response = webTarget.request().post(Entity.json(adminPreferences));
        } catch (Exception e) {
            return;
        }
    }
}
