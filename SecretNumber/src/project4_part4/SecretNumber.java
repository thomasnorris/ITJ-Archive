// Chooses a random number between 1 and 100 and has the user guess at it
// Created by Thomas Norrs for EECS 1510-001 with Dr. Ledgard.

package project4_part4;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;
public class SecretNumber {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Random randNumber = new Random();
        int generatedNumber, guess, distAway;
        
        // Generates a random number and has the user guess
        generatedNumber = randNumber.nextInt(100) + 1;
        guess = Integer.parseInt(JOptionPane.showInputDialog("A number "
                + "between 1 and 100 has been generated. "
                + "Try and guess the number. Enter 0 to quit."));
        
        // Gives clues to how far away the user is from the correct answer        
        while (guess != 0 && guess != generatedNumber) {
            distAway = Math.abs(guess-generatedNumber);
            
            if (distAway > 30)
                guess = Integer.parseInt(JOptionPane.showInputDialog("Way "
                        + "Too High or Way Too Low. Try Again."));                
            else if (distAway >= 10 && distAway <= 30) 
                guess = Integer.parseInt(JOptionPane.showInputDialog("High "
                        + "or Low. Try Again."));   
            else if (distAway < 10) 
                guess = Integer.parseInt(JOptionPane.showInputDialog("A "
                        + "Little High or A Little Low. Try Again."));   
        }    
        if (guess != 0)
            JOptionPane.showMessageDialog(null, "Congrats! You've "
                        + "Guessed Correctly!");            
    }
}    

