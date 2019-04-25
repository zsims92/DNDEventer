package main.com.RPGEventer.entities.character.PlayerCharacter;

import javafx.scene.Node;
import main.com.RPGEventer.entities.character.baseCharacter;

public class basePlayerCharacter extends baseCharacter {
    public basePlayerCharacter(Integer health) {
        this.Health = health;
    }

    @Override
    public Node displayNode() {
        return null;
    }


}
