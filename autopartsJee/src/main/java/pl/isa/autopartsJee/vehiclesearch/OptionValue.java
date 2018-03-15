package pl.isa.autopartsJee.vehiclesearch;

import com.fasterxml.jackson.annotation.JsonProperty;

class OptionValue {

    @JsonProperty("name")
    private String name;

    @JsonProperty("api")
    private String api;

    OptionValue() {};

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getApi() {
        return api;
    }

    void setApi(String api) {
        this.api = api;
    }
}
