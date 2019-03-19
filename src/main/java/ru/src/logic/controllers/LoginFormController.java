package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.HibernateUtils;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.User;

import java.io.IOException;

public class LoginFormController {
    @FXML
    public PasswordField passField_password;
    @FXML
    public TextField text_login;
    @FXML
    public Label label_alarm;
    @FXML
    public Button btn_enter;
    @FXML
    public AnchorPane anchor;
    @FXML
    public MenuBar menu;
    @FXML
    public MenuItem item_settings;

    private Stage mainFormStage;
    private Parent mainForm;
    private FXMLLoader mainFormFXMLLoader = new FXMLLoader();
    private MainFormController mainFormController;

    private User user;
    public User getUser() {
        return user;
    }

    @FXML
    public void initialize() {
        menu.setVisible(false);

        item_settings.setAccelerator(new KeyCodeCombination(KeyCode.ENTER,
                KeyCombination.CONTROL_DOWN,
                KeyCombination.ALT_DOWN,
                KeyCombination.SHIFT_DOWN));
    }

    public void enter(ActionEvent actionEvent) {
        label_alarm.setText(null);
        String login = text_login.getText();
        String password = MemberUtils.getPasswordHash(passField_password.getText());

        if(DBConnection.isPairLoginAndPasswordCorrect(login, password)) {
                user = DBConnection.getUser(login);
                initializeMainForm();
                checkInitMainFormStage();
                closeCurrentStage(actionEvent);
                mainFormController.setUser(user);
                mainFormStage.show();
                mainFormStage.setOnCloseRequest(event -> exitApp(actionEvent));
        } else {
            label_alarm.setText("Проверьте пару логин/пароль");
            label_alarm.setTextFill(MemberUtils.EMPTY_COLOR);
        }
    }

    private void initializeMainForm() {
        try {
            mainFormFXMLLoader.setLocation(getClass().getResource("/ui/MainForm.fxml"));
            mainForm = mainFormFXMLLoader.load();
            mainFormController = mainFormFXMLLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeCurrentStage(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    private void checkInitMainFormStage() {
        if(mainFormStage == null) {
            mainFormStage = new Stage();
            mainFormStage.setScene(new Scene(mainForm));
            mainFormStage.setMaximized(true);
            mainFormStage.setTitle("ИС ТПП ВО");
        }
    }

    private void exitApp(ActionEvent actionEvent) {
        HibernateUtils.closeSessionFactory();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void openSettings() {
        Stage settingsStage;
        FXMLLoader settingsFxmlLoader = new FXMLLoader();
        Parent settings = null;

        try {
            settingsFxmlLoader.setLocation(getClass().getResource("/ui/Settings.fxml"));
            settings = settingsFxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        settingsStage = new Stage();
        settingsStage.setScene(new Scene(settings));
        settingsStage.setTitle("Настройки");

        settingsStage.show();
    }
}
