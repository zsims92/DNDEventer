package main.com.RPGEventer;
import main.com.RPGEventer.mapEditor.MapMain;
import main.com.RPGEventer.mapEditor.mapOptions.MapEditorOptions;

public class launcher {
    public static void main(String[] args) {

        MapMain nMap = new MapMain();
        MapEditorOptions option = MapEditorOptions.LAUNCHEDITOR;
        nMap.run(option);

    }
}
