package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class paladin extends baseEntity {

    protected String name = "Paladin";

    public paladin() {
    }

    public paladin(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}