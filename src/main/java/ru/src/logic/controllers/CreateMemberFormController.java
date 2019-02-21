package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Address.AddressActual;
import ru.src.model.Address.AddressLegal;
import ru.src.model.General.GeneralInformation;
import ru.src.model.Member;
import ru.src.model.Personal.Contact;
import ru.src.model.Personal.Director;
import ru.src.model.Personal.Relate;
import ru.src.model.Services;
import ru.src.model.SocialNetworks;
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;

import java.util.*;

public class CreateMemberFormController {

    @FXML
    public TextField text_memberId;
    @FXML
    public TextField text_memberSerial;
    @FXML
    public ComboBox<String> comboBox_memberStatus;
    @FXML
    public DatePicker date_memberDate;
    @FXML
    public TextField text_memberShortName;
    @FXML
    public Label label_alarm_memberId;
    @FXML
    public Label label_alarm_memberSerial;
    @FXML
    public Label label_alarm_memberStatus;
    @FXML
    public Label label_alarm_memberDate;
    @FXML
    public Label label_alarm_memberShortName;

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
    public Label label_alarm_relate_fullName;
    @FXML
    public Label label_alarm_relate_dateOfCreation;
    @FXML
    public Label label_alarm_relate_size;
    @FXML
    public Label label_alarm_relate_services;
    @FXML
    public Label label_alarm_relate_changes;

    @FXML
    public ComboBox<String> comboBox_generalInformation_organizationForm;
    @FXML
    public ComboBox<String> comboBox_generalInformation_economicSector;
    @FXML
    public TextArea text_generalInformation_investmentsTarget;
    @FXML
    public TextField text_generalInformation_investmentsSize;
    @FXML
    public TextArea text_generalInformation_changes;
    @FXML
    public ComboBox<String> comboBox_generalInformation_ownershipForm;
    @FXML
    public ComboBox<String> comboBox_generalInformation_activityType;
    @FXML
    public ComboBox<String> comboBox_generalInformation_businessForm;
    
    @FXML
    public Label label_alarm_generalInformation_investmentsTarget;
    @FXML
    public Label label_alarm_generalInformation_investmentsSize;
    @FXML
    public Label label_alarm_generalInformation_changes;

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
    public Label label_alarm_director_fullName;
    @FXML
    public Label label_alarm_director_position;
    @FXML
    public Label label_alarm_director_phoneMobile;
    @FXML
    public Label label_alarm_director_phoneCity;
    @FXML
    public Label label_alarm_director_email;
    @FXML
    public Label label_alarm_director_birthday;
    @FXML
    public Label label_alarm_director_changes;


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
    public Label label_alarm_contact_phone;
    @FXML
    public Label label_alarm_contact_fax;
    @FXML
    public Label label_alarm_contact_site;
    @FXML
    public Label label_alarm_contact_email;
    @FXML
    public Label label_alarm_contact_changes;

    @FXML
    public TextField text_accoutingInformation_ogrn;
    @FXML
    public TextField text_accoutingInformation_kpp;
    @FXML
    public TextField text_accoutingInformation_tin;
    @FXML
    public Label label_alarm_accoutingInformation_ogrn;
    @FXML
    public Label label_alarm_accoutingInformation_kpp;
    @FXML
    public Label label_alarm_accoutingInformation_tin;

    @FXML
    public TextField text_debt_period;
    @FXML
    public TextArea text_debt_comment;
    @FXML
    public ComboBox<String> comboBox_debt_status;
    @FXML
    public Label label_alarm_debt_status;
    @FXML
    public Label label_alarm_debt_period;
    @FXML
    public Label label_alarm_debt_comment;

    @FXML
    public TextField text_addressLegal_regionId;
    @FXML
    public ComboBox<String> comboBox_addressLegal_regionName;
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
    public ComboBox<String> comboBox_addressLegal_district;
    @FXML
    public TextArea text_addressLegal_changes;
    @FXML
    public Label label_alarm_addressLegal_regionId;
    @FXML
    public Label label_alarm_addressLegal_regionName;
    @FXML
    public Label label_alarm_addressLegal_index;
    @FXML
    public Label label_alarm_addressLegal_town;
    @FXML
    public Label label_alarm_addressLegal_street;
    @FXML
    public Label label_alarm_addressLegal_house;
    @FXML
    public Label label_alarm_addressLegal_office;
    @FXML
    public Label label_alarm_addressLegal_district;
    @FXML
    public Label label_alarm_addressLegal_changes;

