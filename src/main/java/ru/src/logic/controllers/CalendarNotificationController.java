package ru.src.logic.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.MemberUtils;

public class CalendarNotificationController {
    @FXML
    public Label label_directorBirthday;
    @FXML
    public Label label_organizationBirthday;
    @FXML
    public Label label_directorBirthday_count;
    @FXML
    public Label label_organizationBirthday_count;

    private Stage calendarStage;
    private CalendarController calendarController;


    @FXML
    public void initialize() {
        label_directorBirthday_count.setText(DBConnection.getCountOfDirectorBirthdayToday().toString());
        label_organizationBirthday_count.setText(DBConnection.getCountOfOrganizationBirthdayToday().toString());
    }

    public void setCalendarParams(Stage calendarStage, CalendarController calendarController) {
        this.calendarStage = calendarStage;
        this.calendarController = calendarController;
    }

    @FXML
    public void openDirectorCalendar(MouseEvent mouseEvent) {
        calendarController.setCurrentMonth(0);
        calendarStage.show();
    }
    @FXML
    public void openOrganizationCalendar(MouseEvent mouseEvent) {
        calendarController.setCurrentMonth(1);
        calendarStage.show();
    }
}
