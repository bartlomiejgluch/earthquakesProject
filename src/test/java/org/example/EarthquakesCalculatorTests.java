package org.example;

        import org.junit.Assert;
        import org.junit.Test;

        import java.io.IOException;

public class EarthquakesCalculatorTests {
    @Test
    public void Get10ClosestEarthquakesTest() throws IOException {

        CloseEarthquakesInfoProvider calculator = new CloseEarthquakesInfoProvider();

        String result[] =  calculator.Get10ClosestEarthquakes(40.730610f, -73.935242f);

        Assert.assertTrue(result.length == 10);
    }
}