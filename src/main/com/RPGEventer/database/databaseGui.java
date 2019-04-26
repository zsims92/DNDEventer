package main.com.RPGEventer.database;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;

import static main.com.RPGEventer.launcher.launcher.manager;


class databaseGui {
    public static final String DATABASESTAGEID = "Database";
    public final String SCENE_FILE = "javaFX/databse/databaseMain.fxml";
    public static final String DATABASESCENEID = "databaseMain";

    public void startUp(){
        Parent root = manager.loadFXML(SCENE_FILE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());

        Stage databaseStage = new Stage();
        databaseStage.setOnCloseRequest((WindowEvent event1) -> manager.removeStage(DATABASESTAGEID));
        manager.addStage(databaseStage, DATABASESTAGEID, true);
        manager.addScene(DATABASESTAGEID, scene, DATABASESCENEID, true);
    }
}
