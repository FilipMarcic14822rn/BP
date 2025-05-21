package person.controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import person.model.utility.JDBCUtils;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    void loginClicked(ActionEvent actionEvent) {
        try {
            //TODO: mozda da baci neki error message umesto ovoga al to je lickanje
            if (JDBCUtils.selectFromTerapeut(null,null,null,null,null,null,password.getText(),email.getText()).isEmpty()) {
                return;
            }

            // Učitaj novi FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loggedIn.fxml"));
            Parent root = fxmlLoader.load();

            // Preuzmi trenutni stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Postavi novu scenu
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registerClicked(ActionEvent actionEvent) {
        try {
            // Učitaj novi FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/registerForm.fxml"));
            Parent root = fxmlLoader.load();

            // Preuzmi trenutni stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Postavi novu scenu
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
