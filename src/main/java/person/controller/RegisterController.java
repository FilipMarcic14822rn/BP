package person.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.w3c.dom.Text;
import person.model.entities.Fakultet;
import person.model.entities.Oblast;
import person.model.utility.JDBCUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField jmbg;
    @FXML
    private TextField telefon;
    @FXML
    private DatePicker datum;
    @FXML
    private ChoiceBox stepen;
    @FXML
    private ChoiceBox fakultet;
    @FXML
    private CheckBox kandidat;
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    private int oblast;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Inicijalizacija stepena
        ObservableList<String> stepeni = FXCollections.observableArrayList("Osnovne", "Master", "Doktorske");
        stepen.setItems(stepeni);
        stepen.getSelectionModel().selectFirst();

        // Inicijalizacija fakulteta
        ObservableList<Fakultet> fakulteti = FXCollections.observableArrayList(JDBCUtils.selectAllFromFakulteti());
        fakultet.setItems(fakulteti);
        fakultet.setConverter(new StringConverter<Fakultet>() {
            @Override
            public String toString(Fakultet object) {
                return object.getNaziv();
            }

            @Override
            public Fakultet fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    void registerClicked(ActionEvent actionEvent) {
        //todo: register logika, ako je uspesno, ako je neuspesno itd

        if(kandidat.isSelected()){
            registrovanjeKandidata();
        }
        else{
            registrovanjeSertifikovanog();
        }


        try {
            // Učitaj novi FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/loginForm.fxml"));
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

    private void registrovanjeSertifikovanog(){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/psihoterapeutRegisterForm.fxml"));
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Psihoterapeut - Registracija");
            stage.setScene(new Scene(root, 450, 450));
            stage.showAndWait();


            Fakultet fakultet1 = (Fakultet) fakultet.getValue();
            JDBCUtils.insertIntoSertifikovaniPsihoterapeut(ime.getText(),prezime.getText(),datum.getValue(),telefon.getText(),stepen.getValue().toString(),jmbg.getText(),fakultet1.getId(),email.getText(),password.getText(),oblast);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrovanjeKandidata(){
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/kandidatRegisterForm.fxml"));
            root = fxmlLoader.load();
            PsihoterapeutRegisterController childController = fxmlLoader.getController();
            childController.setParentController(this);
            Stage stage = new Stage();
            stage.setTitle("Kandidat - Registracija");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getOblastFromChild(int oblast){
        this.oblast=oblast;
    }
}
