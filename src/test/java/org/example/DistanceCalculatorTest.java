package org.example;

import org.junit.Assert;
import org.junit.Test;

public class DistanceCalculatorTest {

    @Test
    public void TestDistance(){
        DistanceCalculator calculator = new DistanceCalculator();

        Assert.assertEquals(731.57,calculator.Calculate(-116.7943333f, 33.4771667f, -122.8208313f,38.8035011f), 0.01);
    }
}