package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.MemberUtils;
import ru.src.logic.implementation.PDFUtils;
import ru.src.model.FindMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public CheckBox checkBox_vedImport_2;

    @FXML
    public CheckBox checkBox_vedExport_1;
    @FXML
    public CheckBox checkBox_vedExport_2;

    @FXML
    public CheckBox checkBox_interactionOnline_1;
    @FXML
    public CheckBox checkBox_interactionOnline_2;

    @FXML
    public CheckBox checkBox_interactionOffline_1;
    @FXML
    public CheckBox checkBox_interactionOffline_2;

    @FXML
    public CheckBox checkBox_b2b_1;
    @FXML
    public CheckBox checkBox_b2b_2;

    @FXML
    public CheckBox checkBox_b2c_1;
    @FXML
    public CheckBox checkBox_b2c_2;

    @FXML
    public CheckBox checkBox_businessMissionVisiting_1;
    @FXML
    public CheckBox checkBox_businessMissionVisiting_2;

    @FXML
    public CheckBox checkBox_businessMissionRegional_1;
    @FXML
    public CheckBox checkBox_businessMissionRegional_2;

    @FXML
    public CheckBox checkBox_mkas_1;
    @FXML
    public CheckBox checkBox_mkas_2;
    @FXML
    public TitledPane title_sortParams;

    @FXML
    public CheckBox checkBox_needForYoungPersonnel_1;
    @FXML
    public CheckBox checkBox_needForYoungPersonnel_2;
    @FXML
    public CheckBox checkBox_discounts_1;
    @FXML
    public CheckBox checkBox_discounts_2;
    @FXML
    public CheckBox checkBox_reliablePartners_1;
    @FXML
    public CheckBox checkBox_reliablePartners_2;
    @FXML
    public CheckBox checkBox_pilotProjects_1;
    @FXML
    public CheckBox checkBox_pilotProjects_2;
    @FXML
    public CheckBox checkBox_antiCorruptionCharter_1;
    @FXML
    public CheckBox checkBox_antiCorruptionCharter_2;

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
    public Button btn_save;

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
    public CheckBox checkBox_newsletter_2;

    @FXML
    public CheckBox checkBox_committees_1;
    @FXML
    public CheckBox checkBox_committees_2;

    @FXML
    public CheckBox checkBox_corporateMember_1;
    @FXML
    public CheckBox checkBox_corporateMember_2;

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
    private boolean isEmptyDateReceiving = false;


    ArrayList<CheckBox> listMemberStatus = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listBusinessForm = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listDebtStatus = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listOrganizationForm = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listOwnershipForm = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listActivityType = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listEconomicSector = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listVedImport = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listVedExport = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listInteractionOnline = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listInteractionOffline = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listB2b = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listB2c = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listBusinessMissionVisiting = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listBusinessMissionRegional = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listMkas = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listNeedForYoungPersonnel = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listDiscounts = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listReliablePartners = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listPilotProjects = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listAntiCorruptionCharter = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listLocation = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listMonth = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listPayment = new ArrayList<CheckBox>();
    ArrayList<DatePicker> listDatePayment = new ArrayList<DatePicker>();
    ArrayList<CheckBox> listReceiving = new ArrayList<CheckBox>();
    ArrayList<DatePicker> listDateReceiving = new ArrayList<DatePicker>();
    ArrayList<CheckBox> listNewsletter = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listCommittees = new ArrayList<CheckBox>();
    ArrayList<CheckBox> listCorporateMember = new ArrayList<CheckBox>();


    private HashMap<Integer, CheckBox> servicesCheckBoxMap = new HashMap<>();

    Boolean[] listOfFlags = new Boolean[16];

    private ObservableList<FindMember> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        column_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_memberSerial.setCellValueFactory(new PropertyValueFactory<>("memberSerial"));
        column_contactPhone.setCellValueFactory(new PropertyValueFactory<>("memberStatus"));
        column_memberStatus.setCellValueFactory(new PropertyValueFactory<>("phone"));
        column_memberShortName.setCellValueFactory(new PropertyValueFactory<>("memberShortName"));

        list.addListener(new ListChangeListener<FindMember>() {
            @Override
            public void onChanged(Change<? extends FindMember> c) {
                countOfselect.setText("Количество организаций: " + list.size());
            }
        });

        initializeListMemberStatus();
        initializeBusinessForm();
        initializeDebtStatus();
        initializeOrganizationForm();
        initializeOwnershipForm();
        initializeActivityType();
        initializeEconomicSector();
        initializeVedImport();
        initializeVedExport();
        initializeInteractionOnline();
        initializeInteractionOffline();
        initializeB2b();
        initializeB2c();
        initializeBusinessMissionVisiting();
        initializeBusinessMissionRegional();
        initializeMkas();
        initializeNeedForYoungPersonnel();
        initializeDiscounts();
        initializeReliablePartners();
        initializePilotProjects();
        initializeAntiCorruptionCharter();
        initializeLocation();
        initializeMonth();
        initializePayment();
        initializeDatePayment();
        initializeReceiving();
        initializeDateReceiving();
        initializeServices();
        initializeNewsletter();
        initializeCommittees();
        initializeCorporateMember();

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

    private void initializeDatePayment() {
        listDatePayment.add(date_payment_1);
        listDatePayment.add(date_payment_2);
    }
    private void initializePayment() {
        listPayment.add(checkBox_payment_1);
        listPayment.add(checkBox_payment_2);
    }
    private void initializeMonth() {
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
    }
    private void initializeLocation() {
        listLocation.add(checkBox_location_1);
        listLocation.add(checkBox_location_2);
        listLocation.add(checkBox_location_3);
    }
    private void initializeAntiCorruptionCharter() {
        listAntiCorruptionCharter.add(checkBox_antiCorruptionCharter_1);
        listAntiCorruptionCharter.add(checkBox_antiCorruptionCharter_2);
    }
    private void initializePilotProjects() {
        listPilotProjects.add(checkBox_pilotProjects_1);
        listPilotProjects.add(checkBox_pilotProjects_2);
    }
    private void initializeReliablePartners() {
        listReliablePartners.add(checkBox_reliablePartners_1);
        listReliablePartners.add(checkBox_reliablePartners_2);
    }
    private void initializeDiscounts() {
        listDiscounts.add(checkBox_discounts_1);
        listDiscounts.add(checkBox_discounts_2);
    }
    private void initializeNeedForYoungPersonnel() {
        listNeedForYoungPersonnel.add(checkBox_needForYoungPersonnel_1);
        listNeedForYoungPersonnel.add(checkBox_needForYoungPersonnel_2);
    }
    private void initializeMkas() {
        listMkas.add(checkBox_mkas_1);
        listMkas.add(checkBox_mkas_2);
    }
    private void initializeBusinessMissionRegional() {
        listBusinessMissionRegional.add(checkBox_businessMissionRegional_1);
        listBusinessMissionRegional.add(checkBox_businessMissionRegional_2);
    }
    private void initializeBusinessMissionVisiting() {
        listBusinessMissionVisiting.add(checkBox_businessMissionVisiting_1);
        listBusinessMissionVisiting.add(checkBox_businessMissionVisiting_2);
    }
    private void initializeB2c() {
        listB2c.add(checkBox_b2c_1);
        listB2c.add(checkBox_b2c_2);
    }
    private void initializeB2b() {
        listB2b.add(checkBox_b2b_1);
        listB2b.add(checkBox_b2b_2);
    }
    private void initializeInteractionOffline() {
        listInteractionOffline.add(checkBox_interactionOffline_1);
        listInteractionOffline.add(checkBox_interactionOffline_2);
    }
    private void initializeInteractionOnline() {
        listInteractionOnline.add(checkBox_interactionOnline_1);
        listInteractionOnline.add(checkBox_interactionOnline_2);
    }
    private void initializeVedExport() {
        listVedExport.add(checkBox_vedExport_1);
        listVedExport.add(checkBox_vedExport_2);
    }
    private void initializeVedImport() {
        listVedImport.add(checkBox_vedImport_1);
        listVedImport.add(checkBox_vedImport_2);
    }
    private void initializeEconomicSector() {
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
    }
    private void initializeActivityType() {
        listActivityType.add(checkBox_activityType_1);
        listActivityType.add(checkBox_activityType_2);
    }
    private void initializeOwnershipForm() {
        listOwnershipForm.add(checkBox_ownershipForm_1);
        listOwnershipForm.add(checkBox_ownershipForm_2);
        listOwnershipForm.add(checkBox_ownershipForm_3);
    }
    private void initializeOrganizationForm() {
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
    }
    private void initializeDebtStatus() {
        listDebtStatus.add(checkBox_debt_status_1);
        listDebtStatus.add(checkBox_debt_status_2);
    }
    private void initializeBusinessForm() {
        listBusinessForm.add(checkBox_businessForm_1);
        listBusinessForm.add(checkBox_businessForm_2);
        listBusinessForm.add(checkBox_businessForm_3);
        listBusinessForm.add(checkBox_businessForm_4);
    }
    private void initializeListMemberStatus() {
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
    }
    private void initializeReceiving() {
        listReceiving.add(checkBox_receiving_1);
        listReceiving.add(checkBox_receiving_2);
    }
    private void initializeDateReceiving() {
        listDateReceiving.add(date_receiving_1);
        listDateReceiving.add(date_receiving_2);
    }
    private void initializeServices() {
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
    }
    private void initializeNewsletter() {
        listNewsletter.add(checkBox_newsletter_1);
        listNewsletter.add(checkBox_newsletter_2);
    }
    private void initializeCommittees() {
        listCommittees.add(checkBox_committees_1);
        listCommittees.add(checkBox_committees_2);
    }
    private void initializeCorporateMember() {
        listCorporateMember.add(checkBox_corporateMember_1);
        listCorporateMember.add(checkBox_corporateMember_2);
    }

    private void addMemberStatusListener() {
        label_memberStatus.setOnMouseClicked(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyCBMemberStatus) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyBusinessForm) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyDebtStatus) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyOrganizationForm) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyOwnershipForm) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyActivityTypeForm) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyEconomicSector) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyVedImport) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyVedExport) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyInteractionOnline) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyInteractionOffline) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyB2b) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyB2c) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyBusinessMissionVisiting) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptybusinessMissionRegional) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyMkas) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyLocation) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyAntiCorruptionCharter) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyPilotProjects) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyReliablePartners) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyDiscounts) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyNeedForYoungPersonnel) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyCorporateMember) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyCommittees) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyNewsletter) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyMonth) {
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
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyPayment) {
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
            if(newValue) disableDatePayment(false);
            else disableDatePayment(true);
        });

        checkBox_payment_2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) disableDatePayment(false);
            else disableDatePayment(true);
        });
    }
    private void addReceivingListener() {
        label_receiving.setOnMouseClicked(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                if(event.getClickCount() == 2){
                    if(!isEmptyReceiving) {
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
            if(newValue) disableDateReceiving(false);
            else disableDateReceiving(true);
        });

        checkBox_receiving_2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) disableDateReceiving(false);
            else disableDateReceiving(true);
        });
    }

    private void selectAllCheckBox(boolean value) {
        selectMemberStatus(value);
        selectBusinessForm(value);
        selectDebtStatus(value);
        selectOrganizationForm(value);
        selectOwnershipForm(value);
        selectActivityType(value);
        selectEconomicSector(value);
        selectVedImport(value);
        selectVedExport(value);
        selectInteractionOnline(value);
        selectInteractionOffline(value);
        selectB2b(value);
        selectB2c(value);
        selectBusinessMissionVisiting(value);
        selectBusinessMissionRegional(value);
        selectMkas(value);
        selectNeedForYoungPersonnel(value);
        selectDiscounts(value);
        selectReliablePartners(value);
        selectPilotProjects(value);
        selectAntiCorruptionCharter(value);
        selectLocation(value);
        selectMonth(value);
        selectPayment(value);
        selectReceiving(value);
        selectServices(value);
        selectNewsletter(value);
        selectCommittees(value);
        selectCorporateMember(value);
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
    private void selectServices(boolean value) {
        servicesCheckBoxMap.forEach((integer, checkBox) -> checkBox.setSelected(value));
    }
    private void disableDatePayment(boolean value) {
        listDatePayment.forEach(datePicker -> datePicker.setDisable(value));
    }
    private void disableDateReceiving(boolean value) {
        listDateReceiving.forEach(datePicker -> datePicker.setDisable(value));
    }


    public void clearAllCheckBox(ActionEvent actionEvent) {
        selectAllCheckBox(false);
        list.clear();
    }

    public void search(ActionEvent actionEvent) {
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

        test.add(getWherePartFromList(listVedImport, "gi.VED_IMPORT", 4));
        test.add(getWherePartFromList(listVedExport, "gi.VED_EXPORT", 4));

        test.add(getWherePartFromList(listInteractionOnline, "gi.INTERACTION_ONLINE",2));
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
        test.add(getWherePartFromList(listCommittees, "gi.COMMITTEES", 4));
        test.add(getWherePartFromList(listCorporateMember, "gi.CORPORATE_MEMBER", 4));

        test.add(getWherePartFromList(listLocation, "al.ADDRESS_LEGAL_REGION_ID;al.ADDRESS_LEGAL_DISTRICT", 5));
        test.add(getWherePartFromList(listMonth, "month(MEMBER_DATE_OF_ENTRY)", 6));
        test.add(getWherePartFromDate(listDatePayment, "i.INVOICE_ORDER_DATE;i.INVOICE_DATE_OF_CREATION"));
        test.add(getWherePartFromDate(listDateReceiving, "i.INVOICE_DATE_OF_RECEIVING;i.INVOICE_DATE_OF_RECEIVING"));
        test.add(getWherePartFromList(listReceiving, "i.INVOICE_STATUS_OF_RECEIVING", 8));
        test.add(getWherePartFromList(listPayment, "i.INVOICE_STATUS_OF_PAYMENT", 7));
        test.add(getWherePartFromServices());

        ListUtils.removeAllNullObjectFromList(test);

        String selectQuery = "SELECT DISTINCT m.MEMBER_ID, " +
                "m.MEMBER_SERIAL, " +
                "c.CONTACT_PHONE, " +
                "m.MEMBER_STATUS, " +
                "m.MEMBER_SHORT_NAME";
        String fromQuery = "FROM MEMBER m \n" +
               "INNER JOIN CONTACT c ON m.MEMBER_ID=c.MEMBER_ID " +
               "INNER JOIN DEBT d ON m.MEMBER_ID=d.MEMBER_ID " +
               "INNER JOIN GENERAL_INFORMATION gi ON m.MEMBER_ID=gi.MEMBER_ID " +
               "INNER JOIN ADDRESS_LEGAL al ON m.MEMBER_ID=al.MEMBER_ID " +
               "LEFT JOIN INVOICE i ON m.MEMBER_ID=i.MEMBER_ID " +
               "INNER JOIN MEMBER_SERVICES ms ON m.MEMBER_ID = ms.MEMBER_ID";
        String whereQuery = "WHERE " + getAppendWhereQuery(test) + ";";

        return selectQuery + "\n" + fromQuery + "\n" + whereQuery;
    }

    private String getWherePartFromList(ArrayList<CheckBox> checkBoxes, String pattern, int flag) {
        String result = "";

        ArrayList<String> someSelect = new ArrayList<String>();
        for (CheckBox checkBox: checkBoxes) {
            if(checkBox.isSelected()) {
                if(flag == 1) someSelect.add(pattern + " = '" + checkBox.getText() + "'");
                if(flag == 2) someSelect.add(pattern + " = " + MemberUtils.interestingToBoolean(checkBox.getText()));
                if(flag == 3) someSelect.add(pattern + " = " + MemberUtils.debtToBoolean(checkBox.getText()));
                if(flag == 4) someSelect.add(pattern + " = " + MemberUtils.yesNoToBoolean(checkBox.getText()));
                if(flag == 5) {
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
                }
                if(flag == 6) {
                    Integer month = 0;
                    for (Map.Entry<Integer, String> entry: ListUtils.getMonth().entrySet()) {
                        if(entry.getValue().equals(checkBox.getText())) {
                            month = entry.getKey();
                        }
                    }
                    someSelect.add(pattern + " = " + month.toString());
                }
                if(flag == 7) someSelect.add(pattern + " = " + MemberUtils.paymentToBoolean(checkBox.getText()));
                if(flag == 8) someSelect.add(pattern + " = " + MemberUtils.receiveToBoolean(checkBox.getText()));
            }
        }

        if(!(someSelect.size() == 0)) {
            for (int i = 0; i < someSelect.size(); i++) {
                if (i != someSelect.size() - 1) result += someSelect.get(i) + " OR ";
                else result += someSelect.get(i);
            }
            return result;
        }
        else return null;

    }

    private String getWherePartFromDate(ArrayList<DatePicker> datePickers, String pattern) {
        String result = "";

        ArrayList<String> someSelect = new ArrayList<String>();
        String[] splitPattern = pattern.split(";");

        if(checkBox_payment_1.isSelected() && !checkBox_payment_2.isSelected()) {
            if (!(datePickers.get(0).getValue() == null))
                someSelect.add(splitPattern[0] + " >= '" + datePickers.get(0).getValue().toString() + "'");
            if (!(datePickers.get(1).getValue() == null))
                someSelect.add(splitPattern[0] + " <= '" + datePickers.get(1).getValue().toString() + "'");
        }
        if(!checkBox_payment_1.isSelected() && checkBox_payment_2.isSelected()) {
            if (!(datePickers.get(0).getValue() == null))
                someSelect.add(splitPattern[1] + " >= '" + datePickers.get(0).getValue().toString() + "'");
            if (!(datePickers.get(1).getValue() == null))
                someSelect.add(splitPattern[1] + " <= '" + datePickers.get(1).getValue().toString() + "'");
        }

        if (!(someSelect.size() == 0)) {
            for (int i = 0; i < someSelect.size(); i++) {
                if (i != someSelect.size() - 1) result += someSelect.get(i) + " AND ";
                else result += someSelect.get(i);
            }
            return result;
        } else return null;

    }

    private String getWherePartFromServices() {
        StringBuilder result = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        int numbersCount = 0;
        for (Map.Entry<Integer, CheckBox> entry: servicesCheckBoxMap.entrySet()) {
            if(entry.getValue().isSelected()) {
                numbersCount++;
                numbers.append(entry.getKey()).append(",");
            }
        }
        if(numbersCount != 0) {
            numbers.deleteCharAt(numbers.length() - 1);
            return result.append("ms.SERVICES_ID IN(")
                    .append(numbers)
                    .append(") GROUP BY m.MEMBER_ID HAVING COUNT(*)=")
                    .append(numbersCount).toString();
        } else return null;

    }

    private String getAppendWhereQuery(ArrayList<String> list) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            if(i != list.size() - 1) result.append("(").append(list.get(i)).append(") AND ");
            else result.append(list.get(i));
        }



        return result.toString();
    }

    public void saveToPDF(ActionEvent actionEvent) {
        ArrayList<String> listParagraphForPDF = new ArrayList<String>();
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_memberStatus, listMemberStatus));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_businessForm, listBusinessForm));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_debt_status, listDebtStatus));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_organizationForm, listOrganizationForm));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_ownershipForm, listOwnershipForm));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_activityType, listActivityType));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_economicSector, listEconomicSector));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_vedImport, listVedImport));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_vedExport, listVedExport));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_interactionOnline, listInteractionOnline));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_interactionOffline, listInteractionOffline));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_b2b, listB2b));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_b2c, listB2c));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_businessMissionVisiting, listBusinessMissionVisiting));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_businessMissionRegional, listBusinessMissionRegional));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_mkas, listMkas));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_needForYoungPersonnel, listNeedForYoungPersonnel));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_discounts, listDiscounts));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_reliablePartners, listReliablePartners));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_pilotProjects, listPilotProjects));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_antiCorruptionCharter, listAntiCorruptionCharter));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_newsletter, listNewsletter));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_committees, listCommittees));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_corporateMember, listCorporateMember));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_location, listLocation));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_month, listMonth));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_payment, listPayment));
        listParagraphForPDF.add(ListUtils.getDataFromCheckBoxMassive(label_receiving, listReceiving));

        ListUtils.removeAllNullObjectFromList(listParagraphForPDF);

        PDFUtils.saveToPDF(listParagraphForPDF, "/home/green/test/test.pdf");

    }
}
