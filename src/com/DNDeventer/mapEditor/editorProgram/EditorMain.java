package com.DNDeventer.mapEditor.editorProgram;

import com.DNDeventer.mapEditor.MAPSTATS;
import javafx.stage.Stage;

public class EditorMain implements MAPSTATS {
    public static void run(){
        EditorGui newEditor = new EditorGui();
        newEditor.startUp();
    }
}
