package main.com.RPGEventer.database.javaFX.controllers;

import main.com.RPGEventer.database.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainDatabase {
    private DatabaseMain dbMain = new DatabaseMain();

    //Main window buttons
    public Button connectBtn;
    public Button disconnectBtn;
    public Button updateBtn;
    public Button deleteBtn;
    public Button insertBtn;

    //User info bottom panel
    public TextField serverIP;
    public TextField userName;
    public TextField databaseName;
    public TextField port;
    public PasswordField passWord;

    //Insert Menu Items
    public TextField insert_tableName;
    public TextField insert_columns;
    public TextField insert_values;

    //Update Menu Items
    public TextField update_tableName;
    public TextField update_col1val1;
    public TextField update_col2val2;

    //Delete Menu Items
    public TextField del_tableName;
    public TextField del_col1val1;

    public void onClickUpdate() throws Exception {
        if(update_tableName.getText().equals("") ||
                update_col1val1.getText().equals("") ||
                update_col2val2.getText().equals("")){
            System.out.println("Please enter valid tables, columns, values");
        }

        String tableName = update_tableName.getText();
        String col1val1 = update_col1val1.getText();
        String col2val2 = update_col2val2.getText();

        dbMain.updateData(tableName, col1val1, col2val2);
    }

    @FXML
    public void onClickInsert() throws Exception{

        if(insert_tableName.getText().equals("") ||
                insert_columns.getText().equals("") ||
                insert_values.getText().equals("")){
            System.out.println("Please enter valid tables, columns, values");
        }

        String tableName = insert_tableName.getText();
        String columns[] = { insert_columns.getText()};
        String values[] = {insert_values.getText()};

        dbMain.insertData(tableName, columns, values);
    }

    public void onClickDelete() throws Exception{
        if(del_tableName.getText().equals("") || del_col1val1.getText().equals("") ) {
            System.out.println("Please enter valid tables, columns, values");
        }

        String tableName = del_tableName.getText();
        String col1val1 = del_col1val1.getText();

        dbMain.deleteData(tableName, col1val1);

    }

    public void onClickConnect(){
        String ip;
        String name;
        String pass;
        String dbName;
        String portNumber;

        if(serverIP.getText().equals("") || userName.getText().equals("") || databaseName.getText().equals("")) {
            System.out.println("Please check hostname/database name/username");

        }else {
            ip = serverIP.getText();
            name = userName.getText();
            dbName = databaseName.getText();
            pass = passWord.getText();

            if (port.getText().equals("")){
                portNumber = "3306";
            } else {
                portNumber = port.getText();
            }

            //dbMain.initConnection(ip, dbName, name, pass, portNumber);
        }
    }

    public void onClickDisconnect() {
        //TODO
        // dbMain.closeConnection();
    }

    public void openMenuInsert(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("insert.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Insert Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    public void openMenuDelete(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delete.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Delete Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    public void openMenuUpdate(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("update.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Update Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }

    public void openMenuDebug(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("debug.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Debug Menu");
            stage.setScene(new Scene(root1));
            stage.show();

        }catch (Exception e) {
            System.out.println("Cant load new window");
        }
    }
}
