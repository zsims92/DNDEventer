package com.DNDeventer.Database;

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

    // Start of Debug functions
    public static void driverInfo(){
        if(!debugMode) { return; }
        getDrivers();
        loginTimeout();
    }
    public static void getDrivers(){
        Enumeration listOfDrivers = DriverManager.getDrivers();
        System.out.println("List of Drivers: " +listOfDrivers);
    }
    public static void loginTimeout(){
        Integer logTimeout = DriverManager.getLoginTimeout();
        System.out.println("You need to wait: " + logTimeout + " before accessing this database.");
    } //END OF DEBUG FUNCTIONS



    public static void initConnection() throws SQLException{
        try{
            do {
                // 1. Get a connection to database
                Connection myConn = DriverManager.getConnection(url, userName, passWord);
                // 2. Create a statement
                Statement myStmt = myConn.createStatement();
                //TODO: setup this boolean, not sure  why its not working but im tired and going to bed now!
            } while (myStmt.isClosed());

            driverInfo();
            //TODO: Make some logical setup to invoke insert, update, delete here


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: Setup a loop for array length to properly insert all args
    public static void insertData(String table_name, String[] columns, String[] values) throws SQLException{
        try{
            // 3. Execute SQL query
            String sql = "INSERT INTO " + table_name
                    + " ("+ columns[0] + ", " + columns[1] +", " + columns[2] + ")"
                    + " values (" + values[0] + ", "+ values[1] + ", "+ values[2] + ")";
            /*
            * insert into table
            * column1 col2 col3
            *    val1 val2 val3
            * */

            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: Setup deletion for entire table, ie DELETE FROM Customers;
    public static void deleteData(String table_name, String condition) throws SQLException{
        try{
            // 3. Execute SQL query
            String sql = "DELETE FROM " + table_name
                    + " WHERE " + condition;
            //Valid condition is something like:  CustomerName='Alfonso'

            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO: method overloading for no location (VERY DANGEROUS THO!)
    public static void updateData(String table_name, String conditionValue, String conditionLocation) throws SQLException{
        try{
            // 3. Execute SQL query
            String sql = "UPDATE " + table_name
                    + " SET " + conditionValue
                    + " WHERE " + conditionLocation;
            /*
             * conditionValue: ContactName='JuanBean'
             * conditionLocation: Country='Mexico'
             * */

            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }





}
