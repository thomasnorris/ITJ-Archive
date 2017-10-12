// Determines if a point lies within a circle with a radius 10 centered at 
// the origin.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project3_part2;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Circle {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        double changeX, changeY, coordinates, distance;
        String stringInput, stringInput2;
        int x, y;
        
        // Gives dialog box to input two coordinates
        stringInput = JOptionPane.showInputDialog("Enter a point with two "
                + "coordinates:");
        
        // Replaces spaces in stringInput string with a blank character
        // (ex. "1 2" = "12")
        // and changes the type from string to double
        stringInput2 = stringInput.replaceAll("\\s+","");
        coordinates = Double.parseDouble(stringInput2);
        
        // Retrieves x and y coordinates from the input
        y = (int) coordinates % 10;
        coordinates /= 10;
        x = (int) coordinates % 10;
        
        // Calculate change in x and y coordinates
        changeX = x-0;
        changeY = y-0;
        
        // Uses distance formula to determine the distance of the point
        distance = Math.sqrt(Math.pow(changeX, 2) + Math.pow(changeY, 2));
        
        // Outputs whether or not the point is in the circle or not
        if (distance <= 10) {
            JOptionPane.showMessageDialog(null, "Point ("+x+", "+y+")"
                    + " is in the circle.");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Point ("+x+", "+y+")"
                    + " is not in the circle.");
        }
    }
}
