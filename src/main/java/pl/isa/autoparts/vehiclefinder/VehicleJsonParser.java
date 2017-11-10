package pl.isa.autoparts.vehiclefinder;

import pl.isa.autoparts.tools.JsonParser;

import java.io.IOException;

public class VehicleJsonParser extends JsonParser {

    public static Vehicle parseVehicleJsonFromURL(String url) throws IOException {

        return (Vehicle) parseJsonFromURL(url, new Vehicle());
    }
}
