package main.com.RPGEventer.entities.character;

import main.com.RPGEventer.entities.character.inventory.Inventory;
import main.com.RPGEventer.entities.character.inventory.inventoryInterface;
import main.com.RPGEventer.entities.items.baseItem;
import main.com.RPGEventer.javaFXManager.fxNodeInterface;

public abstract class baseCharacter implements inventoryInterface, fxNodeInterface, interactionInterface {
    private Inventory inventory;
    public Integer Health = 100;

    @Override
    public String getStatusEffect() {
        return "";
    }

    @Override
    public boolean addItemToInventory(baseItem itemToAdd, baseCharacter characterToAddItemTo) {
        //So every baseCharacter will have an inventory and will add/remove items the same way.  If not,
        //I can override those differences.  Like and NPC should never add items to their inventory, idt
        //Its a pretty simple fix otherwise, all I have to do is remove that override and use this one ofc

        return false;
    }

    @Override
    public boolean removeItemFromInventory(baseItem itemToRemove, baseCharacter characterToRemoveItemFrom) {
        return false;
    }

    @Override
    public boolean addStatusEffect(String effect, baseCharacter characterToFuckUpOrHealWhatever) {
        return false;
    }

    public Integer getHealth() {
        return Health;
    }
    public void setHealth(Integer health) {
        this.Health = health;
    }
    @Override
    public boolean useItem(baseItem itemToUse, baseCharacter characterUsingItem) {
        return false;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
