package main.com.RPGEventer.database;

import java.sql.*;
import java.util.Enumeration;

public class DatabaseMain {

    private Connection myConn;
    private Statement myStmt;

    public void initConnection(String serverIP, String databaseName, String userName, String passWord, String port){
        try{
            String url = "jdbc:mysql://" + serverIP + ":" + port + "/" + databaseName;
            do {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection(url, userName, passWord);
                // 2. Create a statement
                myStmt = myConn.createStatement();
            } while (myStmt.isClosed());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try{
            if(!myStmt.isClosed()) {
                myStmt.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void readData(String sql){
        try{
            ResultSet rs = myStmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++){
                    if ( i > 1) System.out.print(", ");
                    String columnValue = rs.getString(i);
                    System.out.println(columnValue + " " + rsmd.getColumnName(i));
                }
            }
        } catch (Exception e){
            System.out.println("Failed to read data!");
        }
    }


    public void insertData(String table_name, String columns[], String values[]) {
        try{
            // 3. Execute SQL query
            String sql = "INSERT INTO " + table_name
                    + " (" + columns + ")"
                    + " VALUES (" + values + ")";

            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");
            readData(sql);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String table_name, String col1val1) {
        try{
            // 3. Execute SQL query
            String sql = "DELETE FROM " + table_name
                    + " WHERE " + col1val1;
            //Valid condition is something like:  CustomerName='Alfonso'
            if(col1val1.equals("")){
                sql = "DELETE FROM " + table_name;
                myStmt.executeUpdate(sql);
                System.out.println("Delete complete.");
                readData(sql);
            } else {
                myStmt.executeUpdate(sql);
                System.out.println("Delete complete.");
                readData(sql);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(String table_name, String col1val1, String col2val2) {
        try{
            // 3. Execute SQL query
            String sql = "UPDATE " + table_name
                    + " SET " + col1val1
                    + " WHERE " + col2val2;

            if(col1val1.equals("") || col2val2.equals("")){
                System.out.println("Please enter a valid value!");
            } else {
                myStmt.executeUpdate(sql);
                System.out.println("Update complete.");
                readData(sql);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Debug Functions
    public Enumeration listOfDrivers(){
        return DriverManager.getDrivers();
    }

    public Integer logTimeOut() {
        return DriverManager.getLoginTimeout();
    }

}