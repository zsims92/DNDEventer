package main.com.RPGEventer.javaFXManager;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.launcher.launcher;

import java.awt.*;
import java.util.Vector;

import static main.com.RPGEventer.launcher.launcher.manager;

/***
 * @author zachs
 * @version 1.0
 * @since 1.0
 *
 * The Static2DStage class takes care of the startup process for making a new window.  It adds the stage and
 * all the following scenes to the fxManager.  Classes extending this will generally only have to specify
 * their variables in the constructor and then run startup.
 */
public abstract class Static2DStage extends Stage{
    public String STAGE_ID;
    public Vector<String> SCENE_IDS;
    public Vector<String> SCENE_FILES;
    public Integer numScenes = 20;
    public Vector<Scene> scenes = null;

    public void startUp(boolean show, boolean closeOthers){
        if(this.scenes == null){
            scenes = new Vector<>(this.numScenes);
        }
        for(Integer index =0; index < SCENE_IDS.size(); index++){
            Parent root = launcher.manager.loadFXML(SCENE_FILES.elementAt(index));
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            scenes.add(new Scene(root, screenSize.getWidth(), screenSize.getHeight() -81));
        }
        this.setOnCloseRequest((event1) -> {
            //manager.removeStage(STAGE_ID);
            manager.showOrHideManager(true);
        });

        launcher.manager.addStage(this, STAGE_ID, show, closeOthers);
        for(Integer index = 0; index < scenes.size(); index++){
            launcher.manager.addScene(STAGE_ID, scenes.elementAt(index), SCENE_IDS.elementAt(index), show);
        }
    }

    public  String getSTAGEID() {
        return STAGE_ID;
    }

    public void setSTAGEID(String STAGEID) {
        STAGE_ID = STAGEID;
    }


    public Integer getMaxScenes() {
        return numScenes;
    }

    public void setMaxScenes(Integer maxScenes) {
        this.numScenes = maxScenes;
    }
    public Vector<String> getSCENE_IDS() {
        return SCENE_IDS;
    }

    public void setSCENE_IDS(Vector<String> SCENE_IDS) {
        this.SCENE_IDS = SCENE_IDS;
    }

    public Vector<String> getSCENE_FILES() {
        return SCENE_FILES;
    }

    public void setSCENE_FILES(Vector<String> SCENE_FILES) {
        this.SCENE_FILES = SCENE_FILES;
    }
}
