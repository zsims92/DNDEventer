package main.com.RPGEventer.entities.character.inventory;

import main.com.RPGEventer.entities.character.baseCharacter;
import main.com.RPGEventer.entities.items.baseItem;

public interface inventoryInterface {
    boolean addItemToInventory(baseItem itemToAdd, baseCharacter characterToAddItemTo);
    boolean removeItemFromInventory(baseItem itemToRemove, baseCharacter characterToRemoveItemFrom);
    boolean useItem(baseItem itemToUse, baseCharacter characterUsingItem);
}
