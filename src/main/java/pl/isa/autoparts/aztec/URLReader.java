package pl.isa.autoparts.aztec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {

    public static String readFromURL(String url) throws IOException {

        URL sessionURL = new URL(url);
        URLConnection connection = sessionURL.openConnection();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null)
            stringBuilder.append(line).append('\n');

        reader.close();

        return stringBuilder.toString();
    }
}
