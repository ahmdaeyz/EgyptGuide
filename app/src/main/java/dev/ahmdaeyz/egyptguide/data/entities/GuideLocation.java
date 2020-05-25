package dev.ahmdaeyz.egyptguide.data.entities;


import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class GuideLocation {
    private final String name;
    private final String exactLocation;
    private final String description;
    private final LocationType locationType;

    @ParcelConstructor
    GuideLocation(String name, String exactLocation, String description, LocationType locationType) {
        this.name = name;
        this.exactLocation = exactLocation;
        this.description = description;
        this.locationType = locationType;
    }

    public String getName() {
        return name;
    }

    public String getExactLocation() {
        return exactLocation;
    }

    public String getDescription() {
        return description;
    }

    public LocationType getLocationType() {
        return locationType;
    }

}
