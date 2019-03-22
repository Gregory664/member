package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.src.logic.dto.CheckBoxGroup;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.MemberUtils;
import ru.src.logic.implementation.PDFUtils;
import ru.src.model.FindMember;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static ru.src.logic.implementation.ListUtils.getDataFromCheckBoxMassive;

public class SelectController {
    @FXML
    public TableView<FindMember> table_select;
    @FXML
    public TableColumn<FindMember, String> column_memberId;
    @FXML
    public TableColumn<FindMember, String> column_memberSerial;
    @FXML
    public TableColumn<FindMember, String> column_contactPhone;
    @FXML
    public TableColumn<FindMember, String> column_memberStatus;
    @FXML
    public TableColumn<FindMember, String> column_memberShortName;

    @FXML
    public Label countOfselect;

    @FXML
    public Label label_memberStatus;
    @FXML
    public Label label_businessForm;
    @FXML
    public Label label_debt_status;
    @FXML
    public Label label_organizationForm;
    @FXML
    public Label label_ownershipForm;
    @FXML
    public Label label_activityType;
    @FXML
    public Label label_economicSector;
    @FXML
    public Label label_vedImport;
    @FXML
    public Label label_vedExport;
    @FXML
    public Label label_interactionOnline;
    @FXML
    public Label label_interactionOffline;
    @FXML
    public Label label_b2b;
    @FXML
    public Label label_b2c;
    @FXML
    public Label label_businessMissionVisiting;
    @FXML
    public Label label_businessMissionRegional;
    @FXML
    public Label label_mkas;
    @FXML
    public Label label_needForYoungPersonnel;
    @FXML
    public Label label_discounts;
    @FXML
    public Label label_reliablePartners;
    @FXML
    public Label label_pilotProjects;
    @FXML
    public Label label_antiCorruptionCharter;
    @FXML
    public Label label_newsletter;
    @FXML
    public Label label_committees;
    @FXML
    public Label label_corporateMember;

    @FXML
    public Button btn_clear;
    @FXML
    public Button btn_search;
    @FXML
    public Label label_location;
    @FXML
    public Label label_month;
    @FXML
    public Label label_receiving;

    @FXML
    public CheckBox checkBox_memberstatus_1;
    @FXML
    public CheckBox checkBox_memberstatus_2;
    @FXML
    public CheckBox checkBox_memberstatus_3;
    @FXML
    public CheckBox checkBox_memberstatus_4;
    @FXML
    public CheckBox checkBox_memberstatus_5;
    @FXML
    public CheckBox checkBox_memberstatus_6;
    @FXML
    public CheckBox checkBox_memberstatus_7;
    @FXML
    public CheckBox checkBox_memberstatus_8;
    @FXML
    public CheckBox checkBox_memberstatus_9;
    @FXML
    public CheckBox checkBox_memberstatus_10;


    @FXML
    public CheckBox checkBox_businessForm_1;
    @FXML
    public CheckBox checkBox_businessForm_2;
    @FXML
    public CheckBox checkBox_businessForm_3;
    @FXML
    public CheckBox checkBox_businessForm_4;

    @FXML
    public CheckBox checkBox_debt_status_1;
    @FXML
    public CheckBox checkBox_debt_status_2;

    @FXML
    public CheckBox checkBox_organizationForm_1;
    @FXML
    public CheckBox checkBox_organizationForm_2;
    @FXML
    public CheckBox checkBox_organizationForm_4;
    @FXML
    public CheckBox checkBox_organizationForm_3;
    @FXML
    public CheckBox checkBox_organizationForm_6;
    @FXML
    public CheckBox checkBox_organizationForm_7;
    @FXML
    public CheckBox checkBox_organizationForm_8;
    @FXML
    public CheckBox checkBox_organizationForm_9;
    @FXML
    public CheckBox checkBox_organizationForm_5;
    @FXML
    public CheckBox checkBox_organizationForm_10;
    @FXML
    public CheckBox checkBox_organizationForm_11;
    @FXML
    public CheckBox checkBox_organizationForm_12;
    @FXML
    public CheckBox checkBox_organizationForm_13;
    @FXML
    public CheckBox checkBox_organizationForm_14;
    @FXML
    public CheckBox checkBox_organizationForm_15;
    @FXML
    public CheckBox checkBox_organizationForm_16;
    @FXML
    public CheckBox checkBox_organizationForm_17;
    @FXML
    public CheckBox checkBox_organizationForm_18;

