// Program that counts change of coins and compares it to an initial
// coin value that is entered by the user.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project4_part3;
import java.util.Scanner;
public class CountingChange {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int sum1, sum2, valDimes, valNickles, valPennies;
        int numNickles, numDimes, numPennies;
        boolean pass = false;
        
        // Asks for total value of coins (between 0 and 99 cents)
        askForCoinValue(); 
        sum1 = stdin.nextInt();
        
        // Fails if the number is not between 0 and 99
        while (sum1 < 0 || sum1 > 99) {
            System.out.print("That value is not acceptable. Try again.\n"
                    + "Enter an integer value sum of coins "
                    + "that is between 0 and 99: ");
                sum1 = stdin.nextInt();    
        }
        
        // Asks for numbers of each coin denomination and compares to the
        // initial value of coins from earlier. If they match, success,
        // otherwise prompts for coins until they match
        while (pass == false) {
            askForDimes();
            numDimes = stdin.nextInt();
            askForNickles();
            numNickles = stdin.nextInt();
            askForPennies();
            numPennies = stdin.nextInt();
            
            valDimes = numDimes * 10;
            valNickles = numNickles * 5;
            valPennies = numPennies;
            sum2 = valDimes+valNickles+valPennies;
                    
            if (sum1 != sum2) {
                System.out.println("No. Enter the correct number of coins.");
                pass = false;
            } else {
                System.out.println("Yes.\nValue of dimes: "+valDimes+" cents"
                        + "\nValue of nickles: "+valNickles+" cents\nValue "
                        + "of pennies: "+valPennies+" cents"); 
                pass = true;
            }
        }       
    }     
   
    // Methods of prompting for coin values
    Scanner stdin = new Scanner(System.in);
    public static void askForCoinValue() {
        System.out.print("Enter an integer value sum of coins "
                + "that is between 0 and 99: ");
    }                            
    public static void askForDimes() {
        System.out.print("Enter number of dimes: ");
    }
    public static void askForNickles() {
        System.out.print("Enter number of nickles: ");
    }
    public static void askForPennies() {
        System.out.print("Enter number of pennies: ");
    }  
}
    
    

