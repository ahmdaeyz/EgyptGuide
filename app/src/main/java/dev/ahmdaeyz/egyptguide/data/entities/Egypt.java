package dev.ahmdaeyz.egyptguide.data.entities;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Egypt implements ILocation {
    private static Egypt INSTANCE;
    private List<GuideLocation> locations;
    private Egypt(){
        locations = new ArrayList<>();
        addLocations();
    }


    public static Egypt getInstance(){
        if (INSTANCE!=null){
            return INSTANCE;
        }else{
            return new Egypt();
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
                        "Hurghada",
                        "395km south of Suez",
                        "Hurghada is noted for its magnificent summer and winter climate. The clarity of its water made it a centre of tourist attraction especially for divers and practicing water sports because of the worldwide fame of its coral reefs and rare marine life it enjoys.",
                        LocationType.FAMOUS_CITIES,
                        "https://www.sis.gov.eg/Content/Upload/slider/52016813469917.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Nuwebie",
                        "Aqaba Gulf, south for Dahab",
                        "Nuwebie is a city known for its wide touristic and trade fame. Having an area of 5097 km, it embraces several touristic projects and depends on marine tourism as well as diving and safari.",
                        LocationType.FAMOUS_CITIES,
                        "https://www.sis.gov.eg/Content/Upload/slider/520168135218780.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Aswan",
                        "899 km south of Cairo",
                        "Aswan is considered the most beautiful winter resort not only in Egypt, but also in the whole world as it is distinguished by its fascinating nature and serenity far from the bustle of cities,and its warm weather which is characterized by dryness and sunshine throughout the year.",
                        LocationType.FAMOUS_CITIES,
                        "https://www.sis.gov.eg/Content/Upload/slider/520168193646647.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "El-Ain El-Sukhna",
                        "140 km east of Cairo",
                        "EL-Ain EL-Sukhna: the Arabic for “hot spring” was named after the nearby sulphur springs .It is also an ideal site for fishing and water sports.",
                        LocationType.FAMOUS_CITIES,
                        "https://www.sis.gov.eg/Content/Upload/slider/5201681655355.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Port Said",
                        "The mouth of the Suez Canal to the north",
                        "It is the second port in Egypt, after Alexandria. The history of establishing Port Said dates back to digging the Suez Canal. It is named after Khedive Said who gave the approval to dig.",
                        LocationType.FAMOUS_CITIES,
                        "https://www.sis.gov.eg/Content/Upload/slider/520168193210901.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Gezira Museum",
                        "Cairo",
                        "The idea of establishing a museum to exhibit modern Egyptian art masterpieces was first introduced in 1925 by Mohammed Mahmoud Khalil, a famous Egyptian fine art fan. Following a joint exhibition by Egyptian and foreign artists at the Cairo Arts Saloon, Khalil decided to purchase some of the exhibited items to be the cornerstone of the museum.",
                        LocationType.MUSEUMS,
                        "https://www.sis.gov.eg/Content/Upload/slider/4201624143324270.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Museum of Nasser",
                        "Cairo",
                        "The Pharaonic Village at the Nile banks set up a special museum for late President Gamal Abdul-Nasser. It exhibits data about Nasser's personal life from his birth in Bakos district in Alexandria up to his death, in addition to the private properties and some rare photos that record his life and his national and international stances. Nasser's family provided the museum with a great number of the Egyptian leader's personal properties, as many tourists rush to visit the museum, Arabs in particular.",
                        LocationType.MUSEUMS,
                        "https://www.sis.gov.eg/Content/Upload/slider/420162414356210.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "The Child Museum",
                        "Cairo",
                        "Science, technology, imagination, truth in the past, present and future; all interact to create a wonderful world for the Egyptian child, namely, the Child Museum.\n" +
                                "\n" +
                                "It is an edifice that appeals to a child's intelligence and inquisitive nature, allowing interaction with what he sees in full freedom. Children at this museum are able to deal with high technology and modern methods to enrich their knowledge and imagination.",
                        LocationType.MUSEUMS,
                        "https://www.sis.gov.eg/Content/Upload/slider/4201625114759130.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Denshway Museum",
                        "Minoufiya",
                        "was rebuilt to witness and immortalize the historic story of the Egyptian peasants' struggle in Denshway village against the then British colonialism.\n" +
                                "\n" +
                                "The museum was designed by the consultative engineer Hany el-Meniawi to host all cultural activities besides Denshway incident. However, it comprises all historic documents on the event, as well as different instruments used in agriculture at that time such as the waterwheel and the shadoof.",
                        LocationType.MUSEUMS,
                        "https://www.sis.gov.eg/Content/Upload/slider/4201625124251500.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Abdeen Palace Museum complex",
                        "Cairo",
                        "Abdeen Palace is one of the most famous palaces that were erected during the reign of Mohamed Ali Pasha Dynasty. It was the seat of the government as of 1872 till 1952. During such eventful period of time, Abdeen Palace witnessed unforgettable events that undoubtedly affected Egypt's modern and contemporary history.",
                        LocationType.MUSEUMS,
                        "https://www.sis.gov.eg/Content/Upload/slider/420162513413276.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Ahmed Ibn Tulun Mosque",
                        "Cairo",
                        "In 868 AD the Abbassid caliph al-Mu’taz sent Ahmad Ibn Tulun to govern Egypt. The new governor soon declared his independence and successfully defended his new domain against the Abbassid armies sent to unseat him. He built al-Qitai, a new capital centered around a vast central mosque, the courtyard of which could accommodate his entire army and their horses. His rule lasted for 37 years and was ended by the Abbassids. Mohammed Ibn Tugh was appointed governor over the province and was allowed to rule independently from khalifal controls. He was granted the title Ikhshid and hence the Ikhshidid dynasty ruled form Ad 935-969 when Egypt was invaded by Shi’a Fatimid armies from Tunisia.",
                        LocationType.MOSQUES,
                        "https://www.sis.gov.eg/Content/Upload/slider/420162722525135.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Al-Rifai Mosque",
                        "Cairo",
                        "Al-Rifai Mosque covers an area of 6,500 square meters. It competes with mosque of Sultan Hassan in greatness, and grandeur.\n" +
                                "\n" +
                                "It is strange that in spite of the mosque being called Al-Rifai, Rifai, the well-known spiritual Islamic leader, has not been buried in it, instead he is buried in Iraq.",
                        LocationType.MOSQUES,
                        "https://www.sis.gov.eg/Content/Upload/slider/4201627222852757.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Amr Ibn Al-As Mosque",
                        "Cairo",
                        "The mosque was built in a shape of rectangular low shed of wood and palm leaves supported on columns of palm stems, stones and mud bricks while the floor was covered with gravel. That first simple mosque measures about 29 m. in length and 17 m. in width.\n" +
                                "\n" +
                                "Since the time of the foundation of the mosque many additions and extensions took place, but the most important one was made by the governor Abudllah Ibn Taher during the reign of Caliph Al Mamoun in the 9th century. He extended the mosque adding a new area at the S.W side and that extension was the last one.",
                        LocationType.MOSQUES,
                        "https://www.sis.gov.eg/Content/Upload/slider/4201627215613752.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Saint Catherine's Monastery",
                        "The Sinai Peninsula",
                        "The monastery is controlled by the autonomous Church of Sinai, part of the wider Eastern Orthodox Church, and is a UNESCO World Heritage Site.\n" +
                                "\n" +
                                "Built between 548 and 565, the monastery is one of the oldest working Christian monasteries in the world. The site contains the world's oldest continually operating library, possessing many unique books.",
                        LocationType.CHURCHES,
                        "https://www.sis.gov.eg/Content/Upload/slider/820172813334535.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Abu Serga Church",
                        "Cairo",
                        "The Church was built in the 4th century and was probably finished during the 5th century.\n" +
                                "\n" +
                                "Saints Sergius and Bacchus Church is traditionally believed to have been built on the spot where the Holy Family, Joseph, Mary and the infant Jesus Christ, rested at the end of their journey into Egypt.",
                        LocationType.CHURCHES,
                        "https://www.sis.gov.eg/Content/Upload/slider/8201728124954361.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "The Hanging Church",
                        "Cairo",
                        "The Hanging Church is one of the oldest churches in Egypt and the history of a church on this site dates to the 2nd century AD.\n" +
                                "\n" +
                                "It is called the Hanging Church because it was built on the southern of Babylon Fortress, the Roman fortress in Coptic Cairo (Old Cairo). Logs of palm trees and layers of stones were constructed above the ruins of the Roman fortress to be used as a fundament. The Hanging Church is a unique church and has a wooden roof in the shape of Noah's ark.",
                        LocationType.CHURCHES,
                        "https://www.sis.gov.eg/Content/Upload/slider/8201728124855689.jpg"
                )
        );
        locations.add(
                new GuideLocation(
                        "Saint Mark's Coptic Orthodox Cathedral",
                        "Cairo",
                        "The cathedral is the Seat of the Coptic Orthodox Pope. It was built during the time when Pope Cyril VI of Alexandria was Pope of the Coptic Orthodox Church, and was inaugurated by him in 1969.",
                        LocationType.CHURCHES,
                        "https://www.sis.gov.eg/Content/Upload/slider/820172813334535.jpg"
                )
        );
    }

}
