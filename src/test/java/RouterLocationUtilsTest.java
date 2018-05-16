import models.Link;
import models.Location;
import models.Router;
import org.junit.Test;
import utils.RouterLocationUtils;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RouterLocationUtilsTest {
    static final String LONDON = "london";
    static final String LEICESTER = "leicester";

    @Test
    public void shouldBeAbleToFetchRouters() {
        Router[] routers = RouterLocationUtils.fetchRouters();
        assertThat("router list should not be empty", routers.length, is(greaterThan(0)));
    }

    @Test
    public void shouldBeAbleToFetchLocations() {
        Location[] locations = RouterLocationUtils.fetchLocations();
        assertThat("locations list should not be empty", locations.length, is(greaterThan(0)));
    }

    @Test
    public void shouldBeAbleToPrettyPrintOutput() {
        String expectedOutput = "Adastral <-> London";

        Link basicLink = new Link("Adastral", "London");

        assertThat("output should be nicely printed", basicLink.toString(), is(expectedOutput));
    }

    @Test
    public void shouldBeAbleToCreateLinksFromRoutersAndLocations() {
        Location london = new Location(10, "london_postcode", LONDON);
        Location leicester = new Location(11, "leicester_postcode", LEICESTER);
        Location[] locations = new Location[]{london, leicester};

        Router londonRouter = new Router(1, "londonRouter", 10, new int[]{2});
        Router leicesterRouter = new Router(2, "leicesterRouter", 11, new int[]{1});
        Router[] routers = new Router[]{londonRouter, leicesterRouter};

        List<Link> links = RouterLocationUtils.createLinks(locations, routers);

        assertThat("links only has 1 link", links.size(), is(1));

        Link link = links.get(0);
        assertThat("make sure the link's first location is london", link.getFirstLocation(), is(LONDON));
        assertThat("make sure the link's second location is leicester", link.getSecondLocation(), is(LEICESTER));
    }
}