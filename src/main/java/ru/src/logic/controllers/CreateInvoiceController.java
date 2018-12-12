package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.omg.CORBA.INV_FLAG;
import ru.src.logic.implementation.DBConnection;
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

    private Invoice invoice;
    private Member member;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void saveInvoice(ActionEvent actionEvent) {
        invoice = new Invoice(this.member,
                              Integer.valueOf(text_invoiceNumber.getText()),
                              date_invoice_dateCreation.getValue(),
                              Integer.valueOf(text_invoice_price.getText()));
        invoice.setStatusPayment(false);
        invoice.setStatusReceiving(false);

        clearText();

        closeWindow(actionEvent);
    }

    public void initialize() {

    }

    @FXML
    private void closeWindow(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    private void clearText() {
        text_invoice_price.clear();
        text_invoiceNumber.clear();
        date_invoice_dateCreation.setValue(LocalDate.now());
    }

}
