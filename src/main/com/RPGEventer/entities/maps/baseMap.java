package main.com.RPGEventer.entities.maps;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Translate;
import main.com.RPGEventer.interfaces.displayable;
import java.io.File;

public class baseMap implements displayable {
    public static final Integer MAX_TILE_PACKS = 10;
    public static final Integer MAX_MAP_SIZE = 200;
    private static final double MODEL_SCALE_FACTOR = 400;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard
    private static final int VIEWPORT_SIZE = 1920;
    public Point3D center = new Point3D(0,0,0);

    public Node getMyNode() {
        return myNode;
    }

    private Node myNode;

    public baseMap(){
        this.myNode=nodeToDisplay();
    }
    public MeshView loadMeshViews() {
        File file = new File("C:\\Users\\zachs\\IdeaProjects\\RPGEventer\\src\\resources\\stlFiles\\tester.stl");
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(file);
        Mesh mesh = importer.getImport();
        return new MeshView(mesh);
    }
    @Override
    public Node nodeToDisplay() {
        Group root = new Group();
        double x=0.0, y = 0.0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                MeshView meshView = loadMeshViews();
                meshView.scaleXProperty().set(10);
                meshView.scaleYProperty().set(10);
                meshView.scaleZProperty().set(10);
                x = meshView.getBoundsInLocal().getWidth();
                y = meshView.getBoundsInLocal().getHeight();
                System.out.println((i*x-100.0) + " " + (y*j-100.0) + " 0.0");
                meshView.getTransforms().add(new Translate(i*x-100.0, j*y-100.0, 0));
                root.getChildren().add(meshView);
            }
        }
        PointLight pl  = new PointLight();
        pl.setTranslateZ(-4000);
        pl.setColor(new Color(.4,0,0,1.0));
        root.getChildren().add(pl);
        this.center = new Point3D(x*5, y*5, 0);
        this.myNode=root;
        return root;
    }

    @Override
    public void removeFromScene() {

    }

    @Override
    public void update() {

    }

}
