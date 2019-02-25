package ru.src.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import ru.src.logic.implementation.HibernateUtils;


public class Solution extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/ui/MainForm.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon.png")));
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("F11"));
        primaryStage.setMaximized(true);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> exitApplication(primaryStage));
    }

    private void exitApplication(Stage primaryStage) {
        HibernateUtils.closeSessionFactory();
        primaryStage.close();
    }
}


