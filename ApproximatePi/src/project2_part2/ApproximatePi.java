// This program approximates the value of Pi given a given equation.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project2_part2;
public class ApproximatePi { 
    public static void main(String[] args) {
        double pi;
        
        // Uses formulat for the approximate value of Pi
        pi = (4 * (1.0 - 1/3.0 + 1/5.0 - 1/7.0 + 1/9.0 - 1/11.0 + 1/13.0));
        
        // Outputs approximation of Pi
        System.out.println("The approximate value of Pi is: " + pi);
    }   
}
