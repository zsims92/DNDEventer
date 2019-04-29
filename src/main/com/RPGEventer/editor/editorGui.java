package main.com.RPGEventer.editor;

import main.com.RPGEventer.javaFXManager.Static2DStage;

import java.util.Vector;

import static main.com.RPGEventer.launcher.Main.textBundle;

public class editorGui extends Static2DStage {
    public editorGui(){
        this.numScenes = 1;
        this.STAGE_ID = textBundle.getString("EDITOR_STAGE_ID");
        this.SCENE_FILES = new Vector<>(numScenes+1);
        this.SCENE_IDS = new Vector<>(numScenes+1);
        this.SCENE_FILES.add(textBundle.getString("EDITOR_SCENE_FILE"));
        this.SCENE_IDS.add(textBundle.getString("EDITOR_SCENE_ID"));
    }
}