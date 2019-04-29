package main.com.RPGEventer.javaFXManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;

import static main.com.RPGEventer.launcher.Main.LOGGER;

public class fxManager {
    public Vector<classStage> getStages() {
        return Stages;
    }

    private final Vector<classStage> Stages;
    private final classStage fxManagerStage;
    private final boolean showManager;

    public fxManager(Stage primaryStage, boolean showManager){
        Stages = new Vector<>();
        this.fxManagerStage = new classStage(primaryStage, "fxManager");
        String sceneFile = "javaFX/fxManager.fxml";
        Parent root = loadFXML(sceneFile);

        this.showManager = showManager;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight()-80);

        this.fxManagerStage.getBaseStage().setScene(scene);
        LOGGER.info("The JavaFX Manger is running");
    }

    public void addStage(Stage stageToAdd, String stageID, boolean show, boolean closeOthers){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)) {
                System.out.println("Already have that stage");
                return;
            }
        }
        classStage newStage = new classStage(stageToAdd, stageID);
        if(show){
            setStage(stageID, closeOthers);
        }
        Stages.add(newStage);
    }

    public void addScene(String stageID, Scene sceneToAdd, String sceneID, boolean show){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)){
                for(classScene cScene: cStage.getBaseStageScenes()){
                    if(cScene.getSceneID().equals(sceneID)){
                        System.out.println("Already have that scene in this stage");
                        return;
                    }
                }
                cStage.addScene(sceneToAdd, sceneID);
                if(show){
                    setScene(stageID, sceneID);
                }
            }
        }
    }

    public Vector<classStage> getStagesShown(){
        Vector<classStage> shownStages = new Vector<>();
        for(classStage cStage: Stages){
            if(cStage.getBaseStage().isShowing()){
                shownStages.add(cStage);
            }
        }
        return shownStages;
    }


    public classScene getSceneShown(String stageID){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)){
                for(classScene cScene: cStage.getBaseStageScenes()){
                    if(cScene.getScene().getRoot().isVisible()){
                        return cScene;
                    }
                }
            }
        }
        return null;
    }

    public void setStage(String stageID, boolean closeOthers){
        for(classStage cStage: Stages) {
            if (cStage.getClassID().equals(stageID)) {
                cStage.getBaseStage().show();
                cStage.getBaseStage().setScene(cStage.getBaseStageScenes().get(0).getScene());
                cStage.getBaseStage().setAlwaysOnTop(true);
                cStage.getBaseStage().setAlwaysOnTop(false);
                this.fxManagerStage.getBaseStage().hide();
            } else {
                if (closeOthers) {
                    cStage.getBaseStage().close();
                }
            }
        }
    }

    public void setScene(String stageID, String sceneID){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)){
                for(classScene cScene : cStage.getBaseStageScenes()){
                    if(cScene.getSceneID().equals(sceneID)){
                        cStage.getBaseStage().setScene(cScene.getScene());
                        if(!cStage.getBaseStage().isShowing()){
                            cStage.getBaseStage().show();
                        }
                    }
                }
            }
        }
        if(this.showManager && !this.fxManagerStage.getBaseStage().isShowing()){
            this.fxManagerStage.getBaseStage().show();
        }
    }

    public void showOrHideManager(boolean show){
        if(show) {
            this.fxManagerStage.getBaseStage().show();
        } else{
            this.fxManagerStage.getBaseStage().hide();
        }
    }

    public void removeStage(String stageID){
        for(classStage cs: Stages){
            if(cs.getClassID().equals(stageID)){
                cs.getBaseStageScenes().removeAllElements();
                cs.getBaseStage().close();
                Stages.removeElement(cs);
                break;
            }
        }
    }

    public Parent loadFXML(String fileToLoad){
        Parent root = new VBox();
        URL url = null;
        try
        {
            url  = getClass().getResource( "/resources/" + fileToLoad );
            root = FXMLLoader.load( url );
        }
        catch ( Exception ex )
        {
            LOGGER.log(Level.SEVERE, "This file: /resources/" + fileToLoad + " threw an error:\n", ex);
        }
        return root;
    }
}
