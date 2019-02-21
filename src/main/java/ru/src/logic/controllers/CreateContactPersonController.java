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

import java.util.HashSet;

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

    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

    private boolean createContactPerson = false;

    public boolean isCreateContactPerson() {
        return createContactPerson;
    }

    public void setCreateContactPerson(boolean createContactPerson) {
        this.createContactPerson = createContactPerson;
    }

    @FXML
    public void initialize() {
        MemberUtils.checkTextPhone(text_contactPerson_phoneMobile, label_alarm_contactPerson_phoneMobile);
        MemberUtils.checkTextLength(text_contactPerson_fullName, label_alarm_contactPerson_fullName, 50);
        MemberUtils.checkTextLength(text_contactPerson_position, label_alarm_contactPerson_position, 255);
        MemberUtils.checkTextLength(text_contactPerson_email, label_alarm_contactPerson_email, 50);

    }

    private boolean isFieldsEmpty() {
        HashSet<Boolean> set = new HashSet<Boolean>();
        set.add(MemberUtils.isEmptyField(text_contactPerson_fullName));
        set.add(MemberUtils.isEmptyField(text_contactPerson_position));
        set.add(MemberUtils.isEmptyField(text_contactPerson_phoneMobile));
        set.add(MemberUtils.isEmptyField(text_contactPerson_email));
        return set.contains(true);
    }

    public void saveContactPerson(ActionEvent actionEvent) {

        if (!isFieldsEmpty()) {
            label_alarm_contactPerson_email.setTextFill(null);

            contactPerson = new ContactPerson(
                    this.member,
                    text_contactPerson_fullName.getText(),
                    text_contactPerson_position.getText(),
                    text_contactPerson_phoneMobile.getText(),
                    text_contactPerson_email.getText()
            );

            createContactPerson = true;
            closeWindow(actionEvent);
        } else {
            label_alarm_contactPerson_fullName.setText(null);
            label_alarm_contactPerson_position.setText(null);
            label_alarm_contactPerson_phoneMobile.setText(null);

            label_alarm_contactPerson_email.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_contactPerson_email.setText("Заполните обязательные поля");
        }

    }

    public void clearTextAndStyle() {
        text_contactPerson_fullName.clear();
        text_contactPerson_position.clear();
        text_contactPerson_phoneMobile.clear();
        text_contactPerson_email.clear();

        label_alarm_contactPerson_fullName.setText("");
        label_alarm_contactPerson_position.setText("");
        label_alarm_contactPerson_phoneMobile.setText("");
        label_alarm_contactPerson_email.setText("");

        text_contactPerson_fullName.setStyle(null);
        text_contactPerson_position.setStyle(null);
        text_contactPerson_phoneMobile.setStyle(null);
        text_contactPerson_email.setStyle(null);

        label_alarm_contactPerson_fullName.setStyle(null);
        label_alarm_contactPerson_position.setStyle(null);
        label_alarm_contactPerson_phoneMobile.setStyle(null);
        label_alarm_contactPerson_email.setStyle(null);
    }



    @FXML
    public void closeWindow(ActionEvent actionEvent) {
        clearTextAndStyle();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
