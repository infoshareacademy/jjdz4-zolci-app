package pl.isa.autoparts.aztec;

import pl.isa.autoparts.tools.JsonParser;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;


public class AztecVehicle {

    @JsonProperty("Dane")
    private AztecData aztecData;

    public AztecData getAztecData() {
        return aztecData;
    }

    public boolean hasError() {

        if (getAztecData().getError() < 0) return true;

        return false;
    }
}
