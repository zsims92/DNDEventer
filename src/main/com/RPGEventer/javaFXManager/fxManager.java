package main.com.RPGEventer.javaFXManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.Vector;

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
        this.fxManagerStage.getBaseStage().setIconified(true);
        String sceneFile = "javaFX/fxManager.fxml";
        Parent root = loadFXML(sceneFile);

        this.showManager = showManager;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight()-80);

        this.fxManagerStage.getBaseStage().setScene(scene);
    }

    public void addStage(Stage stageToAdd, String stageID, boolean show){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)) {
                System.out.println("Already have that stage");
                return;
            }
        }
        classStage newStage = new classStage(stageToAdd, stageID);
        if(show){
            setStage(stageID, false);
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
            System.out.println( "  fxmlResource = " + fileToLoad );
        }
        catch ( Exception ex )
        {
            System.out.println( "Exception on FXMLLoader.load()" );
            System.out.println( "  * url: " + url );
            System.out.println( "  * " + ex );
            System.out.println( "    ----------------------------------------\n" );
        }

        return root;
    }
}
