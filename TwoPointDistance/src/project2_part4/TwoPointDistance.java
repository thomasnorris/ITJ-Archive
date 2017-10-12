// This program gives the distance between two points
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project2_part4;
import java.util.Scanner;
public class TwoPointDistance {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        double     x1, x2, y1, y2, d;
        
        // Prompts for input of x1 and y1 coordinates
        System.out.print("Enter x1 and y1: ");
        x1 = stdin.nextDouble();
        y1 = stdin.nextDouble();
        
        // Prompts for inpur of x2 and y2 coordinates
        System.out.print("Enter x2 and y2: ");
        x2 = stdin.nextDouble();
        y2 = stdin.nextDouble();
        
        // Pythagoreans formula using coordinates
        d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        
        // Outputs the distance between the points
        System.out.println("The distance is "+d);
    }
    
}
