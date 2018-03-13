package pl.isa.autopartsJee.vehiclesearch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionValue {

    @JsonProperty("name")
    private String name;

    @JsonProperty("api")
    private String api;

    public OptionValue() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
