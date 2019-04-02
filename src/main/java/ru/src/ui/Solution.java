package ru.src.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.src.logic.implementation.ConnectionUtils;
import ru.src.logic.factory.HibernateUtils;

public class Solution extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/LoginForm.fxml"));
        primaryStage.setTitle("Вход в ИС ТПП ВО");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        ConnectionUtils.activateConnection();

        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> exitApplication(primaryStage));
    }

    private void exitApplication(Stage primaryStage) {
        if(HibernateUtils.isActive()) HibernateUtils.closeSessionFactory();
        primaryStage.close();
    }
}


