package pl.isa.autoparts.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JsonParser {

    private JsonParser() {

    }

    public static <T> T parseJsonFromURL(String url, T jsonObject) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new URL(url), (Class<T>) jsonObject.getClass());
    }

    public static <T> T parseJsonFromFile(String fileName, T jsonObject) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream file = classLoader.getResourceAsStream(fileName);
        if (file == null) throw new IOException();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, (Class<T>) jsonObject.getClass());
    }
}
