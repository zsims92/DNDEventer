package main.com.RPGEventer.entities.items;

import javafx.event.Event;
import javafx.scene.Node;
import main.com.RPGEventer.entities.character.baseCharacter;
import main.com.RPGEventer.entities.maps.baseMap;
import main.com.RPGEventer.interfaces.displayable;
import main.com.RPGEventer.interfaces.interactable;
import main.com.RPGEventer.interfaces.inventoriable;

import java.awt.event.ActionEvent;

public class baseItem implements inventoriable, displayable, interactable {
    @Override
    public Node nodeToDisplay() {
        return null;
    }

    @Override
    public void removeFromScene() {

    }

    @Override
    public void update() {

    }


    @Override
    public boolean addItemToInventory(baseItem itemToAdd, baseCharacter characterToAddItemTo) {
        if(characterToAddItemTo == null || itemToAdd == null) { System.out.println("Could NOT add " + itemToAdd + " to your inventory!"); return false; }
        else { System.out.println(itemToAdd + " has been added to your inventory!"); return true;}
    }

    @Override
    public boolean removeItemFromInventory(baseItem itemToRemove, baseCharacter characterToRemoveItemFrom) {
        if(characterToRemoveItemFrom == null || itemToRemove == null) { System.out.println( itemToRemove + " is NOT in your inventory!"); return false; }
        else { System.out.println(itemToRemove + " has been removed from your inventory!"); return true;}

    }

    @Override
    public boolean useItem(baseItem itemToUse, baseCharacter characterUsingItem) {
        if(characterUsingItem == null || itemToUse == null) { System.out.println( "I can NOT use " + itemToUse +"!"); return false; }
        else { System.out.println("ermagawd, im using: " + itemToUse); return true;}
    }

    @Override
    public boolean interact(baseCharacter char1, baseCharacter char2) {
        if(char1 == null || char2 == null) { System.out.println( "There is no one here, stupid!"); return false; }
        else { System.out.println("Sup dawg, trade shit?"); return true;}

    }

    @Override
    public boolean interact(baseCharacter char1, baseItem item) {
        if(char1 == null || item == null) { System.out.println( "I have no idea what im doing"); return false; }
        else { System.out.println("Wait, did something just happen?!"); return true;}
    }

    @Override
    public boolean interact(baseItem item, baseMap map) {
        if(item == null || map == null) { System.out.println( "Flux capacitor is broken."); return false; }
        else { System.out.println("Im doing a thing!"); return true;}
    }

    @Override
    public boolean interact(baseCharacter char1, baseMap map) {
        if(char1 == null || map == null) { System.out.println( "The cake is a lie"); return false; }
        else { System.out.println("Im eating the cake."); return true;}
    }
}
