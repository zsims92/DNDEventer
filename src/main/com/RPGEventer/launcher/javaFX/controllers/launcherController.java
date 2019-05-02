package main.com.RPGEventer.launcher.javaFX.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.com.RPGEventer.editor.editorGui;
import main.com.RPGEventer.event.runEvent.display.mainDisplay;

import static main.com.RPGEventer.launcher.Main.LOGGER;
import static main.com.RPGEventer.launcher.Main.textBundle;

public class launcherController {

    public editorGui ed = null;
    public mainDisplay game = null;

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
        editorText.setText(textBundle.getString("EDITOR_FEATURES"));
        PlayText.setText(textBundle.getString("PLAY_FEATURES"));
        browseText.setText(textBundle.getString("BROWSE_FEATURES"));
        createText.setText(textBundle.getString("CREATE_FEATURES"));
    }

    @FXML
    void openEditorMain() {
        editorGui ed = new editorGui();
        ed.startUp(true, true);
        LOGGER.info("Opened up an editor");
    }
    @FXML
    void openMainDisplay(){
        mainDisplay game = new mainDisplay();
        game.startUp(true, true);
        LOGGER.info("Opened up an main display");

    }

}
