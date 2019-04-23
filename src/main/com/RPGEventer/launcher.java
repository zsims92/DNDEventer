package main.com.RPGEventer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.com.RPGEventer.database.DatabaseGui;
import main.com.RPGEventer.javaFXHelper.FXHelper;
import main.com.RPGEventer.javaFXHelper.FXManager;
import main.com.RPGEventer.mapEditor.mapOptions.MapLoad;
import main.com.RPGEventer.mapEditor.editorProgram.EditorGui;


public class launcher extends Application{
    public static FXManager manager;

    @Override
    public void start(Stage primaryStage)  throws Exception{
        manager = new FXManager(primaryStage);
        String sceneFile = "javaFX/launcher.fxml";
        Parent root = manager.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        manager.addScene("Launcher", scene, "Launcher");
        manager.setStage("Launcher");
        manager.setScene("Launcher", "Launcher");
    }

    public void run(){
        launch("");
    }

}

