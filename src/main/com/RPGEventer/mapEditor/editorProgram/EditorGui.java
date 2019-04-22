package main.com.RPGEventer.mapEditor.editorProgram;

import main.com.RPGEventer.javaFXHelper.FXHelper;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class EditorGui{
    FXHelper AppHelper = new FXHelper();

    public void startUp() throws Exception{
        String sceneFile = "javaFX/EditorProgram/LoadingScreen.fxml";
        Parent root = AppHelper.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        FXHelper.currentStage.setTitle("Database manaFUCKBRANDO!");
        FXHelper.currentStage.setScene(scene);
        FXHelper.currentStage.show();
    }
}