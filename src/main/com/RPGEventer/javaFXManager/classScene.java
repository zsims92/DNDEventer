package main.com.RPGEventer.javaFXManager;

import javafx.scene.Scene;

public class classScene {
    public Scene getScene() {
        return scene;
    }

    public String getSceneID() {
        return sceneID;
    }

    private Scene scene;
    private String sceneID;

    public classScene(Scene scene, String sceneID){
        this.scene = scene;
        this.sceneID = sceneID;
    }
}
