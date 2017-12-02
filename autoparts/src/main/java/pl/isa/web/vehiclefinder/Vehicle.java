package pl.isa.web.vehiclefinder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {

    @JsonProperty("dataname")
    private String dataname;

    @JsonProperty("data")
    private VehicleData[] data;

    @JsonProperty("datatype")
    private String datatype;

    @JsonProperty("breadcrumbs")
    private VehicleBreadcrumbs[] breadcrumbs;

    public String getDataname() {
        return dataname;
    }

    public VehicleData[] getData() {
        return data;
    }

    public String getDatatype() {
        return datatype;
    }

    public VehicleBreadcrumbs[] getBreadcrumbs() {
        return breadcrumbs;
    }
}
