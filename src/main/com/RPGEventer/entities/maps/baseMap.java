package main.com.RPGEventer.entities.maps;

import javafx.scene.Node;
import main.com.RPGEventer.interfaces.displayable;

public class baseMap implements displayable {
    public static final Integer MAX_TILE_PACKS = 10;
    public static final Integer MAX_MAP_SIZE = 200;

    @Override
    public Node nodeToDisplay() {
        return null;
    }

    @Override
    public void removeFromScene() {

    }

    @Override
    public void update() {

    }
}
