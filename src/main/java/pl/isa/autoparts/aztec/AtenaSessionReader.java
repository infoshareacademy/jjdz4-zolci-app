package pl.isa.autoparts.aztec;


import java.io.IOException;

public class AtenaSessionReader {

    private static final String SESSION_URL_PREAMBLE = "https://aztec.atena.pl/PWM2/rest/aztec/getbysession?";

    private String sessionKey;
    private String userKey;
    private String sessionURL;

    public AtenaSessionReader(AtenaUser user) {

        userKey = user.getUserKey();
    }

    public AtenaSessionReader(String sessionKey, AtenaUser user) {

        this.sessionKey = sessionKey;
        userKey = user.getUserKey();
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    private String createSessionURL() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(SESSION_URL_PREAMBLE)
                .append("sessionKey=").append(sessionKey)
                .append("&userKey=").append(userKey);

        return stringBuilder.toString();
    }

    public AztecVehicle parseAztecFromSession() throws IOException {

        sessionURL = createSessionURL();
        return AztecJsonParser.parseAztecFromURL(sessionURL);
    }

    public AztecVehicle parseAztecFromSession(String sessionKey) throws IOException {

        this.sessionKey = sessionKey;
        sessionURL = createSessionURL();

        return AztecJsonParser.parseAztecFromURL(sessionURL);
    }
}
