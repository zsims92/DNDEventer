package com.DNDeventer.mapEditor.editorProgram;

import com.DNDeventer.javaFXHelper.FXHelper;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class EditorGui extends Application {
    FXHelper AppHelper = new FXHelper();

    @Override
    public void start(Stage primaryStage) throws IOException{
        FXHelper.currentStage = primaryStage;
        String sceneFile = "../mapEditor/editorProgram/javaFX/fxml/LoadingScreen.fxml";
        Parent root = AppHelper.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        FXHelper.currentStage.setTitle("Database manaFUCKBRANDO!");
        FXHelper.currentStage.setScene(scene);
        FXHelper.currentStage.show();
    }


    public boolean isExited(){
        return true;
    }
    public void startUp(){
        launch();
    }
}