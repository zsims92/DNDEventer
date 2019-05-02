package main.com.RPGEventer.entities.maps;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import main.com.RPGEventer.entities.tiles.baseTile;
import main.com.RPGEventer.interfaces.displayable;

import java.io.File;
import java.util.Random;
import java.util.Vector;

public class baseMap implements displayable {
    public static final Integer MAX_TILE_PACKS = 10;
    public static final Integer MAX_MAP_SIZE = 200;

    private Vector<baseTile> tilesInMap;
    private Vector<Vector<baseTile>> map;
    private Integer curTileX;
    private Integer curTileY;

    private Double centerX;
    private Double centerY;

    public Double getCenterX() {
        return centerX;
    }

    public Double getCenterY() {
        return centerY;
    }

    public Node getMyNode() {
        return myNode;
    }

    private Group myNode;

    public baseMap(){
        //this.myNode=nodeToDisplay();
        curTileX = 0;
        curTileY = 0;
        this.myNode = new Group();
        this.centerX=0.0;
        this.centerY=0.0;
        for (int i=0; i<100; i++) {
            addTileToMap();
        }
        setCenter();
    }

    private void setCenter() {
        centerX = this.myNode.getBoundsInParent().getWidth()/2.0;
        System.out.println(centerX);
        centerY = this.myNode.getBoundsInParent().getHeight()/2.0;
        System.out.println(centerY);
    }

    private void addTileToMap() {
        Group model = loadMeshView("");
        model.scaleXProperty().set(10);
        model.scaleYProperty().set(10);
        model.scaleZProperty().set(10);
        model.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
        double x = model.getBoundsInLocal().getWidth()-1;
        double y = model.getBoundsInLocal().getHeight()-1;
        model.getTransforms().add(new Translate(curTileX*x, curTileY*y, 0));

        if(!(curTileX<9)){
            curTileX = 0;
            curTileY++;
        }else {
            curTileX++;
        }
        myNode.getChildren().add(model);
    }

    public Group loadMeshView(String fileName) {
        File file;
        if(fileName.equals("")) {
            Random rand = new Random();
            Integer x = rand.nextInt(5);
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
        }
        else{
            file = new File(fileName);
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
                Group model = loadMeshView("");
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
