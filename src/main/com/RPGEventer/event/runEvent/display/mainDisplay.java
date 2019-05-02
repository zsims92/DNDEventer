package main.com.RPGEventer.event.runEvent.display;

import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import main.com.RPGEventer.entities.maps.baseMap;
import main.com.RPGEventer.javaFXManager.Dynamic3DStage;

import java.awt.*;
import java.util.Vector;

import static main.com.RPGEventer.launcher.Main.textBundle;

public class mainDisplay extends Dynamic3DStage {
    public mainDisplay(){
        //This is for the display elements
        this.numScenes = 1;
        this.STAGE_ID = textBundle.getString("MAIN_DISPLAY_STAGE_ID");
        this.SCENE_IDS = new Vector<>(numScenes+1);
        this.SCENE_IDS.add(textBundle.getString("MAIN_DISPLAY_SCENE_ID"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        baseMap map =  new baseMap();
        Node mapNode = map.getMyNode();

        this.camera = new PerspectiveCamera(true);
        Translate pivot = new Translate(map.getCenterX(), map.getCenterY());
        Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
        Rotate xRotate = new Rotate(0, Rotate.X_AXIS);
        Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);
        camera.setFarClip(5000);
        this.camera.getTransforms().addAll(
            pivot,
            yRotate,
            xRotate,
            zRotate,
            new Translate(0, 0, -4000)
        );
        Group cameraGroup = new Group();
        cameraGroup.getChildren().add(camera);
        cameraGroup.getChildren().add(mapNode);

        SubScene subScene = new SubScene(cameraGroup, screenSize.getWidth(), screenSize.getHeight()-80);
        subScene.setCamera(camera);
        Group mainGroup = new Group();
        mainGroup.getChildren().addAll(subScene,new Label("a/d is left/right\n" +
                "w/s is up/down\n" +
                "qe is zoom in/out\n" +
                "8/5 is for rotation it into scene\n" +
                "7/9 is for spinning it\n" +
                "46 is for tilting it"));

        this.addEventHandler(KeyEvent.KEY_PRESSED, (event -> {
            switch(event.getText()){
                case "a": camera.getTransforms().add(new Translate(75,0,0)); break;
                case "d": camera.getTransforms().add(new Translate(-75,0,0)); break;
                case "e": camera.getTransforms().add(new Translate(0,0,75)); break;
                case "q": camera.getTransforms().add(new Translate(0,0,-75)); break;
                case "w": camera.getTransforms().add(new Translate(0,75,0)); break;
                case "s": camera.getTransforms().add(new Translate(0,-75,0)); break;
                case "4": yRotate.angleProperty().set(Math.min(yRotate.angleProperty().getValue() + 1.0, 45.0)); break;
                case "6": yRotate.angleProperty().set(Math.max(yRotate.angleProperty().getValue() - 1.0, -45.0)); break;
                case "5": xRotate.angleProperty().set(Math.min(xRotate.angleProperty().getValue() + 1.0, 45.0)); break;
                case "8": xRotate.angleProperty().set(Math.max(xRotate.angleProperty().getValue() - 1.0, -45.0)); break;
                case "7": zRotate.angleProperty().set(zRotate.angleProperty().getValue() + 1.0); break;
                case "9": zRotate.angleProperty().set(zRotate.angleProperty().getValue() - 1.0); break;
            }
        }));

        Scene tempScene = new Scene(mainGroup, screenSize.getWidth(), screenSize.getHeight()-80, true, SceneAntialiasing.BALANCED);
        this.addScene(tempScene);
    }
}
