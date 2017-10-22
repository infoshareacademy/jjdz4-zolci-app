package pl.isa.autoparts.aztec;

import pl.isa.autoparts.tools.JsonParser;

import java.io.IOException;

public class AztecJsonParser {

    public static AztecVehicle parseAztecFromURL(String url) throws IOException {

        return (AztecVehicle) JsonParser.parseJsonFromURL(url, new AztecVehicle());
    }

    public static AztecVehicle parseAztecFromFile(String fileName) throws IOException {

        return (AztecVehicle) JsonParser.parseJsonFromFile(fileName, new AztecVehicle());
    }
}
