package pl.isa.autopartsJee.raportModule.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autopartsJee.raportModule.domain.AdminPreferences;

import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class PreferencesRequest {
    private Logger logger = LoggerFactory.getLogger(PreferencesRequest.class);



    public void updatePreferences(AdminPreferences adminPreferences) {
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
