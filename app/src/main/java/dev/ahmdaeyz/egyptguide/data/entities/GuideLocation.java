package dev.ahmdaeyz.egyptguide.data.entities;


import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class GuideLocation {
    private final String name;
    private final String exactLocation;
    private final String description;
    private final LocationType locationType;
    private final String photoUrl;

    @ParcelConstructor
    GuideLocation(String name, String exactLocation, String description, LocationType locationType, String photoUrl) {
        this.name = name;
        this.exactLocation = exactLocation;
        this.description = description;
        this.locationType = locationType;
        this.photoUrl = photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }
}
