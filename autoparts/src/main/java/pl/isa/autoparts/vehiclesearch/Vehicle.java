package pl.isa.autoparts.vehiclesearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.TreeMap;

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

    public Map<String,String> getNamesAndApi() {

        Map<String,String> names = new TreeMap<>();

        for (VehicleData d : data) {
            names.put(d.getName(), d.getLink());
        }

        return names;
    }
}
