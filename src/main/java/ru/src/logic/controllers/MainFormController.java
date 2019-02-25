package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.src.logic.implementation.*;
import ru.src.model.Address.AddressActual;
import ru.src.model.Address.AddressLegal;
import ru.src.model.General.GeneralInformation;
import ru.src.model.Member;
import ru.src.model.Personal.Contact;
import ru.src.model.Personal.ContactPerson;
import ru.src.model.Personal.Director;
import ru.src.model.Personal.Relate;
import ru.src.model.Services;
import ru.src.model.SocialNetworks;
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;
import ru.src.model.buh.Invoice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MainFormController {

    @FXML
    public TextField text_Search;
    @FXML
    public Button btn_Search;

    @FXML
    public TableView table_members;
    @FXML
    public TableColumn<Member, String> column_memberId;
    @FXML
    public TableColumn<Member, LocalDate> column_memberDate;
    @FXML
    public TableColumn<Member, Integer> column_memberSerial;
    @FXML
    public TableColumn<Member, String> column_memberStatus;
    @FXML
    public TableColumn<Member, String> column_memberShortName;

    @FXML
    public TextArea text_relate_fullName;
    @FXML
    public DatePicker date_relate_dateOfCreation;
    @FXML
    public TextField text_relate_size;
    @FXML
    public TextArea text_relate_services;
    @FXML
    public TextArea text_relate_changes;

    @FXML
    public TextField text_generalInformation_organizationForm;
    @FXML
    public TextField text_generalInformation_economicSector;
    @FXML
    public TextField text_generalInformation_ownershipForm;
    @FXML
    public TextField text_generalInformation_activityType;
    @FXML
    public TextField text_generalInformation_businessForm;
    @FXML
    public TextArea text_generalInformation_investmentsTarget;
    @FXML
    public TextField text_generalInformation_investmentsSize;
    @FXML
    public CheckBox checkBox_generalInformation_vedImport;
    @FXML
    public CheckBox checkBox_generalInformation_vedExport;
    @FXML
    public CheckBox checkBox_generalInformation_interactionOnline;
    @FXML
    public CheckBox checkBox_generalInformation_interactionOffline;
    @FXML
    public CheckBox checkBox_generalInformation_b2b;
    @FXML
    public CheckBox checkBox_generalInformation_businessMissionVisiting;
    @FXML
    public CheckBox checkBox_generalInformation_businessMissionRegional;
    @FXML
    public CheckBox checkBox_generalInformation_mkas;
    @FXML
    public CheckBox checkBox_generalInformation_needForYoungPersonnel;
    @FXML
    public CheckBox checkBox_generalInformation_discounts;
    @FXML
    public CheckBox checkBox_generalInformation_b2c;
    @FXML
    public CheckBox checkBox_generalInformation_reliablePartners;
    @FXML
    public CheckBox checkBox_generalInformation_pilotProjects;
    @FXML
    public CheckBox checkBox_generalInformation_antiCorruptionCharter;
    @FXML
    public CheckBox checkBox_generalInformation_newsletter;
    @FXML
    public CheckBox checkBox_generalInformation_committees;
    @FXML
    public CheckBox checkBox_generalInformation_corporateMember;
    @FXML
    public TextArea text_generalInformation_changes;

    @FXML
    public TextField text_director_fullName;
    @FXML
    public TextField text_director_position;
    @FXML
    public TextField text_director_phoneMobile;
    @FXML
    public TextField text_director_phoneCity;
    @FXML
    public TextField text_director_email;
    @FXML
    public DatePicker date_director_birthday;
    @FXML
    public TextArea text_director_changes;

    @FXML
    public TextField text_contact_phone;
    @FXML
    public TextField text_contact_fax;
    @FXML
    public TextField text_contact_site;
    @FXML
    public TextField text_contact_email;
    @FXML
    public TextArea text_contact_changes;

    @FXML
    public TextField text_accoutingInformation_ogrn;
    @FXML
    public TextField text_accoutingInformation_kpp;
    @FXML
    public TextField text_accoutingInformation_tin;

    @FXML
    public TextField text_debt_status;
    @FXML
    public TextField text_debt_period;
    @FXML
    public TextArea text_debt_comment;

    @FXML
    public TextField text_addressLegal_regionId;
    @FXML
    public TextField text_addressLegal_regionName;
    @FXML
    public TextField text_addressLegal_index;
    @FXML
    public TextField text_addressLegal_town;
    @FXML
    public TextField text_addressLegal_street;
    @FXML
    public TextField text_addressLegal_house;
    @FXML
    public TextField text_addressLegal_office;
    @FXML
    public TextField text_addressLegal_district;
    @FXML
    public TextArea text_addressLegal_changes;

    @FXML
    public TextField text_addressActual_regionId;
    @FXML
    public TextField text_addressActual_regionName;
    @FXML
    public TextField text_addressActual_index;
    @FXML
    public TextField text_addressActual_town;
    @FXML
    public TextField text_addressActual_street;
    @FXML
    public TextField text_addressActual_house;
    @FXML
    public TextField text_addressActual_office;
    @FXML
    public TextField text_addressActual_district;
    @FXML
    public TextArea text_addressActual_changes;

    @FXML
    public ComboBox<String> cmbBox_contactPersonId;
    @FXML
    public Button btn_add_contactPerson;
    @FXML
    public Button btn_remove_contactPerson;
    @FXML
    public Button btn_rename_contactPerson;
    @FXML
    public TextField text_contactPerson_position;
    @FXML
    public TextField text_contactPerson_phoneMobile;
    @FXML
    public TextField text_contactPerson_phoneCity;
    @FXML
    public TextField text_contactPerson_email;
    @FXML
    public TextArea text_contactPerson_changes;

    @FXML
    public ComboBox<String> cmbBox_invoiceId;
    @FXML
    public Button btn_add_invoice;
    @FXML
    public Button btn_remove_invoice;
    @FXML
    public Button btn_rename_invoice;
    @FXML
    public TextField text_invoice_statusReceiving;
    @FXML
    public TextField text_invoice_orderId;
    @FXML
    public TextField text_invoice_price;
    @FXML
    public TextField text_invoice_statusPayment;
    @FXML
    public TextArea text_invoice_comment;
    @FXML
    public DatePicker date_invoice_dateCreation;
    @FXML
    public DatePicker date_invoice_dateReceiving;
    @FXML
    public DatePicker date_invoice_orderDate;

    @FXML
    public TextField text_socialNetworks_vkontakte;
    @FXML
    public TextField text_socialNetworks_facebook;
    @FXML
    public TextField text_socialNetworks_telegram;
    @FXML
    public TextField text_socialNetworks_whatsapp;
    @FXML
    public TextField text_socialNetworks_viber;
    @FXML
    public TextField text_socialNetworks_skype;
    @FXML
    public TextField text_socialNetworks_instagram;
    @FXML
    public TextField text_socialNetworks_twitter;
    @FXML
    public TextField text_socialNetworks_youtube;

    @FXML
    public MenuItem menu_addMember;
    @FXML
    public MenuItem menu_deleteMember;
    @FXML
    public MenuItem menu_renameMember;
    @FXML
    public Label countOfOrganization;


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
    public MenuItem item_exitApplication;
    @FXML
    public MenuItem item_openSelect;
    @FXML
    public MenuItem menu_saveMember;
    @FXML
    public MenuItem menu_addMember2;
    @FXML
    public MenuItem menu_connection;
    @FXML
    public MenuItem item_Calendar;
    @FXML
    public Label label_alarm_connection;
    @FXML
    public Label label_notification_calendar;


    public static Organizations memberOrganizations = new Organizations();


    private HashMap<String, Invoice> invoiceHashMap = new HashMap<>();
    private HashMap<String, ContactPerson> contactPersonHashMap = new HashMap<>();
    private HashMap<Integer, CheckBox> servicesCheckBoxMap = new HashMap<>();

    private Stage mainStage;
    private Stage createInvoiceStage;
    private Stage updateInvoiceStage;
    private Stage createContactPersonStage;
    private Stage updateContactPersonStage;
    private Stage createMemberFormStage;
    private Stage updateMemberFormStage;
    private Stage selectStage;
    private Stage settingsStage;
    private Stage calendarStage;
    private Stage calendarNotificationStage;

    private FXMLLoader createInvoiceFxmlLoader = new FXMLLoader();
    private FXMLLoader updateInvoiceFxmlLoader = new FXMLLoader();
    private FXMLLoader createContactPersonFxmlLoader = new FXMLLoader();
    private FXMLLoader updateContactPersonFxmlLoafer = new FXMLLoader();
    private FXMLLoader createMemberFormFxmlLoader = new FXMLLoader();
    private FXMLLoader updateMemberFormFxmlLoader = new FXMLLoader();
    private FXMLLoader selectFormFxmlLoader = new FXMLLoader();
    private FXMLLoader SettingsFxmlLoader = new FXMLLoader();
    private FXMLLoader calendarNotificationFxmlLoader = new FXMLLoader();
    private FXMLLoader calendarFxmlLoader = new FXMLLoader();

    private Parent createInvoice;
    private Parent updateInvoice;
    private Parent createContactPerson;
    private Parent updateContactPerson;
    private Parent createMemberForm;
    private Parent updateMemberForm;
    private Parent selectForm;
    private Parent settings;
    private Parent calendarNotification;
    private Parent calendar;

    private CreateInvoiceController createInvoiceController;
    private UpdateInvoiceController updateInvoiceController;
    private CreateContactPersonController createContactPersonController;
    private UpdateContactPersonController updateContactPersonController;
    private CreateMemberFormController createMemberFormController;
    private UpdateMemberFormController updateMemberFormController;
    private SelectController selectController;
    private CalendarController calendarController;
    private SettingsController settingsController;
    private CalendarNotificationController calendarNotificationController;

    @FXML
    public void initialize() {

        date_relate_dateOfCreation.setStyle("-fx-opacity: 1");
        date_relate_dateOfCreation.getEditor().setStyle("-fx-opacity: 1");

        date_director_birthday.setStyle("-fx-opacity: 1");
        date_director_birthday.getEditor().setStyle("-fx-opacity: 1");

        date_invoice_dateCreation.setStyle("-fx-opacity: 1");
        date_invoice_dateCreation.getEditor().setStyle("-fx-opacity: 1");

        date_invoice_orderDate.setStyle("-fx-opacity: 1");
        date_invoice_orderDate.getEditor().setStyle("-fx-opacity: 1");

        date_invoice_dateReceiving.setStyle("-fx-opacity: 1");
        date_invoice_dateReceiving.getEditor().setStyle("-fx-opacity: 1");



        column_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_memberDate.setCellValueFactory(new PropertyValueFactory<>("memberDate"));
        column_memberSerial.setCellValueFactory(new PropertyValueFactory<>("memberSerial"));
        column_memberStatus.setCellValueFactory(new PropertyValueFactory<>("memberStatus"));
        column_memberShortName.setCellValueFactory(new PropertyValueFactory<>("memberShortName"));

        column_memberId.setStyle("-fx-alignment: CENTER;");
        column_memberDate.setStyle("-fx-alignment: CENTER;");
        column_memberSerial.setStyle("-fx-alignment: CENTER;");
        column_memberStatus.setStyle("-fx-alignment: CENTER;");
        column_memberShortName.setStyle("-fx-alignment: CENTER;");

        initListeners();

        table_members.setItems(memberOrganizations.getMembers());
        countOfOrganization.setText("Количество организаций: " + memberOrganizations.getLength());
        checkConnection(label_alarm_connection, HibernateUtils.isActive);
        checkBirthday(label_notification_calendar);

        initCreateInvoiceLoader();
        initUpdateInvoiceLoader();
        initCreateContactPersonLoader();
        initUpdateContactPersonLoader();
        initCreateMemberFormLoader();
        initUpdateMemberFormLoader();
        initSelectFormLoader();
        initServices();
        initCalendar();
        initSettings();
        initCalendatNotification();
        
        initInterestCheckBox();

        menu_addMember.setDisable(false);
        menu_deleteMember.setDisable(true);
        menu_renameMember.setDisable(true);
    }

    private void initCalendatNotification() {
        try {
            calendarNotificationFxmlLoader.setLocation(getClass().getResource("/ui/calendarNotification.fxml"));
            calendarNotification = calendarNotificationFxmlLoader.load();
            calendarNotificationController = calendarNotificationFxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkBirthday(Label label) {
        Integer directorBirthday = DBConnection.getCountOfDirectorBirthdayToday();
        Integer organizationBirthday = DBConnection.getCountOfOrganizationBirthdayToday();
        if(directorBirthday > 0 || organizationBirthday > 0) {
            label.setTextFill(Color.RED);
            label.setText("Новое событие!");
        }
    }

    private void initSettings() {
        try {
            SettingsFxmlLoader.setLocation(getClass().getResource("/ui/Settings.fxml"));
            settings = SettingsFxmlLoader.load();
            settingsController = SettingsFxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initInterestCheckBox() {
        checkBox_generalInformation_vedExport.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_vedExport.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_interactionOffline.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_interactionOnline.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_b2b.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_b2c.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_businessMissionVisiting.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_businessMissionRegional.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_mkas.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_needForYoungPersonnel.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_discounts.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_reliablePartners.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_pilotProjects.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_antiCorruptionCharter.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_newsletter.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_committees.setStyle("-fx-opacity: 1");
        checkBox_generalInformation_corporateMember.setStyle("-fx-opacity: 1");
    }

    private void initCalendar() {
        try {
            calendarFxmlLoader.setLocation(getClass().getResource("/ui/Calendar.fxml"));
            calendar = calendarFxmlLoader.load();
            calendarController = calendarFxmlLoader.getController();
            calendarController.setParams(table_members);

            calendarStage = new Stage();
            calendarStage.setScene(new Scene(calendar));
            //calendarStage.initModality(Modality.APPLICATION_MODAL);
            calendarStage.setTitle("Календарь");
            //selectStage.initStyle(StageStyle.UNDECORATED);
            //calendarStage.initOwner(mainStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initServices() {
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

        servicesCheckBoxMap.forEach((integer, checkBox) -> {
            checkBox.setStyle("-fx-opacity: 1");
        });
    }

    private void initSelectFormLoader() {
        try {
            selectFormFxmlLoader.setLocation(getClass().getResource("/ui/Select.fxml"));
            selectForm = selectFormFxmlLoader.load();
            selectController = selectFormFxmlLoader.getController();
            selectController.setCurrentStage(selectStage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCreateContactPersonLoader() {
        try {
            createContactPersonFxmlLoader.setLocation(getClass().getResource("/ui/ContactPerson/CreateContactPerson.fxml"));
            createContactPerson = createContactPersonFxmlLoader.load();
            createContactPersonController = createContactPersonFxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUpdateContactPersonLoader() {
        try {
            updateContactPersonFxmlLoafer.setLocation(getClass().getResource("/ui/ContactPerson/UpdateContactPerson.fxml"));
            updateContactPerson = updateContactPersonFxmlLoafer.load();
            updateContactPersonController = updateContactPersonFxmlLoafer.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCreateInvoiceLoader() {
        try {
            createInvoiceFxmlLoader.setLocation(getClass().getResource("/ui/Invoice/CreateInvoiceForm.fxml"));
            createInvoice = createInvoiceFxmlLoader.load();
            createInvoiceController = createInvoiceFxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUpdateInvoiceLoader() {
        try {
            updateInvoiceFxmlLoader.setLocation(getClass().getResource("/ui/Invoice/UpdateInvoiceForm.fxml"));
            updateInvoice = updateInvoiceFxmlLoader.load();
            updateInvoiceController = updateInvoiceFxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCreateMemberFormLoader() {
        try {
            createMemberFormFxmlLoader.setLocation(getClass().getResource("/ui/CreateMemberForm.fxml"));
            createMemberForm = createMemberFormFxmlLoader.load();
            createMemberFormController = createMemberFormFxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUpdateMemberFormLoader() {
        try {
            updateMemberFormFxmlLoader.setLocation(getClass().getResource("/ui/UpdateMemberForm.fxml"));
            updateMemberForm = updateMemberFormFxmlLoader.load();
            updateMemberFormController = updateMemberFormFxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        memberOrganizations.getMembers().addListener(new ListChangeListener<Member>() {
            @Override
            public void onChanged(Change<? extends Member> c) {
                countOfOrganization.setText("Количество организаций: " + memberOrganizations.getLength());
                //clearAll();
                checkConnection(label_alarm_connection, HibernateUtils.isActive);
            }
        });

        //Слушатель, заполняющий все поля по нажатию на строку таблицы
        table_members.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           if(text_Search.getText().equals("")) {
                text_Search.setStyle(null);
            }

            if(newValue != null){
                menu_addMember.setDisable(false);
                menu_deleteMember.setDisable(false);
                menu_renameMember.setDisable(false);

                Member member = (Member) table_members.getSelectionModel().getSelectedItem();
                fillAllInformation(member);
            }
            else {
                menu_addMember.setDisable(false);
                menu_deleteMember.setDisable(true);
                menu_renameMember.setDisable(true);
            }
        });


    }



    private void fillAllInformation(Member member) {
        fillRelate(member.getRelate());//
        fillGeneralInformation(member.getGeneralInformation());
        fillDirector(member.getDirector());
        fillContact(member.getContact());
        fillAccoutingInformation(member.getAccoutingInformation());
        fillDebt(member.getDebt());
        fillAddressLegal(member.getAddressLegal());
        fillAddressActual(member.getAddressActual());
        fillContactPersons(member.getContactPerson());
        fillInvoices(member.getInvoice());
        fillSocialNetworks(member.getSocialNetworks());
        fillServices(member.getServices());


    }

    private void fillServices(List<Services> services) {
        clearServices();

        if(services != null) {
            services.forEach(services1 -> {
                servicesCheckBoxMap.get(services1.getServicesId()).setSelected(true);
            });
        }
    }

    private void fillSocialNetworks(SocialNetworks socialNetworks) {
        clearSocialNetworks();

        text_socialNetworks_vkontakte.setText(socialNetworks.getVkontakte());
        text_socialNetworks_facebook.setText(socialNetworks.getFacebook());
        text_socialNetworks_telegram.setText(socialNetworks.getWhatsapp());
        text_socialNetworks_whatsapp.setText(socialNetworks.getWhatsapp());
        text_socialNetworks_viber.setText(socialNetworks.getViber());
        text_socialNetworks_skype.setText(socialNetworks.getSkype());
        text_socialNetworks_instagram.setText(socialNetworks.getInstagram());
        text_socialNetworks_twitter.setText(socialNetworks.getTwitter());
        text_socialNetworks_youtube.setText(socialNetworks.getYoutube());
    }

    private void fillRelate(Relate relate) {
        clearRelate();

        text_relate_fullName.setText(relate.getFullName());
        date_relate_dateOfCreation.setValue(relate.getDateOfCreation());
        text_relate_size.setText(relate.getSize().toString());
        text_relate_services.setText(relate.getServices());
        text_relate_changes.setText(relate.getChanges());
    }

    private void fillGeneralInformation(GeneralInformation generalInformation) {
        clearGeneralInformation();
        clearInterestCheckBox();

        text_generalInformation_organizationForm.setText(generalInformation.getOrganizationForm());
        text_generalInformation_economicSector.setText(generalInformation.getEconomicSector());
        text_generalInformation_ownershipForm.setText(generalInformation.getOwnershipForm());
        text_generalInformation_activityType.setText(generalInformation.getActivityType());
        text_generalInformation_businessForm.setText(generalInformation.getBusinessForm());

        if (generalInformation.getInvestmentsTarget() != null) {
            text_generalInformation_investmentsTarget.setText(generalInformation.getInvestmentsTarget());
        }
        if (generalInformation.getInvestmentsSize() != null) {
            text_generalInformation_investmentsSize.setText(generalInformation.getInvestmentsSize());
        }

        checkBox_generalInformation_vedExport.setSelected(generalInformation.isVedExport());
        checkBox_generalInformation_vedExport.setSelected(generalInformation.isVedImport());
        checkBox_generalInformation_interactionOffline.setSelected(generalInformation.isInteractionOffline());
        checkBox_generalInformation_interactionOnline.setSelected(generalInformation.isInteractionOnline());
        checkBox_generalInformation_b2b.setSelected(generalInformation.isB2b());
        checkBox_generalInformation_b2c.setSelected(generalInformation.isB2c());
        checkBox_generalInformation_businessMissionVisiting.setSelected(generalInformation.isBusinessMissionVisiting());
        checkBox_generalInformation_businessMissionRegional.setSelected(generalInformation.isBusinessMissionRegional());
        checkBox_generalInformation_mkas.setSelected(generalInformation.isMkas());
        checkBox_generalInformation_needForYoungPersonnel.setSelected(generalInformation.isNeedForYoungPersonnel());
        checkBox_generalInformation_discounts.setSelected(generalInformation.isDiscounts());
        checkBox_generalInformation_reliablePartners.setSelected(generalInformation.isReliablePartners());
        checkBox_generalInformation_pilotProjects.setSelected(generalInformation.isPilotProjects());
        checkBox_generalInformation_antiCorruptionCharter.setSelected(generalInformation.isAntiCorruptionCharter());
        checkBox_generalInformation_newsletter.setSelected(generalInformation.isNewsletter());
        checkBox_generalInformation_committees.setSelected(generalInformation.isCommittees());
        checkBox_generalInformation_corporateMember.setSelected(generalInformation.isCorporateMember());

        text_generalInformation_changes.setText(generalInformation.getChanges());

    }

    private void fillDirector(Director director) {
        clearDirector();

        text_director_position.setText(director.getPosition());
        text_director_fullName.setText(director.getFullName());
        text_director_phoneMobile.setText(director.getPhoneMobile());
        text_director_email.setText(director.getEmail());
        text_director_phoneCity.setText(director.getPhoneCity());
        date_director_birthday.setValue(director.getBirthday());
        text_director_changes.setText(director.getChanges());
    }

    private void fillContact(Contact contact) {
        clearContact();

        text_contact_phone.setText(contact.getPhone());
        text_contact_fax.setText(contact.getFax());
        text_contact_site.setText(contact.getSite());
        text_contact_email.setText(contact.getEmail());
        text_contact_changes.setText(contact.getChanges());
    }

    private void fillAccoutingInformation(AccoutingInformation accoutingInformation) {
        clearAccoutingInformation();

        text_accoutingInformation_ogrn.setText(accoutingInformation.getOgrn());
        text_accoutingInformation_kpp.setText(accoutingInformation.getKpp());
        text_accoutingInformation_tin.setText(accoutingInformation.getTin());
    }

    private void fillDebt(Debt debt) {
        clearDebt();

        text_debt_status.setText(MemberUtils.isDebt(debt.getStatus()));
        text_debt_period.setText(debt.getPeriod());
        text_debt_comment.setText(debt.getComment());
    }

    private void fillAddressLegal(AddressLegal addressLegal) {
        clearAddressLegal();

        text_addressLegal_regionId.setText(addressLegal.getRegionId().toString());
        text_addressLegal_regionName.setText(addressLegal.getRegionName());
        text_addressLegal_index.setText(addressLegal.getIndex().toString());
        text_addressLegal_town.setText(addressLegal.getTown());
        text_addressLegal_street.setText(addressLegal.getStreet());
        text_addressLegal_house.setText(addressLegal.getHouse());
        text_addressLegal_office.setText(addressLegal.getOffice());
        text_addressLegal_district.setText(addressLegal.getDistrict());
        text_addressLegal_changes.setText(addressLegal.getChanges());
    }

    private void fillAddressActual(AddressActual addressActual) {
        clearAddressActual();

        text_addressActual_regionId.setText(addressActual.getRegionId().toString());
        text_addressActual_regionName.setText(addressActual.getRegionName());
        text_addressActual_index.setText(addressActual.getIndex().toString());
        text_addressActual_town.setText(addressActual.getTown());
        text_addressActual_street.setText(addressActual.getStreet());
        text_addressActual_house.setText(addressActual.getHouse());
        text_addressActual_office.setText(addressActual.getOffice());
        text_addressActual_district.setText(addressActual.getDistrict());
        text_addressActual_changes.setText(addressActual.getChanges());
    }

    private void fillInvoices(List<Invoice> invoiceList) {
        invoiceHashMap.clear();
        clearInvoiceFields();
        if(invoiceList != null) {
            for (Invoice invoice : invoiceList) {
                invoiceHashMap.put(invoice.getInvoiceId(), invoice);
            }
            ObservableList<String> observableList = FXCollections.observableArrayList();
            invoiceHashMap.forEach((k, v) -> observableList.add(v.getInvoiceNumber().toString() + " (id" + k + ")"));

            cmbBox_invoiceId.setItems(observableList);
            btn_add_invoice.setDisable(false);
            if (invoiceHashMap.size() > 0) {
                cmbBox_invoiceId.getSelectionModel().select(0);
                cmbBox_invoiceId.setDisable(false);
                btn_rename_invoice.setDisable(false);
                btn_remove_invoice.setDisable(false);
            } else {
                cmbBox_invoiceId.setDisable(true);
                btn_rename_invoice.setDisable(true);
                btn_remove_invoice.setDisable(true);
            }
        }
    }

    private void fillContactPersons(List<ContactPerson> contactPeople) {
        contactPersonHashMap.clear();
        clearContactPersonFields();

        if(contactPeople != null) {
            for (ContactPerson contactPerson : contactPeople) {
                contactPersonHashMap.put(contactPerson.getContactPersonId(), contactPerson);
            }
            ObservableList<String> observableList = FXCollections.observableArrayList();
            contactPersonHashMap.forEach((k, v) -> observableList.add(v.getFullName() + " (id" + k + ")"));

            cmbBox_contactPersonId.setItems(observableList);
            btn_add_contactPerson.setDisable(false);
            if (contactPersonHashMap.size() > 0) {
                cmbBox_contactPersonId.getSelectionModel().select(0);
                cmbBox_contactPersonId.setDisable(false);
                btn_remove_contactPerson.setDisable(false);
                btn_rename_contactPerson.setDisable(false);
            } else {
                cmbBox_contactPersonId.setDisable(true);
                btn_remove_contactPerson.setDisable(true);
                btn_rename_contactPerson.setDisable(true);
            }
        }
    }

    public void fillSelectedInvoice(ActionEvent actionEvent) {
        clearInvoiceFields();

        if(invoiceHashMap.size() > 0) {

            Invoice invoice = invoiceHashMap.get(MemberUtils.extractId(cmbBox_invoiceId.getValue()));

            date_invoice_dateCreation.setValue(invoice.getDateCreation());
            text_invoice_statusReceiving.setText(MemberUtils.isReceive(invoice.getStatusReceiving()));
            date_invoice_dateReceiving.setValue(invoice.getDateReceiving());
            text_invoice_orderId.setText(invoice.getOrderId());
            date_invoice_orderDate.setValue(invoice.getOrderDate());
            text_invoice_price.setText(String.valueOf(invoice.getPrice()));
            text_invoice_statusPayment.setText(MemberUtils.isPayment(invoice.getStatusPayment()));
            text_invoice_comment.setText(invoice.getComment());
        }
    }

    public void fillSelectedPerson(ActionEvent actionEvent) {

        clearContactPersonFields();

        if(contactPersonHashMap.size() > 0) {
            ContactPerson contactPerson = contactPersonHashMap.get(MemberUtils.extractId(cmbBox_contactPersonId.getValue()));

            text_contactPerson_position.setText(contactPerson.getPosition());
            text_contactPerson_phoneMobile.setText(contactPerson.getPhoneMobile());
            text_contactPerson_phoneCity.setText(contactPerson.getPhoneCity());
            text_contactPerson_email.setText(contactPerson.getEmail());
            text_contactPerson_changes.setText(contactPerson.getChanges());
        }
    }



    public void createInvoice(ActionEvent actionEvent) {
        if (createInvoiceStage == null) {
            createInvoiceStage = new Stage();
            createInvoiceStage.setResizable(false);
            createInvoiceStage.setScene(new Scene(createInvoice));
            createInvoiceStage.initModality(Modality.APPLICATION_MODAL);
            createInvoiceStage.initOwner(mainStage);
            createInvoiceStage.setTitle("Добавление счета");
        }

        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        if (member.getInvoice() == null) {
            List<Invoice> invoices = new ArrayList<>();
            member.setInvoice(invoices);
        }

        createInvoiceController.setMember(member);
        createInvoiceStage.showAndWait();

        if (createInvoiceController.isCreateInvoice()) {
            if (DBConnection.isInvoiceExists(createInvoiceController.getInvoice().getInvoiceId())) {
                createInvoiceController.setCreateInvoice(false);
                member.getInvoice().add(createInvoiceController.getInvoice());

                DBConnection.updateMember(member);
                memberOrganizations.updateMember(member);
                MemberUtils.informationDialog("Счет успешно добавлен!");
            } else MemberUtils.warningDialog("Такой счет уже существует!");
        }
        createInvoiceController.clearTextAndStyle();
    }

    public void deleteInvoice(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление счета");
        alert.setHeaderText(null);
        alert.setContentText("Вы действительно хотите удалить счет?");

        Optional<ButtonType> optional = alert.showAndWait();

        if(optional.get() == ButtonType.OK) {

            Invoice invoice = invoiceHashMap.get(MemberUtils.extractId(cmbBox_invoiceId.getValue().toString()));
            Member member = (Member) table_members.getSelectionModel().getSelectedItem();
            member.getInvoice().remove(invoice);

            DBConnection.updateMember(member);
            memberOrganizations.updateMember(member);
            MemberUtils.informationDialog("Cчет успешно удален!");
        }
    }

    public void renameInvoice(ActionEvent actionEvent) {
        if(updateInvoiceStage == null) {
            updateInvoiceStage = new Stage();
            updateInvoiceStage.setResizable(false);
            updateInvoiceStage.setScene(new Scene(updateInvoice));
            updateInvoiceStage.initModality(Modality.APPLICATION_MODAL);
            updateInvoiceStage.initOwner(mainStage);
            updateInvoiceStage.setTitle("Редактирование счета");
        }
        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        Invoice invoice = invoiceHashMap.get(MemberUtils.extractId(cmbBox_invoiceId.getValue().toString()));
        updateInvoiceController.setInvoice(invoice);
        updateInvoiceStage.showAndWait();

        int searchIndex = -1;
        for(Invoice invoices: member.getInvoice())
        {
            if(invoices.getInvoiceId().equals(invoice.getInvoiceId())) {
                searchIndex = member.getInvoice().indexOf(invoices);
            }
        }
        member.getInvoice().set(searchIndex, invoice);
        DBConnection.updateMember(member);
        memberOrganizations.updateMember(member);

    }


    public void createContactPerson(ActionEvent actionEvent) {
        if(createContactPersonStage == null) {
            createContactPersonStage = new Stage();
            createContactPersonStage.setResizable(false);
            createContactPersonStage.setScene(new Scene(createContactPerson));
            createContactPersonStage.initModality(Modality.APPLICATION_MODAL);
            createContactPersonStage.setTitle("Добавление контактного лица");
            createContactPersonStage.initOwner(mainStage);
        }

        Member member = (Member) table_members.getSelectionModel().getSelectedItem();

        if (member.getContactPerson() == null) {
            List<ContactPerson> people = new ArrayList<>();
            member.setContactPerson(people);
        }

        createContactPersonController.setMember(member);

        createContactPersonStage.showAndWait();

        if(createContactPersonController.isCreateContactPerson()) {
            createContactPersonController.setCreateContactPerson(false);

            member.getContactPerson().add(createContactPersonController.getContactPerson());
            DBConnection.updateMember(member);
            memberOrganizations.updateMember(member);
            MemberUtils.informationDialog("Контактное лицо успешно добавлено!");
        }
        createContactPersonController.clearTextAndStyle();
    }

    public void removeContactPerson(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление контактного лица");
        alert.setHeaderText(null);
        alert.setContentText("Вы действительно хотите удалить контактное лицо?");

        Optional<ButtonType> optional = alert.showAndWait();

        if(optional.get() == ButtonType.OK) {
            ContactPerson contactPerson = contactPersonHashMap.get(MemberUtils.extractId(cmbBox_contactPersonId.getValue().toString()));
            Member member = (Member) table_members.getSelectionModel().getSelectedItem();
            member.getContactPerson().remove(contactPerson);

            DBConnection.updateMember(member);
            memberOrganizations.updateMember(member);
            MemberUtils.informationDialog("Данные контактного лица успешно удалены!");
        }
    }

    public void renameContactPerson(ActionEvent actionEvent) {
        if (updateContactPersonStage == null) {
            updateContactPersonStage = new Stage();
            updateContactPersonStage.setResizable(false);
            updateContactPersonStage.setScene(new Scene(updateContactPerson));
            updateContactPersonStage.initModality(Modality.APPLICATION_MODAL);
            updateContactPersonStage.initOwner(mainStage);
            updateContactPersonStage.setTitle("Редактирование данных контактного лица");
        }

        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        ContactPerson contactPerson = contactPersonHashMap.get(MemberUtils.extractId(cmbBox_contactPersonId.getValue()));
        updateContactPersonController.setContactPerson(contactPerson);
        updateContactPersonStage.showAndWait();

        if (updateContactPersonController.isUpdateContactPerson()) {
            updateContactPersonController.setUpdateContactPerson(false);
            DBConnection.updateMember(member);
            memberOrganizations.updateMember(member);
            MemberUtils.informationDialog("Данные контактного лица успешно обновлены!");
        }
        updateContactPersonController.clearTextAndStyle();
    }


    public void addMember(ActionEvent actionEvent) {
        if(createMemberFormStage == null) {
            createMemberFormStage = new Stage();
            createMemberFormStage.setScene(new Scene(createMemberForm));
            createMemberFormStage.initModality(Modality.APPLICATION_MODAL);
            createMemberFormStage.initOwner(mainStage);
            createMemberFormStage.setTitle("Добавление организации");
        }

        createMemberFormStage.showAndWait();

        Member newMember = createMemberFormController.getMember();
        if(createMemberFormController.isMemberCreate()) {
            createMemberFormController.setMemberCreate(false);
            DBConnection.addMember(newMember);
            memberOrganizations.addMember(newMember);
            MemberUtils.informationDialog("Организация успешно добавлена!");
        }
        createMemberFormController.clearAll();
    }

    public void deleteMember(ActionEvent actionEvent) {
        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        member.setServices(null);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удаление организации");
        alert.setHeaderText(null);
        alert.setContentText("Вы действительно хотите удалить организацию: " +
                        member.getMemberShortName() + " ?");

        Optional<ButtonType> optional = alert.showAndWait();

        if(optional.get() == ButtonType.OK) {
            DBConnection.removeMember(member);
            memberOrganizations.removeMember(member);
            MemberUtils.informationDialog("Организация успешно удалена");
        }
    }

    public void renameMember(ActionEvent actionEvent) {
        if (updateMemberFormStage == null) {
            updateMemberFormStage = new Stage();
            updateMemberFormStage.setScene(new Scene(updateMemberForm));
            updateMemberFormStage.initModality(Modality.APPLICATION_MODAL);
            updateMemberFormStage.initOwner(mainStage);
            updateMemberFormStage.setTitle("Редактирование данных организации");
        }

        updateMemberFormController.setMember((Member) table_members.getSelectionModel().getSelectedItem());

        updateMemberFormStage.showAndWait();

        if(updateMemberFormController.isMemberUpdate()) {
            updateMemberFormController.setMemberUpdate(false);
            Member member = updateMemberFormController.getMember();
            DBConnection.updateMember(member);
            memberOrganizations.updateMember(member);
            MemberUtils.informationDialog("Данные организации успешно обновлены!");
        } else MemberUtils.informationDialog("Данные организации остались без изменений!");

        updateMemberFormController.clearAll();
    }


    public void openCalendar(ActionEvent actionEvent) {
        if(calendarStage == null) {
            calendarStage = new Stage();
            calendarStage.setScene(new Scene(calendar));
            //calendarStage.initModality(Modality.APPLICATION_MODAL);
            calendarStage.setTitle("Календарь");
            //selectStage.initStyle(StageStyle.UNDECORATED);
            //calendarStage.initOwner(mainStage);
        }

        calendarStage.show();
    }

    public void openNotification(MouseEvent mouseEvent) {

        if (calendarNotificationStage == null) {
            calendarNotificationStage = new Stage();
            calendarNotificationStage.setScene(new Scene(calendarNotification));
            calendarNotificationStage.setTitle("Уведомление!");
            calendarNotificationStage.setResizable(false);
        }
        calendarNotificationController.setCalendarParams(calendarStage, calendarController);
        calendarNotificationStage.show();

    }


    public void openSettings(ActionEvent actionEvent) {
        if(settingsStage == null) {
            settingsStage = new Stage();
            settingsStage.setScene(new Scene(settings));
            settingsStage.setTitle("Настройки");
        }
        settingsController.initialize();
        settingsStage.show();
       // connectionSettingsController.clear();

    }
    @FXML
    public void openSelect(ActionEvent actionEvent) {
        if(selectStage == null) {
            selectStage = new Stage();
            selectStage.setScene(new Scene(selectForm));
            selectStage.initModality(Modality.APPLICATION_MODAL);
            selectStage.setTitle("Сортировка");
            selectStage.initOwner(mainStage);
        }

        selectStage.showAndWait();
    }

    private void checkConnection(Label alarm, boolean isActiveConnection) {
        if(isActiveConnection) {
            label_alarm_connection.setText("установленно");
            label_alarm_connection.setTextFill(Color.GREEN);
        } else {
            label_alarm_connection.setText("не установленно");
            label_alarm_connection.setTextFill(Color.RED);
        }
    }


    @FXML
    private void exitApplication(ActionEvent actionEvent) {
        Stage stage = (Stage) table_members.getScene().getWindow();
        stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    private void clearAll() {
        clearInterestCheckBox();
        clearRelate();
        clearGeneralInformation();
        clearDirector();
        clearContact();
        clearAccoutingInformation();
        clearDebt();
        clearAddressLegal();
        clearAddressActual();
        clearSocialNetworks();
        clearInvoiceFields();
        clearContactPersonFields();
        clearServices();
    }

    private void clearInterestCheckBox() {
        checkBox_generalInformation_vedExport.setSelected(false);
        checkBox_generalInformation_vedExport.setSelected(false);
        checkBox_generalInformation_interactionOffline.setSelected(false);
        checkBox_generalInformation_interactionOnline.setSelected(false);
        checkBox_generalInformation_b2b.setSelected(false);
        checkBox_generalInformation_b2c.setSelected(false);
        checkBox_generalInformation_businessMissionVisiting.setSelected(false);
        checkBox_generalInformation_businessMissionRegional.setSelected(false);
        checkBox_generalInformation_mkas.setSelected(false);
        checkBox_generalInformation_needForYoungPersonnel.setSelected(false);
        checkBox_generalInformation_discounts.setSelected(false);
        checkBox_generalInformation_reliablePartners.setSelected(false);
        checkBox_generalInformation_pilotProjects.setSelected(false);
        checkBox_generalInformation_antiCorruptionCharter.setSelected(false);
        checkBox_generalInformation_newsletter.setSelected(false);
        checkBox_generalInformation_committees.setSelected(false);
        checkBox_generalInformation_corporateMember.setSelected(false);
    }

    private void clearRelate() {
        text_relate_fullName.clear();
        date_relate_dateOfCreation.getEditor().clear();
        text_relate_size.clear();
        text_relate_services.clear();
        text_relate_changes.clear();
    }

    private void clearGeneralInformation() {
        text_generalInformation_organizationForm.clear();
        text_generalInformation_economicSector.clear();
        text_generalInformation_ownershipForm.clear();
        text_generalInformation_activityType.clear();
        text_generalInformation_businessForm.clear();

        text_generalInformation_investmentsTarget.clear();
        text_generalInformation_investmentsSize.clear();
        text_generalInformation_changes.clear();
    }

    private void clearDirector() {
        text_director_position.clear();
        text_director_fullName.clear();
        text_director_phoneMobile.clear();
        text_director_email.clear();
        text_director_phoneCity.clear();
        date_director_birthday.getEditor().clear();
        text_director_changes.clear();
    }

    private void clearContact() {
        text_contact_phone.clear();
        text_contact_fax.clear();
        text_contact_site.clear();
        text_contact_email.clear();
        text_contact_changes.clear();
    }

    private void clearAccoutingInformation() {
        text_accoutingInformation_ogrn.clear();
        text_accoutingInformation_kpp.clear();
        text_accoutingInformation_tin.clear();
    }

    private void clearDebt() {
        text_debt_status.clear();
        text_debt_period.clear();
        text_debt_comment.clear();
    }

    private void clearAddressLegal() {
        text_addressLegal_regionId.clear();
        text_addressLegal_regionName.clear();
        text_addressLegal_index.clear();
        text_addressLegal_town.clear();
        text_addressLegal_street.clear();
        text_addressLegal_house.clear();
        text_addressLegal_office.clear();
        text_addressLegal_district.clear();
        text_addressLegal_changes.clear();
    }

    private void clearAddressActual() {
        text_addressActual_regionId.clear();
        text_addressActual_regionName.clear();
        text_addressActual_index.clear();
        text_addressActual_town.clear();
        text_addressActual_street.clear();
        text_addressActual_house.clear();
        text_addressActual_office.clear();
        text_addressActual_district.clear();
        text_addressActual_changes.clear();
    }

    private void clearSocialNetworks() {
        text_socialNetworks_vkontakte.clear();
        text_socialNetworks_facebook.clear();
        text_socialNetworks_telegram.clear();
        text_socialNetworks_whatsapp.clear();
        text_socialNetworks_viber.clear();
        text_socialNetworks_skype.clear();
        text_socialNetworks_instagram.clear();
        text_socialNetworks_twitter.clear();
        text_socialNetworks_youtube.clear();
    }

    private void clearInvoiceFields() {
        date_invoice_dateCreation.setValue(null);
        text_invoice_statusReceiving.clear();
        date_invoice_dateReceiving.setValue(null);
        text_invoice_orderId.clear();
        date_invoice_orderDate.setValue(null);
        text_invoice_price.clear();
        text_invoice_statusPayment.clear();
        text_invoice_comment.clear();
    }

    private void clearContactPersonFields() {
        text_contactPerson_position.clear();
        text_contactPerson_phoneMobile.clear();
        text_contactPerson_phoneCity.clear();
        text_contactPerson_email.clear();
        text_contactPerson_changes.clear();
    }

    private void clearServices() {
        servicesCheckBoxMap.forEach((integer, checkBox) -> {
            checkBox.setSelected(false);
        });
    }


    public void searchInTable(ActionEvent actionEvent) {

        String id = text_Search.getText();
        int searchIndex = 0;
        for(Member member: memberOrganizations.getMembers()) {
            if(member.getMemberId().equals(id)) break;
            searchIndex++;
        }
        if(searchIndex < memberOrganizations.getMembers().size()) {
            text_Search.setStyle(null);
            table_members.requestFocus();
            table_members.getFocusModel().focus(searchIndex);
            table_members.scrollTo(searchIndex);
            table_members.getSelectionModel().select(searchIndex);
        } else {
            table_members.requestFocus();
            text_Search.setStyle("-fx-border-color: rgb(" + MemberUtils.EMPTY_COLOR2 + ");");
        }
    }

    public void saveMemberToPDF(ActionEvent actionEvent) {
        String path = "/home/green/member.pdf";
        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        PDFUtils.saveMemberToPDF(path, member);
    }



}
