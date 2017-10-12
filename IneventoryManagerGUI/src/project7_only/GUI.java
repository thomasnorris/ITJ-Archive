// Inventory manager GUI. Has many features, useful and reliable.
// Created by Thomas Norris for EECS 1510-001 with Dr. Ledgard.

// Complete GUI class for the inventory manager.
package project7_only;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    // All of the nodes
    public TextField itemName = new TextField();
    public TextField itemQuantity = new TextField();
    public TextField itemNotes = new TextField();
    public ComboBox optionSelect = new ComboBox();
    public Button addItem = new Button("Add Item");
    public Button removeItem = new Button("Delete Item");
    public Button searchItem = new Button("Search");
    public Button exitProg = new Button("Save and Quit");
    public Button startProg = new Button("Start");
    public Button resetInventory = new Button("Reset");
    public Alert quitAlert = new Alert(AlertType.INFORMATION);
    public Alert resetAlert = new Alert(AlertType.CONFIRMATION);
    public Alert resetNotice = new Alert(AlertType.INFORMATION);
    public Label systemOut = new Label();
    public Label itemCounter = new Label();
    public TextArea textArea = new TextArea();
    public Label objectLabel = new Label();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Addding everything to the gridpane 
        GridPane mainGrid = new GridPane();
        mainGrid.setHgap(7);
        mainGrid.setVgap(7);
        mainGrid.setPadding(new Insets(10, 10, 10, 10));
        mainGrid.add(new Label("What would you like to do?"), 0, 0);
        mainGrid.add(optionSelect, 1, 0);
        mainGrid.add(new Label("Item name:"), 0, 1);
        mainGrid.add(itemName, 1, 1);
        mainGrid.add(new Label("Number of items:"), 0, 2);
        mainGrid.add(itemQuantity, 1, 2);
        mainGrid.add(new Label("Notes for this item:"), 0, 3);
        mainGrid.add(itemNotes, 1, 3);
        mainGrid.add(addItem, 1, 4);
        mainGrid.add(removeItem, 1, 4);
        mainGrid.add(searchItem, 1, 4);
        mainGrid.add(exitProg, 2, 6);
        mainGrid.add(startProg, 0, 4);
        mainGrid.add(systemOut, 0, 5);
        mainGrid.add(resetInventory, 0, 4);
        mainGrid.add(itemCounter, 1, 0);
        mainGrid.add(textArea, 2, 1);
        mainGrid.add(objectLabel, 2, 0);
        mainGrid.setAlignment(Pos.TOP_CENTER);
        
        // Set alignment of notes in the gridpane
        GridPane.setColumnSpan(systemOut, 2);
        GridPane.setRowSpan(textArea, 5);
        GridPane.setHalignment(searchItem, HPos.RIGHT);
        GridPane.setHalignment(addItem, HPos.LEFT);
        GridPane.setHalignment(removeItem, HPos.CENTER);
        GridPane.setHalignment(exitProg, HPos.RIGHT);
        GridPane.setHalignment(startProg, HPos.LEFT);
        GridPane.setHalignment(systemOut, HPos.CENTER);
        GridPane.setHalignment(resetInventory, HPos.RIGHT);
        GridPane.setHalignment(optionSelect, HPos.RIGHT);
        GridPane.setHalignment(itemCounter, HPos.LEFT);
        
        // Set the parameters of the notes
        textArea.setPrefWidth(350);
        itemName.setAlignment(Pos.BOTTOM_RIGHT);
        itemName.setPrefWidth(280);
        itemQuantity.setAlignment(Pos.BOTTOM_RIGHT);
        itemQuantity.setPrefWidth(280);
        itemNotes.setAlignment(Pos.BOTTOM_RIGHT);
        itemQuantity.setPrefWidth(280);
        itemName.setPromptText("You must choose an option first");
        itemQuantity.setPromptText("You must choose an option first");
        itemNotes.setPromptText("You must choose an option first");
        optionSelect.getItems().addAll("Add", "Delete","Search", "Reset");
        optionSelect.setPromptText("Choose an option");
        quitAlert.setTitle("Notice");
        quitAlert.setHeaderText(null);
        quitAlert.setContentText("The inventory was updated successfully."
                + "\nSaved to file \"inventoryLog.txt\" which is located in"
                + " the same directory that the application was launched.");
        resetAlert.setTitle("Notice");
        resetAlert.setHeaderText("Clicking \"OK\" will remove all of the "
                + "items that are\ncurrently stored in the inventory.");
        resetAlert.setContentText("Are you sure that you want to do this? "
                + "This cannot be undone.");
        resetNotice.setTitle("Notice");
        resetNotice.setHeaderText(null);
        resetNotice.setContentText("The inventory has been reset "
                + "successfully.");
        objectLabel.setText("  Item Name             Quantity           "
                + "    Notes");
        objectLabel.setStyle("-fx-text-fill: blue");
        
        // Initial disable/enable of the notes on startup
        optionSelect.setDisable(true);
        itemName.setDisable(true);
        itemQuantity.setDisable(true);
        itemNotes.setDisable(true);
        addItem.setDisable(true);
        removeItem.setDisable(true);
        searchItem.setDisable(true);
        resetInventory.setDisable(true);
        startProg.setDisable(false);
        
        // Create the scene
        Scene mainScene = new Scene(mainGrid, 800, 225);
        primaryStage.setTitle("Inventory Management");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        
        // Start the program and run initial methods
        primaryStage.show();
        systemOut.setText("Welcome! To start managing your inventory, "
                + "please click \"Start\" above.");
        systemOut.setStyle("-fx-text-fill: blue");
        Inventory.setItemCounter(itemCounter);
        Inventory.readInventory(itemCounter);
        
        // Switcher for the combobox. Enables/disables nodes relevant 
        // to which combobox option is chosen
        optionSelect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index;
                index = optionSelect.getSelectionModel().getSelectedIndex();
                if (index == 0) {
                    itemName.setDisable(false);
                    itemName.setPromptText("Single word only");
                    itemQuantity.setDisable(false);
                    itemQuantity.setPromptText("Single number only");
                    itemNotes.setDisable(false);
                    itemNotes.setPromptText("Optional");
                    addItem.setDisable(false);
                    removeItem.setDisable(true);
                    searchItem.setDisable(true);
                    startProg.setDisable(true);
                    resetInventory.setDisable(true);
                    systemOut.setText("This will add an item. Enter the "
                            + "info and click \"Add Item\".");
                    systemOut.setStyle("-fx-text-fill: blue");
                } if (index == 1) {
                    itemName.setDisable(false);
                    itemName.setPromptText("Single word only");
                    itemQuantity.setDisable(true);
                    itemQuantity.setPromptText("Not applicable");
                    itemNotes.setDisable(true);
                    itemNotes.setPromptText("Not applicable");
                    addItem.setDisable(true);
                    removeItem.setDisable(false);
                    searchItem.setDisable(true);
                    startProg.setDisable(true);
                    resetInventory.setDisable(true);
                    systemOut.setText("This will delete an item. Enter "
                            + "the name and click \"Delete Item\".");
                    systemOut.setStyle("-fx-text-fill: blue");
                } if (index == 2) {
                    itemName.setDisable(false);
                    itemName.setPromptText("Single word only");
                    itemQuantity.setDisable(true);
                    itemQuantity.setPromptText("Not applicable");
                    itemNotes.setDisable(true);
                    itemNotes.setPromptText("Not applicable");
                    addItem.setDisable(true);
                    removeItem.setDisable(true);
                    searchItem.setDisable(false);
                    startProg.setDisable(true);
                    resetInventory.setDisable(true);
                    systemOut.setText("This will search for an item. "
                            + "Enter the name and click \"Search\".");
                    systemOut.setStyle("-fx-text-fill: blue");
                } if (index == 3) {
                    itemName.setDisable(true);
                    itemName.setPromptText("Not applicable");
                    itemQuantity.setDisable(true);
                    itemQuantity.setPromptText("Not applicable");
                    itemNotes.setDisable(true);
                    itemNotes.setPromptText("Not applicable");
                    addItem.setDisable(true);
                    removeItem.setDisable(true);
                    searchItem.setDisable(true);
                    resetInventory.setDisable(false);
                    startProg.setDisable(true);
                    systemOut.setText("To reset the inventory and "
                            + "delete all items, click \"Reset\". "
                            + "Use caution.");
                    systemOut.setStyle("-fx-text-fill: blue");
                }
            }
        });
        
        // Actions for each of the different button events. Each is unique and 
        // helps to make sure the program works correctly. For example, when
        // an item is added to the inventory, the name must not contain 
        // any spaces. The addItem.setOnAction event checks for this and gives
        // feedback accordingly.
        exitProg.setOnAction((ActionEvent event) -> {
            try {
                Inventory.storeInventory(quitAlert);
            } catch (Exception ex) {
                systemOut.setText("There was a problem quitting the "
                        + "program.");
                systemOut.setStyle("-fx-text-fill: red");
            }
        });
        addItem.setOnAction((ActionEvent event) -> {
            if (!itemName.getText().isEmpty() && !itemQuantity.getText().
                    isEmpty() && itemName.getText().matches("\\w+") && 
                    itemQuantity.getText().matches("\\d+") && 
                    !itemName.getText().contains(" ") && 
                    !itemQuantity.getText().contains(" ")) {
                try {
                    Inventory.addToInventory(systemOut, itemCounter, 
                            itemName.getText(), itemQuantity.getText(), 
                            itemNotes.getText(), textArea);
                } catch (Exception ex) {
                    systemOut.setText("There was a problem updating the "
                            + "inventory.");
                    systemOut.setStyle("-fx-text-fill: red");
                }
                itemName.clear();
                itemQuantity.clear();
                itemNotes.clear(); 
            } else if (itemName.getText().contains(" ")) {
                systemOut.setText("The name must be a single word.");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (itemQuantity.getText().contains(" ")){
                systemOut.setText("The quantity must be a single number.");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (itemName.getText().isEmpty()){
                systemOut.setText("You must enter a name");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (itemQuantity.getText().isEmpty()){
                systemOut.setText("You must enter a quantity");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (!itemName.getText().matches("\\w+")) {
                systemOut.setText("The item's name can only be letters and"
                        + " numbers (only a(A) to z(Z) and 0 to 9).");
                systemOut.setStyle("-fx-text-fill: red"); 
            } else if (!itemQuantity.getText().matches("\\d+")) {
                systemOut.setText("The item's quantity must be a number.");
                systemOut.setStyle("-fx-text-fill: red");
            } 
        });
        startProg.setOnAction((ActionEvent event) -> {
            optionSelect.setDisable(false);
            textArea.setEditable(false);
            startProg.setDisable(true);
            try {
                Inventory.startProgram(systemOut, textArea);
            } catch (Exception ex) {
                systemOut.setText("There was a problem displaying the "
                        + "inventory.");
                systemOut.setStyle("-fx-text-fill: red");
            }
        });  
        searchItem.setOnAction((ActionEvent event) -> {
            textArea.setEditable(false);
            if (!itemName.getText().isEmpty() && itemName.getText().matches
                    ("\\w+") && !itemName.getText().contains(" ")) {
                Inventory.searchInventory(itemName.getText(), systemOut, 
                        itemCounter);
                itemName.clear();
            } else if (itemName.getText().contains(" ")){
                systemOut.setText("The name must be a single word.");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (itemName.getText().isEmpty()) {
                systemOut.setText("You must enter a name to be searched.");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (!itemName.getText().matches("\\w+")) {
                systemOut.setText("The item's name can only be letters and "
                        + "numbers (only a(A) to z(Z) and 0 to 9).");
                systemOut.setStyle("-fx-text-fill: red");
            }
        });
        removeItem.setOnAction((ActionEvent event) -> {
            if (!itemName.getText().isEmpty() && itemName.getText().matches
                    ("\\w+") && !itemName.getText().contains(" ")){
                try { 
                    Inventory.removeFromInventory(itemName.getText(),
                            systemOut, itemCounter, textArea);
                } catch (Exception ex) {
                    systemOut.setText("There was a problem removing the "
                            + "item.");
                    systemOut.setStyle("-fx-text-fill: red");
                }
                itemName.clear();
            } else if (itemName.getText().contains(" ")) {
                systemOut.setText("The name must be a single word.");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (itemName.getText().isEmpty()) {
                systemOut.setText("You must enter a name to remove it.");
                systemOut.setStyle("-fx-text-fill: red");
            } else if (!itemName.getText().matches("\\w+")) {
                systemOut.setText("The item's name can only be letters and "
                        + "numbers (only a(A) to z(Z) and 0 to 9).");
                systemOut.setStyle("-fx-text-fill: red");
            }
        });
        resetInventory.setOnAction((ActionEvent event) -> {
            try {
               Inventory.resetInventory(resetAlert, resetNotice, systemOut, 
                       itemCounter, textArea);
            } catch (Exception ex) {
               systemOut.setText("There was a problem resetting the "
                       + "inventory.");
               systemOut.setStyle("-fx-text-fill: red");
            }
        });
    }
}