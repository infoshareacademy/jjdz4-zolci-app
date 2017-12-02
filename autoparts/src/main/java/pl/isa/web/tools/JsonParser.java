package pl.isa.web.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JsonParser {

    private JsonParser() {

    }

    public static <T> T parseJsonFromURL(String url, Class<T> JsonObjectClass ) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new URL(url), JsonObjectClass);
    }

    public static <T> T parseJsonFromFile(String fileName, Class<T> JsonObjectClass) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream file = classLoader.getResourceAsStream(fileName);
        if (file == null) throw new IOException();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, JsonObjectClass);
    }
}
