// Takes a binary number and converts it to decimal.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project5_part1;
import java.util.*;
public class BinaryConversion {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int decimalNum;
        String binaryString;
        
        System.out.print("Enter a binary number: ");
        binaryString = stdin.next();
        
        while (!binaryString.equals("-1")) {
            decimalNum = binaryToDecimal(binaryString);
            System.out.println("Conversion to decimal: "+decimalNum);
            System.out.print("Enter a binary number: ");
            binaryString = stdin.next();
        } 
        System.out.println("All set!");
        System.exit(0);
    } 

    public static int binaryToDecimal(String binaryString) {
        int decimalNum, stringLength;

        decimalNum = 0;
        stringLength = binaryString.length();
        
        for (int i = 0; i < stringLength; i++) {
            if (binaryString.charAt(i) == '0')
                decimalNum += 0;
            else if (binaryString.charAt(i) == '1')
                decimalNum += Math.pow(2, stringLength - i - 1);
        }
        return decimalNum;      
    }
}
