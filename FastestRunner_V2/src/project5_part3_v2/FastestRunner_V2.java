// Takes a list of marathon runners and finds the fastest and second fastest
// runner, the slowest and second slowerst runner, and prints the list of 
// total runners.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project5_part3_v2;
public class FastestRunner_V2 {
    public static void main(String[] args) {
        int fastest, slowest, secondFastest, secondSlowest, timeHours1, 
                timeHours2, timeHours3, timeHours4, timeMinutes1, 
                timeMinutes2, timeMinutes3, timeMinutes4, numRunners;
        String[] name ={"Elena", "Thomas", "Hamilton", "Suzie", "Phil",
            "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily",
            "Daniel", "Neda", "Aaron", "Kate"};
        int[] time ={341, 273, 278, 329, 445, 402, 388, 275, 243, 334,
            412, 393, 299, 343, 317, 265};
        
        numRunners = 16;
        
        // Calculations of the runners and times
        fastest = getFastest(name, time);
        timeHours1 = time[fastest] / 60;
        timeMinutes1 = time[fastest] - (timeHours1 * 60);
        slowest = getSlowest(name, time);
        timeHours2 = time[slowest] / 60;
        timeMinutes2 = time[slowest] - (timeHours2 * 60);
        secondFastest = getSecondFastest(name, time, fastest);
        timeHours3 = time[secondFastest] / 60;
        timeMinutes3 = time[secondFastest] - (timeHours3 * 60);
        secondSlowest = getSecondSlowest(name, time, slowest);
        timeHours4 = time[secondSlowest] / 60;
        timeMinutes4 = time[secondSlowest] - (timeHours4 * 60);
        
        System.out.printf("Name          Time(Minutes)\n");
        System.out.printf("---------------------------\n");
        for (int i = 0; i < numRunners; i++) 
            System.out.printf("%-17s %-10s\n", name[i], time[i]);
        System.out.println("");
        System.out.println("The fastest runner is "+name[fastest]+" with a "
                + "time of "+time[fastest]+" minutes ("+timeHours1+" hours "
                + "and "+timeMinutes1+" minutes).");
        System.out.println("The second fastest runner is "+name[secondFastest]+" "
                + "with a time of "+time[secondFastest]+" minutes ("+timeHours3+" "
                + "hours and "+timeMinutes3+" minutes).");
        System.out.println("The slowest runner is "+name[slowest]+" with a "
                + "time of "+time[slowest]+" minutes ("+timeHours2+" hours "
                + "and "+timeMinutes2+" minutes).");
        System.out.println("The second slowest runner is "+name[secondSlowest]+" "
                + "with a time of "+time[secondSlowest]+" minutes ("+timeHours4+" "
                + "hours and "+timeMinutes4+" minutes).");
    }
    
    public static int getFastest(String[] name, int[] time) {
        int numRunners, fastest, index;
        numRunners = 16;
        fastest = 10000;
        index = -1;
        
        for (int i = 0; i < numRunners; i++)
            if (time[i] < fastest) { 
                fastest = time[i];
                index = i;
            }    
        return index;
    }
    
    public static int getSlowest(String[] name, int[] time) {
        int numRunners, slowest, index;
        numRunners = 16;
        slowest = 0;
        index = -1;
        
        for (int i = 0; i < numRunners; i++)
            if (time[i] > slowest) {
                slowest = time[i];
                index = i;
            }
        return index;
    }
    
    public static int getSecondFastest(String[] name, int[] time, 
            int fastest) {
        int numRunners, secondFastest, index;
        numRunners = 16;
        secondFastest = 10000;
        index = -1;
        
        for (int i = 0; i < numRunners; i++) 
            if (time[i] < secondFastest && time[i] > time[fastest]) {
                secondFastest = time[i];
                index = i;
            }
        return index;
    }
    
    public static int getSecondSlowest(String[] name, int[] time, 
            int slowest) {
        int numRunners, secondSlowest, index;
        numRunners = 16;
        secondSlowest = 0;
        index = -1;
        
        for (int i = 0; i < numRunners; i++)
            if (time[i] > secondSlowest && time[i] < time[slowest]) {
                secondSlowest = time[i];
                index = i;
            }
        return index;
    }
}
