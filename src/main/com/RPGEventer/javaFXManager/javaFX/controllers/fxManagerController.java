package main.com.RPGEventer.javaFXManager.javaFX.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.com.RPGEventer.javaFXManager.classScene;
import main.com.RPGEventer.javaFXManager.classStage;
import main.com.RPGEventer.launcher;

import java.util.Vector;

public class fxManagerController {
    @FXML
    private VBox stageLoaderButtons;
    @FXML
    private Label stageListArea;
    @FXML
    private Label sceneListArea;

    @FXML
    public void initialize(){
        Timeline updatefxManager = new Timeline(new KeyFrame(Duration.seconds(1.0), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                updateSceneList();
                updateStageList();
                updateStageLoader();

            }
        }));
        updatefxManager.setCycleCount(Timeline.INDEFINITE);
        updatefxManager.play();
    }

    private void updateStageList(){
        Vector<classStage> stages = launcher.manager.getStages();
        String stageToDisplay= "";

        Integer index = 0;
        for(classStage cStage: stages){
            index++;
            stageToDisplay = stageToDisplay.concat(index.toString() + ":\t" + cStage.getClassID() + "\n");
        }
        stageListArea.setText(stageToDisplay);
    }

    private void updateStageLoader(){
        Vector<classStage> stages = launcher.manager.getStages();
        for(classStage cStage: stages){
            boolean needToAdd = true;
            for(Node p: stageLoaderButtons.getChildren()){
                Button temp = (Button) p;
                if(temp.getText() == cStage.getClassID()){
                    needToAdd = false;
                }
            }
            if(needToAdd){
                Button stage = new Button(cStage.getClassID());
                stage.setOnAction((event) -> {
                            launcher.manager.setStage(stage.getText(), false);
                        }
                );
                Platform.runLater(() ->{
                    stageLoaderButtons.getChildren().add(stage);
                });
            }
        }
            if(stageLoaderButtons.getChildren().size() != stages.size()){
                for(Node p : stageLoaderButtons.getChildren()) {
                    Button temp = (Button) p;
                    boolean keep = false;
                    for (classStage cStage: stages) {
                        if (temp.getText() == cStage.getClassID()) {
                            keep = true;
                        }
                    }
                    if(!keep){
                        Platform.runLater(() ->{
                            stageLoaderButtons.getChildren().remove(temp);
                        });
                    }
                }
            }
    }

    private void updateSceneList(){
        Vector<classStage> stages = launcher.manager.getStages();
        String sceneToDisplay = "";
        for(classStage cStage: stages){
            Vector<classScene> scenes = cStage.getBaseStageScenes();
            sceneToDisplay = sceneToDisplay.concat("In stage " + cStage.getClassID() + "\n");
            for(classScene cScene: scenes){
                sceneToDisplay = sceneToDisplay.concat("\t" + cScene.getSceneID() + "\n");
            }
        }
        sceneListArea.setText(sceneToDisplay);
    }

}
