package com.hotel;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBWorker {
    public Connection connection;
    public Connection getConnection(){
         String url = "jdbc:mysql://localhost:3306/Hostel";
         String username= "root";
         String password = "123456789";
         String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
