# nearby-earthquakes
[USGS Earthquake Hazards Program](https://earthquake.usgs.gov/aboutus/) is an organization that analyze earthquake threats around the world. They expose REST API outlining details of recent earthquakes happening around the world - location, magnitude, etc.  
  
We would like to write a program that for a given city (we will provide lat/lon) will find out 10 most nearby earthquakes (earthquakes that happened in the closest proximity of that city)  

## Getting list of earthquakes
Web services for fetching Earthquakes are located here: https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php  
We are interested in all earthquakes that happened during last 30 days: https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson  

For each earthquake there is a lat/lon location of that earthquake. We would like the program to connect to this web service and pull the earthquake data.

## Calculating distance
We expect our program to correctly calculate distance between two lat/lon points. We would like each distance to be rounded to full kilometers.

## Program input
Program should accept two numbers: the latitude and longitude of a city. So for New York a program should be started with numbers:  
```
40.730610  
-73.935242  
```
Source: https://www.latlong.net/place/new-york-city-ny-usa-1848.html

## Program output 
As an output we want our program to list **10** earthquakes that happened in the closest proximity to input point, in the order from the closest to the furthest. For each earthquake we want to print the content of a **title** field followed by || and **distance** in full km.  
```
title || distance  
title || distance  
title || distance  
```

Note that if two earthquakes happened in the same location (lat/lon) we only want it to appear only once on the list. 

## Summary
We would like the solution to do the following
* Read two float numbers from standard input that represent the lat/lon of a city
* Read a list of earthquakes that happened during last 30 days
* Calculate distance between given city and each of the earthquakes
* Print the 10 earthquakes with the smallest distance to the given city. 
* The output list should contain earthquake title and distance in kilometers
* The if two earthquakes happened in exactly the same location (they have the same lat/lon) we only want one of them to be printed.
* It is ok for a solution to use external libraries

## Example usage: 
Example Input:  
```
40.730610  
-73.935242  
```

Example Output:
```
M 2.0 - 10 km NW of Lyon Mountain, New York || 125
M 2.2 - 16 km NNE of Shawville, Canada || 312
M 2.1 - 20 km SSE of Montmagny, Canada || 441
M 1.6 - 10 km SE of Baie-Saint-Paul, Canada || 451
M 1.9 - 6 km W of Bergen, New York || 459
M 1.7 - 25 km ENE of Bracebridge, Canada || 578
M 2.3 - 14 km NNE of Deerfield, Virginia || 604
M 3.5 - 31 km SW of Guantánamo, Cuba || 629
M 2.8 - 4 km SE of Centerville, Maine || 715
M 1.8 - 4 km WNW of Jonesboro, Maine || 716
```
