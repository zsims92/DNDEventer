package main.com.RPGEventer.entities.character.monster;


import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.entities.character.baseCharacter;

public class baseMonster extends baseCharacter {

    @Override
    public void update() {

    }

    @Override
    public Node nodeToDisplay() {
        //Set up node that displays monsters
        AnchorPane root = new AnchorPane();
        GridPane squareMonster = new GridPane();
        //TODO:
        // Fix this shit

        //also fuck you sims

        root.getChildren().add(squareMonster);
        return root;

    }

    @Override
    public void removeFromScene() {

    }

}
