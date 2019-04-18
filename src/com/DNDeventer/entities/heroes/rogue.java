package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class rogue extends baseEntity {

    protected String name = "Rogue";

    public rogue() {
    }

    public rogue(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}