    @FXML
    public TextField text_addressActual_regionId;
    @FXML
    public ComboBox<String> comboBox_addressActual_regionName;
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
    public ComboBox<String> comboBox_addressActual_district;
    @FXML
    public TextArea text_addressActual_changes;
    @FXML
    public Label label_alarm_addressActual_regionId;
    @FXML
    public Label label_alarm_addressActual_regionName;
    @FXML
    public Label label_alarm_addressActual_index;
    @FXML
    public Label label_alarm_addressActual_town;
    @FXML
    public Label label_alarm_addressActual_street;
    @FXML
    public Label label_alarm_addressActual_house;
    @FXML
    public Label label_alarm_addressActual_office;
    @FXML
    public Label label_alarm_addressActual_district;
    @FXML
    public Label label_alarm_addressActual_changes;

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
    public Label label_alarm_socialNetworks_vkontakte;
    @FXML
    public Label label_alarm_socialNetworks_facebook;
    @FXML
    public Label label_alarm_socialNetworks_telegram;
    @FXML
    public Label label_alarm_socialNetworks_whatsapp;
    @FXML
    public Label label_alarm_socialNetworks_viber;
    @FXML
    public Label label_alarm_socialNetworks_skype;
    @FXML
    public Label label_alarm_socialNetworks_instagram;
    @FXML
    public Label label_alarm_socialNetworks_twitter;
    @FXML
    public Label label_alarm_socialNetworks_youtube;

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
    public Button btn_saveMember;
    @FXML
    public Button btn_cancel;
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
    public MenuItem menuItem_duplicateAddress;
    @FXML
    public Label label_alarm_createMember;

    private Member member;
    public Member getMember() {
        return member;
    }

    private ObservableList<String> memberStatus = ListUtils.getMemberStatusList();
    private ObservableList<String> organizationForm = ListUtils.getOrganizationForm();
    private ObservableList<String> economicSector = ListUtils.getEconomicSector();
    private ObservableList<String> ownershipForm = ListUtils.getOwnershipForm();
    private ObservableList<String> activityType = ListUtils.getActivityType();
    private ObservableList<String> businessForm = ListUtils.getBusinessForm();
    private ObservableList<String> debd = ListUtils.getDedbStatusList();
    private ObservableList<String> district = ListUtils.getDistrict();

    private HashMap<Integer, String> regionMap = ListUtils.getRegionMap();
    private ObservableList<String> region = FXCollections.observableArrayList();
    private HashMap<Integer, CheckBox> servicesCheckBoxMap = new HashMap<>();

    private boolean isMemberCreate = false;
    boolean isMemberCreate() {
        return isMemberCreate;
    }
    void setMemberCreate(boolean memberCreate) {
        isMemberCreate = memberCreate;
    }


    @FXML
    public void initialize() {

        addCheckInfoListeners();
        fillAllComboBox();
        initServices();

        text_addressActual_regionId.editableProperty().setValue(false);
        text_addressLegal_regionId.editableProperty().setValue(false);

        comboBox_addressLegal_district.setDisable(true);
        comboBox_addressActual_district.setDisable(true);
    }

