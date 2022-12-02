package com.hotel;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class Controller2 {
    @FXML
    private Button ok;

    @FXML
    private Label lable;


    @FXML
    private AnchorPane Scene;
    @FXML
    private AnchorPane Sss;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bed1;

    @FXML
    private Button bed10;

    @FXML
    private Button bed11;

    @FXML
    private Button bed12;

    @FXML
    private Button bed13;

    @FXML
    private Button bed14;

    @FXML
    private Button bed15;

    @FXML
    private Button bed16;

    @FXML
    private Button bed17;

    @FXML
    private Button bed18;

    @FXML
    private Button bed19;

    @FXML
    private Button bed2;

    @FXML
    private Button bed3;

    @FXML
    private Button bed4;

    @FXML
    private Button bed5;

    @FXML
    private Button bed6;

    @FXML
    private Button bed7;

    @FXML
    private Button bed8;

    @FXML
    private Button bed9;

    @FXML
    private Button back;
    DBWorker worker = new DBWorker();
    Connection connectDB = worker.getConnection();
    public int id;
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    void bbedd(int fl) {
        try {

            Statement statement = connectDB.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select  bed1, bed2, bed3, bed4, bed5, bed6, bed7, bed8, bed9, bed10, bed11, bed12, bed13, bed14, bed15, bed16, bed17, bed18, bed19 from floorID where floorID="+fl);

            while (resultSet.next()) {
                for (int i = 1; i < 20; i++) {
                    arrayList.add(resultSet.getInt(i));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    static OutputStreamWriter outputStream;
    static InputStreamReader inputStream;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public void Serv(int id,int fl,int bed) {
        try {


            Socket clientSocket = new Socket("127.0.0.1", 1377);
            inputStream = new InputStreamReader(clientSocket.getInputStream());
            outputStream = new OutputStreamWriter(clientSocket.getOutputStream());

            bufferedReader = new BufferedReader(inputStream);
            bufferedWriter = new BufferedWriter(outputStream);
            while (true) {
                String florid = String.valueOf(bed);
                bufferedWriter.write(String.valueOf(id+" "+fl+" "+florid));
                bufferedWriter.newLine();
                bufferedWriter.flush();
                bufferedReader.readLine();

                if (florid.equalsIgnoreCase("BYE")) ;
                break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    void initialize(int fl,int id) {
        bbedd(fl);
        Button(id,fl);



        //BACK!!!!!!
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            try {

                DDA dda = new DDA();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("floor.fxml"));
                Parent root = loader.load();
                FloorController floorController = loader.getController();
                floorController.initialize(id);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("NULP");
                stage.show();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

public void Button(int id , int fl){
    for (int i = 1; i < arrayList.toArray().length; i++) {
        Button button = (Button) Sss.lookup("#bed"+i);
            if (arrayList.get(i-1) ==0) {
                int finalI = i;

                button.setOnAction(event -> {
                    button.getScene().getWindow();
                    Serv(id,fl,finalI);
                    try {


                        Stage primaryStage = new Stage();

                        primaryStage.setTitle("NULP");
                        Label label = new Label("               Ви забронювали місце: " + finalI );
                        label.setFont(new Font("Areal",24));
                        Scene scene = new Scene(label, 400, 200);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    }catch (Exception e ){
                        System.err.println(e);
                    }
                });

            }else {
               button.setStyle("-fx-background-color: Red");
            }

}

        }

    }
