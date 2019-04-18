package com.DNDeventer.entities.heroes;

import com.DNDeventer.entities.baseEntity;

public class cleric extends baseEntity {

    protected String name = "Cleric";

    public cleric() {
    }

    public cleric(String name, Integer health, Integer attKMax, Integer blockMax) {
        this.setName(name);
        this.setHealth(health);
        this.setAttKMax(attKMax);
        this.setBlockMax(blockMax);
    }


}
