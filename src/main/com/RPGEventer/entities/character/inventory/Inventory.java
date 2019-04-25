package main.com.RPGEventer.entities.character.inventory;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.entities.items.baseItem;
import main.com.RPGEventer.javaFXManager.fxNodeInterface;

import java.util.Vector;

public class Inventory implements fxNodeInterface {
        private final Vector<baseItem> itemsInInventory;

        //TODO
        //Add lots of bullshit here
        public Inventory(Integer size){
                itemsInInventory = new Vector<>(size);
        }

        @Override
        public Node displayNode() {
                //Set up node that displays inventory
                AnchorPane root = new AnchorPane();
                GridPane inventoryDisplay = new GridPane();
                //TODO:
                // Based on inventory size
                inventoryDisplay.addColumn(0, itemsInInventory.elementAt(0).displayNode());
                inventoryDisplay.addColumn(1);
                inventoryDisplay.addRow(0);
                inventoryDisplay.addRow(1);

                root.getChildren().add(inventoryDisplay);
                return root;
        }
}
