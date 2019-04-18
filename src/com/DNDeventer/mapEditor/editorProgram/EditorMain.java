package com.DNDeventer.mapEditor.editorProgram;

import com.DNDeventer.mapEditor.MAPSTATS;
import javafx.stage.Stage;

public class EditorMain implements MAPSTATS {
    public static void run(){
        System.out.println("Welcome to the map editor!!!.  Brando is the nicest person in the world.  He really is so");
        EditorGui newEditor = new EditorGui();
        newEditor.startUp();
    }
}
