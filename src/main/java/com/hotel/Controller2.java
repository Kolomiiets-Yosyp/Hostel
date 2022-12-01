package com.hotel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller2 {

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
    void bbedd() {
        try {

            Statement statement = connectDB.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select  bed1, bed2, bed3, bed4, bed5, bed6, bed7 from floorID where floorID=4");
            while (resultSet.next()) {
                for (int i = 2; i < 8; i++) {
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

    public void Serv(int bed) {
        try {


            Socket clientSocket = new Socket("127.0.0.1", 1377);
            inputStream = new InputStreamReader(clientSocket.getInputStream());
            outputStream = new OutputStreamWriter(clientSocket.getOutputStream());

            bufferedReader = new BufferedReader(inputStream);
            bufferedWriter = new BufferedWriter(outputStream);
            while (true) {
                String florid = String.valueOf(bed);
                bufferedWriter.write(florid);
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
    void initialize(Scene scene) {

        bbedd();
        Button(scene);

        //BACK!!!!!!
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            try {

                DDA dda = new DDA();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("floor.fxml"));
                Parent root = loader.load();
                FloorController floorController = loader.getController();
                floorController.initialize(dda.getX());
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

public void Button(Scene scene){

            ArrayList<Button> buttons= new ArrayList<Button>();
            buttons.add((Button) Sss.getChildren());
        System.out.println(buttons.get(0));
//        button.setOnAction(event -> {
//            button.getScene().getWindow().hide();
//            System.out.println(1111);
//
//        });
}
//        bed1.setOnAction(event -> {
//            bed1.getScene().getWindow().hide();
//
//            if (arrayList.get(1) ==0) {
//                Serv(1);
//            }
//        });
//        bed2.setOnAction(event -> {
//            bed2.getScene().getWindow().hide();
//            if (arrayList.get(2) ==0) {
//                Serv(2);
//            }
//        });
//        bed3.setOnAction(event -> {
//            bed3.getScene().getWindow().hide();
//            if (arrayList.get(3) ==0) {
//                Serv(3);
//            }
//        });
//        bed4.setOnAction(event -> {
//            bed4.getScene().getWindow().hide();
//            if (arrayList.get(4) ==0) {
//                Serv(4);
//            }
//        });
//        bed5.setOnAction(event -> {
//            bed5.getScene().getWindow().hide();
//            if (arrayList.get(5) ==0) {
//                Serv(5);
//            }
//        });
//        bed6.setOnAction(event -> {
//            bed6.getScene().getWindow().hide();
//            if (arrayList.get(6) ==0) {
//                Serv(6);
//            }
//        });
//        bed7.setOnAction(event -> {
//            bed7.getScene().getWindow().hide();
//            if (arrayList.get(7) ==0) {
//                Serv(7);
//            }
//        });
//        bed8.setOnAction(event -> {
//            bed8.getScene().getWindow().hide();
//            if (arrayList.get(8) ==0) {
//                Serv(8);
//            }
//        });
//        bed9.setOnAction(event -> {
//            bed9.getScene().getWindow().hide();
//            if (arrayList.get(9) ==0) {
//                Serv(9);
//            }
//        });
//        bed10.setOnAction(event -> {
//            bed10.getScene().getWindow().hide();
//            if (arrayList.get(10) ==0) {
//                Serv(10);
//            }
//        });
//        bed11.setOnAction(event -> {
//            bed11.getScene().getWindow().hide();
//            if (arrayList.get(11) ==0) {
//                Serv(11);
//            }
//        });
//        bed12.setOnAction(event -> {
//            bed12.getScene().getWindow().hide();
//            if (arrayList.get(12) ==0) {
//                Serv(12);
//            }
//        });


        }


