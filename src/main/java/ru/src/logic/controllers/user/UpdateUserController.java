package ru.src.logic.controllers.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    private Stage updatePasswordStage;
    private Parent updatePassword;
    private FXMLLoader updatePasswordFXMLLoader = new FXMLLoader();
    private UpdatePasswordController updatePasswordController;

    @FXML
    public void initialize() {
        try {
            updatePasswordFXMLLoader.setLocation(getClass().getResource("/ui/User/UpdatePassword.fxml"));
            updatePassword = updatePasswordFXMLLoader.load();
            updatePasswordController = updatePasswordFXMLLoader.getController();


        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return set.contains(true);
    }

    public void Clear() {
        text_login.clear();
        text_fullName.clear();
        text_position.clear();
        isAdmin.setSelected(false);
        isUpdateUser = false;
    }

    public void updateUser(ActionEvent actionEvent) {
        if(!isEmptyFields()) {
            user.setFullName(text_fullName.getText());
            user.setPosition(text_position.getText());
            isUpdateUser = true;
            closeApp(actionEvent);

        } else  {
            label_alarm_user.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_user.setText("Заполните обязательные поля");
        }
    }

    public void closeApp(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void updatePassword(ActionEvent actionEvent) {
        if(updatePasswordStage == null) {
            updatePasswordStage = new Stage();
            updatePasswordStage.setScene(new Scene(updatePassword));
            updatePasswordStage.setResizable(false);
            updatePasswordStage.setTitle("Смена пароля");
        }
        updatePasswordStage.showAndWait();
        if(updatePasswordController.isPasswordUpdate()) {
            isUpdateUser = true;
            user.setPassword(MemberUtils.getPasswordHash(updatePasswordController.getPassword()));
            MemberUtils.informationDialog("Пароль успешно обновлен");
        }
        updatePasswordController.clear();
    }
}
