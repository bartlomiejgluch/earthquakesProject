package org.example;

//copied from here
//https://www.geodatasource.com/developers/java
//and here https://andrew.hedges.name/experiments/haversine/

public class DistanceCalculator {

    private static final double Rk  = 6373;// mean radius of the earth (km) at 39 degrees from the equator

    public float Calculate(float lat1, float lon1, float lat2,float lon2 ) {
        lat1 = deg2rad(lat1);
        lon1 = deg2rad(lon1);
        lat2 = deg2rad(lat2);
        lon2 = deg2rad(lon2);

        double 	dlat = lat2 - lat1;
        double 	dlon = lon2 - lon1;

        double a  = Math.pow(Math.sin(dlat/2),2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon/2),2);
        double c  = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double dk = c * Rk;

        return (float)dk;
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::	This function converts decimal degrees to radians						 :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static float deg2rad(double deg) {
        return (float)(deg * Math.PI / 180.0);
    }
}
