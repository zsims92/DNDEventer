package main.com.RPGEventer.entities.maps;

import com.interactivemesh.jfx.importer.stl.StlMeshImporter;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import main.com.RPGEventer.interfaces.displayable;

import java.awt.*;
import java.io.File;

public class baseMap implements displayable {
    public static final Integer MAX_TILE_PACKS = 10;
    public static final Integer MAX_MAP_SIZE = 200;
    private static final double MODEL_SCALE_FACTOR = 400;
    private static final double MODEL_X_OFFSET = 0; // standard
    private static final double MODEL_Y_OFFSET = 0; // standard
    private static final int VIEWPORT_SIZE = 1920;

    public Node getMyNode() {
        return myNode;
    }

    private Node myNode;

    public baseMap(){
        this.myNode=nodeToDisplay();
    }
    public MeshView loadMeshViews() {
        File file = new File("C:\\Users\\zachs\\IdeaProjects\\RPGEventer\\src\\resources\\stlFiles\\tester.stl"); //Force everyone to change their user name to zachs mwuahahahaha
        StlMeshImporter importer = new StlMeshImporter();
        importer.read(file);
        Mesh mesh = importer.getImport();
        return new MeshView(mesh);
    }

    private Group root;
    @Override
    public Node nodeToDisplay() {
        root = new Group();
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                MeshView meshView = loadMeshViews();
                meshView.scaleXProperty().set(10);
                meshView.scaleYProperty().set(10);
                meshView.scaleZProperty().set(10);
                Double x, y;
                x = meshView.getBoundsInLocal().getWidth();
                y = meshView.getBoundsInLocal().getHeight();
                meshView.getTransforms().add(new Translate(i*x, j*y, 0));
                root.getChildren().add(meshView);
            }
        }
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
