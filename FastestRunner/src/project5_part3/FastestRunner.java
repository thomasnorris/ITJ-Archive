// Takes a list of marathon runners and finds the fastest and second fastest
// runner, the slowest and second slowerst runner, and prints the list of 
// runners.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project5_part3;
public class FastestRunner {
    public static void main(String[] args) {
        int numRunners, fastestTime, slowestTime, fastestTime2, 
                slowestTime2, timeHours1, timeHours2, timeHours3, timeHours4, 
                timeMinutes1, timeMinutes2, timeMinutes3, timeMinutes4;
        String fastestRunner, slowestRunner, fastestRunner2, slowestRunner2;
        numRunners = 16;
        slowestTime = 0;
        slowestTime2 = 0;
        fastestTime = 100000;
        fastestTime2 = 100000;
        slowestRunner = "";
        slowestRunner2 = "";
        fastestRunner = "";
        fastestRunner2 = "";
        
        
        String[] name ={"Elena", "Thomas", "Hamilton", "Suzie", "Phil",
            "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily",
            "Daniel", "Neda", "Aaron", "Kate"};
        int[] time ={341, 273, 278, 329, 445, 402, 388, 275, 243, 334,
            412, 393, 299, 343, 371, 265};
        
        System.out.printf("Name          Time(Minutes)\n");
        System.out.printf("---------------------------\n");
        for (int i = 0; i < numRunners; i++) {
            System.out.printf("%-17s %-10s\n", name[i], time[i]);
        }
        // Slowest and fastest runners
        for (int i = 0; i < numRunners; i++)
            if (time[i] > slowestTime) {
                slowestTime = time[i];
                slowestRunner = name[i];
            } else if (time[i] < fastestTime){
                fastestTime = time[i];
                fastestRunner = name[i];  
            }
        // Second slowest and second fastest runners
        for (int i = 0; i < numRunners; i++)
            if (time[i] > slowestTime2 && time[i] < slowestTime) {
                slowestTime2 = time[i];
                slowestRunner2 = name[i];
            } else if (time[i] < fastestTime2 && 
                    time[i] > fastestTime) {
                fastestTime2 = time[i];
                fastestRunner2 = name[i];
            }        
        
        timeHours1 = slowestTime / 60;
        timeMinutes1 = slowestTime - (timeHours1 * 60);    
        timeHours2 = fastestTime / 60;
        timeMinutes2 = fastestTime - (timeHours2 * 60);
        timeHours3 = slowestTime2 / 60;
        timeMinutes3 = slowestTime2 - (timeHours3 * 60);
        timeHours4 = fastestTime2 / 60;
        timeMinutes4 = fastestTime2 - (timeHours4 * 60);
        
        System.out.println("");
        System.out.println("The fastest runner is "+fastestRunner+
                " with a time of "+ fastestTime+" minutes ("+timeHours2+" "
                + "hours and "+timeMinutes2+" minutes).");
        System.out.println("The second fastest runner is "+fastestRunner2+
                " with a time of "+ fastestTime2+" minutes ("+timeHours4+" "
                + "hours and "+timeMinutes4+" minutes).");
        System.out.println("The slowest runner is "+slowestRunner+
                " with a time of "+ slowestTime+" minutes ("+timeHours1+" "
                + "hours and "+timeMinutes1+" minutes).");
        System.out.println("The second slowest runner is "+slowestRunner2+
                " with a time of "+ slowestTime2+" minutes ("+timeHours3+" "
                + "hours and "+timeMinutes3+" minutes)."); 
    }             
} 



