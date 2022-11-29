package com.hotel;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SingUpButton;

    @FXML
    private Label loginMassageLabel;

    @FXML
    private TextField login_filed;

    @FXML
    private PasswordField password_filed;


DDA dda = new DDA();

    @FXML
    void loginButtonOnActionlogin(){
        if (!login_filed.getText().isBlank() && !password_filed.getText().isBlank()) {

        validateLogin();



        }
        else {
            loginMassageLabel.setText("Введіть логін та пароль");
        }
    }


    public void validateLogin() {
        try {


            dda.id(login_filed.getText(),password_filed.getText());
            if (dda.getX() > 0){
                SingUpButton.getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("floor.fxml"));
                Parent root = loader.load();

                FloorController floorController= loader.getController();
                floorController.initialize(dda.getX());
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("NULP");
                stage.show();

            }else {
                loginMassageLabel.setText("Невірний логін або пароль");


            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void loginMassageLabel(MouseEvent event) {
    }

    @FXML
    void initialize()  {

    }


}
