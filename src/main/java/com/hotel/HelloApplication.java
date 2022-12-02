package com.hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.sql.*;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        try {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1040, 600);
        stage.setTitle("NULP");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();}catch (Exception e){

        }
        try {
            Socket clientSocket = new Socket("127.0.0.1", 1377);

        }catch (Exception e){
            Stage primaryStage = new Stage();

            primaryStage.setTitle("NULP");
            Label label = new Label("   No SERVER connect " );
            label.setFont(new Font("Areal",24));
            Scene scene = new Scene(label, 400, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }

    public static void main(String[] args)  {

        launch();
    }



}