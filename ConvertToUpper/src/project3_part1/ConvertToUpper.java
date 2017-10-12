// Takes a lowercase letter and converts it to uppercase.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project3_part1;
import java.util.Scanner;
public class ConvertToUpper {   
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String input; 
        char letter, result;
        
        // Prompts for a letter       
        System.out.print("Enter a letter: ");
        input = stdin.next();
        letter = input.charAt(0);

        // Checks to see if input using ASCII characters. If it is a  
        // letter it will output the uppercase equivalent. 
        // Otherwise it will fail
        if (letter >= 'a' && letter <= 'z' || letter >= 'A' && letter
                <= 'Z') {
            result = input.toUpperCase().charAt(0); 
            System.out.println("The uppcase equivalent of " + letter + ""
                    + " is\n\t" + result);
        } 
        else {
            System.out.println("Not a letter."); 
    }
    }
 }