    private void addCheckInfoListeners() {
        MemberUtils.checkTextLength(text_memberId, label_alarm_memberId, 10);
        MemberUtils.checkTextDigital(text_memberSerial, label_alarm_memberSerial, 9);
        MemberUtils.checkTextLength(text_memberShortName, label_alarm_memberShortName, 255);

        MemberUtils.checkTextLength(text_relate_fullName, label_alarm_relate_fullName, 255);
        MemberUtils.checkTextDigital(text_relate_size, label_alarm_relate_size, 9);
        MemberUtils.checkTextLength(text_relate_services, label_alarm_relate_services, 255);
        MemberUtils.checkTextLength(text_relate_changes, label_alarm_relate_changes, 255);

        MemberUtils.checkTextLength(text_generalInformation_investmentsTarget, label_alarm_generalInformation_investmentsTarget, 255);
        MemberUtils.checkTextDigital(text_generalInformation_investmentsSize, label_alarm_generalInformation_investmentsSize, 9);
        MemberUtils.checkTextLength(text_generalInformation_changes, label_alarm_generalInformation_changes, 255);

        MemberUtils.checkTextLength(text_director_fullName, label_alarm_director_fullName, 255);
        MemberUtils.checkTextLength(text_director_position, label_alarm_director_position, 50);
        MemberUtils.checkTextPhone(text_director_phoneMobile, label_alarm_director_phoneMobile);
        MemberUtils.checkTextPhone(text_director_phoneCity, label_alarm_director_phoneCity);
        MemberUtils.checkTextLength(text_director_email, label_alarm_director_email, 50);
        MemberUtils.checkTextLength(text_director_changes, label_alarm_director_changes, 255);

        MemberUtils.checkTextPhone(text_contact_phone, label_alarm_contact_phone);
        MemberUtils.checkTextPhone(text_contact_fax, label_alarm_contact_fax);
        MemberUtils.checkTextLength(text_contact_site, label_alarm_contact_site, 50);
        MemberUtils.checkTextLength(text_contact_email, label_alarm_contact_email, 50);
        MemberUtils.checkTextLength(text_contact_changes, label_alarm_contact_changes, 255);

        MemberUtils.checkTextDigital(text_accoutingInformation_ogrn, label_alarm_accoutingInformation_ogrn, 15);
        MemberUtils.checkTextDigital(text_accoutingInformation_kpp, label_alarm_accoutingInformation_kpp, 9);
        MemberUtils.checkTextDigital(text_accoutingInformation_tin, label_alarm_accoutingInformation_tin, 10);

        MemberUtils.checkTextLength(text_debt_period, label_alarm_debt_period, 45);
        MemberUtils.checkTextLength(text_debt_comment, label_alarm_debt_comment, 255);

        MemberUtils.checkTextDigital(text_addressLegal_regionId, label_alarm_addressLegal_regionId, 3);
        MemberUtils.checkTextDigital(text_addressLegal_index, label_alarm_addressLegal_index, 6);
        MemberUtils.checkTextLength(text_addressLegal_town, label_alarm_addressLegal_town, 45);
        MemberUtils.checkTextLength(text_addressLegal_street, label_alarm_addressLegal_street, 45);
        MemberUtils.checkTextLength(text_addressLegal_house, label_alarm_addressLegal_house, 6);
        MemberUtils.checkTextLength(text_addressLegal_office, label_alarm_addressLegal_office, 6);
        MemberUtils.checkTextLength(text_addressLegal_changes, label_alarm_addressLegal_changes, 255);

        MemberUtils.checkTextDigital(text_addressActual_regionId, label_alarm_addressActual_regionId, 3);
        MemberUtils.checkTextDigital(text_addressActual_index, label_alarm_addressActual_index, 6);
        MemberUtils.checkTextLength(text_addressActual_town, label_alarm_addressActual_town, 45);
        MemberUtils.checkTextLength(text_addressActual_street, label_alarm_addressActual_street, 45);
        MemberUtils.checkTextLength(text_addressActual_house, label_alarm_addressActual_house, 6);
        MemberUtils.checkTextLength(text_addressActual_office, label_alarm_addressActual_office, 6);
        MemberUtils.checkTextLength(text_addressActual_changes, label_alarm_addressActual_changes, 255);

        MemberUtils.checkTextLength(text_socialNetworks_vkontakte, label_alarm_socialNetworks_vkontakte, 45);
        MemberUtils.checkTextLength(text_socialNetworks_facebook, label_alarm_socialNetworks_facebook, 45);
        MemberUtils.checkTextLength(text_socialNetworks_telegram, label_alarm_socialNetworks_telegram, 45);
        MemberUtils.checkTextLength(text_socialNetworks_whatsapp, label_alarm_socialNetworks_whatsapp, 45);
        MemberUtils.checkTextLength(text_socialNetworks_viber, label_alarm_socialNetworks_viber, 45);
        MemberUtils.checkTextLength(text_socialNetworks_skype, label_alarm_socialNetworks_skype, 45);
        MemberUtils.checkTextLength(text_socialNetworks_instagram, label_alarm_socialNetworks_instagram, 45);
        MemberUtils.checkTextLength(text_socialNetworks_twitter, label_alarm_socialNetworks_twitter, 45);
        MemberUtils.checkTextLength(text_socialNetworks_youtube, label_alarm_socialNetworks_youtube, 45);
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

    }

