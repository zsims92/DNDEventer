package main.com.RPGEventer.javaFXManager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.launcher.launcher;

import java.awt.*;

import static main.com.RPGEventer.launcher.launcher.manager;

/***
 * @author zachs
 * @version 1.0
 * @since 1.0
 *
 * The newWindow class takes care of the startup process for making a new window.  It adds the stage and
 * all the following scenes to the fxManager.  Classes extending this will generally only have to specify
 * their variables in the constructor and then run startup.
 */
public abstract class newWindow {
    public static String STAGE_ID;
    public static String[] SCENE_IDS;
    public String[] SCENE_FILES;
    public Integer numScenes = 20;

    public void startUp(){
        Scene[] scenes = new Scene[numScenes];
        for(Integer index =0; index < SCENE_IDS.length; index++){
            Parent root = launcher.manager.loadFXML(SCENE_FILES[index]);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            scenes[index] = new Scene(root, screenSize.getWidth(), screenSize.getHeight() -81);
        }

        Stage stage = new Stage();

        stage.setMaximized(true);
        stage.setOnCloseRequest((event1) ->
                manager.removeStage(STAGE_ID)
        );

        launcher.manager.addStage(stage, STAGE_ID, true);
        for(Integer index = 0; index < scenes.length; index++){
            launcher.manager.addScene(STAGE_ID, scenes[index], SCENE_IDS[index], true);
        }
    }

    public static String getSTAGEID() {
        return STAGE_ID;
    }

    public static void setSTAGEID(String STAGEID) {
        newWindow.STAGE_ID = STAGEID;
    }

    public static String[] getSceneIds() {
        return SCENE_IDS;
    }

    public static void setSceneIds(String[] sceneIds) {
        SCENE_IDS = sceneIds;
    }

    public String[] getSCENE_FILES() {
        return SCENE_FILES;
    }

    public void setSCENE_FILES(String[] SCENE_FILES) {
        this.SCENE_FILES = SCENE_FILES;
    }

    public Integer getMaxScenes() {
        return numScenes;
    }

    public void setMaxScenes(Integer maxScenes) {
        this.numScenes = maxScenes;
    }
}
