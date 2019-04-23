package main.com.RPGEventer.javaFXHelper;

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

    private Stage baseStage;
    private Vector<classScene> baseStageScenes;
    private String classID;

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
