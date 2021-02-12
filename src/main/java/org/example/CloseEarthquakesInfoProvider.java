package org.example;

import java.io.IOException;
import java.util.*;

public class CloseEarthquakesInfoProvider {

    private final GeoService geoService;
    private final DistanceCalculator distanceCalculator;

    public CloseEarthquakesInfoProvider() {

        this.geoService = new GeoService();
        this.distanceCalculator = new DistanceCalculator();
    }

    public String[] Get10ClosestEarthquakes(float latitude, float longitude) throws IOException {

        ArrayList<EarthquakeInfoDto> earthQuakeInfoList = this.geoService.GetEarthquakeInfo();

        ArrayList<CloseEarthquakeInfoDto> listWithDistance = new ArrayList<>();

        for (EarthquakeInfoDto info:earthQuakeInfoList) {
            CloseEarthquakeInfoDto item = new CloseEarthquakeInfoDto();
            item.info = info;
            item.distance = this.distanceCalculator.Calculate(info.latitude, info.longtitude, latitude, longitude);

            listWithDistance.add(item);
        }

        //remove duplicates
        SortedSet<CloseEarthquakeInfoDto> set = new TreeSet<>((o1, o2) -> {
            if (o1.info.name.equals(o2.info.name)) {
                return 0;
            }
            return -1;
        });
        set.addAll(listWithDistance);
        listWithDistance = new ArrayList<>(set);

        //sort properly
        listWithDistance.sort((o1, o2) -> Float.compare(o1.distance, o2.distance));

        //take 10
        listWithDistance = new ArrayList<>(listWithDistance.subList(0, 10));

        ArrayList<String> result = new ArrayList<>();

        for (CloseEarthquakeInfoDto item : listWithDistance) {
            String text = String.format("%s || %.0f", item.info.name, item.distance);
            result.add(text);
        }

        return result.toArray(new String[result.size()]);
    }

}

