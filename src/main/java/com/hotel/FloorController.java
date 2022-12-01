package com.hotel;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import org.w3c.dom.Text;

public class FloorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button fool1;

    @FXML
    private Button fool2;

    @FXML
    private Button fool3;

    @FXML
    private Button fool4;

    @FXML
    private Button fool5;

    @FXML
    private Button fool6;

    @FXML
    private Button fool7;
    @FXML
   private Text textID;

    public int id;
HelloController helloController= new HelloController();
    static OutputStreamWriter outputStream;
    static InputStreamReader inputStream;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;


    public void Serv(int floorId) {
        try {


            Socket clientSocket = new Socket("127.0.0.1", 1377);
            inputStream = new InputStreamReader(clientSocket.getInputStream());
            outputStream = new OutputStreamWriter(clientSocket.getOutputStream());

            bufferedReader = new BufferedReader(inputStream);
            bufferedWriter = new BufferedWriter(outputStream);
            while (true) {
                String florid = String.valueOf(floorId);
                bufferedWriter.write(florid);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedReader.readLine();

                if (florid.equalsIgnoreCase("BYE")) ;
                break;
            }
        }catch (Exception e){
            System.err.println(e);
        }
    }

    @FXML
    void initialize(int id) {

        int x1=1;
        fool1.setOnAction(event -> {
            fool1.getScene().getWindow().hide();
            try {

                Serv(x1);

                DDA dda = new DDA();

                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("NULP");

                Controller2 controller2= loader.getController();
                controller2.initialize(stage.getScene());
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        fool2.setOnAction(event -> {

            fool2.getScene().getWindow().hide();
            try {

                DDA dda = new DDA();
                Serv(x1+1);
                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("NULP");
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        fool3.setOnAction(event -> {
            fool3.getScene().getWindow().hide();
            try {

                Serv(x1+2);
                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("NULP");
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        fool4.setOnAction(event -> {
            fool4.getScene().getWindow().hide();
            try {

                DDA dda = new DDA();
                Serv(x1+3);
                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.setTitle("NULP");
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }




}


