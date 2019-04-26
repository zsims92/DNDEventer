package main.com.RPGEventer.interfaces;

import main.com.RPGEventer.entities.maps.baseMap;
import main.com.RPGEventer.entities.character.baseCharacter;
import main.com.RPGEventer.entities.items.baseItem;

public interface interactable {
    boolean interact(baseCharacter char1, baseCharacter char2);
    boolean interact(baseCharacter char1, baseItem item);
    boolean interact(baseItem item, baseMap map);
    boolean interact(baseCharacter char1, baseMap map);
    //boolean interact(baseCharacter char 1, Effect effect);   char1.interact(char1, getTileEffect().)
}
