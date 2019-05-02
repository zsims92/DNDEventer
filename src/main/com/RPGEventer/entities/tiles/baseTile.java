package main.com.RPGEventer.entities.tiles;

import com.interactivemesh.jfx.importer.col.ColModelImporter;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.entities.status.statusEffect;
import main.com.RPGEventer.interfaces.displayable;

import java.io.File;
import java.util.Random;

public class baseTile implements displayable{
    private Node displayNode;

    public Group getMesh() {
        return mesh;
    }

    private Group mesh;
    private String name;
    private statusEffect effect;
    private boolean[][] activeSubParts;

    /***
     *
     * @param mesh The 3d tile display
     * @param name A name for the tile
     */
    public baseTile(Group mesh, String name, statusEffect effect, boolean[][] activeSubParts){
        this.mesh= mesh;
        this.displayNode = nodeToDisplay();
        this.activeSubParts = activeSubParts;
    }

    @Override
    public void update() {
    }


    @Override
    public Node nodeToDisplay() {
        Group root=null;
        root.getChildren().add(mesh);
        return root;
    }

    @Override
    public void removeFromScene() {

    }

}
