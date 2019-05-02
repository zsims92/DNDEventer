package main.com.RPGEventer.javaFXManager;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.com.RPGEventer.launcher.launcher;

import java.util.Vector;

import static main.com.RPGEventer.launcher.launcher.manager;

public abstract class Dynamic3DStage extends Stage{
    public String STAGE_ID;
    public Vector<String> SCENE_IDS;
    public Vector<String> SCENE_FILES;
    public Integer numScenes = 20;
    public PerspectiveCamera camera;
    public Vector<Scene> scenes = null;

    public void startUp(boolean show, boolean closeOthers){
        if(this.scenes == null){
            scenes = new Vector<>(this.numScenes);
        }
        this.setOnCloseRequest((event1) -> {
            manager.removeStage(STAGE_ID);
            manager.showOrHideManager(true);
        });

        launcher.manager.addStage(this, STAGE_ID, show, closeOthers);
        for(Integer index = 0; index < scenes.size(); index++){
            launcher.manager.addScene(STAGE_ID, scenes.elementAt(index), SCENE_IDS.elementAt(index), show);
        }
    }
    public boolean addScene(Scene display){
        if(this.scenes == null){
            scenes = new Vector<>(this.numScenes);
        }
        this.scenes.add(display);
        return false;
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
