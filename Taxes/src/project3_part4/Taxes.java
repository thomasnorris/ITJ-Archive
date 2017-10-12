// Calculates net taxable income
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project3_part4;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Taxes {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        DecimalFormat taxdf = new DecimalFormat ("$###,###.##");
        double tax, income, percent10, percent15, percent25;
        String finalTaxOutput;

        percent10 = (9275 * 0.1); 
        percent15 = (percent10 + ((37650 - 9275) * 0.15));
        percent25 = (percent15 + ((91150 - 37650) * .25));

        // Prompts for user input of their taxable income
        System.out.print("Enter your net taxable income: ");
        income = stdin.nextDouble();

        // Checks for the tax bracket for which the inputted value
        // belongs and then does the calculation accordingly
        if (income <= 9275) {
            tax = percent10;
            finalTaxOutput = taxdf.format(tax);
            System.out.println("Your 2014 tax is " + finalTaxOutput);
        } 
        else if (income > 9275 && income <= 37650) {
            tax = (percent10 + ((income - 9275) * .15));
            finalTaxOutput = taxdf.format(tax);
            System.out.println("Your 2014 tax is " + finalTaxOutput);
        }
        else if (income > 37650 && income <= 91150) {
            tax = percent15 + ((income - 37650) * .25);
            finalTaxOutput = taxdf.format(tax);
            System.out.println("Your 2014 tax is " + finalTaxOutput);
        }
        else if (income > 91150 && income < 190000) {
            tax = percent25 + ((income - 91150) * .28);
            finalTaxOutput = taxdf.format(tax);
            System.out.println("Your 2014 tax is " + finalTaxOutput);
        } 
        else while (income >= 190000) {
            System.out.print("Amount too great.\nEnter your net"
                    + " taxable income: ");
            income = stdin.nextDouble();
        }
    }       
        
}        
