package pl.isa.autoparts.aztec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AztecJsonParser {

    public static AztecVehicle parseAztecJsonFromURL(String url) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new URL(url), AztecVehicle.class);
    }

    public static AztecVehicle parseAztecJsonFromFile(String fileName) throws IOException, FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        if (file == null) throw new FileNotFoundException();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(file, AztecVehicle.class);
    }

    public static String aztecVehicleToJson(AztecVehicle aztecVehicle) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(aztecVehicle);
    }
}
