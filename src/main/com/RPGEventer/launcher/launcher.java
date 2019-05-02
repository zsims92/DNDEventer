package main.com.RPGEventer.launcher;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.javaFXManager.fxManager;

import java.awt.*;

import static main.com.RPGEventer.launcher.Main.textBundle;


public class launcher extends Application{
    public static fxManager manager;
    public static final String LAUNCHER_STAGE_ID = textBundle.getString("LAUNCHER_STAGE_ID");
    private static final String LAUNCHER_SCENE_ID = textBundle.getString("LAUNCHER_SCENE_ID");

    @Override
    public void start(Stage primaryStage){
        manager = new fxManager(primaryStage, false);
        Stage launcher = new Stage();
        String SCENE_FILE = textBundle.getString("LAUNCHER_SCENE_FILE");
        Parent root = manager.loadFXML(SCENE_FILE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene launcherScene  = new Scene(root, screenSize.getWidth(), screenSize.getHeight()-80);

        launcher.setOnCloseRequest( (event -> {
            //manager.removeStage(LAUNCHER_STAGE_ID);
            manager.showOrHideManager(true);
        }));

        manager.addStage(launcher, LAUNCHER_STAGE_ID, true, true);
        manager.addScene(LAUNCHER_STAGE_ID, launcherScene, LAUNCHER_SCENE_ID, true);
    }

    public void run(){
        launch("");
    }

}

