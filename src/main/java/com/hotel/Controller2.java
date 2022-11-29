package com.hotel;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller2 {

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
void bbedd(){
        try {

            Statement statement=connectDB.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from floorID");

        while (resultSet.next()) {
            for (int i = 2; i < 9; i++) {
                if (resultSet.getInt(i) == 1) {
                    System.out.println(resultSet.getInt(1));
                }
            }
        }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


}
    @FXML
    void initialize(int id,int floorID) {
    bbedd();
        back.setOnAction(event -> {
            back.getScene().getWindow().hide();
            try {

                DDA dda = new DDA();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("floor.fxml"));
                Parent root = loader.load();
                FloorController floorController= loader.getController();
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
        bed1.setOnAction(event -> {
            bed1.getScene().getWindow().hide();
            try {
                PreparedStatement preparedStatement1=connectDB.prepareStatement("update floorID set bed1 = ?  where floorID =?;");
                preparedStatement1.setInt(2,floorID);
                preparedStatement1.setInt(1,1);

                int i = preparedStatement1.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
