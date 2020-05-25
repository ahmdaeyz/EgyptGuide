package dev.ahmdaeyz.egyptguide.data.entities;

import android.content.res.Resources;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import dev.ahmdaeyz.egyptguide.R;

public class Egypt implements ILocation {
    private static Egypt INSTANCE;
    private List<GuideLocation> locations;
    private final Resources resources;

    private Egypt(Resources resources) {
        locations = new ArrayList<>();
        this.resources = resources;
        addLocations();
    }


    public static Egypt getInstance(){
        if (INSTANCE!=null){
            return INSTANCE;
        }else{
            throw new IllegalStateException("You have to call init first.");
        }
    }

    public static Egypt init(Resources resources) throws InstantiationException {
        if (INSTANCE != null) {
            throw new InstantiationException("Already Intialized");
        } else {
            return new Egypt(resources);
        }
    }
    @Override
    public List<LocationType> getAvailableLocationTypes() {
        ArrayList<LocationType> locationTypes = new ArrayList<>();
        locationTypes.add( LocationType.CHURCHES);
        locationTypes.add( LocationType.MOSQUES);
        locationTypes.add( LocationType.MUSEUMS);
        locationTypes.add( LocationType.FAMOUS_CITIES);
        return locationTypes;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<GuideLocation> getLocationsOfType(LocationType locationType) {
        return locations.stream()
                .map(GuideLocation.class::cast)
                .filter((location)->location.getLocationType()==locationType)
                .collect(Collectors.toList());
    }

    private void addLocations() {
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.hurghada),
                        resources.getString(R.string.hurghada_exact_location),
                        resources.getString(R.string.hurghada_details),
                        LocationType.FAMOUS_CITIES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.nuwebie),
                        resources.getString(R.string.nuwebie_exact_location),
                        resources.getString(R.string.nuwebie_details),
                        LocationType.FAMOUS_CITIES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.aswan),
                        resources.getString(R.string.aswan_exact_location),
                        resources.getString(R.string.aswan_details),
                        LocationType.FAMOUS_CITIES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.el_ain_el_sukhna),
                        resources.getString(R.string.el_ain_el_sukhna_exact_location),
                        resources.getString(R.string.el_ain_el_sukhna_details),
                        LocationType.FAMOUS_CITIES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.port_said),
                        resources.getString(R.string.port_said_exact_location),
                        resources.getString(R.string.port_said_details),
                        LocationType.FAMOUS_CITIES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.gezira_museum),
                        resources.getString(R.string.gezira_museum_exact_location),
                        resources.getString(R.string.gezira_museum_details),
                        LocationType.MUSEUMS
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.museum_of_nasser),
                        resources.getString(R.string.museum_of_nasser_exact_location),
                        resources.getString(R.string.museum_of_nasser_details),
                        LocationType.MUSEUMS
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.the_child_museum),
                        resources.getString(R.string.the_child_museum_exact_location),
                        resources.getString(R.string.the_child_museum_details),
                        LocationType.MUSEUMS
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.denshway_museum),
                        resources.getString(R.string.denshway_museum_exact_location),
                        resources.getString(R.string.denshway_museum_details),
                        LocationType.MUSEUMS
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.abdeen_palace_museum_complex),
                        resources.getString(R.string.abdeen_palace_museum_complex_exact_location),
                        resources.getString(R.string.abdeen_palace_museum_complex_details),
                        LocationType.MUSEUMS
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.ahmed_ibn_tulun_mosque),
                        resources.getString(R.string.ahmed_ibn_tulun_mosque_exact_location),
                        resources.getString(R.string.ahmed_ibn_tulun_mosque_details),
                        LocationType.MOSQUES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.al_rifai_mosque),
                        resources.getString(R.string.al_rifai_mosque_exact_location),
                        resources.getString(R.string.al_rifai_mosque_details),
                        LocationType.MOSQUES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.amr_ibn_al_as_mosque),
                        resources.getString(R.string.amr_ibn_al_as_mosque_exact_location),
                        resources.getString(R.string.amr_ibn_al_as_mosque_details),
                        LocationType.MOSQUES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.saint_catherine_s_monastery),
                        resources.getString(R.string.saint_catherine_s_monastery_exact_location),
                        resources.getString(R.string.saint_catherine_s_monastery_details),
                        LocationType.CHURCHES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.abu_serga_church),
                        resources.getString(R.string.abu_serga_church_exact_location),
                        resources.getString(R.string.abu_serga_church_details),
                        LocationType.CHURCHES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.the_hanging_church),
                        resources.getString(R.string.the_hanging_church_exact_location),
                        resources.getString(R.string.the_hanging_church_details),
                        LocationType.CHURCHES
                )
        );
        locations.add(
                new GuideLocation(
                        resources.getString(R.string.saint_mark_s_coptic_orthodox_cathedral),
                        resources.getString(R.string.saint_mark_s_coptic_orthodox_cathedral_exact_details),
                        resources.getString(R.string.saint_mark_s_coptic_orthodox_cathedral_details),
                        LocationType.CHURCHES
                )
        );
    }

    public static HashMap<String, Integer> getDrawables() {
        HashMap<String, Integer> drawables = new HashMap<>();
        drawables.put("Saint Mark's Coptic Orthodox Cathedral", R.drawable.saint_mark_s_coptic_orthodox_cathedral);
        drawables.put("The Hanging Church", R.drawable.the_hanging_church);
        drawables.put("Abu Serga Church", R.drawable.abu_serga_church);
        drawables.put("Saint Catherine's Monastery", R.drawable.saint_catherine_s_monastery);
        drawables.put("Amr Ibn Al-As Mosque", R.drawable.amr_ibn_al_as_mosque);
        drawables.put("Al-Rifai Mosque", R.drawable.al_rifai_mosque);
        drawables.put("Ahmed Ibn Tulun Mosque", R.drawable.ahmed_ibn_tulun_mosque);
        drawables.put("Abdeen Palace Museum complex", R.drawable.abdeen_palace_museum_complex);
        drawables.put("Denshway Museum", R.drawable.denshway_museum);
        drawables.put("The Child Museum", R.drawable.the_child_museum);
        drawables.put("Museum of Nasser", R.drawable.museum_of_nasser);
        drawables.put("Gezira Museum", R.drawable.gezira_museum);
        drawables.put("Port Said", R.drawable.port_said);
        drawables.put("Aswan", R.drawable.aswan);
        drawables.put("Nuwebie", R.drawable.nuwebie);
        drawables.put("Hurghada", R.drawable.hurghada);
        drawables.put("El-Ain El-Sukhna", R.drawable.el_ain_el_sukhna);
        return drawables;
    }
}
