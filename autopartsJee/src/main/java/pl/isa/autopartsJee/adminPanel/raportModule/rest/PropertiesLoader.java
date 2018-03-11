package pl.isa.autopartsJee.adminPanel.raportModule.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private Logger logger = LoggerFactory.getLogger(PreferencesRequest.class);

    public Properties loadProperties() {

        Properties prop = new Properties();

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputFile = classloader.getResourceAsStream("config.properties");
            prop.load(inputFile);
        } catch (java.io.IOException e) {
            logger.warn("Properties file not found");
        }
        return prop;
    }
}
