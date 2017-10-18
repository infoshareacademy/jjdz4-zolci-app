package pl.isa.autoparts.aztec;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AztecVehicle {

    @JsonProperty("Dane")
    private AztecData aztecData;

    public AztecData getAztecData() {
        return aztecData;
    }

    @Override
    public String toString() {

        try {
            return AztecJsonParser.aztecVehicleToJson(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
