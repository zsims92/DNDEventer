package main.com.RPGEventer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.com.RPGEventer.database.DatabaseGui;
import main.com.RPGEventer.javaFXHelper.FXHelper;
import main.com.RPGEventer.mapEditor.mapOptions.MapLoad;
import main.com.RPGEventer.mapEditor.editorProgram.EditorGui;


public class launcher extends Application{
    FXHelper fxHelper = new FXHelper();

    @Override
    public void start(Stage primaryStage)  throws Exception{
        FXHelper.currentStage = primaryStage;
        String sceneFile = "javaFX/launcher.fxml";
        Parent root = fxHelper.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        FXHelper.currentStage.setTitle("Fuck you Brando");
        FXHelper.currentStage.setScene(scene);
        FXHelper.currentStage.show();
    }
    public void reset() throws Exception{
        String sceneFile = "javaFX/launcher.fxml";
        Parent root = fxHelper.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        FXHelper.currentStage.setTitle("Fuck you Brando");
        FXHelper.currentStage.setScene(scene);
        FXHelper.currentStage.show();
    }

    public void run(){
        launch("");
    }

}

