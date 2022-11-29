package com.hotel;

import java.io.IOException;
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

    @FXML
    void initialize(int id) {
        DBWorker worker = new DBWorker();
        Connection connectDB = worker.getConnection();
        PreparedStatement pStatement;
        int x1=1;
        fool1.setOnAction(event -> {
            fool1.getScene().getWindow().hide();
            try {

                PreparedStatement pStatement2 =connectDB.prepareStatement("update users set floorID=? where id=?");
                pStatement2.setInt(1,x1);
                pStatement2.setInt(2,id);
                int i2 = pStatement2.executeUpdate();
                DDA dda = new DDA();

                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();
                Controller2 controller2= loader.getController();
                controller2.initialize(id,x1);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("NULP");
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        fool2.setOnAction(event -> {

            fool2.getScene().getWindow().hide();
            try {
                PreparedStatement pStatement2 =connectDB.prepareStatement("update users set floorID=2 where id=?");
                pStatement2.setInt(1,id);
                int i2 = pStatement2.executeUpdate();
                DDA dda = new DDA();

                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();
                Controller2 controller2= loader.getController();
                controller2.initialize(id,x1+1);
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
                PreparedStatement pStatement2 =connectDB.prepareStatement("update users set floorID=3 where id=?");
                pStatement2.setInt(1,id);
                int i2 = pStatement2.executeUpdate();
                DDA dda = new DDA();

                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();
                Controller2 controller2= loader.getController();
                controller2.initialize(id,x1+2);
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
                PreparedStatement pStatement2 =connectDB.prepareStatement("update users set floorID=4 where id=?");
                pStatement2.setInt(1,id);
                int i2 = pStatement2.executeUpdate();
                DDA dda = new DDA();

                FXMLLoader loader=new FXMLLoader(getClass().getResource("2.fxml"));
                Parent root = loader.load();
                Controller2 controller2= loader.getController();
                controller2.initialize(id,x1+3);
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


