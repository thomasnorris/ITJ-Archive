// Program for basic 1inventory and stock management
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

package project6_only;
import java.io.*;
import java.util.*;
public class Project6_Only {
    public static Entry[] entryList = new Entry[200];
    public static void main(String[] args) throws Exception {
        Scanner stdin = new Scanner(System.in);
        final int NUM_ENTRIES;
        int currentSize;
        char command;
        String name, number, notes, inventoryLog;
        currentSize = 0;
        NUM_ENTRIES = 200;
        inventoryLog = null;
        
        System.out.println("Codes are entered as 1 to 8 characters.\n"
            + "Use \"e\" for enter, \"f\" for find, \"l\" "
            + "for list, \"q\" for quit. ");
        currentSize = readInventory(inventoryLog, currentSize);
        while(currentSize < NUM_ENTRIES) {
            System.out.print("Command: ");
            command = stdin.next().charAt(0);
            switch(command) {
                case 'e': {
                    name = stdin.next();
                    System.out.print("Enter a quantity: ");
                    number = stdin.next();
                    System.out.print("Enter notes: ");
                    stdin.nextLine();
                    notes = stdin.nextLine();
                    entryList[currentSize] = new Entry(name, number, notes);
                    currentSize++;
                    System.out.println("");
                    break;
                } case 'l': {
                    listAllEntries(entryList, currentSize);
                    break;
                } case 'q': {
                    storeInventory(inventoryLog, currentSize);
                    break;
                } case 'f': {
                    name = stdin.next();
                    searchInventory(entryList, name, currentSize);
                    break;
                }   
            }
        } 
        System.exit(0);
    }
    
    public static void listAllEntries(Entry[] entryList, int currentSize) {
        if (currentSize == 0) 
            System.out.println("There are currently no items "
                + "in the inventory.");
        for (int i = 0; i < currentSize; i++) {
            System.out.println("Entry "+(i+1)+": "+entryList[i].name+
                "\n-- "+entryList[i].number+"\n-- "+
                entryList[i].notes+"\n");
        }   
    } 
  
    public static void searchInventory(Entry[] entryList, String name, 
            int currentSize) {
        boolean found;
        found = false;
        for (int i = 0; i < currentSize; i++) {
            if (entryList[i].name.equalsIgnoreCase(name)) {
                System.out.println("-- "+entryList[i].name+"\n-- "
                    +entryList[i].number+"\n-- "+entryList[i].notes+"\n");
                found = true;
            }
        } 
        if (found == false)
            System.out.println("** No entry with code "+name+"\n");
    }
    
    public static void storeInventory(String inventoryLog, 
            int currentSize) throws Exception {
        try (PrintStream P = new PrintStream("src\\project6_only\\"
            + "inventoryLog.txt")) {
            for (int i = 0; i < currentSize; i++) {
                P.println(entryList[i].name + "  " + entryList[i].number 
                    + "  " + entryList[i].notes);  
            }  
        System.out.println("Inventory Stored.");
        System.exit(0);
        }
    }

    public static int readInventory(String inventoryLog, 
            int currentSize) throws Exception {
        java.io.File file = new java.io.File("src\\project6_only"
            + "\\inventoryLog.txt");
        if (!file.exists())
            file.createNewFile();
        String name, number, notes;
        Scanner fileIn = new Scanner(file);
        for (int i = 0; fileIn.hasNext(); i++) {
            name = fileIn.next();
            number = fileIn.next();
            notes = fileIn.nextLine();
            notes = notes.trim();
            entryList[i] = new Entry(name, number, notes);
            currentSize++;
        }  
        return currentSize;
    }  
}