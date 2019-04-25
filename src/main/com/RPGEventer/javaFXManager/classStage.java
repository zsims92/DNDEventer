package main.com.RPGEventer.javaFXManager;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Vector;

public class classStage {
    public Stage getBaseStage() {
        return baseStage;
    }

    public Vector<classScene> getBaseStageScenes() {
        return baseStageScenes;
    }

    public String getClassID() {
        return classID;
    }

    private final Stage baseStage;
    private final Vector<classScene> baseStageScenes;
    private final String classID;

    public classStage(Stage stage, String classID){
        this.baseStage = stage;
        this.classID = classID;
        this.baseStageScenes = new Vector<>();
    }

    public void addScene(Scene sceneToAdd, String sceneID){
        classScene cs = new classScene(sceneToAdd, sceneID);
        this.baseStageScenes.add(cs);
    }
}
