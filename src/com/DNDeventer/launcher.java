package com.DNDeventer;
import com.DNDeventer.mapEditor.MapMain;
import com.DNDeventer.mapEditor.MapEditorOptions;

public class launcher {
    public static void main(String[] args) {

        MapMain nMap = new MapMain();
        MapEditorOptions option = MapEditorOptions.LOADMAP;
        nMap.run(option);

    }
}
