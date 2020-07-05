/* Calculating the distance between two GPS points. 
Input is line in the form "latitude1 longitude1 latitude2 longitude2". */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class lab8HaversineDistanceCalculator {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        double lat1 = sc.nextDouble();
        double lon1 = sc.nextDouble();
        double lat2 = sc.nextDouble();
        double lon2 = sc.nextDouble();
       
        double result = distance(lat1, lat2, lon1, lon2);

        System.out.println(Math.round(result/100000)*100);
    }

    public static double distance(double lat1, double lat2, double lon1,
        double lon2) {

    final int R = 6371;

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000;

    distance = Math.pow(distance, 2);

    return Math.sqrt(distance);
    }
}