    @FXML
    public CheckBox checkBox_ownershipForm_1;
    @FXML
    public CheckBox checkBox_ownershipForm_2;
    @FXML
    public CheckBox checkBox_ownershipForm_3;

    @FXML
    public CheckBox checkBox_activityType_1;
    @FXML
    public CheckBox checkBox_activityType_2;

    @FXML
    public CheckBox checkBox_economicSector_1;
    @FXML
    public CheckBox checkBox_economicSector_2;
    @FXML
    public CheckBox checkBox_economicSector_3;
    @FXML
    public CheckBox checkBox_economicSector_4;
    @FXML
    public CheckBox checkBox_economicSector_5;
    @FXML
    public CheckBox checkBox_economicSector_6;
    @FXML
    public CheckBox checkBox_economicSector_7;
    @FXML
    public CheckBox checkBox_economicSector_8;
    @FXML
    public CheckBox checkBox_economicSector_9;
    @FXML
    public CheckBox checkBox_economicSector_10;
    @FXML
    public CheckBox checkBox_economicSector_11;
    @FXML
    public CheckBox checkBox_economicSector_12;
    @FXML
    public CheckBox checkBox_economicSector_13;
    @FXML
    public CheckBox checkBox_economicSector_14;
    @FXML
    public CheckBox checkBox_economicSector_15;
    @FXML
    public CheckBox checkBox_economicSector_16;
    @FXML
    public CheckBox checkBox_economicSector_17;
    @FXML
    public CheckBox checkBox_economicSector_18;
    @FXML
    public CheckBox checkBox_economicSector_19;
    @FXML
    public CheckBox checkBox_economicSector_20;

    @FXML
    public CheckBox checkBox_vedImport_1;
    @FXML
    public CheckBox checkBox_vedImport_0;

    @FXML
    public CheckBox checkBox_vedExport_1;
    @FXML
    public CheckBox checkBox_vedExport_0;

    @FXML
    public CheckBox checkBox_interactionOnline_1;
    @FXML
    public CheckBox checkBox_interactionOnline_0;

    @FXML
    public CheckBox checkBox_interactionOffline_1;
    @FXML
    public CheckBox checkBox_interactionOffline_0;

    @FXML
    public CheckBox checkBox_b2b_1;
    @FXML
    public CheckBox checkBox_b2b_0;

    @FXML
    public CheckBox checkBox_b2c_1;
    @FXML
    public CheckBox checkBox_b2c_0;

    @FXML
    public CheckBox checkBox_businessMissionVisiting_1;
    @FXML
    public CheckBox checkBox_businessMissionVisiting_0;

    @FXML
    public CheckBox checkBox_businessMissionRegional_1;
    @FXML
    public CheckBox checkBox_businessMissionRegional_0;

    @FXML
    public CheckBox checkBox_mkas_1;
    @FXML
    public CheckBox checkBox_mkas_0;

    @FXML
    public CheckBox checkBox_needForYoungPersonnel_1;
    @FXML
    public CheckBox checkBox_needForYoungPersonnel_0;
    @FXML
    public CheckBox checkBox_discounts_1;
    @FXML
    public CheckBox checkBox_discounts_0;
    @FXML
    public CheckBox checkBox_reliablePartners_1;
    @FXML
    public CheckBox checkBox_reliablePartners_0;
    @FXML
    public CheckBox checkBox_pilotProjects_1;
    @FXML
    public CheckBox checkBox_pilotProjects_0;
    @FXML
    public CheckBox checkBox_antiCorruptionCharter_1;
    @FXML
    public CheckBox checkBox_antiCorruptionCharter_0;

    @FXML
    public AnchorPane anchor_General;
    @FXML
    public AnchorPane anchor_BusinessCharacteristics;
    @FXML
    public AnchorPane anchor_Interests;

