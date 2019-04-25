package main.com.RPGEventer.entities.character;

public interface interactionInterface {
    boolean addStatusEffect(String effect, baseCharacter characterToFuckUpOrHealWhatever);
    String getStatusEffect();
}
