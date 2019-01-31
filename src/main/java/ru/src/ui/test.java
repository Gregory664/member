package ru.src.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import ru.src.logic.implementation.HibernateUtils;


public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/ui/MainForm.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/ui/MainForm_v2.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> exitApplication(primaryStage));
    }

    private void exitApplication(Stage primaryStage) {
        HibernateUtils.closeSessionFactory();
        primaryStage.close();
    }
}


