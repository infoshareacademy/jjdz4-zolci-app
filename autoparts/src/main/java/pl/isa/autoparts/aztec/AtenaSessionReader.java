package pl.isa.autoparts.aztec;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.isa.autoparts.tools.JsonParser;

import java.io.IOException;

public class AtenaSessionReader {

    private Logger logger = LoggerFactory.getLogger(AtenaSessionReader.class.getName());

    private static final String SESSION_URL_PREAMBLE = "https://aztec.atena.pl/PWM2/rest/aztec/getbysession?";
    private static final String ATENA_API_KEY = "qY2?0Pw!";

    private String sessionKey;

    public AtenaSessionReader(String sessionKey) {

        this.sessionKey = sessionKey;
    }

    public AztecVehicle parseAztecFromSession() throws IOException {

        return JsonParser.parseJsonFromURL(createSessionURL(), AztecVehicle.class);
    }

    private String createSessionURL() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(SESSION_URL_PREAMBLE)
                .append("sessionKey=").append(sessionKey)
                .append("&userKey=").append(ATENA_API_KEY);

        logger.debug("Created API link: " + stringBuilder.toString());

        return stringBuilder.toString();
    }
}
