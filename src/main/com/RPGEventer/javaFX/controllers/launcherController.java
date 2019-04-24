package main.com.RPGEventer.javaFX.controllers;

import javafx.fxml.FXML;
import main.com.RPGEventer.database.DatabaseGui;
import main.com.RPGEventer.launcher;

public class launcherController {
    @FXML
    public void closeAction(){
      
    }
    @FXML
    public void playEventClicked(){

    }
    @FXML
    public void newEventClicked(){

    }
    @FXML
    public void downloadEventClicked(){

    }
    @FXML
    public void rpgEditorButtonClicked(){

    }
    @FXML
    public void databaseOpen(){
        DatabaseGui db = new DatabaseGui();
        db.startUp();
    }
}
