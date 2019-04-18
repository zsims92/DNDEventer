package com.DNDeventer.mapEditor;

import java.io.File;
import java.util.Scanner;

import static java.lang.Boolean.*;

public class MapLoader {
    private String loadedMap[];
    private File fileNameToLoad;
    private Integer numTilePacks;
    private String tilePackLocations[];
    private Integer xDimension, yDimension;
    public final Integer MAXTILEPACKS = 10;
    public final Integer MAXMAPSIZE = 200;
    private boolean mapLoaded = FALSE;
    private ERRORSTATUS error = ERRORSTATUS.NO_ERROR;

    MapLoader(){
        this.numTilePacks = 0;
        this.xDimension = 0;
        this.yDimension = 0;
    }

    MapLoader(File fileNameToLoad){
        this.fileNameToLoad = fileNameToLoad;
        this.numTilePacks = 0;
        this.xDimension = 0;
        this.yDimension = 0;
    }

    public boolean loadMap(){
        if(fileNameToLoad.exists()) {
            try (Scanner fileScanner = new Scanner(this.fileNameToLoad)) {
                this.numTilePacks = fileScanner.nextInt();
                if (this.numTilePacks > MAXTILEPACKS) {
                    this.numTilePacks = MAXTILEPACKS;
                    this.error = ERRORSTATUS.NUMOFTILEPACKSTOOLARGE;
                }

                fileScanner.nextLine();
                this.tilePackLocations = new String[this.numTilePacks];
                for (int i = 0; i < this.numTilePacks; i++) {
                    this.tilePackLocations[i] = fileScanner.nextLine();
                }

                this.xDimension = fileScanner.nextInt();
                fileScanner.nextLine();
                this.yDimension = fileScanner.nextInt();
                fileScanner.nextLine();

                Integer mapSize;
                if (this.xDimension * this.yDimension > MAXMAPSIZE) {
                    this.loadedMap = new String[MAXMAPSIZE];
                    this.error = ERRORSTATUS.MAPDIMENSIONSTOOLARGE;
                    mapSize = MAXMAPSIZE;
                }
                else {
                    this.loadedMap = new String[this.xDimension * this.yDimension];
                    mapSize = this.xDimension * this.yDimension;
                }
                Integer index = 0;
                while (index < mapSize) {
                    this.loadedMap[index] = fileScanner.nextLine();
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
    public String[] getLoadedMap() {
        return loadedMap;
    }

    public Integer getNumTilePacks() {
        return numTilePacks;
    }

    public String[] getTilePackLocations() {
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
