package main.com.RPGEventer.entities.items;

import javafx.scene.Node;
import main.com.RPGEventer.entities.character.baseCharacter;
import main.com.RPGEventer.entities.character.interactionInterface;
import main.com.RPGEventer.entities.character.inventory.inventoryInterface;
import main.com.RPGEventer.javaFXManager.fxNodeInterface;

public class baseItem implements inventoryInterface, fxNodeInterface, interactionInterface {
    @Override
    public Node displayNode() {
        return null;
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
    public boolean addStatusEffect(String effect, baseCharacter characterToFuckUpOrHealWhatever) {
        return false;
    }

    @Override
    public String getStatusEffect() {
        return "deal damage";
    }
}
