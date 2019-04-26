package main.com.RPGEventer.entities.character;

import javafx.scene.Node;
import main.com.RPGEventer.entities.character.inventory.inventory;
import main.com.RPGEventer.entities.character.properties.attributes;
import main.com.RPGEventer.entities.character.properties.stats;
import main.com.RPGEventer.entities.status.statusEffect;
import main.com.RPGEventer.interfaces.inventoriable;
import main.com.RPGEventer.entities.items.baseItem;
import main.com.RPGEventer.entities.maps.baseMap;
import main.com.RPGEventer.interfaces.displayable;
import main.com.RPGEventer.interfaces.interactable;

import java.util.Vector;

public abstract class baseCharacter implements inventoriable, displayable, interactable {
    //Vars
    public inventory charInventory;
    public stats charStats;
    public attributes charAttributes;
    public Vector<statusEffect> charEffects;

    @Override
    public Node nodeToDisplay() {
        return null;
    }
    //Overrides
    @Override
    public boolean addItemToInventory(baseItem itemToAdd, baseCharacter characterToAddItemTo) {
        //So every baseCharacter will have an inventory and will add/remove items the same way.  If not,
        //I can override those differences.  Like and nonPlayerCharacter should never add items to their inventory, idt
        //Its a pretty simple fix otherwise, all I have to do is remove that override and use this one ofc

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
    public void removeFromScene() {

    }

    @Override
    public boolean interact(baseItem item, baseMap map) {
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
    public boolean interact(baseCharacter char1, baseMap map) {
        return false;
    }

    //Methods
    public inventory getInventory() {
        return charInventory;
    }
}
