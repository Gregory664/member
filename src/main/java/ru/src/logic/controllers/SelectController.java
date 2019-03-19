package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.MemberUtils;
import ru.src.logic.implementation.PDFUtils;
import ru.src.model.FindMember;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

    private boolean isEmptyCBMemberStatus = false;
    private boolean isEmptyBusinessForm = false;
    private boolean isEmptyDebtStatus = false;
    private boolean isEmptyOrganizationForm = false;
    private boolean isEmptyOwnershipForm = false;
    private boolean isEmptyActivityTypeForm = false;
    private boolean isEmptyEconomicSector = false;
    private boolean isEmptyVedImport = false;
    private boolean isEmptyVedExport = false;
    private boolean isEmptyInteractionOnline = false;
    private boolean isEmptyInteractionOffline = false;
    private boolean isEmptyB2b = false;
    private boolean isEmptyB2c = false;
    private boolean isEmptyBusinessMissionVisiting = false;
    private boolean isEmptybusinessMissionRegional = false;
    private boolean isEmptyMkas = false;
    private boolean isEmptyNeedForYoungPersonnel = false;
    private boolean isEmptyDiscounts = false;
    private boolean isEmptyReliablePartners = false;
    private boolean isEmptyPilotProjects = false;
    private boolean isEmptyAntiCorruptionCharter = false;
    private boolean isEmptyNewsletter = false;
    private boolean isEmptyCommittees = false;
    private boolean isEmptyCorporateMember = false;

    private boolean isEmptyLocation = false;
    private boolean isEmptyMonth = false;
    private boolean isEmptyPayment = false;
    private boolean isEmptyReceiving = false;

    private ArrayList<CheckBox> listMemberStatus = new ArrayList<>();
    private ArrayList<CheckBox> listBusinessForm = new ArrayList<>();
    private ArrayList<CheckBox> listDebtStatus = new ArrayList<>();
    private ArrayList<CheckBox> listOrganizationForm = new ArrayList<>();
    private ArrayList<CheckBox> listOwnershipForm = new ArrayList<>();
    private ArrayList<CheckBox> listActivityType = new ArrayList<>();
    private ArrayList<CheckBox> listEconomicSector = new ArrayList<>();
    private ArrayList<CheckBox> listVedImport = new ArrayList<>();
    private ArrayList<CheckBox> listVedExport = new ArrayList<>();
    private ArrayList<CheckBox> listInteractionOnline = new ArrayList<>();
    private ArrayList<CheckBox> listInteractionOffline = new ArrayList<>();
    private ArrayList<CheckBox> listB2b = new ArrayList<>();
    private ArrayList<CheckBox> listB2c = new ArrayList<>();
    private ArrayList<CheckBox> listBusinessMissionVisiting = new ArrayList<>();
    private ArrayList<CheckBox> listBusinessMissionRegional = new ArrayList<>();
    private ArrayList<CheckBox> listMkas = new ArrayList<>();
    private ArrayList<CheckBox> listNeedForYoungPersonnel = new ArrayList<>();
    private ArrayList<CheckBox> listDiscounts = new ArrayList<>();
    private ArrayList<CheckBox> listReliablePartners = new ArrayList<>();
    private ArrayList<CheckBox> listPilotProjects = new ArrayList<>();
    private ArrayList<CheckBox> listAntiCorruptionCharter = new ArrayList<>();
    private ArrayList<CheckBox> listLocation = new ArrayList<>();
    private ArrayList<CheckBox> listMonth = new ArrayList<>();
    private ArrayList<CheckBox> listPayment = new ArrayList<>();
    private ArrayList<DatePicker> listDatePayment = new ArrayList<>();
    private ArrayList<CheckBox> listReceiving = new ArrayList<>();
    private ArrayList<DatePicker> listDateReceiving = new ArrayList<>();
    private ArrayList<CheckBox> listNewsletter = new ArrayList<>();
    private ArrayList<CheckBox> listCommittees = new ArrayList<>();
    private ArrayList<CheckBox> listCorporateMember = new ArrayList<>();

    private HashMap<Integer, CheckBox> servicesCheckBoxMap = new HashMap<>();
    private ObservableList<FindMember> list = FXCollections.observableArrayList();

    private Stage currentStage;

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

        addMemberStatusListener();
        addBusinessFormListener();
        addDebtStatusListener();
        addOrganizationFormListener();
        addOwnershipFormListener();
        addActivityTypeListener();
        addEconomicSectorListener();
        addVedImportListener();
        addVedExportExportListener();
        addInteractionOnlineListener();
        addInteractionOfflineListener();
        addB2bListener();
        addB2cListener();
        addBusinessMissionVisitingListener();
        addbusinessMissionRegionalListener();
        addMkasListener();
        addLocationListener();
        addAntiCorruptionCharterListener();
        addPilotProjectsListener();
        addReliablePartnersListener();
        addDiscountsListener();
        addNeedForYoungPersonnelListener();
        addMonthListener();
        addPaymentListener();
        addReceivingListener();
        addNewsletterListener();
        addCommitteesListener();
        addCorporateMemberListener();

        addSelectAllGeneralCheckBox();
        addSelectAllBusinessCharacteristicsCheckBox();
        addSelectAllInterestsCheckBox();
    }


    private void addSelectAllInterestsCheckBox() {
        anchor_Interests.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 5) {
                    selectVedImport(true);
                    selectVedExport(true);
                    selectB2b(true);
                    selectB2c(true);
                    selectBusinessMissionVisiting(true);
                    selectBusinessMissionRegional(true);
                    selectMkas(true);
                    selectAntiCorruptionCharter(true);
                    selectPilotProjects(true);
                    selectReliablePartners(true);
                    selectDiscounts(true);
                    selectNeedForYoungPersonnel(true);
                    selectNewsletter(true);
                    selectCommittees(true);
                    selectCorporateMember(true);
                    selectInteractionOnline(true);
                    selectInteractionOffline(true);
                }
            }
        });
    }

    private void addSelectAllBusinessCharacteristicsCheckBox() {
        anchor_BusinessCharacteristics.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 5) {
                    selectEconomicSector(true);
                    selectOrganizationForm(true);
                    selectOwnershipForm(true);
                    selectActivityType(true);
                    selectBusinessForm(true);
                }
            }
        });
    }

    private void addSelectAllGeneralCheckBox() {
        anchor_General.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 5) {
                    selectMemberStatus(true);
                    selectDebtStatus(true);
                    selectLocation(true);
                    selectMonth(true);
                }
            }
        });
    }


    private void addEachCheckBoxesToEachLists() {
        listDatePayment.add(date_payment_1);
        listDatePayment.add(date_payment_2);

        listPayment.add(checkBox_payment_1);
        listPayment.add(checkBox_payment_2);

        listMonth.add(checkBox_month_1);
        listMonth.add(checkBox_month_2);
        listMonth.add(checkBox_month_3);
        listMonth.add(checkBox_month_4);
        listMonth.add(checkBox_month_5);
        listMonth.add(checkBox_month_6);
        listMonth.add(checkBox_month_7);
        listMonth.add(checkBox_month_8);
        listMonth.add(checkBox_month_9);
        listMonth.add(checkBox_month_10);
        listMonth.add(checkBox_month_11);
        listMonth.add(checkBox_month_12);

        listLocation.add(checkBox_location_1);
        listLocation.add(checkBox_location_2);
        listLocation.add(checkBox_location_3);

        listAntiCorruptionCharter.add(checkBox_antiCorruptionCharter_1);
        listAntiCorruptionCharter.add(checkBox_antiCorruptionCharter_0);

        listPilotProjects.add(checkBox_pilotProjects_1);
        listPilotProjects.add(checkBox_pilotProjects_0);

        listReliablePartners.add(checkBox_reliablePartners_1);
        listReliablePartners.add(checkBox_reliablePartners_0);

        listDiscounts.add(checkBox_discounts_1);
        listDiscounts.add(checkBox_discounts_0);

        listNeedForYoungPersonnel.add(checkBox_needForYoungPersonnel_1);
        listNeedForYoungPersonnel.add(checkBox_needForYoungPersonnel_0);

        listMkas.add(checkBox_mkas_1);
        listMkas.add(checkBox_mkas_0);

        listBusinessMissionRegional.add(checkBox_businessMissionRegional_1);
        listBusinessMissionRegional.add(checkBox_businessMissionRegional_0);

        listBusinessMissionVisiting.add(checkBox_businessMissionVisiting_1);
        listBusinessMissionVisiting.add(checkBox_businessMissionVisiting_0);

        listB2c.add(checkBox_b2c_1);
        listB2c.add(checkBox_b2c_0);

        listB2b.add(checkBox_b2b_1);
        listB2b.add(checkBox_b2b_0);

        listInteractionOffline.add(checkBox_interactionOffline_1);
        listInteractionOffline.add(checkBox_interactionOffline_0);

        listInteractionOnline.add(checkBox_interactionOnline_1);
        listInteractionOnline.add(checkBox_interactionOnline_0);

        listVedExport.add(checkBox_vedExport_1);
        listVedExport.add(checkBox_vedExport_0);

        listVedImport.add(checkBox_vedImport_1);
        listVedImport.add(checkBox_vedImport_0);

        listEconomicSector.add(checkBox_economicSector_1);
        listEconomicSector.add(checkBox_economicSector_2);
        listEconomicSector.add(checkBox_economicSector_3);
        listEconomicSector.add(checkBox_economicSector_4);
        listEconomicSector.add(checkBox_economicSector_5);
        listEconomicSector.add(checkBox_economicSector_6);
        listEconomicSector.add(checkBox_economicSector_7);
        listEconomicSector.add(checkBox_economicSector_8);
        listEconomicSector.add(checkBox_economicSector_9);
        listEconomicSector.add(checkBox_economicSector_10);
        listEconomicSector.add(checkBox_economicSector_11);
        listEconomicSector.add(checkBox_economicSector_12);
        listEconomicSector.add(checkBox_economicSector_13);
        listEconomicSector.add(checkBox_economicSector_14);
        listEconomicSector.add(checkBox_economicSector_15);
        listEconomicSector.add(checkBox_economicSector_16);
        listEconomicSector.add(checkBox_economicSector_17);
        listEconomicSector.add(checkBox_economicSector_18);
        listEconomicSector.add(checkBox_economicSector_19);
        listEconomicSector.add(checkBox_economicSector_20);

        listActivityType.add(checkBox_activityType_1);
        listActivityType.add(checkBox_activityType_2);

        listOwnershipForm.add(checkBox_ownershipForm_1);
        listOwnershipForm.add(checkBox_ownershipForm_2);
        listOwnershipForm.add(checkBox_ownershipForm_3);

        listOrganizationForm.add(checkBox_organizationForm_1);
        listOrganizationForm.add(checkBox_organizationForm_2);
        listOrganizationForm.add(checkBox_organizationForm_3);
        listOrganizationForm.add(checkBox_organizationForm_4);
        listOrganizationForm.add(checkBox_organizationForm_5);
        listOrganizationForm.add(checkBox_organizationForm_6);
        listOrganizationForm.add(checkBox_organizationForm_7);
        listOrganizationForm.add(checkBox_organizationForm_8);
        listOrganizationForm.add(checkBox_organizationForm_9);
        listOrganizationForm.add(checkBox_organizationForm_10);
        listOrganizationForm.add(checkBox_organizationForm_11);
        listOrganizationForm.add(checkBox_organizationForm_12);
        listOrganizationForm.add(checkBox_organizationForm_13);
        listOrganizationForm.add(checkBox_organizationForm_14);
        listOrganizationForm.add(checkBox_organizationForm_15);
        listOrganizationForm.add(checkBox_organizationForm_16);
        listOrganizationForm.add(checkBox_organizationForm_17);
        listOrganizationForm.add(checkBox_organizationForm_18);

        listDebtStatus.add(checkBox_debt_status_1);
        listDebtStatus.add(checkBox_debt_status_2);

        listBusinessForm.add(checkBox_businessForm_1);
        listBusinessForm.add(checkBox_businessForm_2);
        listBusinessForm.add(checkBox_businessForm_3);
        listBusinessForm.add(checkBox_businessForm_4);

        listMemberStatus.add(checkBox_memberstatus_1);
        listMemberStatus.add(checkBox_memberstatus_2);
        listMemberStatus.add(checkBox_memberstatus_3);
        listMemberStatus.add(checkBox_memberstatus_4);
        listMemberStatus.add(checkBox_memberstatus_5);
        listMemberStatus.add(checkBox_memberstatus_6);
        listMemberStatus.add(checkBox_memberstatus_7);
        listMemberStatus.add(checkBox_memberstatus_8);
        listMemberStatus.add(checkBox_memberstatus_9);
        listMemberStatus.add(checkBox_memberstatus_10);

        listReceiving.add(checkBox_receiving_1);
        listReceiving.add(checkBox_receiving_2);

        listDateReceiving.add(date_receiving_1);
        listDateReceiving.add(date_receiving_2);

        servicesCheckBoxMap.put(1, checkBox_services_1);
        servicesCheckBoxMap.put(2, checkBox_services_2);
        servicesCheckBoxMap.put(3, checkBox_services_3);
        servicesCheckBoxMap.put(4, checkBox_services_4);
        servicesCheckBoxMap.put(5, checkBox_services_5);
        servicesCheckBoxMap.put(6, checkBox_services_6);
        servicesCheckBoxMap.put(7, checkBox_services_7);
        servicesCheckBoxMap.put(8, checkBox_services_8);
        servicesCheckBoxMap.put(9, checkBox_services_9);
        servicesCheckBoxMap.put(10, checkBox_services_10);
        servicesCheckBoxMap.put(11, checkBox_services_11);
        servicesCheckBoxMap.put(12, checkBox_services_12);
        servicesCheckBoxMap.put(13, checkBox_services_13);
        servicesCheckBoxMap.put(14, checkBox_services_14);
        servicesCheckBoxMap.put(15, checkBox_services_15);
        servicesCheckBoxMap.put(16, checkBox_services_16);
        servicesCheckBoxMap.put(17, checkBox_services_17);

        listNewsletter.add(checkBox_newsletter_1);
        listNewsletter.add(checkBox_newsletter_0);

        listCommittees.add(checkBox_committees_1);
        listCommittees.add(checkBox_committees_0);

        listCorporateMember.add(checkBox_corporateMember_1);
        listCorporateMember.add(checkBox_corporateMember_0);
    }

    private void addMemberStatusListener() {
        label_memberStatus.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyCBMemberStatus) {
                        selectMemberStatus(true);
                        isEmptyCBMemberStatus = true;
                    } else {
                        selectMemberStatus(false);
                        isEmptyCBMemberStatus = false;
                    }
                }
            }
        });
    }

    private void addBusinessFormListener() {
        label_businessForm.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyBusinessForm) {
                        selectBusinessForm(true);
                        isEmptyBusinessForm = true;
                    } else {
                        selectBusinessForm(false);
                        isEmptyBusinessForm = false;
                    }
                }
            }
        });
    }

    private void addDebtStatusListener() {
        label_debt_status.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyDebtStatus) {
                        selectDebtStatus(true);
                        isEmptyDebtStatus = true;
                    } else {
                        selectDebtStatus(false);
                        isEmptyDebtStatus = false;
                    }
                }
            }
        });
    }

    private void addOrganizationFormListener() {
        label_organizationForm.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyOrganizationForm) {
                        selectOrganizationForm(true);
                        isEmptyOrganizationForm = true;
                    } else {
                        selectOrganizationForm(false);
                        isEmptyOrganizationForm = false;
                    }
                }
            }
        });
    }

    private void addOwnershipFormListener() {
        label_ownershipForm.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyOwnershipForm) {
                        selectOwnershipForm(true);
                        isEmptyOwnershipForm = true;
                    } else {
                        selectOwnershipForm(false);
                        isEmptyOwnershipForm = false;
                    }
                }
            }
        });
    }

    private void addActivityTypeListener() {
        label_activityType.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyActivityTypeForm) {
                        selectActivityType(true);
                        isEmptyActivityTypeForm = true;
                    } else {
                        selectActivityType(false);
                        isEmptyActivityTypeForm = false;
                    }
                }
            }
        });
    }

    private void addEconomicSectorListener() {
        label_economicSector.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyEconomicSector) {
                        selectEconomicSector(true);
                        isEmptyEconomicSector = true;
                    } else {
                        selectEconomicSector(false);
                        isEmptyEconomicSector = false;
                    }
                }
            }
        });
    }

    private void addVedImportListener() {
        label_vedImport.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyVedImport) {
                        selectVedImport(true);
                        isEmptyVedImport = true;
                    } else {
                        selectVedImport(false);
                        isEmptyVedImport = false;
                    }
                }
            }
        });
    }

    private void addVedExportExportListener() {
        label_vedExport.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyVedExport) {
                        selectVedExport(true);
                        isEmptyVedExport = true;
                    } else {
                        selectVedExport(false);
                        isEmptyVedExport = false;
                    }
                }
            }
        });
    }

    private void addInteractionOnlineListener() {
        label_interactionOnline.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyInteractionOnline) {
                        selectInteractionOnline(true);
                        isEmptyInteractionOnline = true;
                    } else {
                        selectInteractionOnline(false);
                        isEmptyInteractionOnline = false;
                    }
                }
            }
        });
    }

    private void addInteractionOfflineListener() {
        label_interactionOffline.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyInteractionOffline) {
                        selectInteractionOffline(true);
                        isEmptyInteractionOffline = true;
                    } else {
                        selectInteractionOffline(false);
                        isEmptyInteractionOffline = false;
                    }
                }
            }
        });
    }

    private void addB2bListener() {
        label_b2b.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyB2b) {
                        selectB2b(true);
                        isEmptyB2b = true;
                    } else {
                        selectB2b(false);
                        isEmptyB2b = false;
                    }
                }
            }
        });
    }

    private void addB2cListener() {
        label_b2c.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyB2c) {
                        selectB2c(true);
                        isEmptyB2c = true;
                    } else {
                        selectB2c(false);
                        isEmptyB2c = false;
                    }
                }
            }
        });
    }

    private void addBusinessMissionVisitingListener() {
        label_businessMissionVisiting.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyBusinessMissionVisiting) {
                        selectBusinessMissionVisiting(true);
                        isEmptyBusinessMissionVisiting = true;
                    } else {
                        selectBusinessMissionVisiting(false);
                        isEmptyBusinessMissionVisiting = false;
                    }
                }
            }
        });
    }

    private void addbusinessMissionRegionalListener() {
        label_businessMissionRegional.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptybusinessMissionRegional) {
                        selectBusinessMissionRegional(true);
                        isEmptybusinessMissionRegional = true;
                    } else {
                        selectBusinessMissionRegional(false);
                        isEmptybusinessMissionRegional = false;
                    }
                }
            }
        });
    }

    private void addMkasListener() {
        label_mkas.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyMkas) {
                        selectMkas(true);
                        isEmptyMkas = true;
                    } else {
                        selectMkas(false);
                        isEmptyMkas = false;
                    }
                }
            }
        });

    }

    private void addLocationListener() {
        label_location.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyLocation) {
                        selectLocation(true);
                        isEmptyLocation = true;
                    } else {
                        selectLocation(false);
                        isEmptyLocation = false;
                    }
                }
            }
        });
    }

    private void addAntiCorruptionCharterListener() {
        label_antiCorruptionCharter.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyAntiCorruptionCharter) {
                        selectAntiCorruptionCharter(true);
                        isEmptyAntiCorruptionCharter = true;
                    } else {
                        selectAntiCorruptionCharter(false);
                        isEmptyAntiCorruptionCharter = false;
                    }
                }
            }
        });
    }

    private void addPilotProjectsListener() {
        label_pilotProjects.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyPilotProjects) {
                        selectPilotProjects(true);
                        isEmptyPilotProjects = true;
                    } else {
                        selectPilotProjects(false);
                        isEmptyPilotProjects = false;
                    }
                }
            }
        });
    }

    private void addReliablePartnersListener() {
        label_reliablePartners.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyReliablePartners) {
                        selectReliablePartners(true);
                        isEmptyReliablePartners = true;
                    } else {
                        selectReliablePartners(false);
                        isEmptyReliablePartners = false;
                    }
                }
            }
        });
    }

    private void addDiscountsListener() {
        label_discounts.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyDiscounts) {
                        selectDiscounts(true);
                        isEmptyDiscounts = true;
                    } else {
                        selectDiscounts(false);
                        isEmptyDiscounts = false;
                    }
                }
            }
        });
    }

    private void addNeedForYoungPersonnelListener() {
        label_needForYoungPersonnel.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyNeedForYoungPersonnel) {
                        selectNeedForYoungPersonnel(true);
                        isEmptyNeedForYoungPersonnel = true;
                    } else {
                        selectNeedForYoungPersonnel(false);
                        isEmptyNeedForYoungPersonnel = false;
                    }
                }
            }
        });
    }

    private void addCorporateMemberListener() {
        label_corporateMember.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyCorporateMember) {
                        selectCorporateMember(true);
                        isEmptyCorporateMember = true;
                    } else {
                        selectCorporateMember(false);
                        isEmptyCorporateMember = false;
                    }
                }
            }
        });
    }

    private void addCommitteesListener() {
        label_committees.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyCommittees) {
                        selectCommittees(true);
                        isEmptyCommittees = true;
                    } else {
                        selectCommittees(false);
                        isEmptyCommittees = false;
                    }
                }
            }
        });
    }

    private void addNewsletterListener() {
        label_newsletter.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyNewsletter) {
                        selectNewsletter(true);
                        isEmptyNewsletter = true;
                    } else {
                        selectNewsletter(false);
                        isEmptyNewsletter = false;
                    }
                }
            }
        });
    }

    private void addMonthListener() {
        label_month.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyMonth) {
                        selectMonth(true);
                        isEmptyMonth = true;
                    } else {
                        selectMonth(false);
                        isEmptyMonth = false;
                    }
                }
            }
        });
    }

    private void addPaymentListener() {
        label_payment.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyPayment) {
                        selectPayment(true);
                        isEmptyPayment = true;
                    } else {
                        selectPayment(false);
                        isEmptyPayment = false;
                    }
                }
            }
        });

        checkBox_payment_1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) disableDatePayment(false);
            else disableDatePayment(true);
        });

        checkBox_payment_2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) disableDatePayment(false);
            else disableDatePayment(true);
        });
    }

    private void addReceivingListener() {
        label_receiving.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2) {
                    if (!isEmptyReceiving) {
                        selectReceiving(true);
                        isEmptyReceiving = true;
                    } else {
                        selectReceiving(false);
                        isEmptyReceiving = false;
                    }
                }
            }
        });

        checkBox_receiving_1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) disableDateReceiving(false);
            else disableDateReceiving(true);
        });

        checkBox_receiving_2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) disableDateReceiving(false);
            else disableDateReceiving(true);
        });
    }


    private void unSelectAllCheckBox() {
        selectMemberStatus(false);
        selectBusinessForm(false);
        selectDebtStatus(false);
        selectOrganizationForm(false);
        selectOwnershipForm(false);
        selectActivityType(false);
        selectEconomicSector(false);
        selectVedImport(false);
        selectVedExport(false);
        selectInteractionOnline(false);
        selectInteractionOffline(false);
        selectB2b(false);
        selectB2c(false);
        selectBusinessMissionVisiting(false);
        selectBusinessMissionRegional(false);
        selectMkas(false);
        selectNeedForYoungPersonnel(false);
        selectDiscounts(false);
        selectReliablePartners(false);
        selectPilotProjects(false);
        selectAntiCorruptionCharter(false);
        selectLocation(false);
        selectMonth(false);
        selectPayment(false);
        selectReceiving(false);
        unSelectServices();
        selectNewsletter(false);
        selectCommittees(false);
        selectCorporateMember(false);
    }

    private void selectMemberStatus(boolean value) {
        listMemberStatus.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectBusinessForm(boolean value) {
        listBusinessForm.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectDebtStatus(boolean value) {
        listDebtStatus.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectOrganizationForm(boolean value) {
        listOrganizationForm.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectOwnershipForm(boolean value) {
        listOwnershipForm.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectActivityType(boolean value) {
        listActivityType.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectEconomicSector(boolean value) {
        listEconomicSector.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectVedImport(boolean value) {
        listVedImport.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectVedExport(boolean value) {
        listVedExport.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectInteractionOnline(boolean value) {
        listInteractionOnline.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectInteractionOffline(boolean value) {
        listInteractionOffline.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectB2b(boolean value) {
        listB2b.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectB2c(boolean value) {
        listB2c.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectBusinessMissionVisiting(boolean value) {
        listBusinessMissionVisiting.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectBusinessMissionRegional(boolean value) {
        listBusinessMissionRegional.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectMkas(boolean value) {
        listMkas.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectAntiCorruptionCharter(boolean value) {
        listAntiCorruptionCharter.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectPilotProjects(boolean value) {
        listPilotProjects.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectReliablePartners(boolean value) {
        listReliablePartners.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectDiscounts(boolean value) {
        listDiscounts.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectNeedForYoungPersonnel(boolean value) {
        listNeedForYoungPersonnel.forEach(checkBox -> checkBox.setSelected(value));

    }

    private void selectNewsletter(boolean value) {
        listNewsletter.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectCommittees(boolean value) {
        listCommittees.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectCorporateMember(boolean value) {
        listCorporateMember.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectLocation(boolean value) {
        listLocation.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectMonth(boolean value) {
        listMonth.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectPayment(boolean value) {
        listPayment.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void selectReceiving(boolean value) {
        listReceiving.forEach(checkBox -> checkBox.setSelected(value));
    }

    private void unSelectServices() {
        servicesCheckBoxMap.forEach((integer, checkBox) -> checkBox.setSelected(false));
    }

    private void disableDatePayment(boolean value) {
        listDatePayment.forEach(datePicker -> {
            datePicker.setDisable(value);
            datePicker.getEditor().clear();
        });
    }

    private void disableDateReceiving(boolean value) {
        listDateReceiving.forEach(datePicker -> {
            datePicker.setDisable(value);
            datePicker.getEditor().clear();
        });
    }


    public void clearAllFields() {
        unSelectAllCheckBox();
        list.clear();
    }

    @FXML
    public void search() {
        list.clear();
        list.addAll(DBConnection.getQueryList(getResultQuery()));
        table_select.setItems(list);
    }

    private String getResultQuery() {
        ArrayList<String> test = new ArrayList<>();

        test.add(getWherePartFromList(listMemberStatus, "m.MEMBER_STATUS", 1));
        test.add(getWherePartFromList(listBusinessForm, "gi.BUSINESS_FORM", 1));
        test.add(getWherePartFromList(listOrganizationForm, "gi.ORGANIZATION_FORM", 1));
        test.add(getWherePartFromList(listOwnershipForm, "gi.OWNERSHIP_FORM", 1));
        test.add(getWherePartFromList(listActivityType, "gi.ACTIVITY_TYPE", 1));
        test.add(getWherePartFromList(listEconomicSector, "gi.ECONOMIC_SECTOR", 1));

        test.add(getWherePartFromList(listDebtStatus, "d.DEBT_STATUS", 3));

        test.add(getWherePartFromList(listVedImport, "gi.VED_IMPORT", 2));
        test.add(getWherePartFromList(listVedExport, "gi.VED_EXPORT", 2));

        test.add(getWherePartFromList(listInteractionOnline, "gi.INTERACTION_ONLINE", 2));
        test.add(getWherePartFromList(listInteractionOffline, "gi.INTERACTION_OFFLINE", 2));
        test.add(getWherePartFromList(listB2b, "gi.B2B", 2));
        test.add(getWherePartFromList(listB2c, "gi.B2C", 2));
        test.add(getWherePartFromList(listBusinessMissionVisiting, "gi.BUSINESS_MISSION_VISITING", 2));
        test.add(getWherePartFromList(listBusinessMissionRegional, "gi.BUSINESS_MISSION_REGIONAL", 2));
        test.add(getWherePartFromList(listMkas, "gi.MKAS", 2));
        test.add(getWherePartFromList(listAntiCorruptionCharter, "gi.ANTI_CORRUPTION_CHARTER", 2));
        test.add(getWherePartFromList(listPilotProjects, "gi.PILOT_PROJECTS", 2));
        test.add(getWherePartFromList(listReliablePartners, "gi.RELIABLE_PARTNERS", 2));
        test.add(getWherePartFromList(listDiscounts, "gi.DISCOUNTS", 2));
        test.add(getWherePartFromList(listNeedForYoungPersonnel, "gi.NEED_FOR_YOUNG_PERSONNEL", 2));
        test.add(getWherePartFromList(listNewsletter, "gi.NEWSLETTER", 2));
        test.add(getWherePartFromList(listCommittees, "gi.COMMITTEES", 2));
        test.add(getWherePartFromList(listCorporateMember, "gi.CORPORATE_MEMBER", 2));

        test.add(getWherePartFromList(listLocation, "al.ADDRESS_LEGAL_REGION_ID;al.ADDRESS_LEGAL_DISTRICT", 5));
        test.add(getWherePartFromList(listMonth, "month(MEMBER_DATE_OF_ENTRY)", 6));
        test.add(getWherePartFromDate(listDatePayment, "i.INVOICE_ORDER_DATE;i.INVOICE_DATE_OF_CREATION"));
        test.add(getWherePartFromDate(listDateReceiving, "i.INVOICE_DATE_OF_RECEIVING;i.INVOICE_DATE_OF_RECEIVING"));
        test.add(getWherePartFromList(listReceiving, "i.INVOICE_STATUS_OF_RECEIVING", 8));
        test.add(getWherePartFromList(listPayment, "i.INVOICE_STATUS_OF_PAYMENT", 7));
        test.add(getWherePartFromServices());

        test.removeIf(MemberUtils::isEmptyString);

        String selectQuery = "SELECT DISTINCT m.MEMBER_ID, " +
                "m.MEMBER_SERIAL, " +
                "c.CONTACT_PHONE, " +
                "m.MEMBER_STATUS, " +
                "m.MEMBER_SHORT_NAME, " +
                "c.CONTACT_EMAIL";
        String fromQuery = "FROM MEMBER m \n" +
                "INNER JOIN CONTACT c ON m.MEMBER_ID=c.MEMBER_ID " +
                "INNER JOIN DEBT d ON m.MEMBER_ID=d.MEMBER_ID " +
                "INNER JOIN GENERAL_INFORMATION gi ON m.MEMBER_ID=gi.MEMBER_ID " +
                "INNER JOIN ADDRESS_LEGAL al ON m.MEMBER_ID=al.MEMBER_ID " +
                "LEFT JOIN INVOICE i ON m.MEMBER_ID=i.MEMBER_ID " +
                "LEFT JOIN MEMBER_SERVICES ms ON m.MEMBER_ID = ms.MEMBER_ID";
        String whereQuery = "WHERE " + getAppendWhereQuery(test) + ";";
        return selectQuery + "\n" + fromQuery + "\n" + whereQuery;
    }

    private String getWherePartFromList(ArrayList<CheckBox> checkBoxes, String pattern, int flag) {
        String result = "";

        ArrayList<String> someSelect = new ArrayList<>();
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
                        OptionalInt monthNumber = ListUtils.getMonth().entrySet().stream()
                                .filter(entry -> entry.getValue().equals(checkBox.getText()))
                                .mapToInt(Map.Entry::getKey)
                                .findFirst();
                        if (monthNumber.isPresent()) someSelect.add(pattern + " = " + monthNumber.getAsInt());
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
            for (int i = 0; i <= someSelect.size() - 1; i++) {
                result += someSelect.get(i) + " OR ";
            }
            result += someSelect.get(someSelect.size() - 1);
        }
        return result;
    }

    private String getWherePartFromDate(ArrayList<DatePicker> datePickers, String pattern) {
        StringBuilder result = new StringBuilder();

        ArrayList<String> someSelect = new ArrayList<>();
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
            for (int i = 0; i <= someSelect.size() - 1; i++) {
                result.append(someSelect.get(i)).append(" AND ");
            }
            result.append(someSelect.get(someSelect.size() - 1));
        }
        return result.toString();
    }

    private String getWherePartFromServices() {
        StringBuilder result = new StringBuilder("");
        StringBuilder numbers = new StringBuilder();
        int numbersCount = 0;
        for (Map.Entry<Integer, CheckBox> entry : servicesCheckBoxMap.entrySet()) {
            if (entry.getValue().isSelected()) {
                numbersCount++;
                numbers.append(entry.getKey()).append(",");
            }
        }
        if (numbersCount != 0) {
            numbers.deleteCharAt(numbers.length() - 1);
            result.append("ms.SERVICES_ID IN(")
                    .append(numbers)
                    .append(") GROUP BY m.MEMBER_ID HAVING COUNT(*)=")
                    .append(numbersCount);
        }
        return result.toString();
    }

    private String getAppendWhereQuery(ArrayList<String> list) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) result.append("(").append(list.get(i)).append(") AND ");
            else result.append(list.get(i));
        }
        return result.toString();
    }

    @FXML
    public void saveToPDF() {
        ArrayList<String[]> listSelectedParams = new ArrayList<>();
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_memberStatus.getText(), listMemberStatus));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_businessForm.getText(), listBusinessForm));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_debt_status.getText(), listDebtStatus));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_organizationForm.getText(), listOrganizationForm));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_ownershipForm.getText(), listOwnershipForm));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_activityType.getText(), listActivityType));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_economicSector.getText(), listEconomicSector));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_vedImport.getText(), listVedImport));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_vedExport.getText(), listVedExport));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_interactionOnline.getText(), listInteractionOnline));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_interactionOffline.getText(), listInteractionOffline));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_b2b.getText(), listB2b));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_b2c.getText(), listB2c));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_businessMissionVisiting.getText(), listBusinessMissionVisiting));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_businessMissionRegional.getText(), listBusinessMissionRegional));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_mkas.getText(), listMkas));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_needForYoungPersonnel.getText(), listNeedForYoungPersonnel));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_discounts.getText(), listDiscounts));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_reliablePartners.getText(), listReliablePartners));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_pilotProjects.getText(), listPilotProjects));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_antiCorruptionCharter.getText(), listAntiCorruptionCharter));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_newsletter.getText(), listNewsletter));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_committees.getText(), listCommittees));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_corporateMember.getText(), listCorporateMember));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_location.getText(), listLocation));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_month.getText(), listMonth));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_payment.getText(), listPayment));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive(label_receiving.getText(), listReceiving));
        listSelectedParams.add(ListUtils.getDataFromCheckBoxMassive("Интересующие услуги", new ArrayList<>(servicesCheckBoxMap.values())));

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
