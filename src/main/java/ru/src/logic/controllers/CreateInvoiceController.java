package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Member;
import ru.src.model.buh.Invoice;

import java.time.LocalDate;

public class CreateInvoiceController {
    @FXML
    public TextField text_invoiceNumber;
    @FXML
    public TextField text_invoice_price;
    @FXML
    public DatePicker date_invoice_dateCreation;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnCancel;
    @FXML
    public Label label_alarm_invoiceNumber;
    @FXML
    public Label label_alarm_invoice_dateCreation;
    @FXML
    public Label label_alarm_invoice_price;

    private Invoice invoice;
    private Member member;
    private boolean createInvoice = false;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isCreateInvoice() {
        return createInvoice;
    }

    @FXML
    public void initialize(){
        MemberUtils.checkTextLength(text_invoiceNumber, label_alarm_invoiceNumber, 5);
        MemberUtils.checkTextLength(text_invoice_price, label_alarm_invoice_price, 9);
        MemberUtils.checkTextDigital(text_invoiceNumber);
        MemberUtils.checkTextDigital(text_invoice_price);
    }


    public void saveInvoice(ActionEvent actionEvent) {
        boolean isEmpty = false;
        if(MemberUtils.isEmptyTextField(text_invoiceNumber)) {
            MemberUtils.checkAlarm(text_invoiceNumber, label_alarm_invoiceNumber);
            isEmpty = true;
        } else {
            text_invoiceNumber.setStyle(null);
            label_alarm_invoiceNumber.setStyle(null);
            label_alarm_invoiceNumber.setText("");
        }

        if(MemberUtils.isEmptyTextField(text_invoice_price)) {
            MemberUtils.checkAlarm(text_invoice_price, label_alarm_invoice_price);
            isEmpty = true;
        } else {
            text_invoice_price.setStyle(null);
            label_alarm_invoice_price.setStyle(null);
            label_alarm_invoice_price.setText("");
        }

        if(date_invoice_dateCreation.getValue() == null) {
            MemberUtils.checkAlarm(date_invoice_dateCreation, label_alarm_invoice_dateCreation);
            isEmpty = true;
        } else {
            date_invoice_dateCreation.setStyle(null);
            label_alarm_invoice_dateCreation.setStyle(null);
            label_alarm_invoice_dateCreation.setText("");
        }

        if(!isEmpty) {
            invoice = new Invoice(this.member,
                    Integer.valueOf(text_invoiceNumber.getText()),
                    date_invoice_dateCreation.getValue(),
                    Integer.valueOf(text_invoice_price.getText()));
            invoice.setStatusPayment(false);
            invoice.setStatusReceiving(false);

            clearText();
            clearStyle();

            createInvoice = true;

            closeWindow(actionEvent);
        }
    }

    @FXML
    private void closeWindow(ActionEvent actionEvent) {
        createInvoice = false;
        clearText();
        clearStyle();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    private void clearText() {
        text_invoice_price.clear();
        text_invoiceNumber.clear();
        date_invoice_dateCreation.setValue(LocalDate.now());
        label_alarm_invoiceNumber.setText("");
        label_alarm_invoice_price.setText("");
        label_alarm_invoice_dateCreation.setText("");

    }

    private void clearStyle() {
        text_invoiceNumber.setStyle(null);
        text_invoice_price.setStyle(null);
        date_invoice_dateCreation.setStyle(null);
        label_alarm_invoice_dateCreation.setStyle(null);
        label_alarm_invoice_price.setStyle(null);
        label_alarm_invoiceNumber.setStyle(null);
    }




}
