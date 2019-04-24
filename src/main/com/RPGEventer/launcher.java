package main.com.RPGEventer;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import main.com.RPGEventer.javaFXManager.FXManager;


public class launcher extends Application{
    public static FXManager manager;
    public static final String LAUNCHERSTAGEID = "Launcher";
    public final String SCENE_FILE = "javaFX/launcher.fxml";
    public static final String LAUNCHERSCENEID = "LauncherMain";

    @Override
    public void start(Stage primaryStage){
        manager = new FXManager(primaryStage, true);
        Stage launcher = new Stage();
        Parent root = manager.loadFXML(SCENE_FILE);
        Scene launcherScene = new Scene(root);
        manager.addStage(launcher, LAUNCHERSTAGEID, true);
        manager.addScene(LAUNCHERSTAGEID, launcherScene, LAUNCHERSCENEID, true);
    }

    public void run(){
        launch("");
    }

}

