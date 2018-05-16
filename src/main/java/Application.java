import models.Link;
import models.Location;
import models.Router;
import utils.RouterLocationUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Location[] locations = RouterLocationUtils.fetchLocations();
        Router[] routers = RouterLocationUtils.fetchRouters();

        List<Link> links = RouterLocationUtils.createLinks(locations, routers);

        for(Link link : links) {
            System.out.println(link.toString());
        }
    }
}
