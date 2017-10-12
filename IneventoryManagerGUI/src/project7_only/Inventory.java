// The "brains" class of the inventory manager.
// Each method is a different function.

package project7_only;
import java.io.PrintStream;
import java.util.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
public class Inventory {
    public static Entry[] entryList = new Entry[200];
    public static int currentSize = 0;
    public static java.io.File file = new java.io.File("inventoryLog.txt");
    
    // Method for adding items to the entryList array, adding items to the 
    // textarea, sorting the array alhabetically, and saving the entries to 
    // the inventoryLog.txt file.
    public static void addToInventory(Label systemOut, Label itemCounter, 
            String name, String number, String notes, TextArea 
            textArea) throws Exception {
        boolean nameExists;
        nameExists = false;
        if (currentSize < 200) {
            for (int i = 0; i < currentSize; i++) {
                if (name.equalsIgnoreCase(entryList[i].name))
                    nameExists = true;
            }
            if (nameExists == false) {
                entryList[currentSize] = new Entry(name, number, notes);
                currentSize++;
                bubbleSort();
                try (PrintStream P = new PrintStream("inventoryLog.txt")) {
                    for (int i = 0; i < currentSize; i++) {
                        P.printf("%-15s %-10s %-10s\n", entryList[i].name, 
                                entryList[i].number, entryList[i].notes); 
                    }  
                }
                textArea.clear();
                Scanner fileIn = new Scanner(file);
                while (fileIn.hasNext()) {
                    textArea.setStyle("-fx-font-family: monospace");
                    textArea.appendText(fileIn.nextLine()+"\n");
                    textArea.setEditable(false);
                }
                systemOut.setText("The item \""+name+"\" has been "
                            + "succeessfully added to the inventory.");
                systemOut.setStyle("-fx-text-fill: green");
                setItemCounter(itemCounter);
            } 
            else if (nameExists == true) {
                systemOut.setText("The name \""+name+"\" is already in the "
                        + "inventory.");
                systemOut.setStyle("-fx-text-fill: red");
            } 
        } else {
            systemOut.setText("Maximum amount of entries achieved. Cannot add.");
                systemOut.setStyle("-fx-text-fill: red");
        }
    }
    
    // Second method for the initial startup of the program. Determines if 
    // there are initial items in the inventory and loads them into 
    // the textarea.
    public static void startProgram(Label systemOut, TextArea textArea) 
            throws Exception {
        if (currentSize == 0) {
            systemOut.setText("There are currently no items stored. "
                    + "Please choose an option above.");
            systemOut.setStyle("-fx-text-fill: blue");
        }
        else {
            textArea.clear();
            Scanner fileIn = new Scanner(file);
            while (fileIn.hasNext()) {
                textArea.setStyle("-fx-font-family: monospace");
                textArea.appendText(fileIn.nextLine()+"\n");
                textArea.setEditable(false);
            }
            
            systemOut.setText("Items are listed in the box to the right. "
                    + "Please choose an option above.");
            systemOut.setStyle("-fx-text-fill: blue");
        }
    }
    
    // Method for searching the inventory. Searches the array for the name of
    // an item and returns what it finds.
    public static void searchInventory(String name, Label systemOut, 
            Label itemCounter) {
        boolean found;
        found = false;
        for (int i = 0; i < currentSize; i++) {
            if (entryList[i].name.equalsIgnoreCase(name)) {
                systemOut.setText("The item \""+entryList[i].name+"\" is in "
                        + "the inventory. You can find it in the box to the "
                        + "right.");
                systemOut.setStyle("-fx-text-fill: green");
                setItemCounter(itemCounter);
                found = true;
            }
        } 
        if (found == false) {
            systemOut.setText("No item found for the name \""+name+"\". You"
                    + " cannot find it in the box to the right.");
            systemOut.setStyle("-fx-text-fill: red");
        }
    }
    
    // Method for quitting the inventory. The array is written to a file
    // which is loaded on initial startup so a user can pick up where they 
    // last left off.
    public static void storeInventory(Alert quitAlert) throws Exception {
        try (PrintStream P = new PrintStream("inventoryLog.txt")) {
            for (int i = 0; i < currentSize; i++) {
                P.printf("%-15s %-10s %-10s\n", entryList[i].name, 
                        entryList[i].number, entryList[i].notes);  
            }  
        }
        quitAlert.showAndWait();
        System.exit(0); 
    }
    
