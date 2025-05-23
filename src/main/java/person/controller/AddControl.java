package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import person.model.Person;
import person.model.base.Server;
import person.model.entities.Terapeut;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class AddControl implements EventHandler<ActionEvent> {

    private final TextField firstNameTextField;
    private final TextField lastNameTextField;
    private final DatePicker dateOfBirthPicker;

    private final TableView<Terapeut> personTableView;

    public AddControl(TextField firstNameTextField, TextField lastNameTextField, DatePicker dateOfBirthPicker, TableView<Terapeut> personTableView) {
        this.firstNameTextField = firstNameTextField;
        this.lastNameTextField = lastNameTextField;
        this.dateOfBirthPicker = dateOfBirthPicker;
        this.personTableView = personTableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String firstName = this.firstNameTextField.getText().trim();
        String lastName = this.lastNameTextField.getText().trim();
        LocalDate dateOfBirth = this.dateOfBirthPicker.getValue();
        JDBCUtils.insertIntoTest(firstName, lastName, 1);
        List<Terapeut> terapeuti = JDBCUtils.selectAllFromTerapeut();
        Server.SERVER.setTerapeuti(terapeuti);
        this.personTableView.setItems(FXCollections.observableArrayList(terapeuti));
        this.firstNameTextField.clear();
        this.lastNameTextField.clear();
        this.dateOfBirthPicker.setValue(LocalDate.now().minusYears(20));
    }
}
