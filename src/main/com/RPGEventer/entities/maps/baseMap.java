package main.com.RPGEventer.entities.maps;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.interfaces.displayable;

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
    @Override
    public Node nodeToDisplay() {
        AnchorPane root = new AnchorPane();
        Group mapGroup = new Group();
        GridPane mapDisplay = new GridPane();
        mapGroup.getChildren().add(mapDisplay);

        for(int i=0; i<10; i++){
            mapDisplay.addRow(i);
            mapDisplay.addColumn(i);
        }
        for(int i=0; i <10; i++){
            for(int j=0; j<10; j++){
                ImageView display = new ImageView();
                display.setImage(new Image("resources/tilePacks/defaultTilePackage/im1.bmp"));
                display.setFitHeight(400);
                display.setFitWidth(400);
                mapDisplay.add(display, i, j);
            }
        }
        AnchorPane.setTopAnchor(mapGroup, 0.0);
        AnchorPane.setBottomAnchor(mapGroup, 0.0);
        AnchorPane.setLeftAnchor(mapGroup, 0.0);
        AnchorPane.setRightAnchor(mapGroup, 0.0);
        root.getChildren().add(mapGroup);
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
