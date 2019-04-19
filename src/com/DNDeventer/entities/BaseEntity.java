package com.DNDeventer.entities;

public class BaseEntity {

    private String name = "Default";
    private Integer level = 0;
    private Integer exp = 0;
    private Double expToNextLevel = ((exp + 1) * 2.7);
    private Integer shield = 0;
    private Integer armor = 0;
    private Integer dexModifier = 0;
    private Integer speed = 0;
    private Integer armorClass = dexModifier + armor + shield;
    private Integer health = 0;
    private Integer attKMax = 0;
    private Integer blockMax = 0;
    private String[] standardLanguages = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc"};

    //Character primaries
    private Integer strength = 0;
    private Integer dexterity = 0;
    private Integer constitution = 0;
    private Integer intelligence = 0;
    private Integer wisdom = 0;
    private Integer charisma = 0;


    public BaseEntity() {

    }

    public BaseEntity(String name, Integer level, Integer exp, Double expToNextLevel, Integer shield, Integer armor, Integer dexModifier, Integer speed, Integer armorClass, Integer health, Integer attKMax, Integer blockMax, String[] standardLanguages, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.expToNextLevel = expToNextLevel;
        this.shield = shield;
        this.armor = armor;
        this.dexModifier = dexModifier;
        this.speed = speed;
        this.armorClass = armorClass;
        this.health = health;
        this.attKMax = attKMax;
        this.blockMax = blockMax;
        this.standardLanguages = standardLanguages;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Double getExpToNextLevel() {
        return expToNextLevel;
    }

    public void setExpToNextLevel(Double expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }

    public Integer getShield() {
        return shield;
    }

    public void setShield(Integer shield) {
        this.shield = shield;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public Integer getDexModifier() {
        return dexModifier;
    }

    public void setDexModifier(Integer dexModifier) {
        this.dexModifier = dexModifier;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttKMax() {
        return attKMax;
    }

    public void setAttKMax(Integer attKMax) {
        this.attKMax = attKMax;
    }

    public Integer getBlockMax() {
        return blockMax;
    }

    public void setBlockMax(Integer blockMax) {
        this.blockMax = blockMax;
    }

    public String[] getStandardLanguages() {
        return standardLanguages;
    }

    public void setStandardLanguages(String[] standardLanguages) {
        this.standardLanguages = standardLanguages;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

}