    @FXML
    public CheckBox checkBox_location_1;
    @FXML
    public CheckBox checkBox_location_2;
    @FXML
    public CheckBox checkBox_location_3;
    @FXML
    public CheckBox checkBox_month_1;
    @FXML
    public CheckBox checkBox_month_2;
    @FXML
    public CheckBox checkBox_month_3;
    @FXML
    public CheckBox checkBox_month_4;
    @FXML
    public CheckBox checkBox_month_5;
    @FXML
    public CheckBox checkBox_month_6;
    @FXML
    public CheckBox checkBox_month_7;
    @FXML
    public CheckBox checkBox_month_8;
    @FXML
    public CheckBox checkBox_month_9;
    @FXML
    public CheckBox checkBox_month_10;
    @FXML
    public CheckBox checkBox_month_11;
    @FXML
    public CheckBox checkBox_month_12;

    @FXML
    public Label label_payment;
    @FXML
    public CheckBox checkBox_payment_1;
    @FXML
    public CheckBox checkBox_payment_2;
    @FXML
    public DatePicker date_payment_1;
    @FXML
    public DatePicker date_payment_2;

    @FXML
    public CheckBox checkBox_receiving_1;
    @FXML
    public CheckBox checkBox_receiving_2;
    @FXML
    public DatePicker date_receiving_1;
    @FXML
    public DatePicker date_receiving_2;

    @FXML
    public CheckBox checkBox_services_1;
    @FXML
    public CheckBox checkBox_services_2;
    @FXML
    public CheckBox checkBox_services_3;
    @FXML
    public CheckBox checkBox_services_4;
    @FXML
    public CheckBox checkBox_services_5;
    @FXML
    public CheckBox checkBox_services_6;
    @FXML
    public CheckBox checkBox_services_7;
    @FXML
    public CheckBox checkBox_services_8;
    @FXML
    public CheckBox checkBox_services_9;
    @FXML
    public CheckBox checkBox_services_10;
    @FXML
    public CheckBox checkBox_services_11;
    @FXML
    public CheckBox checkBox_services_12;
    @FXML
    public CheckBox checkBox_services_13;
    @FXML
    public CheckBox checkBox_services_15;
    @FXML
    public CheckBox checkBox_services_14;
    @FXML
    public CheckBox checkBox_services_16;
    @FXML
    public CheckBox checkBox_services_17;

    @FXML
    public CheckBox checkBox_newsletter_1;
    @FXML
    public CheckBox checkBox_newsletter_0;

    @FXML
    public CheckBox checkBox_committees_1;
    @FXML
    public CheckBox checkBox_committees_0;

    @FXML
    public CheckBox checkBox_corporateMember_1;
    @FXML
    public CheckBox checkBox_corporateMember_0;

    @FXML
    public MenuItem item_savePDF;
    @FXML
    public MenuItem item_saveCSV;
    @FXML
    public Button btn_close;

    private List<CheckBoxGroup> generalsGroups = new ArrayList<>();
    private List<CheckBoxGroup> businessCharacteristicsGroups = new ArrayList<>();
    private List<CheckBoxGroup> interestsGroups = new ArrayList<>();
    private List<CheckBoxGroup> withDateGroups = new ArrayList<>();

    private List<DatePicker> listDatePayment = new ArrayList<>();
    private List<DatePicker> listDateReceiving = new ArrayList<>();
    private List<CheckBox> servicesCheckBoxList = new LinkedList<>();

    private ObservableList<FindMember> list = FXCollections.observableArrayList();

    private Stage currentStage = new Stage();

