package ru.src.logic.controllers;

import javafx.collections.FXCollections;
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
import ru.src.logic.implementation.*;
import ru.src.model.Connection;
import ru.src.model.User;

import java.io.IOException;
import java.util.HashMap;

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

    private Connection connection;
    private ObservableList<User> users;
    private HashMap<String, User> userHashMap = new HashMap<>();

    private Stage createUserStage;
    private Parent createUser;
    private FXMLLoader createUserFXMLLoader = new FXMLLoader();
    private CreateUserController createUserController;

    @FXML
    public void initialize() {
        fillConnectionParams();

        text_password.clear();
        text_password.setVisible(false);

        column_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        column_fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));

        users = FXCollections.observableArrayList();
        users.addAll(DBConnection.getAllUser());

        users.forEach(user -> {
            userHashMap.put(user.getLogin(), user);
        });

        table_users.setItems(users);

        initCreateUserForm();


    }

    private void initCreateUserForm() {
        try {
            createUserFXMLLoader.setLocation(getClass().getResource("/ui/User/CreateUser.fxml"));
            createUser = createUserFXMLLoader.load();
            createUserController = createUserFXMLLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillConnectionParams() {
        connection = ConnectionUtils.getConnection();
        text_hostName.setText(connection.getHostname());
        text_dataBase.setText(connection.getDatabase());
        text_port.setText(connection.getPort());
        text_userName.setText(connection.getUsername());
        passField_password.setText(connection.getPassword());
    }

    public void clear() {
        text_password.clear();
        text_userName.clear();
        text_port.clear();
        text_dataBase.clear();
        text_hostName.clear();
        passField_password.clear();
    }

    @FXML
    public void saveConnection(ActionEvent actionEvent) {
        String pass = "";
        if(text_password.isVisible()) pass = text_password.getText();
        if(passField_password.isVisible()) pass = passField_password.getText();

        ConnectionUtils.setConnection(text_hostName.getText(),
                text_dataBase.getText(),
                text_port.getText(),
                text_userName.getText(),
                pass
        );
        HibernateUtils.closeSessionFactory();
        try {
            MainFormController.memberOrganizations.refresh();
            HibernateUtils.isActive = true;
            closeApp(actionEvent);
        }
        catch (HibernateException e) {
            MemberException.getCheckSqlException(e);
            HibernateUtils.isActive = false;
        }
    }

    @FXML
    public void closeApp(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void showPasswordChar(ActionEvent actionEvent) {

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
        System.out.println("text " + text_password.isVisible());
        System.out.println("pass " + passField_password.isVisible());

    }


    public void addUser(ActionEvent actionEvent) {
        if(createUserStage == null) {
            createUserStage = new Stage();
            createUserStage.setScene(new Scene(createUser));
        }
        createUserStage.showAndWait();

        if(createUserController.getUserCreate()) {
            User newUser = createUserController.getNewUser();
            createUserController.Clear();
            try {
                users.add(newUser);
                DBConnection.addUser(newUser);
                MemberUtils.informationDialog("Пользователь успешно добавлен!");
            } catch (Exception e) {
                MemberUtils.warningDialog("Возникла ошибка : \n" + e.getMessage());
            }
        }
    }

    public void editUser(ActionEvent actionEvent) {
    }

    public void deleteUser(ActionEvent actionEvent) {
    }
}
