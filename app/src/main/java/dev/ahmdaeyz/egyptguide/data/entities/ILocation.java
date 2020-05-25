package dev.ahmdaeyz.egyptguide.data.entities;

import java.util.List;

interface ILocation {
    List<LocationType> getAvailableLocationTypes();
    List<GuideLocation> getLocationsOfType(LocationType locationType);
}
