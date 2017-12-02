package pl.isa.web.aztec;

import com.fasterxml.jackson.annotation.JsonProperty;


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
