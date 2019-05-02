package main.com.RPGEventer.entities.maps;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import com.sun.scenario.effect.light.PointLight;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import main.com.RPGEventer.interfaces.displayable;
import java.io.File;
import java.net.URL;
import java.util.Random;

public class baseMap implements displayable {
    public static final Integer MAX_TILE_PACKS = 10;
    public static final Integer MAX_MAP_SIZE = 200;

    public Node getMyNode() {
        return myNode;
    }

    private Node myNode;

    public baseMap(){
        this.myNode=nodeToDisplay();
    }

    public Group loadMeshView() {
        Random rand = new Random();
        Integer x = rand.nextInt(5);
        File file;
        switch (x) {
            case 0:
                file = new File("src\\resources\\tilePacks\\defaultTilePackage\\firstFloorTile.dae");
                break;
            case 1:
                file = new File("src\\resources\\tilePacks\\defaultTilePackage\\secondFloorTile.dae");
                break;
            case 2:
                file = new File("src\\resources\\tilePacks\\defaultTilePackage\\thirdFloorTile.dae");
                break;
            case 3:
                file = new File("src\\resources\\tilePacks\\defaultTilePackage\\fourthFloorTile.dae");
                break;
            default:
                file = new File("src\\resources\\tilePacks\\defaultTilePackage\\fifthFloorTile.dae");
                break;
        }

        ColModelImporter importer = new ColModelImporter();
        importer.read(file);
        Group model = (Group)importer.getImport()[0];
        return model;
    }
    @Override
    public Node nodeToDisplay() {
        Group root = new Group();
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Group model = loadMeshView();
                model.scaleXProperty().set(10);
                model.scaleYProperty().set(10);
                model.scaleZProperty().set(10);
                model.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
                double x = model.getBoundsInLocal().getWidth()-1;
                double y = model.getBoundsInLocal().getHeight()-1;
                double offsetX = x*5;
                double offsetY = y*5;
                System.out.println((i*x-offsetX) + " " + (y*j-offsetY) + " 0.0");
                model.getTransforms().add(new Translate(i*x-offsetX, j*y-offsetY, 0));
                root.getChildren().add(model);
            }
        }
        return root;
    }

    @Override
    public void removeFromScene() {

    }

    @Override
    public void update() {

    }

}
