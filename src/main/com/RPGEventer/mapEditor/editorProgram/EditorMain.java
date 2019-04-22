package main.com.RPGEventer.mapEditor.editorProgram;

import main.com.RPGEventer.mapEditor.mapOptions.MAPSTATS;

public class EditorMain implements MAPSTATS {

    public static void run(){
        System.out.println("Welcome to the map editor!");
        EditorGui newEditor = new EditorGui();
        newEditor.startUp();

        while(!newEditor.isExited()){
        }
        return;
    }
}
