package main.com.RPGEventer.entities.character.inventory;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.entities.items.baseItem;
import main.com.RPGEventer.interfaces.displayable;

import java.awt.event.ActionEvent;
import java.util.Vector;

public class inventory implements displayable {
        private final Vector<baseItem> itemsInInventory;


        public inventory(Integer size){
                itemsInInventory = new Vector<>(size);
        }

        @Override
        public Node nodeToDisplay() {
                //Set up node that displays inventory
                AnchorPane root = new AnchorPane();
                GridPane inventoryDisplay = new GridPane();


                // TODO:
                //  This loop needs tested
                int invMod = 4;
                int temp = itemsInInventory.size();
                int numRows = 1;
                while(temp-invMod>=0){
                        numRows++;
                        temp -= invMod;
                }

                for(int i=0; i<numRows; i++){
                        inventoryDisplay.addRow(i);
                }

                root.getChildren().add(inventoryDisplay);
                return root;
        }


        @Override
        public void removeFromScene() {

        }

        @Override
        public void update() {

        }
}
