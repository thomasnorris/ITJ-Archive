// Takes a list of names of family members and their 
// ages and finds the oldest.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project4_part1;
import javax.swing.JOptionPane;
public class Oldest {
    public static void main(String[] args) {
        String nameInput, highestName; 
        int ageInput, highestAge;
        
        highestName = "";
        highestAge = 0;
        
        // Prompts for names and ages until "quit" is entered
        // Then displays the oldest person's name
        nameInput = JOptionPane.showInputDialog("Enter a relative's name.");
        while (!nameInput.equals("quit")) {
            ageInput = Integer.parseInt(JOptionPane.showInputDialog("Enter"
                    + " that relative's age."));
            if (ageInput > highestAge) {
                highestAge = ageInput;
                highestName = nameInput;
            }
            nameInput = JOptionPane.showInputDialog("Enter a "
                    + "relative's name.");
        }       
        JOptionPane.showMessageDialog(null, "The oldest person is "
                +highestName+".");
    }  
}
