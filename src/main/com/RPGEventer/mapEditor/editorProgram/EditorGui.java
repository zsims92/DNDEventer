package main.com.RPGEventer.mapEditor.editorProgram;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.com.RPGEventer.launcher;


public class EditorGui{

    public void startUp() throws Exception{
        String sceneFile = "javaFX/EditorProgram/LoadingScreen.fxml";
        Parent root = launcher.manager.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        Stage editorStage = new Stage();
        launcher.manager.addStage(editorStage, "Editor");
        launcher.manager.addScene("Editor", scene, "editorMain");
        launcher.manager.setStage("Editor");
        launcher.manager.setScene("Editor", "editorMain");
    }
}