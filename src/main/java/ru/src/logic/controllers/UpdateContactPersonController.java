package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Personal.ContactPerson;

public class UpdateContactPersonController {
    @FXML
    public TextField text_contactPerson_fullName;
    @FXML
    public TextField text_contactPerson_position;
    @FXML
    public TextField text_contactPerson_phoneMobile;
    @FXML
    public TextField text_contactPerson_phoneCity;
    @FXML
    public TextField text_contactPerson_email;
    @FXML
    public TextArea text_contactPerson_changes;
    @FXML
    public Label label_alarm_contactPerson_fullName;
    @FXML
    public Label label_alarm_contactPerson_position;
    @FXML
    public Label label_alarm_contactPerson_phoneMobile;
    @FXML
    public Label label_alarm_contactPerson_email;
    @FXML
    public Label label_alarm_contactPerson_phoneCity;
    @FXML
    public Label label_alarm_contactPerson_changes;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnCancel;

    @FXML
    public void initialize() {
        MemberUtils.checkTextPhone(text_contactPerson_phoneCity, label_alarm_contactPerson_phoneCity);
        MemberUtils.checkTextPhone(text_contactPerson_phoneMobile, label_alarm_contactPerson_phoneMobile);
        MemberUtils.checkTextLength(text_contactPerson_email, label_alarm_contactPerson_email, 50);
        MemberUtils.checkTextLength(text_contactPerson_changes, label_alarm_contactPerson_changes, 255);
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
        fillFields();
    }

    private void fillFields() {
        text_contactPerson_fullName.setText(contactPerson.getFullName());
        text_contactPerson_position.setText(contactPerson.getPosition());
        text_contactPerson_phoneMobile.setText(contactPerson.getPhoneMobile());
        if(contactPerson.getPhoneCity() != null)
            text_contactPerson_phoneCity.setText(contactPerson.getPhoneCity());
        if(contactPerson.getChanges() != null)
            text_contactPerson_changes.setText(contactPerson.getChanges());
        text_contactPerson_email.setText(contactPerson.getEmail());

    }

    private ContactPerson contactPerson;

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void updateContactPerson(ActionEvent actionEvent) {
        contactPerson.setFullName(text_contactPerson_fullName.getText());
        contactPerson.setPosition(text_contactPerson_position.getText());
        contactPerson.setPhoneMobile(text_contactPerson_phoneMobile.getText());
        contactPerson.setPhoneCity(text_contactPerson_phoneCity.getText());
        contactPerson.setEmail(text_contactPerson_email.getText());
        contactPerson.setChanges(text_contactPerson_changes.getText());

        MemberUtils.informationDialog("Данные контактного лица успешно обновлены!");
        closeWindow(actionEvent);
    }

    public void closeWindow(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
