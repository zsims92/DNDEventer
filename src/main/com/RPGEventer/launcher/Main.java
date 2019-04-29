package main.com.RPGEventer.launcher;

import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static ResourceBundle textBundle;

    public static void main(String[] args){
        LOGGER.info("Loading the resource bundle for localization");
        textBundle = ResourceBundle.getBundle("resources.localization.textBundle");
        launcher launch = new launcher();
        launch.run();
    }
}
