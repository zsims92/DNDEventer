package com.DNDeventer.javaFXHelper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FXHelper {
    public static Stage currentStage;
    public Parent loadFXML(String fileToLoad) throws IOException {
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
}
