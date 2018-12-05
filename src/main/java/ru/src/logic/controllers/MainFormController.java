package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;
import ru.src.model.buh.Invoice;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainFormController {


    private Organizations memberOrganizations = new Organizations();
    private HashMap<Integer, Invoice> invoiceHashMap = new HashMap<>();
    private HashMap<String, ContactPerson> contactPersonHashMap = new HashMap<>();

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
    public ComboBox cmbBox_contactPersonId;
    @FXML
    public Button btn_add_contactPerson;
    @FXML
    public Button btn_remove_contactPerson;
    @FXML
    public Button btn_rename_contactPerson;
    @FXML
    public TextField text_contactPerson_fullName;
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
    public TextField text_invoice_invoiceNumber;
    @FXML
    public DatePicker date_invoice_dateCreation;
    @FXML
    public TextField text_invoice_statusReceiving;
    @FXML
    public DatePicker date_invoice_dateReceiving;
    @FXML
    public TextField text_invoice_orderId;
    @FXML
    public DatePicker date_invoice_orderDate;
    @FXML
    public TextField text_invoice_price;
    @FXML
    public TextField text_invoice_statusPayment;
    @FXML
    public TextArea text_invoice_comment;

    @FXML
    public void initialize() {
        column_memberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        column_memberDate.setCellValueFactory(new PropertyValueFactory<>("memberDate"));
        column_memberSerial.setCellValueFactory(new PropertyValueFactory<>("memberSerial"));
        column_memberStatus.setCellValueFactory(new PropertyValueFactory<>("memberStatus"));
        column_memberShortName.setCellValueFactory(new PropertyValueFactory<>("memberShortName"));

        memberOrganizations.getMembers().addListener(new ListChangeListener<Member>() {
            @Override
            public void onChanged(Change<? extends Member> c) {

            }
        });

        table_members.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                Member member = (Member) table_members.getSelectionModel().getSelectedItem();
                fillAllInformation(member);
            }
        });

        long start = System.currentTimeMillis();
        table_members.setItems(memberOrganizations.getMembers());
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms");
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
        text_generalInformation_investmentsTarget.setText(generalInformation.getInvestmentsTarget());
        text_generalInformation_investmentsSize.setText(generalInformation.getInvestmentsSize());
        text_generalInformation_interactionOffline.setText(MemberUtils.isInteresting(generalInformation.isInteractionOffline()));
        text_generalInformation_interactionOnline.setText(MemberUtils.isInteresting(generalInformation.isInteractionOnline()));
        text_generalInformation_b2b.setText(MemberUtils.isInteresting(generalInformation.isB2b()));
        text_generalInformation_b2c.setText(MemberUtils.isInteresting(generalInformation.isB2c()));
        text_generalInformation_businessMissionVisiting.setText(MemberUtils.isInteresting(generalInformation.isBusinessMissionVisiting()));
        text_generalInformation_businessMissionRegional.setText(MemberUtils.isInteresting(generalInformation.isBusinessMissionRegional()));
        text_generalInformation_mkas.setText(MemberUtils.isInteresting(generalInformation.isMkas()));
        text_generalInformation_changes.setText(generalInformation.getChanges());

    }

    private void fillDirector(Director director) {
        text_director_position.setText(director.getPosition());
        text_director_fullName.setText(director.getFullName());
        text_director_phoneMobile.setText(director.getPhoneMobile());
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
        text_debt_status.setText(debt.getStatus());
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
        for(Invoice invoice: invoiceList) {
            invoiceHashMap.put(invoice.getInvoiceNumber(), invoice);
        }
        ObservableList<Integer> observableList = FXCollections.observableArrayList();
        invoiceHashMap.forEach((k, v) -> observableList.add(k));

        cmbBox_invoiceId.setItems(observableList);

    }

    private void fillContactPersons(List<ContactPerson> contactPeople) {
        contactPersonHashMap.clear();
        for(ContactPerson contactPerson: contactPeople) {
            contactPersonHashMap.put(contactPerson.getFullName(), contactPerson);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList();
        contactPersonHashMap.forEach((k, v) -> observableList.add(k));

        cmbBox_contactPersonId.setItems(observableList);
    }

    public void setMemberParams(MouseEvent mouseEvent) {

    }

    public void fillSelectedInvoice(ActionEvent actionEvent) {
        Invoice invoice = invoiceHashMap.get(cmbBox_invoiceId.getValue());

        date_invoice_dateCreation.setValue(null);
        text_invoice_statusReceiving.clear();
        date_invoice_dateReceiving.setValue(null);
        text_invoice_orderId.clear();
        date_invoice_orderDate.setValue(invoice.getOrderDate());
        text_invoice_price.clear();
        text_invoice_statusPayment.clear();
        text_invoice_comment.clear();

        date_invoice_dateCreation.setValue(invoice.getDateCreation());
        text_invoice_statusReceiving.setText(MemberUtils.isReceive(invoice.getStatusReceiving()));
        date_invoice_dateReceiving.setValue(invoice.getDateReceiving());
        text_invoice_orderId.setText(invoice.getOrderId().toString());
        date_invoice_orderDate.setValue(invoice.getOrderDate());
        text_invoice_price.setText(invoice.getPrice().toString());
        text_invoice_statusPayment.setText(MemberUtils.isPayment(invoice.getStatusPayment()));
        text_invoice_comment.setText(invoice.getComment());
    }


    public void fillSelectedPerson(ActionEvent actionEvent) {
        ContactPerson contactPerson = contactPersonHashMap.get(cmbBox_contactPersonId.getValue());

        text_contactPerson_position.clear();
        text_contactPerson_phoneMobile.clear();
        text_contactPerson_phoneCity.clear();
        text_contactPerson_email.clear();
        text_contactPerson_changes.clear();

        text_contactPerson_position.setText(contactPerson.getPosition());
        text_contactPerson_phoneMobile.setText(contactPerson.getPhoneMobile());
        text_contactPerson_phoneCity.setText(contactPerson.getPhoneCity());
        text_contactPerson_email.setText(contactPerson.getEmail());
        text_contactPerson_changes.setText(contactPerson.getChanges());
    }
}
