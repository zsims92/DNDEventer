package com.DNDeventer.Database;

import java.sql.*;

public class DatabaseMain {

    private static String userName = "fake-1";
    private static String passWord = "WEp4FAKE7dPf";
    private static Integer port = 3306;
    private static String serverIP = "mysql-fake.com";
    private static String databaseName = "fake391-1";
    private static String url = "jdbc:mysql://" + serverIP + ":" + port + "/" + databaseName;

    public static void sendShit() throws SQLException{
        try{
            // 1. Get a connection to database
            Connection myConn = DriverManager.getConnection(url, userName, passWord);

            // 2. Create a statement
            Statement myStmt = myConn.createStatement();

            // 3. Execute SQL query
            String sql = "INSERT INTO users"
                    + " (id, identifier, license, money, name, skin)"
                    + " values ('3', 'steam:123123123123', 'license:123123123123123', '0', 'Test', '(NULL)')";
            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");


        }catch (Exception e) {
            e.printStackTrace();
        }
    }




}
