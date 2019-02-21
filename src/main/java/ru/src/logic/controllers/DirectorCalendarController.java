package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.model.DirectorCalendar;

import java.time.LocalDate;
import java.util.HashMap;

public class DirectorCalendarController {
    @FXML
    public ComboBox<String> comboBox_month;
    @FXML
    public TableView<DirectorCalendar> table_director;
    @FXML
    public TableColumn<DirectorCalendar, String> column_memberId;
    @FXML
    public TableColumn<DirectorCalendar, String> column_name;
    @FXML
    public TableColumn<DirectorCalendar, String> column_shortName;
    @FXML
    public TableColumn<DirectorCalendar, LocalDate> column_birthday;

    private ObservableList<String> month = FXCollections.observableArrayList();
    private HashMap<Integer, String> monthMap = ListUtils.getMonth();

    @FXML
    public void initialize() {
        initComboBoxMonth();
        column_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        column_name.setCellValueFactory(new PropertyValueFactory<>("fio"));
        column_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_shortName.setCellValueFactory(new PropertyValueFactory<>("shortName"));

        column_birthday.setStyle("-fx-alignment: CENTER;");
        column_name.setStyle("-fx-alignment: CENTER;");
        column_memberId.setStyle("-fx-alignment: CENTER;");
        column_shortName.setStyle("-fx-alignment: CENTER;");
    }

    private void initComboBoxMonth() {
        month.addAll(monthMap.values());
        comboBox_month.getItems().addAll(month);
    }


    public void selectMonth(ActionEvent actionEvent) {
        int month = comboBox_month.getSelectionModel().getSelectedIndex();
        ObservableList<DirectorCalendar> directorCalendars = DBConnection.getDirectorCalendar(++month);
        table_director.getItems().clear();
        if(directorCalendars != null)
            table_director.setItems(directorCalendars);
    }
}
