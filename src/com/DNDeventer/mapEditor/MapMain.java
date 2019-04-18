package com.DNDeventer.mapEditor;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class MapMain {
    private MapLoader myMapLoader = new MapLoader();

    public void run(MapEditorOptions mp) {
        if (mp == MapEditorOptions.LOADMAP) {
            loadMapByFile();
        }
    }

    private void loadMapByFile(){
        System.out.println("Which file should i load the map from?\n");
        Scanner scanner = new Scanner(System.in);
        String nameOfFile = scanner.nextLine();

        File FileToLoadFrom = new File(nameOfFile);
        this.myMapLoader = new MapLoader(FileToLoadFrom);
        if (this.myMapLoader.loadMap()) {
            System.out.println("Loaded from file: " + this.myMapLoader.getfileNameToLoad().getName());
        } else {
            System.out.println("Unable to load from file: " + this.myMapLoader.getfileNameToLoad().getName());
        }

        this.myMapLoader.displayStats();
    }
}
