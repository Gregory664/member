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
import ru.src.model.Personal.ContactPerson;
import ru.src.model.Personal.Director;
import ru.src.model.Personal.Relate;
import ru.src.model.SocialNetworks;
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;
import ru.src.model.buh.Invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CreateMemberFormController {

    ObservableList<String> memberStatus = ListUtils.getMemberStatusList();//
    ObservableList<String> organizationForm = ListUtils.getOrganizationForm();//
    ObservableList<String> economicSector = ListUtils.getEconomicSector();//
    ObservableList<String> ownershipForm = ListUtils.getOwnershipForm();//
    ObservableList<String> activityType = ListUtils.getActivityType();
    ObservableList<String> businessForm = ListUtils.getBusinessForm();
    ObservableList<String> interesting = ListUtils.getInteresting();
    ObservableList<String> ved = ListUtils.getVed();
    ObservableList<String> debd = ListUtils.getDedbStatusList();
    ObservableList<String> district = ListUtils.getDistrict();

    HashMap<Integer, String> regionMap = ListUtils.getRegionMap();
    ObservableList<String> region = FXCollections.observableArrayList();

    @FXML
    public TextField text_memberId;
    @FXML
    public TextField text_memberSerial;
    @FXML
    public ComboBox comboBox_memberStatus;
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
    public ComboBox comboBox_generalInformation_organizationForm;
    @FXML
    public ComboBox comboBox_generalInformation_economicSector;
    @FXML
    public TextArea text_generalInformation_investmentsTarget;
    @FXML
    public TextField text_generalInformation_investmentsSize;
    @FXML
    public TextArea text_generalInformation_changes;
    @FXML
    public ComboBox comboBox_generalInformation_ownershipForm;
    @FXML
    public ComboBox comboBox_generalInformation_activityType;
    @FXML
    public ComboBox comboBox_generalInformation_businessForm;
    @FXML
    public ComboBox comboBox_generalInformation_vedImport;
    @FXML
    public ComboBox comboBox_generalInformation_vedExport;
    @FXML
    public ComboBox comboBox_generalInformation_interactionOnline;
    @FXML
    public ComboBox comboBox_generalInformation_interactionOffline;
    @FXML
    public ComboBox comboBox_generalInformation_b2b;
    @FXML
    public ComboBox comboBox_generalInformation_b2c;
    @FXML
    public ComboBox comboBox_generalInformation_businessMissionVisiting;
    @FXML
    public ComboBox comboBox_generalInformation_businessMissionRegional;
    @FXML
    public ComboBox comboBox_generalInformation_mkas;
    @FXML
    public ComboBox comboBox_generalInformation_needForYoungPersonnel;
    @FXML
    public ComboBox comboBox_generalInformation_discounts;
    @FXML
    public ComboBox comboBox_generalInformation_reliablePartners;
    @FXML
    public ComboBox comboBox_generalInformation_pilotProjects;
    @FXML
    public ComboBox comboBox_generalInformation_antiCorruptionCharter;
    @FXML
    public Label label_alarm_generalInformation_organizationForm;
    @FXML
    public Label label_alarm_generalInformation_economicSector;
    @FXML
    public Label label_alarm_generalInformation_ownershipForm;
    @FXML
    public Label label_alarm_generalInformation_activityType;
    @FXML
    public Label label_alarm_generalInformation_businessForm;
    @FXML
    public Label label_alarm_generalInformation_vedImport;
    @FXML
    public Label label_alarm_generalInformation_vedExport;
    @FXML
    public Label label_alarm_generalInformation_investmentsTarget;
    @FXML
    public Label label_alarm_generalInformation_investmentsSize;
    @FXML
    public Label label_alarm_generalInformation_interactionOnline;
    @FXML
    public Label label_alarm_generalInformation_interactionOffline;
    @FXML
    public Label label_alarm_generalInformation_b2b;
    @FXML
    public Label label_alarm_generalInformation_b2c;
    @FXML
    public Label label_alarm_generalInformation_businessMissionVisiting;
    @FXML
    public Label label_alarm_generalInformation_businessMissionRegional;
    @FXML
    public Label label_alarm_generalInformation_mkas;
    @FXML
    public Label label_alarm_generalInformation_needForYoungPersonnel;
    @FXML
    public Label label_alarm_generalInformation_discounts;
    @FXML
    public Label label_alarm_generalInformation_reliablePartners;
    @FXML
    public Label label_alarm_generalInformation_pilotProjects;
    @FXML
    public Label label_alarm_generalInformation_antiCorruptionCharter;
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
    public ComboBox comboBox_debt_status;
    @FXML
    public Label label_alarm_debt_status;
    @FXML
    public Label label_alarm_debt_period;
    @FXML
    public Label label_alarm_debt_comment;


    @FXML
    public TextField text_addressLegal_regionId;
    @FXML
    public ComboBox comboBox_addressLegal_regionName;
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
    public ComboBox comboBox_addressLegal_district;
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
    public ComboBox comboBox_addressActual_regionName;
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
    public ComboBox comboBox_addressActual_district;
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
    public Button btn_saveMember;
    @FXML
    public Button btn_cancel;

    private Member member;

    public Member getMember() {
        return member;
    }

    @FXML
    public void initialize() {
        clearText();
        clearStyle();

        addCheckInfoListeners();
        fillAllComboBox();

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
        MemberUtils.checkTextLength(text_addressLegal_house, label_alarm_addressLegal_house, 45);
        MemberUtils.checkTextLength(text_addressLegal_office, label_alarm_addressLegal_office, 45);
        MemberUtils.checkTextLength(text_addressLegal_changes, label_alarm_addressLegal_changes, 255);

        MemberUtils.checkTextDigital(text_addressActual_regionId, label_alarm_addressActual_regionId, 3);
        MemberUtils.checkTextDigital(text_addressActual_index, label_alarm_addressActual_index, 6);
        MemberUtils.checkTextLength(text_addressActual_town, label_alarm_addressActual_town, 45);
        MemberUtils.checkTextLength(text_addressActual_street, label_alarm_addressActual_street, 45);
        MemberUtils.checkTextLength(text_addressActual_house, label_alarm_addressActual_house, 45);
        MemberUtils.checkTextLength(text_addressActual_office, label_alarm_addressActual_office, 45);
        MemberUtils.checkTextLength(text_addressActual_changes, label_alarm_addressActual_changes, 255);

        MemberUtils.checkTextLength(text_socialNetworks_vkontakte,  label_alarm_socialNetworks_vkontakte, 45);
        MemberUtils.checkTextLength(text_socialNetworks_facebook, label_alarm_socialNetworks_facebook, 45);
        MemberUtils.checkTextLength(text_socialNetworks_telegram, label_alarm_socialNetworks_telegram, 45);
        MemberUtils.checkTextLength(text_socialNetworks_whatsapp, label_alarm_socialNetworks_whatsapp, 45);
        MemberUtils.checkTextLength(text_socialNetworks_viber, label_alarm_socialNetworks_viber, 45);
        MemberUtils.checkTextLength(text_socialNetworks_skype, label_alarm_socialNetworks_skype, 45);
        MemberUtils.checkTextLength(text_socialNetworks_instagram, label_alarm_socialNetworks_instagram, 45);
        MemberUtils.checkTextLength(text_socialNetworks_twitter, label_alarm_socialNetworks_twitter, 45);
        MemberUtils.checkTextLength(text_socialNetworks_youtube,label_alarm_socialNetworks_youtube, 45);
    }


    private void fillAllComboBox() {
        comboBox_memberStatus.setItems(memberStatus);

        comboBox_generalInformation_organizationForm.setItems(organizationForm);
        comboBox_generalInformation_economicSector.setItems(economicSector);
        comboBox_generalInformation_ownershipForm.setItems(ownershipForm);
        comboBox_generalInformation_activityType.setItems(activityType);
        comboBox_generalInformation_businessForm.setItems(businessForm);
        comboBox_generalInformation_vedExport.setItems(ved);
        comboBox_generalInformation_vedImport.setItems(ved);
        comboBox_generalInformation_interactionOnline.setItems(interesting);
        comboBox_generalInformation_interactionOffline.setItems(interesting);
        comboBox_generalInformation_b2b.setItems(interesting);
        comboBox_generalInformation_b2c.setItems(interesting);
        comboBox_generalInformation_businessMissionVisiting.setItems(interesting);
        comboBox_generalInformation_businessMissionRegional.setItems(interesting);
        comboBox_generalInformation_mkas.setItems(interesting);
        comboBox_generalInformation_needForYoungPersonnel.setItems(interesting);
        comboBox_generalInformation_discounts.setItems(interesting);
        comboBox_generalInformation_reliablePartners.setItems(interesting);
        comboBox_generalInformation_pilotProjects.setItems(interesting);
        comboBox_generalInformation_antiCorruptionCharter.setItems(interesting);
        comboBox_debt_status.setItems(debd);
        comboBox_addressActual_district.setItems(district);
        comboBox_addressLegal_district.setItems(district);


        regionMap.forEach((integer, s) -> region.add(s));
        comboBox_addressActual_regionName.setItems(region);
        comboBox_addressLegal_regionName.setItems(region);
    }

    private void clearLabelAlarm() {
        label_alarm_memberId.setText("");
        label_alarm_memberSerial.setText("");
        label_alarm_memberStatus.setText("");
        label_alarm_memberDate.setText("");
        label_alarm_memberShortName.setText("");

        label_alarm_relate_fullName.setText("");
        label_alarm_relate_dateOfCreation.setText("");
        label_alarm_relate_size.setText("");
        label_alarm_relate_services.setText("");
        label_alarm_relate_changes.setText("");

        label_alarm_generalInformation_organizationForm.setText("");
        label_alarm_generalInformation_economicSector.setText("");
        label_alarm_generalInformation_ownershipForm.setText("");
        label_alarm_generalInformation_activityType.setText("");
        label_alarm_generalInformation_businessForm.setText("");
        label_alarm_generalInformation_vedExport.setText("");
        label_alarm_generalInformation_investmentsTarget.setText("");
        label_alarm_generalInformation_investmentsSize.setText("");
        label_alarm_generalInformation_interactionOnline.setText("");
        label_alarm_generalInformation_interactionOffline.setText("");
        label_alarm_generalInformation_b2b.setText("");
        label_alarm_generalInformation_b2c.setText("");
        label_alarm_generalInformation_businessMissionVisiting.setText("");
        label_alarm_generalInformation_businessMissionRegional.setText("");
        label_alarm_generalInformation_mkas.setText("");
        label_alarm_generalInformation_changes.setText("");
        label_alarm_generalInformation_vedImport.setText("");
        label_alarm_generalInformation_needForYoungPersonnel.setText("");
        label_alarm_generalInformation_discounts.setText("");
        label_alarm_generalInformation_reliablePartners.setText("");
        label_alarm_generalInformation_pilotProjects.setText("");
        label_alarm_generalInformation_antiCorruptionCharter.setText("");

        label_alarm_director_fullName.setText("");
        label_alarm_director_position.setText("");
        label_alarm_director_phoneMobile.setText("");
        label_alarm_director_phoneCity.setText("");
        label_alarm_director_email.setText("");
        label_alarm_director_birthday.setText("");
        label_alarm_director_changes.setText("");

        label_alarm_contact_phone.setText("");
        label_alarm_contact_fax.setText("");
        label_alarm_contact_site.setText("");
        label_alarm_contact_email.setText("");
        label_alarm_contact_changes.setText("");

        label_alarm_accoutingInformation_ogrn.setText("");
        label_alarm_accoutingInformation_kpp.setText("");
        label_alarm_accoutingInformation_tin.setText("");

        label_alarm_debt_status.setText("");
        label_alarm_debt_period.setText("");
        label_alarm_debt_comment.setText("");

        label_alarm_addressLegal_regionId.setText("");
        label_alarm_addressLegal_regionName.setText("");
        label_alarm_addressLegal_index.setText("");
        label_alarm_addressLegal_town.setText("");
        label_alarm_addressLegal_street.setText("");
        label_alarm_addressLegal_house.setText("");
        label_alarm_addressLegal_office.setText("");
        label_alarm_addressLegal_district.setText("");
        label_alarm_addressLegal_changes.setText("");

        label_alarm_addressActual_regionId.setText("");
        label_alarm_addressActual_regionName.setText("");
        label_alarm_addressActual_index.setText("");
        label_alarm_addressActual_town.setText("");
        label_alarm_addressActual_street.setText("");
        label_alarm_addressActual_house.setText("");
        label_alarm_addressActual_office.setText("");
        label_alarm_addressActual_district.setText("");
        label_alarm_addressActual_changes.setText("");

        label_alarm_socialNetworks_vkontakte.setText("");
        label_alarm_socialNetworks_facebook.setText("");
        label_alarm_socialNetworks_telegram.setText("");
        label_alarm_socialNetworks_whatsapp.setText("");
        label_alarm_socialNetworks_viber.setText("");
        label_alarm_socialNetworks_skype.setText("");
        label_alarm_socialNetworks_instagram.setText("");
        label_alarm_socialNetworks_twitter.setText("");
        label_alarm_socialNetworks_youtube.setText("");
    }

    private void clearText() {
        text_memberId.setText("");
        text_memberSerial.setText("");
        text_memberShortName.setText("");

        text_relate_fullName.setText("");
        text_relate_size.setText("");
        text_relate_services.setText("");
        text_relate_changes.setText("");

        text_generalInformation_investmentsTarget.setText("");
        text_generalInformation_investmentsSize.setText("");
        text_generalInformation_changes.setText("");

        text_director_fullName.setText("");
        text_director_position.setText("");
        text_director_phoneMobile.setText("");
        text_director_phoneCity.setText("");
        text_director_email.setText("");
        date_director_birthday.setValue(null);
        text_director_changes.setText("");

        text_contact_phone.setText("");
        text_contact_fax.setText("");
        text_contact_site.setText("");
        text_contact_email.setText("");
        text_contact_changes.setText("");

        text_accoutingInformation_ogrn.setText("");
        text_accoutingInformation_kpp.setText("");
        text_accoutingInformation_tin.setText("");

        text_debt_period.setText("");
        text_debt_comment.setText("");

        text_addressLegal_regionId.setText("");
        text_addressLegal_index.setText("");
        text_addressLegal_town.setText("");
        text_addressLegal_street.setText("");
        text_addressLegal_house.setText("");
        text_addressLegal_office.setText("");
        text_addressLegal_changes.setText("");

        text_addressActual_regionId.setText("");
        text_addressActual_index.setText("");
        text_addressActual_town.setText("");
        text_addressActual_street.setText("");
        text_addressActual_house.setText("");
        text_addressActual_office.setText("");
        text_addressActual_changes.setText("");

        text_socialNetworks_vkontakte.setText("");
        text_socialNetworks_facebook.setText("");
        text_socialNetworks_telegram.setText("");
        text_socialNetworks_whatsapp.setText("");
        text_socialNetworks_viber.setText("");
        text_socialNetworks_skype.setText("");
        text_socialNetworks_instagram.setText("");
        text_socialNetworks_twitter.setText("");
        text_socialNetworks_youtube.setText("");
    }

    private void clearStyle() {
        text_memberId.setStyle(null);
        text_memberSerial.setStyle(null);
        comboBox_memberStatus.setStyle(null);
        date_memberDate.setStyle(null);
        text_memberShortName.setStyle(null);

        text_relate_fullName.setStyle(null);
        date_relate_dateOfCreation.setStyle(null);
        text_relate_size.setStyle(null);
        text_relate_services.setStyle(null);
        text_relate_changes.setStyle(null);

        text_generalInformation_investmentsTarget.setStyle(null);
        text_generalInformation_investmentsSize.setStyle(null);
        text_generalInformation_changes.setStyle(null);

        text_director_fullName.setStyle(null);
        text_director_position.setStyle(null);
        text_director_phoneMobile.setStyle(null);
        text_director_phoneCity.setStyle(null);
        text_director_email.setStyle(null);
        date_director_birthday.setStyle(null);
        text_director_changes.setStyle(null);

        text_contact_phone.setStyle(null);
        text_contact_fax.setStyle(null);
        text_contact_site.setStyle(null);
        text_contact_email.setStyle(null);
        text_contact_changes.setStyle(null);

        text_accoutingInformation_ogrn.setStyle(null);
        text_accoutingInformation_kpp.setStyle(null);
        text_accoutingInformation_tin.setStyle(null);

        text_debt_period.setStyle(null);
        text_debt_comment.setStyle(null);

        text_addressLegal_regionId.setStyle(null);
        text_addressLegal_index.setStyle(null);
        text_addressLegal_town.setStyle(null);
        text_addressLegal_street.setStyle(null);
        text_addressLegal_house.setStyle(null);
        text_addressLegal_office.setStyle(null);
        text_addressLegal_changes.setStyle(null);

        text_addressActual_regionId.setStyle(null);
        text_addressActual_index.setStyle(null);
        text_addressActual_town.setStyle(null);
        text_addressActual_street.setStyle(null);
        text_addressActual_house.setStyle(null);
        text_addressActual_office.setStyle(null);
        text_addressActual_changes.setStyle(null);

        text_socialNetworks_vkontakte.setStyle(null);
        text_socialNetworks_facebook.setStyle(null);
        text_socialNetworks_telegram.setStyle(null);
        text_socialNetworks_whatsapp.setStyle(null);
        text_socialNetworks_viber.setStyle(null);
        text_socialNetworks_skype.setStyle(null);
        text_socialNetworks_instagram.setStyle(null);
        text_socialNetworks_twitter.setStyle(null);
        text_socialNetworks_youtube.setStyle(null);

    }

    private void clearLabelAlarmStyle() {
        label_alarm_memberId.setStyle(null);
        label_alarm_memberSerial.setStyle(null);
        label_alarm_memberStatus.setStyle(null);
        label_alarm_memberDate.setStyle(null);
        label_alarm_memberShortName.setStyle(null);

        label_alarm_relate_fullName.setStyle(null);
        label_alarm_relate_dateOfCreation.setStyle(null);
        label_alarm_relate_size.setStyle(null);
        label_alarm_relate_services.setStyle(null);
        label_alarm_relate_changes.setStyle(null);

        label_alarm_generalInformation_organizationForm.setStyle(null);
        label_alarm_generalInformation_economicSector.setStyle(null);
        label_alarm_generalInformation_ownershipForm.setStyle(null);
        label_alarm_generalInformation_activityType.setStyle(null);
        label_alarm_generalInformation_businessForm.setStyle(null);
        label_alarm_generalInformation_vedExport.setStyle(null);
        label_alarm_generalInformation_investmentsTarget.setStyle(null);
        label_alarm_generalInformation_investmentsSize.setStyle(null);
        label_alarm_generalInformation_interactionOnline.setStyle(null);
        label_alarm_generalInformation_interactionOffline.setStyle(null);
        label_alarm_generalInformation_b2b.setStyle(null);
        label_alarm_generalInformation_b2c.setStyle(null);
        label_alarm_generalInformation_businessMissionVisiting.setStyle(null);
        label_alarm_generalInformation_businessMissionRegional.setStyle(null);
        label_alarm_generalInformation_mkas.setStyle(null);
        label_alarm_generalInformation_changes.setStyle(null);
        label_alarm_generalInformation_vedImport.setStyle(null);
        label_alarm_generalInformation_needForYoungPersonnel.setStyle(null);
        label_alarm_generalInformation_discounts.setStyle(null);
        label_alarm_generalInformation_reliablePartners.setStyle(null);
        label_alarm_generalInformation_pilotProjects.setStyle(null);
        label_alarm_generalInformation_antiCorruptionCharter.setStyle(null);

        label_alarm_director_fullName.setStyle(null);
        label_alarm_director_position.setStyle(null);
        label_alarm_director_phoneMobile.setStyle(null);
        label_alarm_director_phoneCity.setStyle(null);
        label_alarm_director_email.setStyle(null);
        label_alarm_director_birthday.setStyle(null);
        label_alarm_director_changes.setStyle(null);

        label_alarm_contact_phone.setStyle(null);
        label_alarm_contact_fax.setStyle(null);
        label_alarm_contact_site.setStyle(null);
        label_alarm_contact_email.setStyle(null);
        label_alarm_contact_changes.setStyle(null);

        label_alarm_accoutingInformation_ogrn.setStyle(null);
        label_alarm_accoutingInformation_kpp.setStyle(null);
        label_alarm_accoutingInformation_tin.setStyle(null);

        label_alarm_debt_status.setStyle(null);
        label_alarm_debt_period.setStyle(null);
        label_alarm_debt_comment.setStyle(null);

        label_alarm_addressLegal_regionId.setStyle(null);
        label_alarm_addressLegal_regionName.setStyle(null);
        label_alarm_addressLegal_index.setStyle(null);
        label_alarm_addressLegal_town.setStyle(null);
        label_alarm_addressLegal_street.setStyle(null);
        label_alarm_addressLegal_house.setStyle(null);
        label_alarm_addressLegal_office.setStyle(null);
        label_alarm_addressLegal_district.setStyle(null);
        label_alarm_addressLegal_changes.setStyle(null);

        label_alarm_addressActual_regionId.setStyle(null);
        label_alarm_addressActual_regionName.setStyle(null);
        label_alarm_addressActual_index.setStyle(null);
        label_alarm_addressActual_town.setStyle(null);
        label_alarm_addressActual_street.setStyle(null);
        label_alarm_addressActual_house.setStyle(null);
        label_alarm_addressActual_office.setStyle(null);
        label_alarm_addressActual_district.setStyle(null);
        label_alarm_addressActual_changes.setStyle(null);

        label_alarm_socialNetworks_vkontakte.setStyle(null);
        label_alarm_socialNetworks_facebook.setStyle(null);
        label_alarm_socialNetworks_telegram.setStyle(null);
        label_alarm_socialNetworks_whatsapp.setStyle(null);
        label_alarm_socialNetworks_viber.setStyle(null);
        label_alarm_socialNetworks_skype.setStyle(null);
        label_alarm_socialNetworks_instagram.setStyle(null);
        label_alarm_socialNetworks_twitter.setStyle(null);
        label_alarm_socialNetworks_youtube.setStyle(null);
    }

    private void fillSocialNetworks() {
        text_socialNetworks_vkontakte.setText(member.getSocialNetworks().getVkontakte());
        text_socialNetworks_facebook.setText(member.getSocialNetworks().getFacebook());
        text_socialNetworks_telegram.setText(member.getSocialNetworks().getTelegram());
        text_socialNetworks_whatsapp.setText(member.getSocialNetworks().getWhatsapp());
        text_socialNetworks_viber.setText(member.getSocialNetworks().getViber());
        text_socialNetworks_skype.setText(member.getSocialNetworks().getSkype());
        text_socialNetworks_instagram.setText(member.getSocialNetworks().getInstagram());
        text_socialNetworks_twitter.setText(member.getSocialNetworks().getTwitter());
        text_socialNetworks_youtube.setText(member.getSocialNetworks().getYoutube());
    }

    private void fillAddressActual() {
        text_addressActual_regionId.setText(member.getAddressActual().getRegionId().toString());
        comboBox_addressActual_regionName.getSelectionModel().select(member.getAddressActual().getRegionName());
        text_addressActual_index.setText(member.getAddressActual().getIndex().toString());
        text_addressActual_town.setText(member.getAddressActual().getTown());
        text_addressActual_street.setText(member.getAddressActual().getStreet());
        text_addressActual_house.setText(member.getAddressActual().getHouse());
        text_addressActual_office.setText(member.getAddressActual().getOffice());
        comboBox_addressActual_district.getSelectionModel().select(member.getAddressActual().getDistrict());
        text_addressActual_changes.setText(member.getAddressActual().getChanges());
    }

    private void fillAddressLegal() {
        text_addressLegal_regionId.setText(member.getAddressLegal().getRegionId().toString());
        comboBox_addressLegal_regionName.getSelectionModel().select(member.getAddressLegal().getRegionName());
        text_addressLegal_index.setText(member.getAddressLegal().getIndex().toString());
        text_addressLegal_town.setText(member.getAddressLegal().getTown());
        text_addressLegal_street.setText(member.getAddressLegal().getStreet());
        text_addressLegal_house.setText(member.getAddressLegal().getHouse());
        text_addressLegal_office.setText(member.getAddressLegal().getOffice());
        comboBox_addressLegal_district.getSelectionModel().select(member.getAddressLegal().getDistrict());
        text_addressLegal_changes.setText(member.getAddressLegal().getChanges());
    }

    private void fillDebt() {
        text_debt_period.setText(member.getDebt().getPeriod());
        comboBox_debt_status.getSelectionModel().select(MemberUtils.isDebt(member.getDebt().getStatus()));
        text_debt_comment.setText(member.getDebt().getComment());
    }

    private void fillAccoutingInformation() {
        text_accoutingInformation_ogrn.setText(member.getAccoutingInformation().getOgrn());
        text_accoutingInformation_kpp.setText(member.getAccoutingInformation().getKpp());
        text_accoutingInformation_tin.setText(member.getAccoutingInformation().getTin());
    }

    private void fillContact() {
        text_contact_phone.setText(member.getContact().getPhone());
        text_contact_fax.setText(member.getContact().getFax());
        text_contact_site.setText(member.getContact().getSite());
        text_contact_email.setText(member.getContact().getEmail());
        text_contact_changes.setText(member.getContact().getChanges());
    }

    private void fillDirector() {
        text_director_fullName.setText(member.getDirector().getFullName());
        text_director_position.setText(member.getDirector().getPosition());
        text_director_phoneMobile.setText(member.getDirector().getPhoneMobile());
        text_director_phoneCity.setText(member.getDirector().getPhoneCity());
        text_director_email.setText(member.getDirector().getEmail());
        date_director_birthday.setValue(member.getDirector().getBirthday());
        text_director_changes.setText(member.getDirector().getChanges());
    }

    private void fillGeneralInformation() {
        comboBox_generalInformation_organizationForm.getSelectionModel().select(member.getGeneralInformation().getOrganizationForm());
        comboBox_generalInformation_economicSector.getSelectionModel().select(member.getGeneralInformation().getEconomicSector());
        text_generalInformation_investmentsTarget.setText(member.getGeneralInformation().getInvestmentsTarget());
        text_generalInformation_investmentsSize.setText(member.getGeneralInformation().getInvestmentsSize().toString());
        text_generalInformation_changes.setText(member.getGeneralInformation().getChanges());
        comboBox_generalInformation_ownershipForm.getSelectionModel().select(member.getGeneralInformation().getOwnershipForm());
        comboBox_generalInformation_activityType.getSelectionModel().select(member.getGeneralInformation().getActivityType());
        comboBox_generalInformation_businessForm.getSelectionModel().select(member.getGeneralInformation().getBusinessForm());
        comboBox_generalInformation_vedImport.getSelectionModel().select(MemberUtils.isImportExport(member.getGeneralInformation().isVedImport()));
        comboBox_generalInformation_vedExport.getSelectionModel().select(MemberUtils.isImportExport(member.getGeneralInformation().isVedExport()));
        comboBox_generalInformation_interactionOnline.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isInteractionOnline()));
        comboBox_generalInformation_interactionOffline.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isInteractionOffline()));
        comboBox_generalInformation_b2b.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isB2b()));
        comboBox_generalInformation_b2c.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isB2c()));
        comboBox_generalInformation_businessMissionVisiting.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isBusinessMissionRegional()));
        comboBox_generalInformation_businessMissionRegional.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isBusinessMissionRegional()));
        comboBox_generalInformation_mkas.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isMkas()));
        comboBox_generalInformation_needForYoungPersonnel.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isNeedForYoungPersonnel()));
        comboBox_generalInformation_discounts.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isDiscounts()));
        comboBox_generalInformation_reliablePartners.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isReliablePartners()));
        comboBox_generalInformation_pilotProjects.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isPilotProjects()));
        comboBox_generalInformation_antiCorruptionCharter.getSelectionModel().select(MemberUtils.isInteresting(member.getGeneralInformation().isAntiCorruptionCharter()));

    }

    private void fillMember() {
        text_memberId.setText(member.getMemberId());
        text_memberSerial.setText(member.getMemberSerial().toString());
        comboBox_memberStatus.getSelectionModel().select(member.getMemberStatus());
        date_memberDate.setValue(member.getMemberDate());
        text_memberShortName.setText(member.getMemberShortName());
    }

    private void fillRelate() {
        text_relate_fullName.setText(member.getRelate().getFullName());
        date_relate_dateOfCreation.setValue(member.getRelate().getDateOfCreation());
        text_relate_size.setText(member.getRelate().getSize().toString());
        text_relate_services.setText(member.getRelate().getServices());
        text_relate_changes.setText(member.getRelate().getChanges());
    }


    private void fillAllFields() {
        fillMember();
        fillRelate();
        fillGeneralInformation();
        fillDirector();
        fillContact();
        fillAccoutingInformation();
        fillDebt();
        fillAddressLegal();
        fillAddressActual();
        fillSocialNetworks();
    }

    private boolean isMemberCreate = false;

    public boolean isMemberCreate() {
        return isMemberCreate;
    }

    public void setMemberCreate(boolean memberCreate) {
        isMemberCreate = memberCreate;
    }

    @FXML
    public void saveMember(ActionEvent actionEvent) {
        if(!isFieldsEmpty()) {
            if(!DBConnection.isMemberExists(text_memberId.getText())) {
                setMemberParams();
                isMemberCreate = true;
                clearText();
                clearStyle();
                closeWindow(actionEvent);
            } else {
                MemberUtils.alertDialog("Организация с таким номером билета уже существует!");
            }
        }

    }

    private void setMemberParams() {
        member = new Member(text_memberId.getText(),
                Integer.valueOf(text_memberSerial.getText()),
                comboBox_memberStatus.getSelectionModel().getSelectedItem().toString(),
                date_memberDate.getValue(),
                text_memberShortName.getText()
        );

        Relate relate = new Relate(member,
                text_relate_fullName.getText(),
                Integer.valueOf(text_relate_size.getText()),
                text_relate_services.getText());
        if (date_relate_dateOfCreation.getValue() != null)
            relate.setDateOfCreation(date_relate_dateOfCreation.getValue());
        if (text_relate_services.getText().length() > 0)
            relate.setServices(text_relate_services.getText());


        GeneralInformation genInf = new GeneralInformation(
                member,
                comboBox_generalInformation_organizationForm.getSelectionModel().getSelectedItem().toString(),
                comboBox_generalInformation_economicSector.getSelectionModel().getSelectedItem().toString(),
                comboBox_generalInformation_ownershipForm.getSelectionModel().getSelectedItem().toString(),
                comboBox_generalInformation_activityType.getSelectionModel().getSelectedItem().toString(),
                comboBox_generalInformation_businessForm.getSelectionModel().getSelectedItem().toString(),
                MemberUtils.vedToBoolean(comboBox_generalInformation_vedImport.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.vedToBoolean(comboBox_generalInformation_vedExport.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_interactionOffline.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_interactionOnline.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_b2b.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_b2c.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_businessMissionVisiting.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_businessMissionRegional.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_mkas.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_needForYoungPersonnel.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_discounts.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_reliablePartners.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_pilotProjects.getSelectionModel().getSelectedItem().toString()),
                MemberUtils.interestingToBoolean(comboBox_generalInformation_antiCorruptionCharter.getSelectionModel().getSelectedItem().toString())
        );

        if (text_generalInformation_investmentsTarget.getText().length() > 0)
            genInf.setInvestmentsTarget(text_generalInformation_investmentsTarget.getText());
        if (text_generalInformation_investmentsSize.getText().length() > 0)
            genInf.setInvestmentsSize(Integer.valueOf(text_generalInformation_investmentsSize.getText()));


        Director dir = new Director(
                member,
                text_director_position.getText(),
                text_director_fullName.getText(),
                text_director_phoneMobile.getText(),
                text_director_email.getText()
        );

        if (text_director_phoneCity.getText().length() > 0)
            dir.setPhoneCity(text_director_phoneCity.getText());
        if (text_director_changes.getText().length() > 0)
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
                comboBox_addressLegal_regionName.getSelectionModel().getSelectedItem().toString(),
                Integer.valueOf(text_addressLegal_index.getText()),
                text_addressLegal_town.getText(),
                text_addressLegal_street.getText(),
                text_addressLegal_house.getText()
        );

        if (text_addressLegal_office.getText().length() > 0)
            legal.setOffice(text_addressLegal_office.getText());
        if (!comboBox_addressLegal_district.isDisable())
            legal.setDistrict(comboBox_addressLegal_district.getSelectionModel().getSelectedItem().toString());
        if (text_addressLegal_changes.getText().length() > 0)
            legal.setChanges(text_addressLegal_changes.getText());


        AddressActual actual = new AddressActual(
                member,
                Integer.valueOf(text_addressActual_regionId.getText()),
                comboBox_addressActual_regionName.getSelectionModel().getSelectedItem().toString(),
                Integer.valueOf(text_addressActual_index.getText()),
                text_addressActual_town.getText(),
                text_addressActual_street.getText(),
                text_addressActual_house.getText()
        );

        if (text_addressActual_office.getText().length() > 0)
            actual.setOffice(text_addressActual_office.getText());
        if (!comboBox_addressActual_district.isDisable())
            actual.setDistrict(comboBox_addressActual_district.getSelectionModel().getSelectedItem().toString());
        if (text_addressActual_changes.getText().length() > 0)
            actual.setChanges(text_addressActual_changes.getText());


        Debt debt = new Debt(
                member,
                MemberUtils.debtToBoolean(comboBox_debt_status.getSelectionModel().getSelectedItem().toString())
        );

        if(text_debt_period.getText().length() > 0)
            debt.setPeriod(text_debt_period.getText());
        if(text_debt_comment.getText().length() > 0)
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

        member.setRelate(relate);
        member.setGeneralInformation(genInf);
        member.setDirector(dir);
        member.setContact(contact);
        member.setAccoutingInformation(accoutingInformation);
        member.setAddressLegal(legal);
        member.setAddressActual(actual);
        member.setSocialNetworks(networks);
        member.setDebt(debt);
        member.setContactPerson(new ArrayList<ContactPerson>());
        member.setInvoice(new ArrayList<Invoice>());

    }

    private boolean isFieldsEmpty() {
        HashSet<Boolean> set = new HashSet<Boolean>();

        set.add(MemberUtils.isEmptyField(text_memberId, label_alarm_memberId));
        set.add(MemberUtils.isEmptyField(text_memberSerial, label_alarm_memberSerial));
        set.add(MemberUtils.isEmptyField(date_memberDate, label_alarm_memberDate));
        set.add(MemberUtils.isEmptyField(comboBox_memberStatus, label_alarm_memberStatus));
        set.add(MemberUtils.isEmptyField(text_memberShortName, label_alarm_memberShortName));

        set.add(MemberUtils.isEmptyField(text_relate_fullName, label_alarm_relate_fullName));
        //MemberUtils.isEmptyField(isEmpty, date_relate_dateOfCreation, label_alarm_relate_dateOfCreation);
        set.add(MemberUtils.isEmptyField(text_relate_size, label_alarm_relate_size));
        set.add(MemberUtils.isEmptyField(text_relate_services, label_alarm_relate_services));
        //MemberUtils.isEmptyField(isEmpty, text_relate_changes, label_alarm_relate_changes);

        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_organizationForm, label_alarm_generalInformation_organizationForm));
        set.add( MemberUtils.isEmptyField(comboBox_generalInformation_economicSector, label_alarm_generalInformation_economicSector));
        //MemberUtils.isEmptyField(isEmpty, text_generalInformation_investmentsTarget, label_alarm_generalInformation_investmentsTarget);
        //MemberUtils.isEmptyField(isEmpty, text_generalInformation_investmentsSize, label_alarm_generalInformation_investmentsSize);
        //MemberUtils.isEmptyField(isEmpty, text_generalInformation_changes, label_alarm_generalInformation_changes);
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_ownershipForm, label_alarm_generalInformation_ownershipForm));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_activityType, label_alarm_generalInformation_activityType));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_businessForm, label_alarm_generalInformation_businessForm));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_vedImport, label_alarm_generalInformation_vedImport));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_vedExport, label_alarm_generalInformation_vedExport));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_interactionOnline, label_alarm_generalInformation_interactionOnline));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_interactionOffline, label_alarm_generalInformation_interactionOffline));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_b2b, label_alarm_generalInformation_b2b));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_b2c, label_alarm_generalInformation_b2c));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_businessMissionVisiting, label_alarm_generalInformation_businessMissionVisiting));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_businessMissionRegional, label_alarm_generalInformation_businessMissionRegional));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_mkas, label_alarm_generalInformation_mkas));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_needForYoungPersonnel, label_alarm_generalInformation_needForYoungPersonnel));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_discounts, label_alarm_generalInformation_discounts));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_reliablePartners, label_alarm_generalInformation_reliablePartners));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_pilotProjects, label_alarm_generalInformation_pilotProjects));
        set.add(MemberUtils.isEmptyField(comboBox_generalInformation_antiCorruptionCharter, label_alarm_generalInformation_antiCorruptionCharter));


        set.add(MemberUtils.isEmptyField(text_director_fullName, label_alarm_director_fullName));
        set.add(MemberUtils.isEmptyField(text_director_position, label_alarm_director_position));
        set.add(MemberUtils.isEmptyField(text_director_phoneMobile, label_alarm_director_phoneMobile));
        //MemberUtils.isEmptyField(isEmpty, text_director_phoneCity, label_alarm_director_phoneCity);
        set.add(MemberUtils.isEmptyField(text_director_email, label_alarm_director_email));
        //MemberUtils.isEmptyField(isEmpty, date_director_birthday, label_alarm_director_birthday);
        //MemberUtils.isEmptyField(isEmpty, text_director_changes, label_alarm_director_changes);

        set.add(MemberUtils.isEmptyField(text_contact_phone, label_alarm_contact_phone));
        //MemberUtils.isEmptyField(isEmpty, text_contact_fax, label_alarm_contact_fax);
        //MemberUtils.isEmptyField(isEmpty, text_contact_site, label_alarm_contact_site);
        set.add(MemberUtils.isEmptyField(text_contact_email, label_alarm_contact_email));
        //MemberUtils.isEmptyField(isEmpty, text_contact_changes, label_alarm_contact_changes);

        set.add(MemberUtils.isEmptyField(text_accoutingInformation_ogrn, label_alarm_accoutingInformation_ogrn));
        set.add(MemberUtils.isEmptyField(text_accoutingInformation_kpp, label_alarm_accoutingInformation_kpp));
        set.add(MemberUtils.isEmptyField(text_accoutingInformation_tin, label_alarm_accoutingInformation_tin));

        //MemberUtils.isEmptyField(isEmpty, text_debt_period, label_alarm_debt_period);
        //MemberUtils.isEmptyField(isEmpty, text_debt_comment, label_alarm_debt_comment);
        set.add(MemberUtils.isEmptyField(comboBox_debt_status, label_alarm_debt_status));

        //MemberUtils.isEmptyField(isEmpty, text_addressLegal_regionId, label_alarm_addressLegal_regionId);
        set.add(MemberUtils.isEmptyField(comboBox_addressLegal_regionName, label_alarm_addressLegal_regionName));
        set.add(MemberUtils.isEmptyField(text_addressLegal_index, label_alarm_addressLegal_index));
        set.add(MemberUtils.isEmptyField(text_addressLegal_town, label_alarm_addressLegal_town));
        set.add(MemberUtils.isEmptyField(text_addressLegal_street, label_alarm_addressLegal_street));
        set.add(MemberUtils.isEmptyField(text_addressLegal_house, label_alarm_addressLegal_house));
        //MemberUtils.isEmptyField(isEmpty, text_addressLegal_office, label_alarm_addressLegal_office);
       // MemberUtils.isEmptyField(isEmpty, comboBox_addressLegal_district, label_alarm_addressLegal_district);
        //MemberUtils.isEmptyField(isEmpty, text_addressLegal_changes, label_alarm_addressLegal_changes);

        //MemberUtils.isEmptyField(isEmpty, text_addressActual_regionId, label_alarm_addressActual_regionId);
        set.add(MemberUtils.isEmptyField(comboBox_addressActual_regionName, label_alarm_addressActual_regionName));
        set.add(MemberUtils.isEmptyField(text_addressActual_index, label_alarm_addressActual_index));
        set.add(MemberUtils.isEmptyField(text_addressActual_town, label_alarm_addressActual_town));
        set.add(MemberUtils.isEmptyField(text_addressActual_street, label_alarm_addressActual_street));
        set.add(MemberUtils.isEmptyField(text_addressActual_house, label_alarm_addressActual_house));

        return set.contains(true);
    }

    @FXML
    public void closeWindow(ActionEvent actionEvent) {
        clearText();
        clearStyle();
        clearLabelAlarm();
        clearLabelAlarmStyle();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void editAddressLegalRegionId(ActionEvent actionEvent) {
        Integer id = -1;
        String regionName = comboBox_addressLegal_regionName.getValue().toString();

        for(Map.Entry<Integer, String> entry: regionMap.entrySet()) {
            if(entry.getValue().equals(regionName)) {
                id = entry.getKey();
            }
        }

        text_addressLegal_regionId.setText(id.toString());

        if(regionName.equals("Воронежская область")) {
            comboBox_addressLegal_district.setDisable(false);
        }
        else {
            comboBox_addressLegal_district.setDisable(true);
            comboBox_addressLegal_district.getSelectionModel().select(null);
        }
    }

    public void editAddressActualRegionId(ActionEvent actionEvent) {
        Integer id = -1;
        String regionName = comboBox_addressActual_regionName.getValue().toString();

        for(Map.Entry<Integer, String> entry: regionMap.entrySet()) {
            if(entry.getValue().equals(regionName)) {
                id = entry.getKey();
            }
        }

        text_addressActual_regionId.setText(id.toString());

        if(regionName.equals("Воронежская область")) {
            comboBox_addressActual_district.setDisable(false);
        }
        else {

            comboBox_addressActual_district.setDisable(true);
            comboBox_addressActual_district.getSelectionModel().select(null);
        }
    }
}
