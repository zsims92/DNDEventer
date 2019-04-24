package main.com.RPGEventer.database;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static main.com.RPGEventer.launcher.manager;


public class DatabaseGui{
    public static final String DATABASESTAGEID = "Database";
    public final String SCENE_FILE = "javaFX/Database/mainDatabase.fxml";
    public static final String DATABASESCENEID = "DatabaseMain";

    public void startUp(){
        Parent root = manager.loadFXML(SCENE_FILE);
        Scene scene = new Scene(root);
        Stage databaseStage = new Stage();
        databaseStage.setOnCloseRequest((WindowEvent event1) -> {
            manager.removeStage(DATABASESTAGEID);
        });
        manager.addStage(databaseStage, DATABASESTAGEID, true);
        manager.addScene(DATABASESTAGEID, scene, DATABASESCENEID, true);
    }
}
