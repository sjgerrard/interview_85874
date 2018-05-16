package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Router extends IdObject {
    private int location_id;
    private int[] router_links;

    @JsonCreator
    public Router(@JsonProperty("id") int id,
                  @JsonProperty("name") String name,
                  @JsonProperty("location_id") int location_id,
                  @JsonProperty("router_links") int[] router_links) {

        this.id = id;
        this.name = name;
        this.location_id = location_id;
        this.router_links = router_links;
    }

    public int getLocationId() {
        return location_id;
    }

    public int[] getRouterLinks() {
        return router_links;
    }
}
