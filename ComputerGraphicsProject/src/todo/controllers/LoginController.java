package todo.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import todo.animation.Shake;
import todo.dto.DatabaseHandler;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signin;

    @FXML
    private Button signup;

    @FXML
    void initialize() {
        signup.setOnAction(event -> {
            signup.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/todo/view/SignUp.fxml"));

            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent parent = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.showAndWait();
        });

        signin.setOnAction(event -> {
            String userLogin = login.getText().trim();
            String userPassword = password.getText().trim();

            if(signInUser(userLogin, userPassword)){
                signin.getScene().getWindow().hide();

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/todo/view/Main.fxml"));

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent parent = fxmlLoader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.showAndWait();
            } else {
                Shake shakeLogin = new Shake(login);
                Shake shakePassword = new Shake(password);
                shakeLogin.playAnimation();
                shakePassword.playAnimation();
            }

        });
    }

    public boolean signInUser(String login1, String password){
        try {
            ResultSet resultSet = DatabaseHandler.databaseHandler.getUser(login1, password);
            resultSet.next();
            String passwordDB = resultSet.getString("pasword");
            if(passwordDB.equals(password)){
                return true;
            } else{
                return false;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            //throwables.printStackTrace();
            return false;
        }
    }
}

