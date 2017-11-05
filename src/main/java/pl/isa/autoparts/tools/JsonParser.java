package pl.isa.autoparts.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JsonParser {

    public static Object parseJsonFromURL(String url, Object object) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new URL(url), object.getClass());
    }

    public static Object parseJsonFromFile(String fileName, Object object) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream file = classloader.getResourceAsStream(fileName);

        if (file == null) throw new IOException();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(file, object.getClass());
    }

    public static String toJsonString(Object object) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(object);
    }
}
