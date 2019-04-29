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
        return false;
    }

    @Override
    public boolean removeItemFromInventory(baseItem itemToRemove, baseCharacter characterToRemoveItemFrom) {
        return false;
    }

    @Override
    public boolean useItem(baseItem itemToUse, baseCharacter characterUsingItem) {
        return false;
    }

    @Override
    public boolean interact(baseCharacter char1, baseCharacter char2) {
        return false;
    }

    @Override
    public boolean interact(baseCharacter char1, baseItem item) {
        return false;
    }

    @Override
    public boolean interact(baseItem item, baseMap map) {
        return false;
    }

    @Override
    public boolean interact(baseCharacter char1, baseMap map) {
        return false;
    }
}
