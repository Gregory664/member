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
import ru.src.model.DateOfCreationOrganization;

import java.time.LocalDate;
import java.util.HashMap;

public class DateOfCreationCalendarController {
    @FXML
    public ComboBox<String> comboBox_month;
    @FXML
    public TableView<DateOfCreationOrganization> table_organization;
    @FXML
    public TableColumn<DateOfCreationOrganization, LocalDate> column_dateOfCreation;
    @FXML
    public TableColumn<DateOfCreationOrganization, String> column_memberId;
    @FXML
    public TableColumn<DateOfCreationOrganization, String> column_shortName;

    private ObservableList<String> month = FXCollections.observableArrayList();
    private HashMap<Integer, String> monthMap = ListUtils.getMonth();

    @FXML
    public void initialize() {
        initComboBoxMonth();
        column_dateOfCreation.setCellValueFactory(new PropertyValueFactory<>("dateOfCreation"));
        column_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_shortName.setCellValueFactory(new PropertyValueFactory<>("shortName"));

        column_dateOfCreation.setStyle("-fx-alignment: CENTER;");
        column_memberId.setStyle("-fx-alignment: CENTER;");
        column_shortName.setStyle("-fx-alignment: CENTER;");
    }

    private void initComboBoxMonth() {
        month.addAll(monthMap.values());
        comboBox_month.getItems().addAll(month);
    }

    public void selectMonth(ActionEvent actionEvent) {
        int month = comboBox_month.getSelectionModel().getSelectedIndex();
        ObservableList<DateOfCreationOrganization> organizations = DBConnection.getOrganization(++month);
        table_organization.getItems().clear();
        if(organizations != null)
            table_organization.setItems(organizations);
    }
}
