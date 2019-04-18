package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class ranger extends baseEntity {

    protected String name = "Ranger";

    public ranger() {
    }

    public ranger(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}