package main.com.RPGEventer.mapEditor.editorProgram.javaFX.controllers;

import javafx.fxml.FXML;
import main.com.RPGEventer.javaFXHelper.FXHelper;
import main.com.RPGEventer.launcher;

public class LoadingScreen {
    @FXML
    public void closeEditor(){
        launcher.manager.setStage("Launcher");
        launcher.manager.setScene("Launcher", "Launcher");
        launcher.manager.removeStage("Editor");
    }
}
