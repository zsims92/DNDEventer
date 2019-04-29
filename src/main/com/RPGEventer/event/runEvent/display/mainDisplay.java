package main.com.RPGEventer.event.runEvent.display;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
        Node n = map.getMyNode();

        this.camera = new PerspectiveCamera(true);
        camera.translateZProperty().set(-500);
        camera.setNearClip(1);
        camera.setFarClip(1000);

        Group cameraGroup = new Group();
        cameraGroup.getChildren().add(camera);
        cameraGroup.getChildren().add(n);
        SubScene subScene = new SubScene(cameraGroup, screenSize.getWidth(), screenSize.getHeight()-80);
        subScene.setCamera(camera);

        Group temp = new Group();
        temp.getChildren().add(subScene);
        this.addEventHandler(KeyEvent.KEY_PRESSED, (event -> {
            switch(event.getText()){
                case "w": n.getTransforms().add(new Rotate(-1, Rotate.X_AXIS)); break;
                case "s": n.getTransforms().add(new Rotate(1, Rotate.X_AXIS)); break;
                case "q": n.getTransforms().add(new Rotate(-1, Rotate.Z_AXIS)); break;
                case "e": n.getTransforms().add(new Rotate(1, Rotate.Z_AXIS)); break;
                case "d": n.getTransforms().add(new Rotate(-1, Rotate.Y_AXIS)); break;
                case "a": n.getTransforms().add(new Rotate(1, Rotate.Y_AXIS)); break;

            }
        }));
        Scene tempScene = new Scene(temp, screenSize.getWidth(), screenSize.getHeight()-80, true, SceneAntialiasing.BALANCED);
        this.addScene(tempScene);
    }
}
