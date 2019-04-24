package main.com.RPGEventer.RPGEditor.editorProgram;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;
import main.com.RPGEventer.launcher;

import static java.lang.Boolean.FALSE;
import static main.com.RPGEventer.launcher.manager;


public class EditorGui{

    public static final String EDITORSTAGEID = "Editor";
    public final String SCENE_FILE = "javaFX/Database/mainDatabase.fxml";
    public static final String EDITORSCENEID = "EditorMain";

    public void startUp(){
        Parent root = launcher.manager.loadFXML(SCENE_FILE);
        Scene scene = new Scene(root);
        Stage editorStage = new Stage();
        editorStage.setOnCloseRequest((WindowEvent event1) -> {
            manager.removeStage(EDITORSCENEID);
        });
        launcher.manager.addStage(editorStage, EDITORSTAGEID, true);
        launcher.manager.addScene(EDITORSTAGEID, scene, EDITORSCENEID, true);
    }
}