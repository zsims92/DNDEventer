package main.com.RPGEventer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.javaFXManager.FXManager;

import java.awt.*;


public class launcher extends Application{
    public static FXManager manager;
    public static final String LAUNCHERSTAGEID = "Launcher";
    private static final String LAUNCHERSCENEID = "LauncherMain";

    @Override
    public void start(Stage primaryStage){
        manager = new FXManager(primaryStage, true);
        Stage launcher = new Stage();
        String SCENE_FILE = "javaFX/launcher.fxml";
        Parent root = manager.loadFXML(SCENE_FILE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene launcherScene  = new Scene(root, screenSize.getWidth(), screenSize.getHeight()-80);
        launcher.setMaximized(true);

        manager.addStage(launcher, LAUNCHERSTAGEID, true);
        manager.addScene(LAUNCHERSTAGEID, launcherScene, LAUNCHERSCENEID, true);
    }

    public void run(){
        launch("");
    }

}

