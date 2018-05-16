package models;

public class Link {
    private String firstLocation;
    private String secondLocation;

    public Link(String firstLocation, String secondLocation) {
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;

    }

    public String getFirstLocation() {
        return firstLocation;
    }

    public String getSecondLocation() {
        return secondLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return
                (firstLocation.equals(link.getFirstLocation()) && secondLocation.equals(link.getSecondLocation())) ||
                (firstLocation.equals(link.getSecondLocation()) && secondLocation.equals(link.getFirstLocation()));
    }

    @Override
    public String toString() {
        return firstLocation + " <-> " + secondLocation;
    }
}
