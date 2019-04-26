package main.com.RPGEventer.interfaces;

import main.com.RPGEventer.entities.character.baseCharacter;
import main.com.RPGEventer.entities.items.baseItem;

public interface inventoriable {
    boolean addItemToInventory(baseItem itemToAdd, baseCharacter characterToAddItemTo);
    boolean removeItemFromInventory(baseItem itemToRemove, baseCharacter characterToRemoveItemFrom);
    boolean useItem(baseItem itemToUse, baseCharacter characterUsingItem);

}