    @FXML
    public void initialize() {
        column_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_memberSerial.setCellValueFactory(new PropertyValueFactory<>("memberSerial"));
        column_contactPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_memberStatus.setCellValueFactory(new PropertyValueFactory<>("memberStatus"));
        column_memberShortName.setCellValueFactory(new PropertyValueFactory<>("memberShortName"));

        column_memberId.setStyle("-fx-alignment: CENTER;");
        column_memberSerial.setStyle("-fx-alignment: CENTER;");
        column_contactPhone.setStyle("-fx-alignment: CENTER;");
        column_memberStatus.setStyle("-fx-alignment: CENTER;");

        table_select.setPlaceholder(new Label("Нет данных, удовлетворяющих критериям"));

        countOfselect.setText("Количество организаций: " + list.size());
        item_saveCSV.setDisable(true);
        item_savePDF.setDisable(true);

        list.addListener((ListChangeListener<FindMember>) c -> {
            countOfselect.setText("Количество организаций: " + list.size());
            if (list.size() == 0) {
                item_saveCSV.setDisable(true);
                item_savePDF.setDisable(true);
            } else {
                item_saveCSV.setDisable(false);
                item_savePDF.setDisable(false);
            }
        });

        addEachCheckBoxesToEachLists();

        addListenersForLabels(interestsGroups);
        addListenersForLabels(generalsGroups);
        addListenersForLabels(businessCharacteristicsGroups);
        addListenersWithDates(withDateGroups);

        addListenerForAnchor(anchor_Interests, interestsGroups);
        addListenerForAnchor(anchor_BusinessCharacteristics, businessCharacteristicsGroups);
        addListenerForAnchor(anchor_General, generalsGroups);
    }

