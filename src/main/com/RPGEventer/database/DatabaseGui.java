package main.com.RPGEventer.database;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.javaFXHelper.FXHelper;
import main.com.RPGEventer.launcher;

import java.io.IOException;


public class DatabaseGui{
    DatabaseMain dmMain = new DatabaseMain();

    public void startUp() throws Exception {
        String sceneFile = "javaFX/Database/mainDatabase.fxml";
        Parent root = launcher.manager.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        Stage editorStage = new Stage();
        launcher.manager.addStage(editorStage, "Database");
        launcher.manager.addScene("Database", scene, "databaseMain");
        launcher.manager.setStage("Database");
        launcher.manager.setScene("Database", "databaseMain");
    }
}
