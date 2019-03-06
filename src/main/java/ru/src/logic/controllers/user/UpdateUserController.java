package ru.src.logic.controllers.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.User;

import java.io.IOException;
import java.util.HashSet;

public class UpdateUserController {
    @FXML
    public TextField text_login;
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
    public PasswordField passField_password;
    @FXML
    public PasswordField passField_password2;
    @FXML
    public GridPane grid_password;
    @FXML
    public AnchorPane anchor;
    @FXML
    public Button btn_updatePassword;

    private Boolean isUpdateUser = false;
    public Boolean getUpdateUser() {
        return isUpdateUser;
    }

    private User user;
    public void setUser(User user) {
        this.user = user;
        fillFields();
    }
    public User getUser() {
        return user;
    }

    @FXML
    public void initialize() {
        grid_password.setVisible(false);
        grid_password.setMinHeight(0);
        grid_password.setMaxHeight(0);
    }

    private void fillFields() {
        text_fullName.setText(user.getFullName());
        text_login.setText(user.getLogin());
        text_position.setText(user.getPosition());
        isAdmin.setSelected(user.getAdmin());
    }

    private Boolean isEmptyFields() {
        HashSet<Boolean> set = new HashSet<>();
        set.add(MemberUtils.isEmptyField(text_fullName));
        set.add(MemberUtils.isEmptyField(text_position));
        if(grid_password.isVisible()) {
            set.add(MemberUtils.isEmptyField(passField_password));
            set.add(MemberUtils.isEmptyField(passField_password2));
        }
        return set.contains(true);
    }

    public void Clear() {
        label_alarm_user.setText(null);
        text_login.clear();
        text_fullName.clear();
        text_position.clear();
        passField_password.clear();
        passField_password2.clear();
        isAdmin.setSelected(false);
        isUpdateUser = false;
    }

    public void updateUser(ActionEvent actionEvent) {
        if(!isEmptyFields()) {
            if(passField_password.getText().equals(passField_password2.getText())) {
                user.setFullName(text_fullName.getText());
                user.setPosition(text_position.getText());
                user.setAdmin(isAdmin.isSelected());
                System.out.println(passField_password2.getText());
                if (grid_password.isVisible()) user.setPassword(MemberUtils.getPasswordHash(passField_password2.getText()));
                isUpdateUser = true;
                closeApp(actionEvent);
            } else {
                label_alarm_user.setText("Пароли не совпадают");
                isUpdateUser = false;
            }
        } else  {
            label_alarm_user.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_user.setText("Заполните обязательные поля");
        }
    }

    public void closeApp(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void updatePassword(ActionEvent actionEvent) {
        if(grid_password.isVisible()) {
            grid_password.setVisible(false);
            grid_password.setMinHeight(0);
            grid_password.setMaxHeight(0);
            resizeWindows(291 + 28, actionEvent);
        }
        else {
            grid_password.setVisible(true);
            grid_password.setMinHeight(84);
            grid_password.setMaxHeight(84);
            resizeWindows(375 + 28, actionEvent);
        }
        passField_password.clear();
        passField_password2.clear();
    }

    public void resizeWindows(double heigth, ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setMinHeight(heigth);
        stage.setMaxHeight(heigth);
    }
}
