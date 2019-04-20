package com.DNDeventer.mapEditor.editorProgram;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class EditorGui extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{
        String sceneFile = "javaFX/fxml/LoadingScreen.fxml";
        Parent root = loadFXML(sceneFile);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Database manaFUCKBRANDO!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Parent loadFXML(String fileToLoad) throws IOException{
        Parent root;
        URL url = null;
        try
        {
            url  = getClass().getResource( fileToLoad );
            root = FXMLLoader.load( url );
            System.out.println( "  fxmlResource = " + fileToLoad );
        }
        catch ( Exception ex )
        {
            System.out.println( "Exception on FXMLLoader.load()" );
            System.out.println( "  * url: " + url );
            System.out.println( "  * " + ex );
            System.out.println( "    ----------------------------------------\n" );
            throw ex;
        }

        return root;
    }


    public boolean isExited(){
        return true;
    }
    public void startUp(){
        launch();
    }
}