package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class monk extends baseEntity {

    protected String name = "Monk";

    public monk() {
    }

    public monk(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}