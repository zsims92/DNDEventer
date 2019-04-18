package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class druid extends baseEntity {

    protected String name = "Druid";

    public druid() {
    }

    public druid(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}
