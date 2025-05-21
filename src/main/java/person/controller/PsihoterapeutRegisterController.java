package person.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import person.model.entities.Oblast;
import person.model.utility.JDBCUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class PsihoterapeutRegisterController implements Initializable {
    @FXML
    private ChoiceBox oblast;

    private RegisterController parentController;

    public void setParentController(RegisterController parentController) {
        this.parentController = parentController;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Oblast> oblastList = FXCollections.observableArrayList(JDBCUtils.selectAllFromOblasti());
        oblast.setItems(oblastList);

        oblast.setConverter(new StringConverter<Oblast>() {
            @Override
            public String toString(Oblast oblast) {
                return oblast == null ? "" : oblast.getNaziv();
            }

            @Override
            public Oblast fromString(String string) {
                return oblastList.stream()
                        .filter(o -> o.getNaziv().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });

        if (!oblastList.isEmpty()) {
            oblast.setValue(oblastList.get(0));
        }
    }

    public void regpsih(ActionEvent actionEvent) {
        Oblast selectedOblast = (Oblast) oblast.getValue();
        if (selectedOblast != null && parentController != null) {
            parentController.getOblastFromChild(selectedOblast.getId());
        }

        closeWindow(actionEvent);
    }

    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


}
