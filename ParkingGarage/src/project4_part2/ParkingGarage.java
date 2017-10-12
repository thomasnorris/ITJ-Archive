// Finds the total cost of having 5 cars parked in the Little Parking Garage.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project4_part2;
import java.text.DecimalFormat;
import java.util.Scanner;
public class ParkingGarage {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        DecimalFormat dfHours = new DecimalFormat("##.#");
        DecimalFormat dfCharge = new DecimalFormat("$##.00");
        
        double car1, car2, car3, car4, car5, charge;
        String sumCharge, sumHours;        
        
       
        // Asks for hours parked for each car
        System.out.print("Enter the hours parked for car 1: ");
        car1 = stdin.nextDouble();
        System.out.print("Enter the hours parked for car 2: ");
        car2 = stdin.nextDouble();
        System.out.print("Enter the hours parked for car 3: ");
        car3 = stdin.nextDouble();
        System.out.print("Enter the hours parked for car 4: ");
        car4 = stdin.nextDouble();
        System.out.print("Enter the hours parked for car 5: ");
        car5 = stdin.nextDouble();
        
        // Total hours the cars were parked
        sumHours = dfHours.format(car1+car2+car3+car4+car5);
        
        // Calculates the charge of each car
        if (car1 <= 2) car1 = 5;
        else if (car1 > 2 && car1 < 12) car1 = (5 + (car1 - 2)); 
        else if (car1 >= 12) car1 = 12;
        
        if (car2 <= 2) car2 = 5;
        else if (car2 > 2 && car2 < 12) car2 = (5 + (car2 - 2)); 
        else if (car2 >= 12) car2 = 12;
        
        if (car3 <= 2) car3 = 5;
        else if (car3 > 2 && car3 < 12) car3 = (5 + (car3 - 2)); 
        else if (car3 >= 12) car3 = 12;
        
        if (car4 <= 2) car4 = 5;
        else if (car4 > 2 && car4 < 12) car4 = (5 + (car4 - 2)); 
        else if (car4 >= 12) car4 = 12;
        
        if (car5 <= 2) car5 = 5;
        else if (car5 > 2 && car5 < 12) car5 = (5 + (car5 - 2)); 
        else if (car5 >= 12) car5 = 12;
        
        
        // Displays total charge of each car as well as the total
        // amount of time the cars were parked
        sumCharge = dfCharge.format(Math.ceil(car1+car2+car3+car4+car5));
        System.out.println("\nTotal Hours: "+sumHours+"\nTotal Charge: "
                + ""+sumCharge);
    }
}
    

