package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Member;
import ru.src.model.Personal.ContactPerson;

public class CreateContactPersonController {
    @FXML
    public TextField text_contactPerson_position;
    @FXML
    public TextField text_contactPerson_phoneMobile;
    @FXML
    public TextField text_contactPerson_email;
    @FXML
    public TextField text_contactPerson_fullName;

    @FXML
    public Label label_alarm_contactPerson_fullName;
    @FXML
    public Label label_alarm_contactPerson_position;
    @FXML
    public Label label_alarm_contactPerson_phoneMobile;
    @FXML
    public Label label_alarm_contactPerson_email;

    @FXML
    public Button btnSave;
    @FXML
    public Button btnCancel;

    private ContactPerson contactPerson;
    public ContactPerson getContactPerson() {
        return contactPerson;
    }
    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    private Member member;
    public void setMember(Member member) {
        this.member = member;
    }

    @FXML
    public void initialize() {
        MemberUtils.checkTextPhone(text_contactPerson_phoneMobile);
        MemberUtils.checkTextLength(text_contactPerson_fullName, label_alarm_contactPerson_fullName, 50);
        MemberUtils.checkTextLength(text_contactPerson_position, label_alarm_contactPerson_position, 255);
        MemberUtils.checkTextLength(text_contactPerson_email, label_alarm_contactPerson_email, 50);

    }

    public void saveContactPerson(ActionEvent actionEvent) {
        boolean isEmpty = false;
        if(MemberUtils.isEmptyTextField(text_contactPerson_fullName)) {
            MemberUtils.checkAlarm(text_contactPerson_fullName, label_alarm_contactPerson_fullName);
            isEmpty = true;
        } else {
            text_contactPerson_fullName.setStyle(null);
            label_alarm_contactPerson_fullName.setStyle(null);
            label_alarm_contactPerson_fullName.setText("");
        }

        if(MemberUtils.isEmptyTextField(text_contactPerson_position)) {
            MemberUtils.checkAlarm(text_contactPerson_position, label_alarm_contactPerson_position);
            isEmpty = true;
        } else {
            text_contactPerson_position.setStyle(null);
            label_alarm_contactPerson_position.setStyle(null);
            label_alarm_contactPerson_position.setText("");
        }

        if(MemberUtils.isEmptyTextField(text_contactPerson_phoneMobile)) {
            MemberUtils.checkAlarm(text_contactPerson_phoneMobile, label_alarm_contactPerson_phoneMobile);
            isEmpty = true;
        } else {
            text_contactPerson_phoneMobile.setStyle(null);
            label_alarm_contactPerson_phoneMobile.setStyle(null);
            label_alarm_contactPerson_phoneMobile.setText("");

        }

        if(MemberUtils.isEmptyTextField(text_contactPerson_email)) {
            MemberUtils.checkAlarm(text_contactPerson_email, label_alarm_contactPerson_email);
            isEmpty = true;
        } else {
            text_contactPerson_email.setStyle(null);
            label_alarm_contactPerson_email.setStyle(null);
            label_alarm_contactPerson_email.setText("");

        }

        if(!isEmpty) {
            contactPerson = new ContactPerson(
                    this.member,
                    text_contactPerson_fullName.getText(),
                    text_contactPerson_position.getText(),
                    text_contactPerson_phoneMobile.getText(),
                    text_contactPerson_email.getText());

            clearText();
            clearStyle();

            MemberUtils.alertDialog("Контакты успешно добавлены!");
            closeWindow(actionEvent);
        }
    }

    private void clearText() {
        text_contactPerson_fullName.clear();
        text_contactPerson_position.clear();
        text_contactPerson_phoneMobile.clear();
        text_contactPerson_email.clear();

        label_alarm_contactPerson_fullName.setText("");
        label_alarm_contactPerson_position.setText("");
        label_alarm_contactPerson_phoneMobile.setText("");
        label_alarm_contactPerson_email.setText("");
    }

    private void clearStyle() {
        text_contactPerson_fullName.setStyle(null);
        text_contactPerson_position.setStyle(null);
        text_contactPerson_phoneMobile.setStyle(null);
        text_contactPerson_email.setStyle(null);

        label_alarm_contactPerson_fullName.setStyle(null);
        label_alarm_contactPerson_position.setStyle(null);
        label_alarm_contactPerson_phoneMobile.setStyle(null);
        label_alarm_contactPerson_email.setStyle(null);
    }

    public void closeWindow(ActionEvent actionEvent) {
        clearText();
        clearStyle();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
