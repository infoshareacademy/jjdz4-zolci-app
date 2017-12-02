package pl.isa.web.aztec;


import pl.isa.web.tools.JsonParser;

import java.io.IOException;

public class AtenaSessionReader {

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

        return stringBuilder.toString();
    }
}
