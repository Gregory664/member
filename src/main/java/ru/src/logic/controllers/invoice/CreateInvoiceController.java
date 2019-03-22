package ru.src.logic.controllers.invoice;

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

import java.util.HashSet;

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
    public Invoice getInvoice() {
        return invoice;
    }

    private Member member;
    public void setMember(Member member) {
        this.member = member;
    }

    private boolean createInvoice = false;
    public boolean isCreateInvoice() {
        return createInvoice;
    }

    @FXML
    public void initialize() {
        MemberUtils.checkTextDigital(text_invoiceNumber, label_alarm_invoiceNumber, 5);
        MemberUtils.checkTextDigital(text_invoice_price, label_alarm_invoice_price, 9);
    }

    @FXML
    public void saveInvoice(ActionEvent actionEvent) {
        if (!isFieldsEmpty()) {
            label_alarm_invoice_price.setTextFill(null);
            label_alarm_invoice_price.setText("");

            invoice = new Invoice(this.member,
                    Integer.valueOf(text_invoiceNumber.getText()),
                    date_invoice_dateCreation.getValue(),
                    Integer.valueOf(text_invoice_price.getText()));
            invoice.setStatusPayment(false);
            invoice.setStatusReceiving(false);

            createInvoice = true;
            closeCurrentStage(actionEvent);
        } else {
            label_alarm_invoiceNumber.setText("");
            label_alarm_invoice_dateCreation.setText("");
            label_alarm_invoice_price.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_invoice_price.setText("Заполните обязательные поля");
        }
    }

    private boolean isFieldsEmpty() {
        HashSet<Boolean> set = new HashSet<>();
        set.add(MemberUtils.isEmptyField(text_invoiceNumber));
        set.add(MemberUtils.isEmptyField(text_invoice_price));
        set.add(MemberUtils.isEmptyField(date_invoice_dateCreation));
        return set.contains(true);
    }

    @FXML
    private void closeCurrentStage(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
