package main.com.RPGEventer.javaFXManager.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.com.RPGEventer.editor.editorGui;

public class launcherController {

    @FXML
    private Label editorText;

    @FXML
    private Label PlayText;

    @FXML
    private Label browseText;

    @FXML
    private Label createText;

    @FXML
    public void initialize(){
        editorText.setText("Features:\n" +
                "Create new maps, monsters, player characters and more!\n" +
                "Fully integrated with assets you can download\n" +
                "Easy set up process helps you become an editor pro!\n");

        PlayText.setText("Features:\n" +
                "Load custom events or select from defaults\n" +
                "Events can have multiple maps with live tiles\n" +
                "Can be paused and resumed whenever\n" +
                "Import and then export player characters after event is done\n");
        browseText.setText("Features:\n" +
                "Load custom events or select from defaults\n" +
                "Events can have multiple maps with live tiles\n" +
                "Can be paused and resumed whenever\n" +
                "Import and then export player characters after event is done\n");

        createText.setText("Features:\n" +
                "Load custom events or select from defaults\n" +
                "Events can have multiple maps with live tiles\n" +
                "Can be paused and resumed whenever\n" +
                "Import and then export player characters after event is done\n");
    }


    @FXML
    void openEditorMain(ActionEvent event) {
        editorGui ed = new editorGui();
        ed.startUp();
    }

}
