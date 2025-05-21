package person.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainView extends Stage {

    public MainView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginForm.fxml"));
            URL location = getClass().getResource("/loginForm.fxml");

            Parent root = loader.load();

            this.setTitle("Person JDBC - Main");
            this.setScene(new Scene(root));
            this.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
