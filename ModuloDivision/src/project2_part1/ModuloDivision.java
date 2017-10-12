// This program takes the individual digits of a single integer 
// and adds them together.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project2_part1;
import java.util.Scanner;
public class ModuloDivision {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int integer, num1, num2, num3, num4, num5, sum;
        
        // Prompts for input of a three-digit integer
        System.out.print("Enter a positive three-digit integer: ");
        integer = stdin.nextInt();
       
        // Uses modulo division to break the integer into seperate numbers
        num1 = integer % 10;
        num2 = integer / 10;
        num3 = num2 % 10;
        num4 = num2 / 10;
        num5 = num4 % 10;
        
        // Adds the numbers together
        sum = num1 + num3 + num5;
        
        // Outputs the sum of the digits in the integer
        System.out.println("The sum of the digits is: " + sum);    
    } 
}
