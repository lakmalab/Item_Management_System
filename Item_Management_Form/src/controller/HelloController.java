package controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;

import static javafx.application.Application.launch;

public class HelloController{

    public PasswordField txtPassword;
    public TextField txtEmail;


    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        final String email = "lakmal";
        final String password = "1234";


        String txtPasswordText = txtPassword.getText();
        String txtEmailText = txtEmail.getText();

        User user = new User(txtEmailText, txtPasswordText);
        System.out.println(user);
        if (txtEmailText.equals(email) && txtPasswordText.equals(password)) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Item_form.fxml"))));
            stage.show();
            new Alert(Alert.AlertType.INFORMATION,"Hello "+txtEmailText+" \n Welcome Back").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Error Theres ne User With the Email "+txtEmailText+" \n Please Try again").show();
        }
    }

}