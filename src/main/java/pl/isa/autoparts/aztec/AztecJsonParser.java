package pl.isa.autoparts.aztec;

import pl.isa.autoparts.tools.JsonParser;

import java.io.IOException;

public class AztecJsonParser extends JsonParser {

    public static AztecVehicle parseAztecFromURL(String url) throws IOException {

        return (AztecVehicle) parseJsonFromURL(url, new AztecVehicle());
    }

    public static AztecVehicle parseAztecFromFile(String fileName) throws IOException {

        return (AztecVehicle) parseJsonFromFile(fileName, new AztecVehicle());
    }
}
