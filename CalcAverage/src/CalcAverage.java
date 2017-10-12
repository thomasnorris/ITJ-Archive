import java.util.Scanner;
public class CalcAverage {
// Written by: Thomas Norris
// Computes the average of a set of values entered by the user, e.g. with
//      10.0 5.0 6.0 9.0 0.0
// The average is 7.5
    
public static void main(String[ ] args) {
    Scanner stdin = new Scanner(System.in);
    int     count;
    double number, runningTotal;
    
    runningTotal = 0;
    count = 0;
    System.out.println("Type the numbers, the last being 0");
    
    number = stdin.nextDouble();
    while (number != 0) {
        runningTotal = runningTotal + number;
        count = count + 1;
        number = stdin.nextDouble();
    }
    System.out.print("The average of the ");
    System.out.print(count);
    System.out.print(" numbers is ");
    System.out.println(runningTotal/count);
}
}