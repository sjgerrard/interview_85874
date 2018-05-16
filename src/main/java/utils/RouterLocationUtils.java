package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.IdObject;
import models.Link;
import models.Location;
import models.Router;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouterLocationUtils {
    private static final String SERVER = "http://my-json-server.typicode.com/krazerxz/router_location_test_api/";

    public static Router[] fetchRouters() {
        ObjectMapper mapper = new ObjectMapper();

        Router[] routers = new Router[0];
        try {
            routers = mapper.readValue(new URL(SERVER + "routers"), Router[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return routers;
    }

    public static Location[] fetchLocations() {
        ObjectMapper mapper = new ObjectMapper();

        Location[] locations = new Location[0];
        try {
            locations = mapper.readValue(new URL(SERVER + "locations"), Location[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return locations;
    }

    public static List<Link> createLinks(Location[] locations, Router[] routers) {
        List<Link> links = new ArrayList<>();

        for(Router router : routers) {
            Location routerLocation = (Location) getObjectById(locations, router.getLocationId());

            int[] routerLinks = router.getRouterLinks();

            for(int index = 0; index < routerLinks.length; index++) {
                Router linkedRouter = (Router) getObjectById(routers, routerLinks[index]);
                Location secondLocation = (Location) getObjectById(locations, linkedRouter.getLocationId());

                Link newLink = new Link(routerLocation.getName(), secondLocation.getName());

                if(!links.contains(newLink))
                    links.add(newLink);
            }
        }

        return links;
    }

    public static IdObject getObjectById(IdObject[] collection, int id) {
        return Arrays.stream(collection).filter(objectId -> objectId.getId() == id).findFirst().get();
    }
}
