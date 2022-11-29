package com.hotel;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DDA {


    public int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int id(String text, String password_filedText) {

        String verification = "SELECT Id FROM users WHERE UserLog='" + text + "' AND userPassword ='" + password_filedText + "'";
        DBWorker worker = new DBWorker();
        Connection connectDB = worker.getConnection();


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verification);

            while (queryResult.next()) {
                x = queryResult.getInt(1);
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return x;

    }

}

