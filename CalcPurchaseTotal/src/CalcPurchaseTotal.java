// This program will calculate a total cost of a purchase given
// the number of units and the cost per unit.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

import java.util.Scanner;
public class CalcPurchaseTotal {
    public static void main(String[ ] args) {
        Scanner stdin = new Scanner(System.in);
        int quantity, unit_price, total_amount;
        
        System.out.print("Please enter the Quantity desired: ");
        quantity = stdin.nextInt();
        
        System.out.print("Please enter the Unit price: ");
        unit_price = stdin.nextInt();
        
        System.out.println("");
        
        System.out.print("The Quantity desired is : ");
        System.out.println(quantity);
        
        System.out.print("The Unit Price is : $");
        System.out.println(unit_price);
        
        total_amount = quantity * unit_price;
                
        System.out.print ("The Total Amount is : $");
        System.out.println(total_amount);
    }
}