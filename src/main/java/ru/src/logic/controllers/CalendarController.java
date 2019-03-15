package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.model.DateOfCreationOrganization;
import ru.src.model.DirectorCalendar;
import ru.src.model.Member;
import java.time.LocalDate;
import java.util.Optional;

public class CalendarController {
    @FXML
    public TabPane tabPane;
    @FXML
    public Tab tab_director;
    @FXML
    public ComboBox<String> comboBox_directorMonth;
    @FXML
    public TableView<DirectorCalendar> table_director;
    @FXML
    public TableColumn<DirectorCalendar, String> column_directorBirthday;
    @FXML
    public TableColumn<DirectorCalendar, String> column_directorName;
    @FXML
    public TableColumn<DirectorCalendar, String> column_directorMemberId;
    @FXML
    public TableColumn<DirectorCalendar, String> column_directorShortName;
    @FXML
    public Tab tab_organization;
    @FXML
    public ComboBox<String> comboBox_organizationMonth;
    @FXML
    public TableView<DateOfCreationOrganization> table_organization;
    @FXML
    public TableColumn<DateOfCreationOrganization, LocalDate> column_organizationDateOfCreation;
    @FXML
    public TableColumn<DateOfCreationOrganization, String> column_organizationMemberId;
    @FXML
    public TableColumn<DateOfCreationOrganization, String> column_organizationShortName;

    private ObservableList<String> month = FXCollections.observableArrayList(ListUtils.getMonth().values());
    private TableView<Member> mainFormTable;

    void setParams(TableView params) {
        this.mainFormTable = params;
    }

    @FXML
    public void initialize() {
        comboBox_directorMonth.getItems().addAll(month);
        comboBox_organizationMonth.getItems().addAll(month);

        column_directorBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        column_directorName.setCellValueFactory(new PropertyValueFactory<>("fio"));
        column_directorMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_directorShortName.setCellValueFactory(new PropertyValueFactory<>("shortName"));
        column_directorBirthday.setStyle("-fx-alignment: CENTER;");
        column_directorName.setStyle("-fx-alignment: CENTER;");
        column_directorMemberId.setStyle("-fx-alignment: CENTER;");
        column_directorShortName.setStyle("-fx-alignment: CENTER;");

        column_organizationDateOfCreation.setCellValueFactory(new PropertyValueFactory<>("dateOfCreation"));
        column_organizationMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_organizationShortName.setCellValueFactory(new PropertyValueFactory<>("shortName"));
        column_organizationDateOfCreation.setStyle("-fx-alignment: CENTER;");
        column_organizationMemberId.setStyle("-fx-alignment: CENTER;");
        column_organizationShortName.setStyle("-fx-alignment: CENTER;");
    } 

    public void selectOrganizationMonth() {
        int month = comboBox_organizationMonth.getSelectionModel().getSelectedIndex();
        ObservableList<DateOfCreationOrganization> organizations = DBConnection.getOrganizationCalendar(++month);
        table_organization.getItems().clear();
        if (organizations != null)
            table_organization.setItems(organizations);
    } 

    public void selectDirectorMonth() {
        int month = comboBox_directorMonth.getSelectionModel().getSelectedIndex();
        ObservableList<DirectorCalendar> directorCalendars = DBConnection.getDirectorCalendar(++month);
        table_director.getItems().clear();
        if (directorCalendars != null)
            table_director.setItems(directorCalendars);
    } 

    void setCurrentMonth(int tab) {
        comboBox_directorMonth.getSelectionModel().select(LocalDate.now().getMonth().getValue() - 1);
        comboBox_organizationMonth.getSelectionModel().select(LocalDate.now().getMonth().getValue() - 1);
        selectDirectorMonth();
        selectOrganizationMonth();

        switch (tab) {
            case 0:
                tabPane.getSelectionModel().select(0);
                break;
            case 1:
                tabPane.getSelectionModel().select(1);
                break;
        }
    } 

    public void openMainTableFromDirector(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2) {
            String memberId = table_director.getSelectionModel().getSelectedItem().getMemberId();

            Optional<Member> selectedMember = mainFormTable.getItems().stream()
                    .filter(member -> member.getMemberId().equals(memberId))
                    .findFirst();
            selectedMember.ifPresent(member -> mainFormTable.getSelectionModel().select(member));
        }
    } 

    public void openMainTableFromOrganization(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2) {
            String memberId = table_organization.getSelectionModel().getSelectedItem().getMemberId();

            Optional<Member> selectedMember = mainFormTable.getItems().stream()
                    .filter(member -> member.getMemberId().equals(memberId))
                    .findFirst();
            selectedMember.ifPresent(member -> mainFormTable.getSelectionModel().select(member));
        }
    } 
}
