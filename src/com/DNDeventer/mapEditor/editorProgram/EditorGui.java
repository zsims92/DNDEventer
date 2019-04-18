package com.DNDeventer.mapEditor.editorProgram;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.DNDeventer.Database.*;


public class EditorGui extends Application {

    @Override
    public void start(Stage primaryStage){
        Button btn = new Button();
        btn.setText("Insert Data!");
        btn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
            public void handle(ActionEvent event) {
                System.out.println("Attempting to insert data...");
                try {DatabaseMain.sendShit();}
                catch(Exception e){ e.printStackTrace();}

            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startUp(){
        launch();
    }
}
