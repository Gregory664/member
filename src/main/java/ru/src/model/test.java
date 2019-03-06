package ru.src.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ru.src.logic.implementation.*;

public class test {
    public static void main(String[] args) {
//        DBConnection.addUser(new User("test",
//                MemberUtils.getPasswordHash("test"),
//                true,
//                "Иванов Иван Иванович",
//                "Руководитель отдела"));
        System.out.println(DBConnection.getUser("test"));
        System.out.println(DBConnection.isUserLoginExist("test"));
        HibernateUtils.closeSessionFactory();
    }

}
