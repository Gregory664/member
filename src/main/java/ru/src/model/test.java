package ru.src.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ru.src.logic.implementation.*;

public class test  extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/ui/User/CreateUser.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/ui/User/CreateUser.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon.png")));
        //primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("F11"));
        //primaryStage.setMaximized(true);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> exitApplication(primaryStage));
    }

    private void exitApplication(Stage primaryStage) {
        HibernateUtils.closeSessionFactory();
        primaryStage.close();
    }
}
