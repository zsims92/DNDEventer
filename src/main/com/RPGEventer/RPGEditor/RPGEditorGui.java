package main.com.RPGEventer.RPGEditor;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;
import main.com.RPGEventer.launcher;

import java.awt.*;

import static java.lang.Boolean.FALSE;
import static main.com.RPGEventer.launcher.manager;


public class RPGEditorGui {

    private static final String EDITORSTAGEID = "Editor";
    private final String SCENE_FILE = "javaFX/EditorProgram/rpgEditorMain.fxml";
    private static final String EDITORSCENEID = "EditorMain";

    public void startUp(){
        Parent root = launcher.manager.loadFXML(SCENE_FILE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight() -81);

        Stage editorStage = new Stage();
        editorStage.setOnCloseRequest((event1) ->
            manager.removeStage(EDITORSTAGEID)
        );
        launcher.manager.addStage(editorStage, EDITORSTAGEID, true);
        launcher.manager.addScene(EDITORSTAGEID, scene, EDITORSCENEID, true);
    }
}