package ru.src.logic.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import ru.src.logic.implementation.DBConnection;
import java.io.IOException;

public class CalendarNotificationController {
    @FXML
    public Label label_directorBirthday;
    @FXML
    public Label label_organizationBirthday;
    @FXML
    public Label label_directorBirthday_count;
    @FXML
    public Label label_organizationBirthday_count;

    private FXMLLoader calendarFXMLLoader = new FXMLLoader();
    private Parent calendar;
    private CalendarController calendarController;
    private Stage calendarStage;

    private TableView mainTableView;

    public void setMainTableView(TableView mainTableView) {
        this.mainTableView = mainTableView;
        calendarController.setParams(mainTableView);
    }

    @FXML
    public void initialize() {
        label_directorBirthday_count.setText(DBConnection.getCountOfDirectorBirthdayToday().toString());
        label_organizationBirthday_count.setText(DBConnection.getCountOfOrganizationBirthdayToday().toString());

        initializeCalendar();
    }

    private void initializeCalendar() {
        try {
            calendarFXMLLoader.setLocation(getClass().getResource("/ui/Calendar.fxml"));
            calendar = calendarFXMLLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        calendarStage = new Stage();
        calendarStage.setScene(new Scene(calendar));
        calendarStage.setTitle("Календарь");
        calendarController = calendarFXMLLoader.getController();
    }
    @FXML
    public void openDirectorCalendar() {
        calendarController.setCurrentMonth(0);
        calendarStage.show();
    }
    @FXML
    public void openOrganizationCalendar() {
        calendarController.setCurrentMonth(1);
        calendarStage.show();
    }
}
