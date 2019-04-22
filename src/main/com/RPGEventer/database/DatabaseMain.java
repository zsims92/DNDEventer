package main.com.RPGEventer.database;

import java.sql.*;
import java.util.Enumeration;

public class DatabaseMain {

    private static String userName = "fake-1";
    private static String passWord = "WEp4FAKE7dPf";
    private static Integer port = 3306;
    private static String serverIP = "mysql-fake.com";
    private static String databaseName = "fake391-1";
    private static String url = "jdbc:mysql://" + serverIP + ":" + port + "/" + databaseName;
    private static Boolean debugMode = false;
    private static Connection myConn;
    private static Statement myStmt;

    // Start of Debug functions
    private static void driverInfo(){
        if(!debugMode) { return; }
        getDrivers();
        loginTimeout();
    }
    private static void getDrivers(){
        Enumeration listOfDrivers = DriverManager.getDrivers();
        System.out.println("List of Drivers: " +listOfDrivers);
    }
    private static void loginTimeout(){
        Integer logTimeout = DriverManager.getLoginTimeout();
        System.out.println("You need to wait: " + logTimeout + " before accessing this database.");
    } //END OF DEBUG FUNCTIONS



    public static void initConnection() throws SQLException{
        try{
            do {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection(url, userName, passWord);
                // 2. Create a statement
                myStmt = myConn.createStatement();
            } while (myStmt.isClosed());

            driverInfo();
            //TODO: Make some logical setup to invoke insertData(), updateData(), deleteData() here



        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertData(String table_name, String[] columns, String[] values) throws SQLException{
        try{
            // 3. Execute SQL query
            String sql = "INSERT INTO " + table_name;
            String concatVals = "";
            String concatCols = "";

            for (Integer i = 0; i < columns.length; i++){

                for ( Integer j = 0; j < values.length; j++) {

                    concatVals += values[i] + ", ";
                }
                concatCols += columns[i] + ", ";
            }
            sql += " values (" + concatCols + ")";
            sql += " (" + concatVals + ")";

            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(String table_name, String condition) throws SQLException{
        try{
            // 3. Execute SQL query
            String sql = "DELETE FROM " + table_name
                    + " WHERE " + condition;
            //Valid condition is something like:  CustomerName='Alfonso'
            if(condition.equals("")){
                sql = "DELETE FROM " + table_name;
                myStmt.executeUpdate(sql);
                System.out.println("Insert complete.");
            } else {
                myStmt.executeUpdate(sql);
                System.out.println("Insert complete.");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateData(String table_name, String conditionValue, String conditionLocation) throws SQLException{
        try{
            // 3. Execute SQL query
            String sql = "UPDATE " + table_name
                    + " SET " + conditionValue
                    + " WHERE " + conditionLocation;

            if(conditionValue.equals("") || conditionLocation.equals("")){
                System.out.println("Please enter a valid value!");
            } else {
                myStmt.executeUpdate(sql);
                System.out.println("Insert complete.");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }





}
