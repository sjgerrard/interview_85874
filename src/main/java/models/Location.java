package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location extends IdObject {
    private String postcode;

    @JsonCreator
    public Location(@JsonProperty("id") int id,
                    @JsonProperty("postcode") String postcode,
                    @JsonProperty("name") String name) {

        this.id = id;
        this.postcode = postcode;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
