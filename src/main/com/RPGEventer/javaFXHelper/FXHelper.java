package main.com.RPGEventer.javaFXHelper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FXHelper {
    public static Stage currentStage;
    //TODO
    //Look into setting multiple stages and keeping track of each one here. can create object with stage and ID as vars
    //Would be able to just minimize the launcher and have the extra stages just closed by a function in here that shows
    //the default stage, which would be the first stage added.
    public Parent loadFXML(String fileToLoad) throws IOException {
        Parent root;
        URL url = null;
        try
        {
            url  = getClass().getResource( "/resources/" + fileToLoad );
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
