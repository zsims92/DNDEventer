package main.com.RPGEventer.event.runEvent.display;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import jdk.jfr.EventType;
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
        camera.translateZProperty().set(-1200);
        camera.setFarClip(5000);

        Group cameraGroup = new Group();
        cameraGroup.getChildren().add(camera);
        cameraGroup.getChildren().add(mapNode);
        SubScene subScene = new SubScene(cameraGroup, screenSize.getWidth(), screenSize.getHeight()-80);
        subScene.setCamera(camera);

        Group temp = new Group();
        temp.getChildren().add(subScene);

        this.addEventHandler(KeyEvent.KEY_PRESSED, (event -> {
            switch(event.getText()){
                case "d": camera.getTransforms().add(new Translate(10,0,0)); break;
                case "a": camera.getTransforms().add(new Translate(-10,0,0)); break;
                case "q": camera.getTransforms().add(new Translate(0,0,10)); break;
                case "e": camera.getTransforms().add(new Translate(0,0,-10)); break;
                case "s": camera.getTransforms().add(new Translate(0,10,0)); break;
                case "w": camera.getTransforms().add(new Translate(0,-10,0)); break;
            }
        }));
        Scene tempScene = new Scene(temp, screenSize.getWidth(), screenSize.getHeight()-80, true, SceneAntialiasing.BALANCED);
        this.addScene(tempScene);
    }
}
