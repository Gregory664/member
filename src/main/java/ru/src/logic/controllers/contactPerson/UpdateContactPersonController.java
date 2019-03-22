package ru.src.logic.controllers.contactPerson;

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

import java.util.HashSet;

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

    private boolean updateContactPerson = false;

    private ContactPerson contactPerson;
    public boolean isUpdateContactPerson() {
        return updateContactPerson;
    }

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
        if (contactPerson.getPhoneCity() != null) {
            text_contactPerson_phoneCity.setText(contactPerson.getPhoneCity());
        }
        if (contactPerson.getChanges() != null) {
            text_contactPerson_changes.setText(contactPerson.getChanges());
        }
        if (contactPerson.getEmail() != null) {
            text_contactPerson_email.setText(contactPerson.getEmail());
        }
    }

    @FXML
    public void updateContactPerson(ActionEvent actionEvent) {
        if(!isFieldsEmpty()) {
            contactPerson.setPhoneMobile(text_contactPerson_phoneMobile.getText());
            contactPerson.setPhoneCity(text_contactPerson_phoneCity.getText());
            contactPerson.setEmail(text_contactPerson_email.getText());
            contactPerson.setChanges(text_contactPerson_changes.getText());

            updateContactPerson = true;
            closeWindow(actionEvent);
        } else {
            label_alarm_contactPerson_fullName.setText(null);
            label_alarm_contactPerson_position.setText(null);
            label_alarm_contactPerson_phoneMobile.setText(null);
            label_alarm_contactPerson_email.setText(null);

            label_alarm_contactPerson_changes.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_contactPerson_changes.setText("Заполните обязательные поля");
        }
    }

    private boolean isFieldsEmpty() {
        HashSet<Boolean> set = new HashSet<>();
        set.add(MemberUtils.isEmptyField(text_contactPerson_fullName));
        set.add(MemberUtils.isEmptyField(text_contactPerson_position));
        set.add(MemberUtils.isEmptyField(text_contactPerson_phoneMobile));
        set.add(MemberUtils.isEmptyField(text_contactPerson_email));
        return set.contains(true);
    }

    @FXML
    public void closeWindow(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
