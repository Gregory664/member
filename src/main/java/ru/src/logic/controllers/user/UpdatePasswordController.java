package ru.src.logic.controllers.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;

import java.util.HashSet;

public class UpdatePasswordController {
    @FXML
    public Label label_alarm;
    @FXML
    public PasswordField passField_password;
    @FXML
    public PasswordField passField_password2;
    @FXML
    public Button btn_updatePass;
    @FXML
    public Button btn_close;

    private String password;
    public String getPassword() {
        return password;
    }
    private boolean passwordUpdate = false;
    public boolean isPasswordUpdate() {
        return passwordUpdate;
    }

    private Boolean isEmptyFields() {
        HashSet<Boolean> set = new HashSet<>();
        set.add(MemberUtils.isEmptyField(passField_password));
        set.add(MemberUtils.isEmptyField(passField_password2));
        return set.contains(true);
    }

    @FXML
    public void updatePassword(ActionEvent actionEvent) {
        label_alarm.setText(null);
        if(!isEmptyFields()) {
            if(isPasswordFieldsEquals()) {
                password = passField_password2.getText();
                passwordUpdate = true;
                closeForm(actionEvent);
            } else {
                label_alarm.setTextFill(MemberUtils.EMPTY_COLOR);
                label_alarm.setText("Пароли не совпадают");
            }
        } else {
            label_alarm.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm.setText("Заполните обязательные поля");
        }
    }

    public void clear() {
        passField_password.clear();
        passField_password2.clear();
        label_alarm.setText(null);
        passwordUpdate = false;
    }

    private boolean isPasswordFieldsEquals() {
        return passField_password.getText().equals(passField_password2.getText());
    }

    @FXML
    public void closeForm(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
