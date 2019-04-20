package com.DNDeventer;
import com.DNDeventer.mapEditor.MapMain;
import com.DNDeventer.mapEditor.mapOptions.MapEditorOptions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.net.URL;

public class launcher {
    public static void main(String[] args) {

        MapMain nMap = new MapMain();
        MapEditorOptions option = MapEditorOptions.LAUNCHEDITOR;
        nMap.run(option);

    }
}
