package com.hotel;


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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

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
    static OutputStreamWriter outputStream;
    static InputStreamReader inputStream;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    DDA dda = new DDA();

    @FXML
    void loginButtonOnActionlogin() {
        if (!login_filed.getText().isBlank() && !password_filed.getText().isBlank()) {
            try {
                validateLogin();
//                Serv();

            } catch (Exception e) {
                System.err.println(e);
            }
        } else {
            loginMassageLabel.setText("Введіть логін та пароль");
        }
    }

    public void Serv() {
try {


        Socket clientSocket = new Socket("127.0.0.1", 1377);
        inputStream = new InputStreamReader(clientSocket.getInputStream());
        outputStream = new OutputStreamWriter(clientSocket.getOutputStream());

        bufferedReader = new BufferedReader(inputStream);
        bufferedWriter = new BufferedWriter(outputStream);
        while (true) {
            String mga = String.valueOf(dda.getX());
            bufferedWriter.write(mga);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedReader.readLine();

            if (mga.equalsIgnoreCase("BYE")) ;
            break;
        }
    }catch (Exception e){
    System.err.println(e);
}
    }


    public void validateLogin() {
        try {


            dda.id(login_filed.getText(), password_filed.getText());
            if (dda.getX() > 0) {

                SingUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("floor.fxml"));
                Parent root = loader.load();

                FloorController floorController = loader.getController();
                floorController.initialize(dda.getX());
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("NULP");
                stage.show();

            } else {
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
    void initialize() {

    }


}
