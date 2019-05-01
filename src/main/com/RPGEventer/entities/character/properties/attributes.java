package main.com.RPGEventer.entities.character.properties;

public class attributes {
    private String charName = "Brando";
    private String charOrigin = "WAKANDA";
    private String charRace = "Human";
    private String[] charLanguages = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc"};

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharOrigin() {
        return charOrigin;
    }

    public void setCharOrigin(String charOrigin) {
        this.charOrigin = charOrigin;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
    }

    public String[] getCharLanguages() {
        return charLanguages;
    }

    public void setCharLanguages(String[] charLanguages) {
        this.charLanguages = charLanguages;
    }
}
