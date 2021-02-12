package org.example;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class GeoService {

    public ArrayList<EarthquakeInfoDto> GetEarthquakeInfo() throws IOException {

        String sURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";

        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();

        JsonArray features = rootobj.getAsJsonArray("features");

        ArrayList<EarthquakeInfoDto> parsed = new ArrayList<>();

        for (JsonElement feature: features) {

            JsonObject properties = feature.getAsJsonObject().get("properties").getAsJsonObject();
            JsonArray coordinates = feature.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray();

            EarthquakeInfoDto dto = new EarthquakeInfoDto();

            dto.latitude = coordinates.get(0).getAsFloat();
            dto.longtitude = coordinates.get(1).getAsFloat();
            dto.name  = properties.get("title").getAsString();

            parsed.add(dto);
        }

        return parsed;
    }

}

