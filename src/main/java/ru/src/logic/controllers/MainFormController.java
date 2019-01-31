package ru.src.logic.controllers;

import javafx.application.Platform;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.MemberUtils;
import ru.src.logic.implementation.Organizations;
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
    public TextField text_generalInformation_vedImport;
    @FXML
    public TextField text_generalInformation_vedExport;
    @FXML
    public TextArea text_generalInformation_investmentsTarget;
    @FXML
    public TextField text_generalInformation_investmentsSize;
    @FXML
    public TextField text_generalInformation_interactionOnline;
    @FXML
    public TextField text_generalInformation_interactionOffline;
    @FXML
    public TextField text_generalInformation_b2b;
    @FXML
    public TextField text_generalInformation_b2c;
    @FXML
    public TextField text_generalInformation_businessMissionVisiting;
    @FXML
    public TextField text_generalInformation_businessMissionRegional;
    @FXML
    public TextField text_generalInformation_mkas;
    @FXML
    public TextField text_generalInformation_needForYoungPersonnel;
    @FXML
    public TextField text_generalInformation_discounts;
    @FXML
    public TextField text_generalInformation_reliablePartners;
    @FXML
    public TextField text_generalInformation_pilotProjects;
    @FXML
    public TextField text_generalInformation_antiCorruptionCharter;
    @FXML
    public TextArea text_generalInformation_changes;
    @FXML
    public TextField text_generalInformation_newsletter;
    @FXML
    public TextField text_generalInformation_committees;
    @FXML
    public TextField text_generalInformation_corporateMember;

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
    public ComboBox cmbBox_contactPersonId;
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
    public ComboBox cmbBox_invoiceId;
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
    public TextField text_invoice_dateCreation;
    @FXML
    public TextField text_invoice_dateReceiving;
    @FXML
    public TextField text_invoice_orderDate;

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

    private Organizations memberOrganizations = new Organizations();
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

    private FXMLLoader createInvoicefxmlLoader = new FXMLLoader();
    private FXMLLoader updateInvoicefxmlLoader = new FXMLLoader();
    private FXMLLoader createContactPersonfxmlLoader = new FXMLLoader();
    private FXMLLoader updateContactPersonfxmlLoafer = new FXMLLoader();
    private FXMLLoader createMemberFormfxmlloader = new FXMLLoader();
    private FXMLLoader updateMemberFormfxmlloader = new FXMLLoader();
    private FXMLLoader selectFormfxmlloader = new FXMLLoader();


    private Parent createInvoice;
    private Parent updateInvoice;
    private Parent createContactPerson;
    private Parent updateContactPerson;
    private Parent createMemberForm;
    private Parent updateMemberForm;
    private Parent selectForm;

    private CreateInvoiceController createInvoiceController;
    private UpdateInvoiceController updateInvoiceController;
    private CreateContactPersonController createContactPersonController;
    private UpdateContactPersonController updateContactPersonController;
    private CreateMemberFormController createMemberFormController;
    private UpdateMemberFormController updateMemberFormController;
    private SelectController selectController;



    @FXML
    public void initialize() {
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

        initCreateInvoiceLoader();
        initUpdateInvoiceLoader();
        initCreateContactPersonLoader();
        initUpdateContactPersonLoader();
        initCreateMemberFormLoader();
        initUpdateMemberFormLoader();
        initSelectFormLoader();
        initServices();

        menu_addMember.setDisable(false);
        menu_deleteMember.setDisable(true);
        menu_renameMember.setDisable(true);
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
            selectFormfxmlloader.setLocation(getClass().getResource("/ui/select_v3.fxml"));
            selectForm = selectFormfxmlloader.load();
            selectController = selectFormfxmlloader.getController();
            selectController.setCurrentStage(selectStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCreateContactPersonLoader() {
        try {
            createContactPersonfxmlLoader.setLocation(getClass().getResource("/ui/ContactPerson/CreateContactPerson.fxml"));
            createContactPerson = createContactPersonfxmlLoader.load();
            createContactPersonController = createContactPersonfxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUpdateContactPersonLoader() {
        try {
            updateContactPersonfxmlLoafer.setLocation(getClass().getResource("/ui/ContactPerson/UpdateContactPerson.fxml"));
            updateContactPerson = updateContactPersonfxmlLoafer.load();
            updateContactPersonController = updateContactPersonfxmlLoafer.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCreateInvoiceLoader() {
        try {
            createInvoicefxmlLoader.setLocation(getClass().getResource("/ui/Invoice/CreateInvoiceForm.fxml"));
            createInvoice = createInvoicefxmlLoader.load();
            createInvoiceController = createInvoicefxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUpdateInvoiceLoader() {
        try {
            updateInvoicefxmlLoader.setLocation(getClass().getResource("/ui/Invoice/UpdateInvoiceForm.fxml"));
            updateInvoice = updateInvoicefxmlLoader.load();
            updateInvoiceController = updateInvoicefxmlLoader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initCreateMemberFormLoader() {
        try {
            createMemberFormfxmlloader.setLocation(getClass().getResource("/ui/CreateMemberForm.fxml"));
            createMemberForm = createMemberFormfxmlloader.load();
            createMemberFormController = createMemberFormfxmlloader.getController();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUpdateMemberFormLoader() {
        try {
            updateMemberFormfxmlloader.setLocation(getClass().getResource("/ui/UpdateMemberForm.fxml"));
            updateMemberForm = updateMemberFormfxmlloader.load();
            updateMemberFormController = updateMemberFormfxmlloader.getController();
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
            }
        });

        //Слушатель, заполняющий все поля по нажатию на строку таблицы
        table_members.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
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
        fillRelate(member.getRelate());
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

    private void clearServices() {
        servicesCheckBoxMap.forEach((integer, checkBox) -> {
            checkBox.setSelected(false);
        });
    }

    private void fillSocialNetworks(SocialNetworks socialNetworks) {
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
        text_relate_fullName.setText(relate.getFullName());
        date_relate_dateOfCreation.setValue(relate.getDateOfCreation());
        text_relate_size.setText(relate.getSize().toString());
        text_relate_services.setText(relate.getServices());
        text_relate_changes.setText(relate.getChanges());
    }

    private void fillGeneralInformation(GeneralInformation generalInformation) {
        text_generalInformation_organizationForm.setText(generalInformation.getOrganizationForm());
        text_generalInformation_economicSector.setText(generalInformation.getEconomicSector());
        text_generalInformation_ownershipForm.setText(generalInformation.getOwnershipForm());
        text_generalInformation_activityType.setText(generalInformation.getActivityType());
        text_generalInformation_businessForm.setText(generalInformation.getBusinessForm());
        text_generalInformation_vedImport.setText(MemberUtils.isImportExport(generalInformation.isVedImport()));
        text_generalInformation_vedExport.setText(MemberUtils.isImportExport(generalInformation.isVedExport()));

        if(generalInformation.getInvestmentsTarget() != null)
            text_generalInformation_investmentsTarget.setText(generalInformation.getInvestmentsTarget());
        if(generalInformation.getInvestmentsSize() != null)
            text_generalInformation_investmentsSize.setText(generalInformation.getInvestmentsSize().toString());

        text_generalInformation_interactionOffline.setText(MemberUtils.isInteresting(generalInformation.isInteractionOffline()));
        text_generalInformation_interactionOnline.setText(MemberUtils.isInteresting(generalInformation.isInteractionOnline()));
        text_generalInformation_b2b.setText(MemberUtils.isInteresting(generalInformation.isB2b()));
        text_generalInformation_b2c.setText(MemberUtils.isInteresting(generalInformation.isB2c()));
        text_generalInformation_businessMissionVisiting.setText(MemberUtils.isInteresting(generalInformation.isBusinessMissionVisiting()));
        text_generalInformation_businessMissionRegional.setText(MemberUtils.isInteresting(generalInformation.isBusinessMissionRegional()));
        text_generalInformation_mkas.setText(MemberUtils.isInteresting(generalInformation.isMkas()));
        text_generalInformation_needForYoungPersonnel.setText(MemberUtils.isInteresting(generalInformation.isNeedForYoungPersonnel()));
        text_generalInformation_discounts.setText(MemberUtils.isInteresting(generalInformation.isDiscounts()));
        text_generalInformation_reliablePartners.setText(MemberUtils.isInteresting(generalInformation.isReliablePartners()));
        text_generalInformation_pilotProjects.setText(MemberUtils.isInteresting(generalInformation.isPilotProjects()));
        text_generalInformation_antiCorruptionCharter.setText(MemberUtils.isInteresting(generalInformation.isAntiCorruptionCharter()));
        text_generalInformation_newsletter.setText(MemberUtils.isInteresting(generalInformation.isNewsletter()));
        text_generalInformation_committees.setText(MemberUtils.isYesNo(generalInformation.isNewsletter()));
        text_generalInformation_corporateMember.setText(MemberUtils.isYesNo(generalInformation.isNewsletter()));
        text_generalInformation_changes.setText(generalInformation.getChanges());

    }

    private void fillDirector(Director director) {
        text_director_position.setText(director.getPosition());
        text_director_fullName.setText(director.getFullName());
        text_director_phoneMobile.setText(director.getPhoneMobile());
        text_director_email.setText(director.getEmail());
        text_director_phoneCity.setText(director.getPhoneCity());
        date_director_birthday.setValue(director.getBirthday());
        text_director_changes.setText(director.getChanges());
    }

    private void fillContact(Contact contact) {
        text_contact_phone.setText(contact.getPhone());
        text_contact_fax.setText(contact.getFax());
        text_contact_site.setText(contact.getSite());
        text_contact_email.setText(contact.getEmail());
        text_contact_changes.setText(contact.getChanges());
    }

    private void fillAccoutingInformation(AccoutingInformation accoutingInformation) {
        text_accoutingInformation_ogrn.setText(accoutingInformation.getOgrn());
        text_accoutingInformation_kpp.setText(accoutingInformation.getKpp());
        text_accoutingInformation_tin.setText(accoutingInformation.getTin());
    }

    private void fillDebt(Debt debt) {
        text_debt_status.setText(MemberUtils.isDebt(debt.getStatus()));
        text_debt_period.setText(debt.getPeriod());
        text_debt_comment.setText(debt.getComment());
    }

    private void fillAddressLegal(AddressLegal addressLegal) {
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
        for(Invoice invoice: invoiceList) {
            invoiceHashMap.put(invoice.getInvoiceId(), invoice);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList();
        invoiceHashMap.forEach((k, v) -> observableList.add(v.getInvoiceNumber().toString() + " (id" + k + ")"));



        cmbBox_invoiceId.setItems(observableList);
        btn_add_invoice.setDisable(false);
        if(invoiceHashMap.size() > 0) {
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

    private void fillContactPersons(List<ContactPerson> contactPeople) {
        contactPersonHashMap.clear();
        clearContactPersonFields();
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

    public void setMemberParams(MouseEvent mouseEvent) {

    }

    public void fillSelectedInvoice(ActionEvent actionEvent) {
        clearInvoiceFields();

        if(invoiceHashMap.size() > 0) {

            Invoice invoice = invoiceHashMap.get(MemberUtils.extractId(cmbBox_invoiceId.getValue().toString()));

            text_invoice_dateCreation.setText(MemberUtils.dateToString(invoice.getDateCreation()));
            text_invoice_statusReceiving.setText(MemberUtils.isReceive(invoice.getStatusReceiving()));
            text_invoice_dateReceiving.setText(MemberUtils.dateToString(invoice.getDateReceiving()));
            text_invoice_orderId.setText(invoice.getOrderId());
            text_invoice_orderDate.setText(MemberUtils.dateToString(invoice.getOrderDate()));
            text_invoice_price.setText(String.valueOf(invoice.getPrice()));
            text_invoice_statusPayment.setText(MemberUtils.isPayment(invoice.getStatusPayment()));
            text_invoice_comment.setText(invoice.getComment());

        }
    }

    private void clearInvoiceFields() {
        text_invoice_dateCreation.clear();
        text_invoice_statusReceiving.clear();
        text_invoice_dateReceiving.clear();
        text_invoice_orderId.clear();
        text_invoice_orderDate.clear();
        text_invoice_price.clear();
        text_invoice_statusPayment.clear();
        text_invoice_comment.clear();
    }

    public void fillSelectedPerson(ActionEvent actionEvent) {

        clearContactPersonFields();

        if(contactPersonHashMap.size() > 0) {
            ContactPerson contactPerson = contactPersonHashMap.get(MemberUtils.extractId(cmbBox_contactPersonId.getValue().toString()));

            text_contactPerson_position.setText(contactPerson.getPosition());
            text_contactPerson_phoneMobile.setText(contactPerson.getPhoneMobile());
            text_contactPerson_phoneCity.setText(contactPerson.getPhoneCity());
            text_contactPerson_email.setText(contactPerson.getEmail());
            text_contactPerson_changes.setText(contactPerson.getChanges());
        }
    }

    private void clearContactPersonFields() {
        text_contactPerson_position.clear();
        text_contactPerson_phoneMobile.clear();
        text_contactPerson_phoneCity.clear();
        text_contactPerson_email.clear();
        text_contactPerson_changes.clear();
    }


    public void createInvoice(ActionEvent actionEvent) {
        if(createInvoiceStage == null) {
            createInvoiceStage = new Stage();
            createInvoiceStage.setResizable(false);
            createInvoiceStage.setScene(new Scene(createInvoice));
            createInvoiceStage.initModality(Modality.APPLICATION_MODAL);
            createInvoiceStage.initOwner(mainStage);

        }
        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        if(member.getInvoice() == null){
            List<Invoice> invoices = new ArrayList<>();
            member.setInvoice(invoices);
        }

        createInvoiceController.setMember(member);
        createInvoiceStage.showAndWait();

        if(DBConnection.isInvoiceExists(createInvoiceController.getInvoice().getInvoiceId())) {
            member.getInvoice().add(createInvoiceController.getInvoice());

            DBConnection.updateMember(member);
            memberOrganizations.updateMember(member);
            MemberUtils.informationDialog("Счет успешно добавлен!");
        }
        if(!createInvoiceController.isCreateInvoice()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Такой счет уже существует!");
            alert.showAndWait();
        }


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
        if(createContactPersonStage == null){
            createContactPersonStage = new Stage();
            createContactPersonStage.setResizable(false);
            createContactPersonStage.setScene(new Scene(createContactPerson));
            createContactPersonStage.initModality(Modality.APPLICATION_MODAL);
            createContactPersonStage.initOwner(mainStage);
        }

        Member member = (Member) table_members.getSelectionModel().getSelectedItem();

        if(member.getContactPerson() == null) {
            List<ContactPerson> people = new ArrayList<>();
            member.setContactPerson(people);
        }

        createContactPersonController.setMember(member);
        createContactPersonStage.showAndWait();

        member.getContactPerson().add(createContactPersonController.getContactPerson());

        DBConnection.updateMember(member);
        memberOrganizations.updateMember(member);

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
        if(updateContactPersonStage == null) {
            updateContactPersonStage = new Stage();
            updateContactPersonStage.setResizable(false);
            updateContactPersonStage.setScene(new Scene(updateContactPerson));
            updateContactPersonStage.initModality(Modality.APPLICATION_MODAL);
            updateContactPersonStage.initOwner(mainStage);
        }

        Member member = (Member) table_members.getSelectionModel().getSelectedItem();
        ContactPerson contactPerson = contactPersonHashMap.get(MemberUtils.extractId(cmbBox_contactPersonId.getValue().toString()));
        updateContactPersonController.setContactPerson(contactPerson);
        updateContactPersonStage.showAndWait();

        int searchIndex = -1;
        for(ContactPerson person: member.getContactPerson()) {
            if(person.getContactPersonId().equals(contactPerson.getContactPersonId())) {
                searchIndex = member.getContactPerson().indexOf(person);
            }
        }
        member.getContactPerson().set(searchIndex, contactPerson);
        DBConnection.updateMember(member);
        memberOrganizations.updateMember(member);

    }


    public void addMember(ActionEvent actionEvent) {
        if(createMemberFormStage == null) {
            createMemberFormStage = new Stage();
            createMemberFormStage.setScene(new Scene(createMemberForm));
            createMemberFormStage.initModality(Modality.APPLICATION_MODAL);
            createMemberFormStage.initOwner(mainStage);
        }

        createMemberFormStage.showAndWait();

        Member newMember = createMemberFormController.getMember();
        if(createMemberFormController.isMemberCreate()) {
            createMemberFormController.setMemberCreate(false);
            DBConnection.addMember(newMember);
            memberOrganizations.addMember(newMember);
            MemberUtils.informationDialog("Организация успешно добавлена!");
        }
    }

    public void deleteMember(ActionEvent actionEvent) {
        Member member = (Member) table_members.getSelectionModel().getSelectedItem();

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
        }

        updateMemberFormController.setMember((Member) table_members.getSelectionModel().getSelectedItem());

        updateMemberFormStage.showAndWait();

        Member member = updateMemberFormController.getMember();
        DBConnection.updateMember(member);
        memberOrganizations.updateMember(member);

        MemberUtils.informationDialog("Данные организации успешно обновлены!");

    }

    public void openSelect(ActionEvent actionEvent) {
        if(selectStage == null) {
            selectStage = new Stage();
            selectStage.setScene(new Scene(selectForm));
            selectStage.initModality(Modality.APPLICATION_MODAL);
            selectStage.initOwner(mainStage);
        }

        selectStage.showAndWait();
    }

}