    private void fillAllComboBox() {
        comboBox_memberStatus.setItems(memberStatus);

        comboBox_generalInformation_organizationForm.setItems(organizationForm);
        comboBox_generalInformation_economicSector.setItems(economicSector);
        comboBox_generalInformation_ownershipForm.setItems(ownershipForm);
        comboBox_generalInformation_activityType.setItems(activityType);
        comboBox_generalInformation_businessForm.setItems(businessForm);

        comboBox_debt_status.setItems(debd);
        comboBox_addressActual_district.setItems(district);
        comboBox_addressLegal_district.setItems(district);

        regionMap.forEach((integer, s) -> region.add(s));
        comboBox_addressActual_regionName.setItems(region);
        comboBox_addressLegal_regionName.setItems(region);
    }


    private void clearObjects() {
        comboBox_addressActual_district.getSelectionModel().clearSelection();
        comboBox_addressLegal_district.getSelectionModel().clearSelection();
        comboBox_addressLegal_regionName.getSelectionModel().clearSelection();
        comboBox_debt_status.getSelectionModel().clearSelection();
        comboBox_addressActual_regionName.getSelectionModel().clearSelection();
        comboBox_generalInformation_businessForm.getSelectionModel().clearSelection();
        comboBox_generalInformation_activityType.getSelectionModel().clearSelection();
        comboBox_generalInformation_ownershipForm.getSelectionModel().clearSelection();
        comboBox_generalInformation_economicSector.getSelectionModel().clearSelection();
        comboBox_generalInformation_organizationForm.getSelectionModel().clearSelection();
        comboBox_memberStatus.getSelectionModel().clearSelection();

        text_memberId.setStyle(null);
        text_memberSerial.setStyle(null);
        date_memberDate.setStyle(null);
        comboBox_memberStatus.setStyle(null);
        text_memberShortName.setStyle(null);

        text_relate_fullName.setStyle(null);
        text_relate_size.setStyle(null);
        text_relate_services.setStyle(null);

        comboBox_generalInformation_organizationForm.setStyle(null);
        comboBox_generalInformation_economicSector.setStyle(null);
        comboBox_generalInformation_ownershipForm.setStyle(null);
        comboBox_generalInformation_activityType.setStyle(null);
        comboBox_generalInformation_businessForm.setStyle(null);

        text_director_fullName.setStyle(null);
        text_director_position.setStyle(null);
        text_director_phoneMobile.setStyle(null);
        text_director_email.setStyle(null);

        text_contact_phone.setStyle(null);
        text_contact_email.setStyle(null);

        text_accoutingInformation_ogrn.setStyle(null);
        text_accoutingInformation_kpp.setStyle(null);
        text_accoutingInformation_tin.setStyle(null);

        comboBox_debt_status.setStyle(null);

        comboBox_addressLegal_regionName.setStyle(null);
        text_addressLegal_index.setStyle(null);
        text_addressLegal_town.setStyle(null);
        text_addressLegal_street.setStyle(null);
        text_addressLegal_house.setStyle(null);

        comboBox_addressActual_regionName.setStyle(null);
        text_addressActual_index.setStyle(null);
        text_addressActual_town.setStyle(null);
        text_addressActual_street.setStyle(null);
        text_addressActual_house.setStyle(null);

        date_relate_dateOfCreation.setValue(null);
        date_memberDate.setValue(null);
        date_director_birthday.setValue(null);

    }

