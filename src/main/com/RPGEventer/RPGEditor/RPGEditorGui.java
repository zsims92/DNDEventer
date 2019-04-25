package main.com.RPGEventer.RPGEditor;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.launcher;

import java.awt.*;

import static main.com.RPGEventer.launcher.manager;


public class RPGEditorGui {

    private static final String EDITORSTAGEID = "Editor";
    private static final String EDITORSCENEID = "EditorMain";

    public void startUp(){
        String SCENE_FILE = "javaFX/EditorProgram/rpgEditorMain.fxml";
        Parent root = launcher.manager.loadFXML(SCENE_FILE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight() -81);
        Stage editorStage = new Stage();
        editorStage.setMaximized(true);
        editorStage.setOnCloseRequest((event1) ->
            manager.removeStage(EDITORSTAGEID)
        );
        launcher.manager.addStage(editorStage, EDITORSTAGEID, true);
        launcher.manager.addScene(EDITORSTAGEID, scene, EDITORSCENEID, true);
    }
}