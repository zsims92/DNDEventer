package com.DNDeventer.entities;

public class baseEntity {

    private String name = "Default";
    private Integer health = 100;
    private Integer attKMax = 10;
    private Integer blockMax = 10;

    public baseEntity() {

    }

    public baseEntity(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }

    public int basicAttack() {
        return 1 + (int) (Math.random() * ((attKMax - 1) + 1));
    }

    public int basicBlock() {
        return 1 + (int) (Math.random() * ((attKMax - 1) + 1));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setAttKMax(Integer attKMax) {
        this.attKMax = attKMax;
    }

    public void setBlockMax(Integer blockMax) {
        this.blockMax = blockMax;
    }

    protected Integer getHealth() {
        return health;
    }

    protected String getName() {
        return name;
    }

    protected Integer getAttKMax() {
        return attKMax;
    }

    protected Integer getBlockMax() {
        return blockMax;
    }

}