    private void clearLabelAlarm() {
        label_alarm_memberId.setText(null);
        label_alarm_memberSerial.setText(null);
        label_alarm_memberStatus.setText(null);
        label_alarm_memberDate.setText(null);
        label_alarm_memberShortName.setText(null);

        label_alarm_relate_fullName.setText(null);
        label_alarm_relate_dateOfCreation.setText(null);
        label_alarm_relate_size.setText(null);
        label_alarm_relate_services.setText(null);
        label_alarm_relate_changes.setText(null);

        label_alarm_generalInformation_investmentsTarget.setText(null);
        label_alarm_generalInformation_investmentsSize.setText(null);
        label_alarm_generalInformation_changes.setText(null);

        label_alarm_director_fullName.setText(null);
        label_alarm_director_position.setText(null);
        label_alarm_director_phoneMobile.setText(null);
        label_alarm_director_phoneCity.setText(null);
        label_alarm_director_email.setText(null);
        label_alarm_director_birthday.setText(null);
        label_alarm_director_changes.setText(null);

        label_alarm_contact_phone.setText(null);
        label_alarm_contact_fax.setText(null);
        label_alarm_contact_site.setText(null);
        label_alarm_contact_email.setText(null);
        label_alarm_contact_changes.setText(null);

        label_alarm_accoutingInformation_ogrn.setText(null);
        label_alarm_accoutingInformation_kpp.setText(null);
        label_alarm_accoutingInformation_tin.setText(null);

        label_alarm_debt_status.setText(null);
        label_alarm_debt_period.setText(null);
        label_alarm_debt_comment.setText(null);

        label_alarm_addressLegal_regionId.setText(null);
        label_alarm_addressLegal_regionName.setText(null);
        label_alarm_addressLegal_index.setText(null);
        label_alarm_addressLegal_town.setText(null);
        label_alarm_addressLegal_street.setText(null);
        label_alarm_addressLegal_house.setText(null);
        label_alarm_addressLegal_office.setText(null);
        label_alarm_addressLegal_district.setText(null);
        label_alarm_addressLegal_changes.setText(null);

        label_alarm_addressActual_regionId.setText(null);
        label_alarm_addressActual_regionName.setText(null);
        label_alarm_addressActual_index.setText(null);
        label_alarm_addressActual_town.setText(null);
        label_alarm_addressActual_street.setText(null);
        label_alarm_addressActual_house.setText(null);
        label_alarm_addressActual_office.setText(null);
        label_alarm_addressActual_district.setText(null);
        label_alarm_addressActual_changes.setText(null);

        label_alarm_socialNetworks_vkontakte.setText(null);
        label_alarm_socialNetworks_facebook.setText(null);
        label_alarm_socialNetworks_telegram.setText(null);
        label_alarm_socialNetworks_whatsapp.setText(null);
        label_alarm_socialNetworks_viber.setText(null);
        label_alarm_socialNetworks_skype.setText(null);
        label_alarm_socialNetworks_instagram.setText(null);
        label_alarm_socialNetworks_twitter.setText(null);
        label_alarm_socialNetworks_youtube.setText(null);

        label_alarm_createMember.setText(null);
    }

