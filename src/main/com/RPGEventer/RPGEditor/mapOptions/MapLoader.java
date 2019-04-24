package main.com.RPGEventer.RPGEditor.mapOptions;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Boolean.*;

public class MapLoader implements MAPSTATS {
    private Vector<String> loadedMap;
    private File fileNameToLoad;
    private Integer numTilePacks;
    private Vector<String> tilePackLocations;
    private Integer xDimension, yDimension;
    private boolean mapLoaded = FALSE;
    private ERRORSTATUS error = ERRORSTATUS.NO_ERROR;

    public MapLoader(){
        this.numTilePacks = 0;
        this.xDimension = 0;
        this.yDimension = 0;
    }

    public MapLoader(File fileNameToLoad){
        this.fileNameToLoad = fileNameToLoad;
        this.numTilePacks = 0;
        this.xDimension = 0;
        this.yDimension = 0;
    }

    public boolean loadMap(){
        if(fileNameToLoad.exists()) {
            try (Scanner fileScanner = new Scanner(this.fileNameToLoad)) {
                this.numTilePacks = fileScanner.nextInt();
                if (this.numTilePacks > MAPSTATS.MAX_TILE_PACKS) {
                    this.numTilePacks = MAPSTATS.MAX_TILE_PACKS;
                    this.error = ERRORSTATUS.NUM_OF_TILE_PACKS_TOO_LARGE;
                }

                fileScanner.nextLine();
                this.tilePackLocations = new Vector<>();
                for (int i = 0; i < this.numTilePacks; i++) {
                    this.tilePackLocations.add(fileScanner.nextLine());
                }

                this.xDimension = fileScanner.nextInt();
                fileScanner.nextLine();
                this.yDimension = fileScanner.nextInt();
                fileScanner.nextLine();

                Integer mapSize;
                this.loadedMap = new Vector<>();

                if (this.xDimension * this.yDimension > MAPSTATS.MAX_MAP_SIZE) {
                    this.error = ERRORSTATUS.MAP_DIMENSIONS_TOO_LARGE;
                    mapSize = MAPSTATS.MAX_MAP_SIZE;
                }
                else {
                    mapSize = this.xDimension * this.yDimension;
                }
                Integer index = 0;
                while (index < mapSize) {
                    this.loadedMap.add(fileScanner.nextLine());
                    index++;
                }

                this.mapLoaded = true;
            } catch (Exception e) {
                this.error = ERRORSTATUS.UNABLE_TO_READ_FILE;
            }
        }
        else{
            this.error = ERRORSTATUS.INVALID_MAP_FILE;
        }
        return this.mapLoaded;
    }

    public void displayStats(){
        if(this.mapLoaded) {
            System.out.println("The number of tile packs being used is: " + this.getNumTilePacks());
            System.out.println("The tile packs being used are: ");
            for (String str : this.tilePackLocations) {
                System.out.println("\t" + str);
            }
            System.out.println("The dimensions of the map are x: " + this.xDimension + " y: " + this.yDimension);
            System.out.println("The map tiles that are being used are listed below: ");
            for (String str : this.loadedMap) {
                System.out.println("\t" + str);
            }
            System.out.println("The above is the information on the currently loaded map");
        }
        else{
            System.out.println("No map was loaded.  ");
        }
        System.out.println(this.error);
    }

    public Vector<String> getLoadedMap() {
        return loadedMap;
    }

    private Integer getNumTilePacks() {
        return numTilePacks;
    }

    public Vector<String> getTilePackLocations() {
        return tilePackLocations;
    }

    public Integer getxDimension() {
        return xDimension;
    }

    public Integer getyDimension() {
        return yDimension;
    }

    public boolean isMapLoaded() {
        return mapLoaded;
    }

    public File getfileNameToLoad() {
        return fileNameToLoad;
    }
}