    private void addEachCheckBoxesToEachLists() {

        listDatePayment = Arrays.asList(date_payment_1, date_payment_2);
        withDateGroups.add(new CheckBoxGroup(label_payment, Arrays.asList(checkBox_payment_1, checkBox_payment_2), listDatePayment,
                "i.INVOICE_STATUS_OF_PAYMENT", 7));


        listDateReceiving = Arrays.asList(date_receiving_1, date_receiving_2);
        withDateGroups.add(new CheckBoxGroup(label_receiving, Arrays.asList(checkBox_receiving_1, checkBox_receiving_2), listDateReceiving,
                "i.INVOICE_STATUS_OF_RECEIVING", 8));

        interestsGroups.add(new CheckBoxGroup(label_antiCorruptionCharter, Arrays.asList(checkBox_antiCorruptionCharter_0, checkBox_antiCorruptionCharter_1),
                "gi.ANTI_CORRUPTION_CHARTER", 2));

        interestsGroups.add(new CheckBoxGroup(label_pilotProjects, Arrays.asList(checkBox_pilotProjects_0, checkBox_pilotProjects_1),
                "gi.PILOT_PROJECTS", 2));

        interestsGroups.add(new CheckBoxGroup(label_reliablePartners, Arrays.asList(checkBox_reliablePartners_0, checkBox_reliablePartners_1),
                "gi.RELIABLE_PARTNERS", 2));

        interestsGroups.add(new CheckBoxGroup(label_discounts, Arrays.asList(checkBox_discounts_0, checkBox_discounts_1),
                "gi.DISCOUNTS", 2));

        interestsGroups.add(new CheckBoxGroup(label_needForYoungPersonnel, Arrays.asList(checkBox_needForYoungPersonnel_0, checkBox_needForYoungPersonnel_1),
                "gi.NEED_FOR_YOUNG_PERSONNEL", 2));

        interestsGroups.add(new CheckBoxGroup(label_mkas, Arrays.asList(checkBox_mkas_0, checkBox_mkas_1),
                "gi.MKAS", 2));

        interestsGroups.add(new CheckBoxGroup(label_businessMissionRegional, Arrays.asList(checkBox_businessMissionRegional_0, checkBox_businessMissionRegional_1),
                "gi.BUSINESS_MISSION_REGIONAL", 2));

        interestsGroups.add(new CheckBoxGroup(label_businessMissionVisiting, Arrays.asList(checkBox_businessMissionVisiting_0, checkBox_businessMissionVisiting_1),
                "gi.BUSINESS_MISSION_VISITING", 2));

        interestsGroups.add(new CheckBoxGroup(label_b2c, Arrays.asList(checkBox_b2c_0, checkBox_b2c_1),
                "gi.B2C", 2));

        interestsGroups.add(new CheckBoxGroup(label_b2b, Arrays.asList(checkBox_b2b_0, checkBox_b2b_1),
                "gi.B2B", 2));

        interestsGroups.add(new CheckBoxGroup(label_interactionOffline, Arrays.asList(checkBox_interactionOffline_0, checkBox_interactionOffline_1),
                "gi.INTERACTION_OFFLINE", 2));

        interestsGroups.add(new CheckBoxGroup(label_interactionOnline, Arrays.asList(checkBox_interactionOnline_0, checkBox_interactionOnline_1),
                "gi.INTERACTION_ONLINE", 2));

        interestsGroups.add(new CheckBoxGroup(label_vedExport, Arrays.asList(checkBox_vedExport_0, checkBox_vedExport_1),
                "gi.VED_EXPORT", 2));

        interestsGroups.add(new CheckBoxGroup(label_vedImport, Arrays.asList(checkBox_vedImport_0, checkBox_vedImport_1),
                "gi.VED_IMPORT", 2));

        interestsGroups.add(new CheckBoxGroup(label_newsletter, Arrays.asList(checkBox_newsletter_0, checkBox_newsletter_1),
                "gi.NEWSLETTER", 2));

        interestsGroups.add(new CheckBoxGroup(label_committees, Arrays.asList(checkBox_committees_0, checkBox_committees_1),
                "gi.COMMITTEES", 2));

        interestsGroups.add(new CheckBoxGroup(label_corporateMember, Arrays.asList(checkBox_corporateMember_0, checkBox_corporateMember_1),
                "gi.CORPORATE_MEMBER", 2));

        generalsGroups.add(new CheckBoxGroup(label_month,
                Arrays.asList(checkBox_month_1, checkBox_month_2, checkBox_month_3, checkBox_month_4, checkBox_month_5, checkBox_month_6, checkBox_month_7, checkBox_month_8, checkBox_month_9, checkBox_month_10, checkBox_month_11, checkBox_month_12),
                "month(MEMBER_DATE_OF_ENTRY)", 6));

        generalsGroups.add(new CheckBoxGroup(label_location, Arrays.asList(checkBox_location_1, checkBox_location_2, checkBox_location_3),
                "al.ADDRESS_LEGAL_REGION_ID;al.ADDRESS_LEGAL_DISTRICT", 5));

        generalsGroups.add(new CheckBoxGroup(label_debt_status, Arrays.asList(checkBox_debt_status_1, checkBox_debt_status_2),
                "d.DEBT_STATUS", 3));

        generalsGroups.add(new CheckBoxGroup(label_memberStatus,
                Arrays.asList(checkBox_memberstatus_1, checkBox_memberstatus_2, checkBox_memberstatus_3, checkBox_memberstatus_4, checkBox_memberstatus_5, checkBox_memberstatus_6, checkBox_memberstatus_7, checkBox_memberstatus_8, checkBox_memberstatus_9, checkBox_memberstatus_10),
                "m.MEMBER_STATUS", 1));

        businessCharacteristicsGroups.add(new CheckBoxGroup(label_economicSector,
                Arrays.asList(checkBox_economicSector_1, checkBox_economicSector_2, checkBox_economicSector_3, checkBox_economicSector_4, checkBox_economicSector_5, checkBox_economicSector_6, checkBox_economicSector_7, checkBox_economicSector_8, checkBox_economicSector_9, checkBox_economicSector_10, checkBox_economicSector_11, checkBox_economicSector_12, checkBox_economicSector_13, checkBox_economicSector_14, checkBox_economicSector_15, checkBox_economicSector_16, checkBox_economicSector_17, checkBox_economicSector_18, checkBox_economicSector_19, checkBox_economicSector_20),
                "gi.ECONOMIC_SECTOR", 1));

        businessCharacteristicsGroups.add(new CheckBoxGroup(label_activityType, Arrays.asList(checkBox_activityType_1, checkBox_activityType_2),
                "gi.ACTIVITY_TYPE", 1));

        businessCharacteristicsGroups.add(new CheckBoxGroup(label_ownershipForm, Arrays.asList(checkBox_ownershipForm_1, checkBox_ownershipForm_2, checkBox_ownershipForm_3),
                "gi.OWNERSHIP_FORM", 1));

        businessCharacteristicsGroups.add(new CheckBoxGroup(label_organizationForm,
                Arrays.asList(checkBox_organizationForm_1, checkBox_organizationForm_2, checkBox_organizationForm_3, checkBox_organizationForm_4, checkBox_organizationForm_5, checkBox_organizationForm_6, checkBox_organizationForm_7, checkBox_organizationForm_8, checkBox_organizationForm_9, checkBox_organizationForm_10, checkBox_organizationForm_11, checkBox_organizationForm_12, checkBox_organizationForm_13, checkBox_organizationForm_14, checkBox_organizationForm_15, checkBox_organizationForm_16, checkBox_organizationForm_17, checkBox_organizationForm_18),
                "gi.ORGANIZATION_FORM", 1));

        businessCharacteristicsGroups.add(new CheckBoxGroup(label_businessForm, Arrays.asList(checkBox_businessForm_1, checkBox_businessForm_2, checkBox_businessForm_3, checkBox_businessForm_4),
                "gi.BUSINESS_FORM", 1));


        servicesCheckBoxList.addAll(Arrays.asList(checkBox_services_1, checkBox_services_2, checkBox_services_3, checkBox_services_4, checkBox_services_5, checkBox_services_6, checkBox_services_7, checkBox_services_8, checkBox_services_9, checkBox_services_10, checkBox_services_11, checkBox_services_12, checkBox_services_13, checkBox_services_14, checkBox_services_15, checkBox_services_16, checkBox_services_17));
    }