    private void clearText() {

        text_memberId.clear();
        text_memberSerial.clear();
        text_memberShortName.clear();

        text_relate_fullName.clear();
        text_relate_size.clear();
        text_relate_services.clear();
        text_relate_changes.clear();

        text_generalInformation_investmentsTarget.clear();
        text_generalInformation_investmentsSize.clear();
        text_generalInformation_changes.clear();

        text_director_fullName.clear();
        text_director_position.clear();
        text_director_phoneMobile.clear();
        text_director_phoneCity.clear();
        text_director_email.clear();
        text_director_changes.clear();

        text_contact_phone.clear();
        text_contact_fax.clear();
        text_contact_site.clear();
        text_contact_email.clear();
        text_contact_changes.clear();

        text_accoutingInformation_ogrn.clear();
        text_accoutingInformation_kpp.clear();
        text_accoutingInformation_tin.clear();

        text_debt_period.clear();
        text_debt_comment.clear();

        text_addressLegal_regionId.clear();
        text_addressLegal_index.clear();
        text_addressLegal_town.clear();
        text_addressLegal_street.clear();
        text_addressLegal_house.clear();
        text_addressLegal_office.clear();
        text_addressLegal_changes.clear();

        text_addressActual_regionId.clear();
        text_addressActual_index.clear();
        text_addressActual_town.clear();
        text_addressActual_street.clear();
        text_addressActual_house.clear();
        text_addressActual_office.clear();
        text_addressActual_changes.clear();

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

    private void clearInterest() {
        checkBox_generalInformation_vedImport.setSelected(false);
        checkBox_generalInformation_vedExport.setSelected(false);
        checkBox_generalInformation_interactionOnline.setSelected(false);
        checkBox_generalInformation_interactionOffline.setSelected(false);
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

    private void clearServices() {
        servicesCheckBoxMap.forEach((integer, checkBox) -> checkBox.setSelected(false));
    }

    public void clearAll() {
        clearObjects();
        clearLabelAlarm();
        clearText();
        clearInterest();
        clearServices();
    }


    @FXML
    public void saveMember(ActionEvent actionEvent) {
        if (!isFieldsEmpty()) {
            label_alarm_createMember.setTextFill(null);

            if (!DBConnection.isMemberExists(text_memberId.getText())) {
                setMemberParams();
                isMemberCreate = true;
                closeWindow(actionEvent);
            } else {
                MemberUtils.alertDialog("Организация с таким номером билета уже существует!");
            }
            clearAll();
        } else {
            label_alarm_createMember.setText("Заполните обязательные поля");
            label_alarm_createMember.setTextFill(MemberUtils.EMPTY_COLOR);
        }
    }

    private void setMemberParams() {
        member = new Member(text_memberId.getText(),
                Integer.valueOf(text_memberSerial.getText()),
                comboBox_memberStatus.getSelectionModel().getSelectedItem(),
                date_memberDate.getValue(),
                text_memberShortName.getText()
        );

        Relate relate = new Relate(member,
                text_relate_fullName.getText(),
                Integer.valueOf(text_relate_size.getText()),
                text_relate_services.getText());
        if (date_relate_dateOfCreation.getValue() != null)
            relate.setDateOfCreation(date_relate_dateOfCreation.getValue());
        if (text_relate_services.getText() != null)
            relate.setServices(text_relate_services.getText());
        if (text_relate_changes.getText() != null)
            relate.setChanges(text_relate_changes.getText());


        GeneralInformation genInf = new GeneralInformation(
                member,
                comboBox_generalInformation_organizationForm.getSelectionModel().getSelectedItem(),
                comboBox_generalInformation_economicSector.getSelectionModel().getSelectedItem(),
                comboBox_generalInformation_ownershipForm.getSelectionModel().getSelectedItem(),
                comboBox_generalInformation_activityType.getSelectionModel().getSelectedItem(),
                comboBox_generalInformation_businessForm.getSelectionModel().getSelectedItem(),
                checkBox_generalInformation_vedImport.isSelected(),
                checkBox_generalInformation_vedExport.isSelected(),
                checkBox_generalInformation_interactionOffline.isSelected(),
                checkBox_generalInformation_interactionOnline.isSelected(),
                checkBox_generalInformation_b2b.isSelected(),
                checkBox_generalInformation_b2c.isSelected(),
                checkBox_generalInformation_businessMissionVisiting.isSelected(),
                checkBox_generalInformation_businessMissionRegional.isSelected(),
                checkBox_generalInformation_mkas.isSelected(),
                checkBox_generalInformation_needForYoungPersonnel.isSelected(),
                checkBox_generalInformation_discounts.isSelected(),
                checkBox_generalInformation_reliablePartners.isSelected(),
                checkBox_generalInformation_pilotProjects.isSelected(),
                checkBox_generalInformation_antiCorruptionCharter.isSelected(),
                checkBox_generalInformation_newsletter.isSelected(),
                checkBox_generalInformation_committees.isSelected(),
                checkBox_generalInformation_corporateMember.isSelected()
        );

        if (text_generalInformation_investmentsTarget.getText() != null)
            genInf.setInvestmentsTarget(text_generalInformation_investmentsTarget.getText());
        if (text_generalInformation_investmentsSize.getText() != null) {
            genInf.setInvestmentsSize(text_generalInformation_investmentsSize.getText());
        }
        if (text_generalInformation_changes.getText() != null)
            genInf.setChanges(text_generalInformation_changes.getText());

        Director dir = new Director(
                member,
                text_director_position.getText(),
                text_director_fullName.getText(),
                text_director_phoneMobile.getText(),
                text_director_email.getText()
        );

        if (text_director_phoneCity.getText() != null)
            dir.setPhoneCity(text_director_phoneCity.getText());
        if (text_director_changes.getText() != null)
            dir.setChanges(text_director_changes.getText());


        Contact contact = new Contact(
                member,
                text_contact_phone.getText(),
                text_contact_email.getText()
        );

        if (text_contact_fax.getText().length() > 0)
            contact.setFax(text_contact_fax.getText());
        if (text_contact_site.getText().length() > 0)
            contact.setSite(text_contact_site.getText());
        if (text_contact_changes.getText().length() > 0)
            contact.setSite(text_contact_changes.getText());


        AccoutingInformation accoutingInformation = new AccoutingInformation(
                member,
                text_accoutingInformation_ogrn.getText(),
                text_accoutingInformation_kpp.getText(),
                text_accoutingInformation_tin.getText()
        );


        AddressLegal legal = new AddressLegal(
                member,
                Integer.valueOf(text_addressLegal_regionId.getText()),
                comboBox_addressLegal_regionName.getSelectionModel().getSelectedItem(),
                Integer.valueOf(text_addressLegal_index.getText()),
                text_addressLegal_town.getText(),
                text_addressLegal_street.getText(),
                text_addressLegal_house.getText()
        );

        if (text_addressLegal_office.getText().length() > 0)
            legal.setOffice(text_addressLegal_office.getText());
        if (!comboBox_addressLegal_district.isDisable())
            legal.setDistrict(comboBox_addressLegal_district.getSelectionModel().getSelectedItem());
        if (text_addressLegal_changes.getText().length() > 0)
            legal.setChanges(text_addressLegal_changes.getText());


        AddressActual actual = new AddressActual(
                member,
                Integer.valueOf(text_addressActual_regionId.getText()),
                comboBox_addressActual_regionName.getSelectionModel().getSelectedItem(),
                Integer.valueOf(text_addressActual_index.getText()),
                text_addressActual_town.getText(),
                text_addressActual_street.getText(),
                text_addressActual_house.getText()
        );

        if (text_addressActual_office.getText().length() > 0)
            actual.setOffice(text_addressActual_office.getText());
        if (!comboBox_addressActual_district.isDisable())
            actual.setDistrict(comboBox_addressActual_district.getSelectionModel().getSelectedItem());
        if (text_addressActual_changes.getText().length() > 0)
            actual.setChanges(text_addressActual_changes.getText());


        Debt debt = new Debt(
                member,
                MemberUtils.debtToBoolean(comboBox_debt_status.getSelectionModel().getSelectedItem())
        );

        if (text_debt_period.getText().length() > 0)
            debt.setPeriod(text_debt_period.getText());
        if (text_debt_comment.getText().length() > 0)
            debt.setComment(text_debt_comment.getText());


        SocialNetworks networks = new SocialNetworks(member);

        if (text_socialNetworks_vkontakte.getText().length() > 0)
            networks.setVkontakte(text_socialNetworks_vkontakte.getText());

        if (text_socialNetworks_facebook.getText().length() > 0)
            networks.setFacebook(text_socialNetworks_facebook.getText());

        if (text_socialNetworks_telegram.getText().length() > 0)
            networks.setTelegram(text_socialNetworks_telegram.getText());

        if (text_socialNetworks_whatsapp.getText().length() > 0)
            networks.setWhatsapp(text_socialNetworks_whatsapp.getText());

        if (text_socialNetworks_viber.getText().length() > 0)
            networks.setViber(text_socialNetworks_viber.getText());

        if (text_socialNetworks_skype.getText().length() > 0)
            networks.setSkype(text_socialNetworks_skype.getText());

        if (text_socialNetworks_instagram.getText().length() > 0)
            networks.setInstagram(text_socialNetworks_instagram.getText());

        if (text_socialNetworks_twitter.getText().length() > 0)
            networks.setTwitter(text_socialNetworks_twitter.getText());

        if (text_socialNetworks_youtube.getText().length() > 0)
            networks.setYoutube(text_socialNetworks_youtube.getText());

        List<Services> services = new ArrayList<>();
        servicesCheckBoxMap.forEach((integer, checkBox) -> {
            if (checkBox.isSelected()) {
                services.add(new Services(integer, checkBox.getText()));
            }
        });

        member.setRelate(relate);
        member.setGeneralInformation(genInf);
        member.setDirector(dir);
        member.setContact(contact);
        member.setAccoutingInformation(accoutingInformation);
        member.setAddressLegal(legal);
        member.setAddressActual(actual);
        member.setSocialNetworks(networks);
        member.setDebt(debt);
        member.setContactPerson(new ArrayList<>());
        member.setInvoice(new ArrayList<>());
        member.setServices(services);
    }

    private boolean isFieldsEmpty() {
        HashSet<Boolean> set = new HashSet<>();

        set.add(MemberUtils.isEmptyField(text_memberId));
        set.add(MemberUtils.isEmptyField(text_memberSerial));
        set.add(MemberUtils.isEmptyField(date_memberDate));
        set.add(MemberUtils.isEmptyField(comboBox_memberStatus));
        set.add(MemberUtils.isEmptyField(text_memberShortName));

        set.add(MemberUtils.isEmptyField(text_relate_fullName));
        set.add(MemberUtils.isEmptyField(text_relate_size));
        set.add(MemberUtils.isEmptyField(text_relate_services));

        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_organizationForm));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_economicSector));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_ownershipForm));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_activityType));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_businessForm));

        set.add(MemberUtils.isEmptyField(text_director_fullName));
        set.add(MemberUtils.isEmptyField(text_director_position));
        set.add(MemberUtils.isEmptyField(text_director_phoneMobile));
        set.add(MemberUtils.isEmptyField(text_director_email));

        set.add(MemberUtils.isEmptyField(text_contact_phone));
        set.add(MemberUtils.isEmptyField(text_contact_email));

        set.add(MemberUtils.isEmptyField(text_accoutingInformation_ogrn));
        set.add(MemberUtils.isEmptyField(text_accoutingInformation_kpp));
        set.add(MemberUtils.isEmptyField(text_accoutingInformation_tin));

        set.add(MemberUtils.isEmptyField(comboBox_debt_status));

        set.add(MemberUtils.isEmptyField(comboBox_addressLegal_regionName));
        set.add(MemberUtils.isEmptyField(text_addressLegal_index));
        set.add(MemberUtils.isEmptyField(text_addressLegal_town));
        set.add(MemberUtils.isEmptyField(text_addressLegal_street));
        set.add(MemberUtils.isEmptyField(text_addressLegal_house));

        set.add(MemberUtils.isEmptyField(comboBox_addressActual_regionName));
        set.add(MemberUtils.isEmptyField(text_addressActual_index));
        set.add(MemberUtils.isEmptyField(text_addressActual_town));
        set.add(MemberUtils.isEmptyField(text_addressActual_street));
        set.add(MemberUtils.isEmptyField(text_addressActual_house));

        return set.contains(true);
    }

    @FXML
    public void closeWindow(ActionEvent actionEvent) {
        clearAll();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void editAddressLegalRegionId() {
        Integer id = -1;
        if(comboBox_addressLegal_regionName.getSelectionModel().getSelectedIndex() != -1) {
            String regionName = comboBox_addressLegal_regionName.getValue();

            for (Map.Entry<Integer, String> entry : regionMap.entrySet()) {
                if (entry.getValue().equals(regionName)) {
                    id = entry.getKey();
                }
            }

            text_addressLegal_regionId.setText(id.toString());

            if (regionName.equals("Воронежская область")) {
                comboBox_addressLegal_district.setDisable(false);
            } else {
                comboBox_addressLegal_district.setDisable(true);
                comboBox_addressLegal_district.getSelectionModel().select(null);
            }
        } else text_addressLegal_regionId.clear();
    }

    public void editAddressActualRegionId() {
        Integer id = -1;
        if(comboBox_addressActual_regionName.getSelectionModel().getSelectedIndex() != -1) {
            String regionName = comboBox_addressActual_regionName.getValue();

            for (Map.Entry<Integer, String> entry : regionMap.entrySet()) {
                if (entry.getValue().equals(regionName)) {
                    id = entry.getKey();
                }
            }

            text_addressActual_regionId.setText(id.toString());

            if (regionName.equals("Воронежская область")) {
                comboBox_addressActual_district.setDisable(false);
            } else {
                comboBox_addressActual_district.setDisable(true);
                comboBox_addressActual_district.getSelectionModel().select(null);
            }
        } else text_addressActual_regionId.clear();
    }

    public void duplicateAddress(ActionEvent actionEvent) {
        comboBox_addressActual_regionName.getSelectionModel().select(comboBox_addressLegal_regionName.getSelectionModel().getSelectedItem());
        text_addressActual_index.setText(text_addressLegal_index.getText());
        text_addressActual_town.setText(text_addressLegal_town.getText());
        text_addressActual_street.setText(text_addressLegal_street.getText());
        text_addressActual_house.setText(text_addressLegal_house.getText());
        text_addressActual_office.setText(text_addressLegal_office.getText());
        comboBox_addressLegal_district.getSelectionModel().select(comboBox_addressActual_district.getSelectionModel().getSelectedItem());
        text_addressActual_changes.setText(text_addressLegal_changes.getText());
    }
}
