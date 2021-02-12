package org.example;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class GeoServiceTest {

    @Test
    public void GetJsonData() throws IOException {
        GeoService service = new GeoService();

       ArrayList<EarthquakeInfoDto> result = service.GetEarthquakeInfo();

       Assert.assertTrue(result.size() > 0);
    }
}