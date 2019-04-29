package main.com.RPGEventer.entities.tiles;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.interfaces.displayable;

import java.awt.event.ActionEvent;

public class baseTile implements displayable{
    @Override
    public void update() {

    }


    @Override
    public Node nodeToDisplay() {
        //Set up node that displays monsters
        AnchorPane root = new AnchorPane();
        GridPane squareMonster = new GridPane();
        //TODO:
        // Forgot about this guy.
        // Also this is some shit that needs fixed

        //also also fuck you sims

        root.getChildren().add(squareMonster);
        return root;

    }

    @Override
    public void removeFromScene() {

    }

}
