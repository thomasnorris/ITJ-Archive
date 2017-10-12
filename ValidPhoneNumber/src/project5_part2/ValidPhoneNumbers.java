// Asks for a phone number in a given format and checks to make sure that the
// input matches.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project5_part2;
import java.util.*;
public class ValidPhoneNumbers {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String phoneNumber;
        int count;
        
        count = 0;
        
        System.out.print("Enter a phone number in the format ###-###-####: ");
        phoneNumber = stdin.next();
        
        while (count <= 2 || count >= 4 && count <= 6 || 
                count >= 8 && count <= 11) {
            if (phoneNumber.charAt(count) <= '9' && 
                    phoneNumber.charAt(count) >= '0')
                count++;
            else {
                System.out.println("That is not a valid phone number.");    
                System.exit(0);
            }
        }    
        while (count == 3 || count == 7) {
            if (phoneNumber.charAt(count) == '-')
                count++;
            else {
                System.out.println("That is not a valid phone number.");
                System.exit(0);
            }
        }
        System.out.println("That is correct!");
    }   
}
