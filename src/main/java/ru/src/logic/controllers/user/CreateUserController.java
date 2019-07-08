package ru.src.logic.controllers.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.entities.User;

import java.util.HashSet;

public class CreateUserController {
    @FXML
    public TextField text_login;
    @FXML
    public TextField text_password;
    @FXML
    public TextField text_fullName;
    @FXML
    public TextField text_position;
    @FXML
    public CheckBox isAdmin;
    @FXML
    public Label label_alarm_user;
    @FXML
    public Button bth_save;
    @FXML
    public Button btn_closeApp;
    @FXML
    public Button button_show;
    @FXML
    public PasswordField passField_password;

    private User newUser;
    public User getNewUser() {
        return newUser;
    }

    private Boolean userCreate = false;
    public Boolean isUserCreate() {
        return userCreate;
    }

    public void saveUser(ActionEvent actionEvent) {
        if(!isEmptyFields()) {
            newUser = new User(
                    text_login.getText(),
                    text_password.isVisible() ? text_password.getText() : passField_password.getText(),
                    isAdmin.isSelected(),
                    text_fullName.getText(),
                    text_position.getText()
            );
            userCreate = true;
            closeCurrentStage(actionEvent);
        }
        else {
            label_alarm_user.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_user.setText("Заполните обязательные поля");
        }
    }

    public void showPasswordChar() {
        if(!text_password.isVisible()){
            text_password.setText(passField_password.getText());
            text_password.setVisible(true);
            passField_password.clear();
            passField_password.setVisible(false);
        }
        else {
            passField_password.setText(text_password.getText());
            passField_password.setVisible(true);
            text_password.clear();
            text_password.setVisible(false);
        }
    }

    private Boolean isEmptyFields() {
        HashSet<Boolean> set = new HashSet<>();
        set.add(MemberUtils.isEmptyField(text_login));
        if(text_password.isVisible()) {
            set.add(MemberUtils.isEmptyField(text_password));
        } else {
            set.add(MemberUtils.isEmptyField(passField_password));
        }
        set.add(MemberUtils.isEmptyField(text_fullName));
        set.add(MemberUtils.isEmptyField(text_position));
        return set.contains(true);
    }

    public void closeCurrentStage(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
