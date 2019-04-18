package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class fighter extends baseEntity {

    protected String name = "Fighter";

    public fighter() {
    }

    public fighter(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}