    private void addListenerForAnchor(AnchorPane anchorPane, List<CheckBoxGroup> groupList) {
        anchorPane.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 5) {
                changeStateForAllCheckBoxesInGroup(groupList, true);
            }
        });
    }

    private void addListenersForLabels(List<CheckBoxGroup> groupList) {
        for (CheckBoxGroup checkBoxGroup : groupList) {
            checkBoxGroup.getLabel().setOnMouseClicked(event -> {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                    checkBoxGroup.changeState();
                }
            });
        }
    }

    private void addListenersWithDates(List<CheckBoxGroup> groupList) {
        for (CheckBoxGroup checkBoxGroup : groupList) {
            checkBoxGroup.getLabel().setOnMouseClicked(event -> {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                    checkBoxGroup.changeState();
                }
                for (CheckBox checkBox : checkBoxGroup.getCheckBoxes()) {
                    checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> disableDates(checkBoxGroup.getDatePickers(), !newValue));
                }
            });
        }
    }

    private void changeStateForAllCheckBoxesInGroup(List<CheckBoxGroup> groupList, boolean newValue) {
        groupList.forEach(checkBoxGroup -> checkBoxGroup.changeState(newValue));
    }

    private void disableDates(List<DatePicker> datePickers, boolean value) {
        for (DatePicker datePicker : datePickers) {
            datePicker.setDisable(value);
            datePicker.getEditor().clear();
        }
    }

    public void clearAllFields() {
        changeStateForAllCheckBoxesInGroup(interestsGroups, false);
        changeStateForAllCheckBoxesInGroup(generalsGroups, false);
        changeStateForAllCheckBoxesInGroup(businessCharacteristicsGroups, false);
        changeStateForAllCheckBoxesInGroup(withDateGroups, false);
        servicesCheckBoxList.forEach(checkBox -> checkBox.setSelected(false));
        list.clear();
    }

    @FXML
    public void search() {
        list.clear();
        list.addAll(DBConnection.getQueryList(getResultQuery()));
        table_select.setItems(list);
    }

    private String getResultQuery() {
        ArrayList<String> whereList = new ArrayList<>();

        for (CheckBoxGroup group : interestsGroups) {
            whereList.add(getWherePartFromList(group.getCheckBoxes(), group.getWherePattern(), group.getWhereFlag()));
        }
        for (CheckBoxGroup group : generalsGroups) {
            whereList.add(getWherePartFromList(group.getCheckBoxes(), group.getWherePattern(), group.getWhereFlag()));
        }
        for (CheckBoxGroup group : businessCharacteristicsGroups) {
            whereList.add(getWherePartFromList(group.getCheckBoxes(), group.getWherePattern(), group.getWhereFlag()));
        }
        for (CheckBoxGroup group : withDateGroups) {
            whereList.add(getWherePartFromList(group.getCheckBoxes(), group.getWherePattern(), group.getWhereFlag()));
        }

        whereList.add(getWherePartFromDate(listDatePayment, "i.INVOICE_ORDER_DATE;i.INVOICE_DATE_OF_CREATION"));
        whereList.add(getWherePartFromDate(listDateReceiving, "i.INVOICE_DATE_OF_RECEIVING;i.INVOICE_DATE_OF_RECEIVING"));
        whereList.add(getWherePartFromServices());

        whereList.removeIf(String::isEmpty);


        String selectQuery = "SELECT DISTINCT m.MEMBER_ID, " +
                "m.MEMBER_SERIAL, " +
                "c.CONTACT_PHONE, " +
                "m.MEMBER_STATUS, " +
                "m.MEMBER_SHORT_NAME, " +
                "c.CONTACT_EMAIL \n" +
                "FROM MEMBER m \n" +
                "INNER JOIN CONTACT c ON m.MEMBER_ID=c.MEMBER_ID " +
                "INNER JOIN DEBT d ON m.MEMBER_ID=d.MEMBER_ID " +
                "INNER JOIN GENERAL_INFORMATION gi ON m.MEMBER_ID=gi.MEMBER_ID " +
                "INNER JOIN ADDRESS_LEGAL al ON m.MEMBER_ID=al.MEMBER_ID " +
                "LEFT JOIN INVOICE i ON m.MEMBER_ID=i.MEMBER_ID " +
                "LEFT JOIN MEMBER_SERVICES ms ON m.MEMBER_ID = ms.MEMBER_ID \n";
        String wherePart = whereList.isEmpty() ? "" : "WHERE " + getAppendWhereQuery(whereList) + ";";
        return selectQuery + wherePart;
    }

    private String getWherePartFromList(List<CheckBox> checkBoxes, String pattern, int flag) {
        String result = "";

        List<String> someSelect = new ArrayList<>();
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                switch (flag) {
                    case 1:
                        someSelect.add(pattern + " = '" + checkBox.getText() + "'");
                        break;
                    case 2:
                        someSelect.add(pattern + " = " + MemberUtils.checkBoxIDToBoolean(checkBox));
                        break;
                    case 3:
                        someSelect.add(pattern + " = " + MemberUtils.debtToBoolean(checkBox.getText()));
                        break;
                    case 5:
                        String[] splitPattern = pattern.split(";");
                        if (checkBox.getText().equals("Иногородние")) {
                            someSelect.add(splitPattern[0] + " != 36");
                        }
                        if (checkBox.getText().equals("Воронеж")) {
                            someSelect.add(splitPattern[0] + " = 36 AND " + splitPattern[1] + " = 'Воронеж Городской округ'");
                        }
                        if (checkBox.getText().equals("Воронежская область")) {
                            someSelect.add(splitPattern[0] + " = 36 AND " + splitPattern[1] + " != 'Воронеж Городской округ'");
                        }
                        break;
                    case 6:
                        someSelect.add(pattern + " = " + ListUtils.getMonth().get(checkBox.getText()));
                        break;
                    case 7:
                        someSelect.add(pattern + " = " + MemberUtils.paymentToBoolean(checkBox.getText()));
                        break;
                    case 8:
                        someSelect.add(pattern + " = " + MemberUtils.receiveToBoolean(checkBox.getText()));
                        break;
                }
            }
        }

        if (!someSelect.isEmpty()) {
            result = String.join(" OR ", someSelect);
        }
        return result;
    }

    private String getWherePartFromDate(List<DatePicker> datePickers, String pattern) {
        String result = "";

        List<String> someSelect = new ArrayList<>();
        String[] splitPattern = pattern.split(";");

        if (checkBox_payment_1.isSelected() && !checkBox_payment_2.isSelected()) {
            if (!(datePickers.get(0).getValue() == null)) {
                someSelect.add(splitPattern[0] + " >= '" + datePickers.get(0).getValue().toString() + "'");
            }
            if (!(datePickers.get(1).getValue() == null)) {
                someSelect.add(splitPattern[0] + " <= '" + datePickers.get(1).getValue().toString() + "'");
            }
        }
        if (!checkBox_payment_1.isSelected() && checkBox_payment_2.isSelected()) {
            if (!(datePickers.get(0).getValue() == null)) {
                someSelect.add(splitPattern[1] + " >= '" + datePickers.get(0).getValue().toString() + "'");
            }
            if (!(datePickers.get(1).getValue() == null)) {
                someSelect.add(splitPattern[1] + " <= '" + datePickers.get(1).getValue().toString() + "'");
            }
        }

        if (!someSelect.isEmpty()) {
            result = String.join(" AND ", someSelect);
        }
        return result;
    }

    private String getWherePartFromServices() {
        List<String> numberOfSelectedServices = servicesCheckBoxList.stream()
                .filter(checkBox -> checkBox.isSelected())
                .map(checkBox -> String.valueOf(servicesCheckBoxList.indexOf(checkBox) + 1))
                .collect(Collectors.toList());
        if (numberOfSelectedServices.isEmpty()) {
            return "";
        }
        return "ms.SERVICES_ID IN(" + String.join(",", numberOfSelectedServices) + ") GROUP BY m.MEMBER_ID HAVING COUNT(*)=" + numberOfSelectedServices.size();
    }

    private String getAppendWhereQuery(List<String> list) {
        StringBuilder result = new StringBuilder();

        int lastElement = list.size() - 1;
        for (int i = 0; i < lastElement; i++) {
            result.append("(").append(list.get(i)).append(") AND ");
        }
        result.append(list.get(lastElement));
        return result.toString();
    }

    @FXML
    public void saveToPDF() {
        List<String[]> listSelectedParams = new ArrayList<>();

        for (CheckBoxGroup group : interestsGroups) {
            listSelectedParams.add(getDataFromCheckBoxMassive(group.getLabel().getText(), group.getCheckBoxes()));
        }
        for (CheckBoxGroup group : generalsGroups) {
            listSelectedParams.add(getDataFromCheckBoxMassive(group.getLabel().getText(), group.getCheckBoxes()));
        }
        for (CheckBoxGroup group : businessCharacteristicsGroups) {
            listSelectedParams.add(getDataFromCheckBoxMassive(group.getLabel().getText(), group.getCheckBoxes()));
        }
        for (CheckBoxGroup group : withDateGroups) {
            listSelectedParams.add(getDataFromCheckBoxMassive(group.getLabel().getText(), group.getCheckBoxes()));
        }

        listSelectedParams.add(getDataFromCheckBoxMassive("Интересующие услуги", servicesCheckBoxList));

        listSelectedParams.removeIf(Objects::isNull);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("pdf", "*.pdf"));
        File file = fileChooser.showSaveDialog(currentStage);

        if (file != null) {
            String path = file.getAbsolutePath();
            if (!path.contains(".")) {
                path += ".pdf";
            }
            PDFUtils.savePDFfromFindResult(path, list, listSelectedParams);
        }
    }

    @FXML
    public void saveCSV() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv", "*.csv"));
        File file = fileChooser.showSaveDialog(currentStage);

        if (file != null) {
            String path = file.getAbsolutePath();
            if (!path.contains(".")) {
                path += ".csv";
            }
            saveCSVFile(path);
        }
    }

    private void saveCSVFile(String pathName) {
        try (FileWriter writer = new FileWriter(pathName)) {
            writer.append("Номер билета;Почта;Сокрашенное название организации\n");

            for (FindMember findMember : list) {
                writer.append(findMember.getMemberId()).append(";");
                writer.append(findMember.getEmail()).append(";");
                writer.append(findMember.getMemberShortName()).append("\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void closeCurrentStage(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}