package pl.isa.autoparts.aztec;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AztecJsonParser {

    public static AztecVehicle jsonToAztecVehilce(String jsonData) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonData, AztecVehicle.class);
    }
}