    // First method run by the program. Adds any entries in the 
    // inventoryLog.txt file to the array and adjusts the size accordingly.
    public static int readInventory(Label itemCounter) throws Exception {
        String name, number, notes;
        if (!file.exists()) 
            file.createNewFile();
        Scanner fileIn = new Scanner(file);
        for (int i = 0; fileIn.hasNext(); i++) {
            name = fileIn.next();
            number = fileIn.next();
            notes = fileIn.nextLine();
            notes = notes.trim();
            entryList[i] = new Entry(name, number, notes);
            currentSize++;
        }
        setItemCounter(itemCounter);
        return currentSize;
    }
    
    // Method for removing items from the inventory. A name is entered, if the 
    // name is found in the inventory then it is removed from the array, the 
    // text file and the textarea. Outputs item not found otherwise.
    public static int removeFromInventory(String name, Label systemOut, 
            Label itemCounter, TextArea textArea) 
            throws Exception {
        ArrayList<Entry> entryList2 = new ArrayList<>(Arrays.asList
                (entryList));
        boolean found;
        found = false;
        for (int i = 0; i < currentSize; i++) {
            if (entryList[i].name.equalsIgnoreCase(name)) {
                entryList2.remove(i);
                entryList = entryList2.toArray(new Entry[200]);
                systemOut.setText("Item \""+name+"\" removed successfully.");
                systemOut.setStyle("-fx-text-fill: green");
                currentSize--;
                setItemCounter(itemCounter);
                found = true;
            }
        }
        if (found == false) {
            systemOut.setText("No item found with name "+name+".");
            systemOut.setStyle("-fx-text-fill: red");
        }
        try (PrintStream P = new PrintStream("inventoryLog.txt")) {
            for (int i = 0; i < currentSize; i++) {
                P.printf("%-15s %-10s %-10s\n", entryList[i].name, 
                        entryList[i].number, entryList[i].notes); 
            }  
        }
        textArea.clear();
        Scanner fileIn = new Scanner(file);
        while (fileIn.hasNext()) {
            textArea.setStyle("-fx-font-family: monospace");
            textArea.appendText(fileIn.nextLine()+"\n");
            textArea.setEditable(false);
        }
        return currentSize;
    }
    
    // Method for resetting the inventory. Deletes all entries from the array,
    // the text file and the textarea. Shows alert popups to let the user
    // know what they are about to do and runs according to their choice.
    public static int resetInventory(Alert resetAlert, Alert resetNotice, 
            Label systemOut, Label itemCounter, TextArea textArea) 
            throws Exception {
        ArrayList<Entry> entryList2 = new ArrayList<>(Arrays.asList
                (entryList));
        if (file.length() == 0) {
            systemOut.setText("There are currently no items stored. "
                    + "Cannot reset.");
            systemOut.setStyle("-fx-text-fill: red");
        } else {
            Optional<ButtonType> choice = resetAlert.showAndWait();
            if (choice.get() == ButtonType.OK) {
                for (int i = 0; i < currentSize; i++) {
                    PrintStream P = new PrintStream("inventoryLog.txt");
                    entryList2.remove(i);
                    entryList = entryList2.toArray(new Entry[200]);
                    P.write((new String()).getBytes());
                }
                currentSize = 0;
                setItemCounter(itemCounter);
                resetNotice.showAndWait();
                textArea.clear();
                textArea.setEditable(false);
            } else 
                resetNotice.close();
        }
        return currentSize;
    }
    
    // Method for the alphabetical sort of the array. 
    public static void bubbleSort() {
        for (int i = 1; i < currentSize; i++) {
            for (int j = 0; j < currentSize - i; j++) {
                if (((entryList[j].name.compareToIgnoreCase(entryList[j+1]
                        .name)))>0) {
                    Entry temp = entryList[j];   
                    entryList[j] = entryList[j+1];
                    entryList[j+1] = temp;
                }
            }
        }
    }
    
    // Method to set the item counter label that is found at the
    // top of the GUI.
    public static void setItemCounter(Label itemCounter) {
        itemCounter.setText("Inventory size: "+currentSize+"/200");
        itemCounter.setStyle("-fx-text-fill: blue");
    }
}
