package org.example;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Hello");

            float longitude = 0, latitude = 0;
            boolean success = false;

            do {
                System.out.print("Enter longitude:");

                try {
                    longitude = Float.parseFloat(scanner.next());
                    success = true;
                } catch (Exception ex) {
                    //ignore the exception
                }
            } while (success == false);

            success = false;
            do {
                System.out.print("Enter latitude:");

                try {
                    latitude = Float.parseFloat(scanner.next());
                    success = true;
                } catch (Exception ex) {
                    //ignore the exception
                }
            } while (success == false);

            CloseEarthquakesInfoProvider provider = new CloseEarthquakesInfoProvider();

            String[] result = provider.Get10ClosestEarthquakes(latitude, longitude);

            System.out.println();

            for (String line : result) {
                System.out.println(line);
            }

            System.out.println("--------------------------------------");
            System.out.println("Try again!");
            System.out.println();
        }
    }

}
