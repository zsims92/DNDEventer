package main.com.RPGEventer.database;
import main.com.RPGEventer.javaFXManager.Static2DStage;

import java.util.Vector;

import static main.com.RPGEventer.launcher.Main.textBundle;

class databaseGui extends Static2DStage {
    public databaseGui(){
        this.numScenes = 1;
        this.STAGE_ID = textBundle.getString("DATABASE_STAGE_ID");
        this.SCENE_FILES = new Vector<>(numScenes+1);
        this.SCENE_IDS = new Vector<>(numScenes+1);
        this.SCENE_FILES.add(textBundle.getString("DATABASE_SCENE_FILE"));
        this.SCENE_IDS.add(textBundle.getString("DATABASE_SCENE_ID"));
    }
}
