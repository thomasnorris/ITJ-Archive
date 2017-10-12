// This program computes the wind chill temperature in Farenheit
// given the wind speed in miles per hour and the wind chill index.
// Created By Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project2_part3;
import java.util.Scanner;
public class WindChill {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        double temperatureFarenheit, windSpeed, windChill, T, V;
        
        // Prompts for input of Farenheit temperature
        System.out.print("Enter temperature (Farenheit): ");
        temperatureFarenheit = stdin.nextDouble();
        
        // Loops temperature prompt until value is between -58 and 41
        while(temperatureFarenheit < -58 || temperatureFarenheit > 41) {
            System.out.print("Invalid Temperature. Enter temperature (Farenheit): ");
            temperatureFarenheit = stdin.nextDouble();
        }
        
        // Prompts for wind speed in mph
        System.out.print("Enter wind speed (mph): ");
        windSpeed  = stdin.nextDouble();
        
        // Loops windspeed prompt until value is greater than 2
        while(windSpeed < 2) {
            System.out.print("Invalid wind speed. Enter wind speed (mph) ");
            windSpeed = stdin.nextDouble();
        }
        
        T = temperatureFarenheit;
        V = windSpeed;
        
        // Formula for calculating wind chil using temperature and wind speed
        windChill = (35.74 + (0.6215 * T) - (35.75 * Math.pow(V, 0.16)) + (0.4275 * T * Math.pow(V, 0.16)));
        
        // Outputs the calculated wind chill
        System.out.println("The wind chill index is " + Math.ceil(windChill) + " degrees Farenheit.");
    }
}     

