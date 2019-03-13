package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import ru.src.logic.controllers.user.CreateUserController;
import ru.src.logic.controllers.user.UpdateUserController;
import ru.src.logic.implementation.*;
import ru.src.model.User;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class SettingsController {
    @FXML
    public TextField text_hostName;
    @FXML
    public TextField text_userName;
    @FXML
    public TextField text_port;
    @FXML
    public TextField text_dataBase;
    @FXML
    public PasswordField passField_password;
    @FXML
    public Button button_show;
    @FXML
    public TextField text_password;
    @FXML
    public Button button_saveConnection;
    @FXML
    public Button button_close;

    @FXML
    public TableView<User> table_users;
    @FXML
    public TableColumn<User, String> column_login;
    @FXML
    public TableColumn<User, String> column_fullName;
    @FXML
    public MenuItem item_addUser;
    @FXML
    public MenuItem item_editUser;
    @FXML
    public MenuItem item_deleteUser;


    private boolean changeSettingFromMainForm = false;
    public void setChangeSettingFromMainForm(boolean changeSettingFromMainForm) {
        this.changeSettingFromMainForm = changeSettingFromMainForm;
    }

    private ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        users.addListener((ListChangeListener<User>) c -> checkCountOfUsers());

        text_password.clear();
        text_password.setVisible(false);

        column_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        column_fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        users.addAll(DBConnection.getAllUser());
        table_users.setItems(users);

        fillConnectionParams();
    }

    @FXML
    public void saveConnection(ActionEvent actionEvent) {
        if(HibernateUtils.isActive()) HibernateUtils.closeSessionFactory();

        ConnectionUtils.setConnection(text_hostName.getText(),
                text_dataBase.getText(),
                text_port.getText(),
                text_userName.getText(),
                getPasswordFromCurrentTextBox()
        );

        try {
            ConnectionUtils.checkConnection();
            if(changeSettingFromMainForm) MainFormController.memberOrganizations.refresh();
            closeCurrentStage(actionEvent);
        }
        catch (HibernateException e) {
            MemberException.getCheckSqlException(e);
        }
    }

    @FXML
    public void addUser() {
        Parent createUser = null;
        CreateUserController createUserController = null;

        try {
            FXMLLoader createUserFXMLLoader = new FXMLLoader();
            createUserFXMLLoader.setLocation(getClass().getResource("/ui/User/CreateUser.fxml"));
            createUser = createUserFXMLLoader.load();
            createUserController = createUserFXMLLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage createUserStage = new Stage();
        createUserStage.setScene(new Scene(Objects.requireNonNull(createUser)));
        createUserStage.setResizable(false);
        createUserStage.setTitle("Добавление пользователя");

        createUserStage.showAndWait();

        if (createUserController.isUserCreate()) {
            User newUser = createUserController.getNewUser();
            try {
                users.add(newUser);
                DBConnection.addUser(newUser);
                MemberUtils.informationDialog("Пользователь успешно добавлен!");
            } catch (Exception e) {
                MemberUtils.warningDialog("Возникла ошибка : \n" + e.getMessage());
            }
        }
    }

    @FXML
    public void editUser() {
        Parent updateUser = null;
        UpdateUserController updateUserController = null;

        try {
            FXMLLoader updateUserFXMLLoader = new FXMLLoader();
            updateUserFXMLLoader.setLocation(getClass().getResource("/ui/User/UpdateUser.fxml"));
            updateUser = updateUserFXMLLoader.load();
            updateUserController = updateUserFXMLLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage updateUserStage = new Stage();
        updateUserStage.setScene(new Scene(Objects.requireNonNull(updateUser)));
        updateUserStage.setResizable(false);
        updateUserStage.setTitle("Изменение пользователя");

        User selectedUser = table_users.getSelectionModel().getSelectedItem();
        updateUserController.setUser(selectedUser);
        updateUserStage.showAndWait();

        if (updateUserController.getUpdateUser()) {
            ListUtils.updateUser(users, selectedUser);
            DBConnection.updateUser(selectedUser);
            MemberUtils.informationDialog("Пользователь успешно обновлен!");
        }
    }

    @FXML
    public void deleteUser() {
        User selectedUser = table_users.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление организации");
        alert.setHeaderText(null);
        alert.setContentText("Вы действительно хотите пользователя:\n" +
                selectedUser.getFullName() + " ?");

        Optional<ButtonType> response = alert.showAndWait();
        if(response.isPresent() && response.get() == ButtonType.OK) {
            DBConnection.removeUser(selectedUser);
            users.remove(selectedUser);
            MemberUtils.informationDialog("Пользователь успешно удален!");
        }
    }

    @FXML
    public void closeCurrentStage(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
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

    private String getPasswordFromCurrentTextBox() {
        return text_password.isVisible() ? text_password.getText() : passField_password.getText();
    }

    private void fillConnectionParams() {
        text_hostName.setText(ConnectionUtils.getConnection().getHostname());
        text_dataBase.setText(ConnectionUtils.getConnection().getDatabase());
        text_port.setText(ConnectionUtils.getConnection().getPort());
        text_userName.setText(ConnectionUtils.getConnection().getUsername());
        passField_password.setText(ConnectionUtils.getConnection().getPassword());
    }

    private void checkCountOfUsers() {
        if(users.size() > 0) {
            item_addUser.setDisable(false);
            item_deleteUser.setDisable(false);
            item_editUser.setDisable(false);
        } else {
            item_deleteUser.setDisable(true);
            item_editUser.setDisable(true);
        }
    }
}
