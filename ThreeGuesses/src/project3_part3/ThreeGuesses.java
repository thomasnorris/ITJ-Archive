// Gives the user three chances to guess a secret code.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project3_part3;
import java.util.Scanner; 
public class ThreeGuesses {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int try1, try2, try3, code;
        code = 51;
        
        // Prompts for first code attempt
        System.out.print("Welcome to People's Bank.\nPlease enter your"
                + " secret code:    ");
        try1 = stdin.nextInt();
        
        // If the code is correct on the first try then access is granted. 
        // Otherwise try again
        if (try1 == code) {
            System.out.println("Fine, go ahead.");
        } 
        else {
            System.out.print("Sorry, that is not it. Try again: "); }
            try2 = stdin.nextInt();

        // If attempt two is correct then access is granted. Otherwise try
        // a final time 
        if (try2 == code) {
            System.out.println("Fine, go ahead.");
        } 
        else {
            System.out.print("Sorry, last chance. Try again:    "); }
            try3 = stdin.nextInt();

        // If attempt three is correct then acces is granted. Otherwise
        // access is denied without furthur attempts.
        if (try3 == code) {
            System.out.println("Fine, go ahead.");
        } 
        else {
            System.out.println("Sorry, that is not it. All attempts"
                    + " used."); 
        }
    }  
}
