package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class bard extends baseEntity {

    protected String name = "Bard";

    public bard() {
    }

    public bard(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}
