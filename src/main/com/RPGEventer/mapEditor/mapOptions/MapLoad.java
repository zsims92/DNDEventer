package main.com.RPGEventer.mapEditor.mapOptions;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class MapLoad {
    private MapLoader myMapLoader = new MapLoader();

    public void run() {
        loadMapByFile();
    }

    private void loadMapByFile(){
        System.out.println("Which file should i load the map from?\n");
        Scanner scanner = new Scanner(System.in);
        String nameOfFile = scanner.nextLine();

        URL url  = getClass().getResource( "/" + nameOfFile);

        File FileToLoadFrom = new File(url.getFile());
        this.myMapLoader = new MapLoader(FileToLoadFrom);
        if (this.myMapLoader.loadMap()) {
            System.out.println("Loaded from file: " + this.myMapLoader.getfileNameToLoad().getName());
        } else {
            System.out.println("Unable to load from file: " + this.myMapLoader.getfileNameToLoad().getName());
        }

        this.myMapLoader.displayStats();
    }
}
