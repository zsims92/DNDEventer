package main.com.RPGEventer.entities.character.playerCharacter;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.com.RPGEventer.entities.character.baseCharacter;

public class basePlayerCharacter extends baseCharacter {

    @Override
    public void update() {

    }

   @Override
    public Node nodeToDisplay() {
       //Set up node that displays monsters
       AnchorPane root = new AnchorPane();
       GridPane squarePlayer = new GridPane();
       //TODO:
       // Fix this shit

       //also fuck you sims

       root.getChildren().add(squarePlayer);
       return root;

   }

   @Override
    public void removeFromScene() {

   }

}
