package pl.isa.web.vehiclefinder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleData {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name_clear")
    private String name_clear;

    @JsonProperty("has_image")
    private boolean has_image;

    @JsonProperty("vehicle_grup")
    private String vehicle_group;

    @JsonProperty("kw")
    private String kw;

    @JsonProperty("body")
    private String body;

    @JsonProperty("end_year")
    private String end_year;

    @JsonProperty("hp")
    private String hp;

    @JsonProperty("cylinders")
    private String cylinders;

    @JsonProperty("engine")
    private String engine;

    @JsonProperty("start_month")
    private String start_month;

    @JsonProperty("link")
    private String link;

    @JsonProperty("start_year")
    private String start_year;

    @JsonProperty("brand_id")
    private String brand_id;

    @JsonProperty("end_month")
    private String end_month;

    @JsonProperty("axle")
    private String axle;

    @JsonProperty("ccm")
    private String ccm;

    @JsonProperty("engine_txt")
    private String engine_txt;

    @JsonProperty("model_id")
    private String model_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("fuel")
    private String fuel;

    @JsonProperty("max_weight")
    private String max_weight;

    public String getId() {
        return id;
    }

    public String getName_clear() {
        return name_clear;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public String getVehicle_group() {
        return vehicle_group;
    }

    public String getKw() {
        return kw;
    }

    public String getBody() {
        return body;
    }

    public String getEnd_year() {
        return end_year;
    }

    public String getHp() {
        return hp;
    }

    public String getCylinders() {
        return cylinders;
    }

    public String getEngine() {
        return engine;
    }

    public String getStart_month() {
        return start_month;
    }

    public String getLink() {
        return link;
    }

    public String getStart_year() {
        return start_year;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public String getEnd_month() {
        return end_month;
    }

    public String getAxle() {
        return axle;
    }

    public String getCcm() {
        return ccm;
    }

    public String getEngine_txt() {
        return engine_txt;
    }

    public String getModel_id() {
        return model_id;
    }

    public String getName() {
        return name;
    }

    public String getFuel() {
        return fuel;
    }

    public String getMax_weight() {
        return max_weight;
    }
}
