package main.com.RPGEventer.database;

import javafx.scene.Parent;
import javafx.scene.Scene;
import main.com.RPGEventer.javaFXHelper.FXHelper;

import java.io.IOException;


public class DatabaseGui{
    FXHelper AppHelper = new FXHelper();
    DatabaseMain dmMain = new DatabaseMain();

    public void startUp() throws Exception {
        String sceneFile = "javaFX/Database/mainDatabase.fxml";
        Parent root = AppHelper.loadFXML(sceneFile);
        Scene scene = new Scene(root);
        FXHelper.currentStage.setTitle("Database manaFUCKBRANDO!");
        FXHelper.currentStage.setScene(scene);
        FXHelper.currentStage.show();
    }
}
