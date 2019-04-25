package main.com.RPGEventer.RPGEditor.tiles;

import main.com.RPGEventer.entities.character.baseCharacter;
import main.com.RPGEventer.entities.character.interactionInterface;

public class baseTile implements interactionInterface {
    String effect ="deal poison damage to bitches on top of me";

    @Override
    public boolean addStatusEffect(String effect, baseCharacter characterToFuckUpOrHealWhatever) {
        return false;
    }

    @Override
    public String getStatusEffect() {
        return "deal poison damage to bitches on top of me";
    }
}
