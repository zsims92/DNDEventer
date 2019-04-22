package main.com.RPGEventer.mapEditor;

import main.com.RPGEventer.mapEditor.editorProgram.EditorMain;
import main.com.RPGEventer.mapEditor.mapOptions.MapEditorOptions;
import main.com.RPGEventer.mapEditor.mapOptions.MapLoader;

import java.io.File;
import java.util.Scanner;

public class MapMain {
    private MapLoader myMapLoader = new MapLoader();

    public void run(MapEditorOptions mp) {
        if (mp == MapEditorOptions.LOADMAP) {
            loadMapByFile();
        }
        else if(mp == MapEditorOptions.LAUNCHEDITOR){
            launchEditor();
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
    private void launchEditor(){
        EditorMain.run();
    }
}
