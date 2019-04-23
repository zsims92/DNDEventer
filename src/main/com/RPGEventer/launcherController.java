package main.com.RPGEventer;

import javafx.fxml.FXML;
import main.com.RPGEventer.database.DatabaseGui;
import main.com.RPGEventer.mapEditor.editorProgram.EditorGui;
import main.com.RPGEventer.mapEditor.mapOptions.MapLoad;

public class launcherController {
    @FXML
    public void loadMapEditor(){
        System.out.println("I love brando, I know he is soooo cool");
        EditorGui gui = new EditorGui();
        try {
            gui.startUp();
        }
        catch (Exception e){
            System.out.println("Weell, fuck. My name is sims and my editor gui sucks and failed to load");
        }
    }

    @FXML
    public void loadDatabase(){
        System.out.println("REEEE; MY DATABASE NOW BRANDO CAUSE IM A BITCH.");
        DatabaseGui gui = new DatabaseGui();
        try {
            gui.startUp();
        }
        catch (Exception e){
            System.out.println("Damn. This DB GUI is too sexy to load...");
        }
    }

    @FXML
    public void loadMapLoad(){
        System.out.println("I name my functions loadMapLoad cause im a derpPersonDerp()");
        MapLoad m = new MapLoad();
        m.run();
    }
}
