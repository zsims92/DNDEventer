package main.com.RPGEventer.javaFXHelper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Vector;

public class FXManager{
    private Vector<classStage> Stages;
    public FXManager(Stage defaultStage){
        Stages = new Vector<>();
        classStage defStage = new classStage(defaultStage, "Launcher");
        Stages.add(defStage);
    }

    public void addStage(Stage stageToAdd, String stageID){
        classStage newStage = new classStage(stageToAdd, stageID);
        Stages.add(newStage);
    }

    public void addScene(String stageID, Scene sceneToAdd, String sceneID){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)){
                cStage.addScene(sceneToAdd, sceneID);
            }
        }
    }

    public void setStage(String stageID){
        for(classStage cStage: Stages){
            if(cStage.getClassID().equals(stageID)){
                cStage.getBaseStage().show();
            }
            else{
                cStage.getBaseStage().close();
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
    }

    public void removeStage(String stageID){
        for(classStage cs: Stages){
            if(cs.getClassID().equals(stageID)){
                cs.getBaseStageScenes().clear();
                cs.getBaseStage().close();
                Stages.removeElement(cs);
                break;
            }
        }
    }

    public Parent loadFXML(String fileToLoad) throws IOException {
        Parent root;
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
            throw ex;
        }

        return root;
    }
}
