package main.com.RPGEventer;

import javafx.fxml.FXML;
import main.com.RPGEventer.database.DatabaseGui;
import main.com.RPGEventer.mapEditor.editorProgram.EditorGui;
import main.com.RPGEventer.mapEditor.mapOptions.MapLoad;

public class launcherController {
    @FXML
    public void loadMapEditor(){
        System.out.println("Fuck you brando, you probably think youre soooo cool");
        EditorGui gui = new EditorGui();
        try {
            gui.startUp();
        }
        catch (Exception e){
            System.out.println("Weell, fuck. my editor gui sucks and failed to load");
        }
    }

    @FXML
    public void loadDatabase(){
        System.out.println("yeh. Fuck you brando you bitch. Im loading the database gui");
        DatabaseGui gui = new DatabaseGui();
        try {
            gui.startUp();
        }
        catch (Exception e){
            System.out.println("Weell, your database gui sucks and failed to load");
        }
    }

    @FXML
    public void loadMapLoad(){
        System.out.println("Fuck you brando, cuz you aint cool, soz. this thing doesnt do much yet so LEAVE IT ALONE");
        MapLoad m = new MapLoad();
        m.run();
    }

    @FXML
    public void returnToLauncher() throws Exception{
        launcher l = new launcher();
        l.reset();
    }
}
