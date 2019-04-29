package main.com.RPGEventer.event.runEvent.display;

import javafx.event.EventType;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
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
        this.camera = new PerspectiveCamera();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        AnchorPane pane = new AnchorPane();
        baseMap map =  new baseMap();
        Node n = map.getMyNode();
        pane.getChildren().add(n);
        AnchorPane.setRightAnchor(n, 0.0);
        AnchorPane.setLeftAnchor(n, 0.0);
        AnchorPane.setBottomAnchor(n, 0.0);
        AnchorPane.setTopAnchor(n, 0.0);
        pane.getTransforms().add(new Rotate(90, Rotate.Y_AXIS));

        Camera camera = new PerspectiveCamera();
        camera.getTransforms().addAll (
                new Rotate(90, Rotate.Y_AXIS),
                new Translate(0, 0, -5000));

        Group cameraGroup = new Group();
        cameraGroup.getChildren().add(camera);
        cameraGroup.getChildren().add(pane);
        SubScene subScene = new SubScene(cameraGroup, screenSize.getWidth(), screenSize.getHeight()-80);
        subScene.setCamera(camera);

        Group temp = new Group();
        temp.getChildren().add(subScene);
        this.addEventHandler(KeyEvent.KEY_PRESSED, (event -> {
           switch(event.getText()){
               case "w": camera.getTransforms().add(new Translate(0,10,0)); break;
               case "a": camera.getTransforms().add(new Translate(10,0,0)); break;
               case "s": camera.getTransforms().add(new Translate(0,-10,0)); break;
               case "d": camera.getTransforms().add(new Translate(-10,0,0)); break;
           }
        }));

        Scene tempScene = new Scene(temp, screenSize.getWidth(), screenSize.getHeight()-80, true, SceneAntialiasing.DISABLED);
        this.addScene(tempScene);
    }
}
