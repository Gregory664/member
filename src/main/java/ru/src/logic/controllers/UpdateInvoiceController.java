package ru.src.logic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Member;
import ru.src.model.buh.Invoice;

import java.util.List;
import java.util.regex.Pattern;

public class UpdateInvoiceController {
    @FXML
    public TextField text_invoiceNumber;
    @FXML
    public DatePicker date_dateCreation;
    @FXML
    public DatePicker date_dateReceiving;
    @FXML
    public TextField text_orderId;
    @FXML
    public DatePicker date_orderDate;
    @FXML
    public TextField text_price;
    @FXML
    public TextArea text_comment;
    @FXML
    public ComboBox cmbBox_statusReceiving;
    @FXML
    public ComboBox cmbBox_statusPayment;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnCancel;

    private Invoice invoice;

    private ObservableList<String> payment = FXCollections.observableArrayList();
    private ObservableList<String> receive = FXCollections.observableArrayList();

    public Invoice getInvoice() {
        return invoice;
    }

    @FXML
    public void initialize(){
        Pattern p = Pattern.compile("\\d+");

        MemberUtils.checkDigital(text_orderId);

    }



    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
        fillPayment();
        fillReceive();
        fillFields();

    }

    private void fillPayment() {
        payment.add("Отплачен");
        payment.add("Не отплачен");
        cmbBox_statusPayment.setItems(payment);
    }

    private void fillReceive() {
        receive.add("Получен");
        receive.add("Не получен");
        cmbBox_statusReceiving.setItems(receive);
    }

    private void fillFields() {
        text_invoiceNumber.setText(invoice.getInvoiceNumber().toString());
        date_dateCreation.setValue(invoice.getDateCreation());
        date_dateReceiving.setValue(invoice.getDateReceiving());
        text_orderId.setText(invoice.getOrderId());
        date_orderDate.setValue(invoice.getOrderDate());
        text_price.setText(invoice.getPrice().toString());
        cmbBox_statusPayment.getSelectionModel().select(MemberUtils.isPayment(invoice.getStatusPayment()));
        cmbBox_statusReceiving.getSelectionModel().select(MemberUtils.isReceive(invoice.getStatusReceiving()));

        text_comment.setText(invoice.getComment());

        setDateOfCreationHide();


    }

    private void setDateOfCreationHide() {
        date_dateCreation.setEditable(false);

        date_dateCreation.setOnMouseClicked(e -> {
            if(!date_dateCreation.isEditable())
                date_dateCreation.hide();
        });
    }

    public void updateInvoice(ActionEvent actionEvent) {
        invoice.setInvoiceNumber(Integer.valueOf(text_invoiceNumber.getText()));
        invoice.setDateCreation(date_dateCreation.getValue());
        invoice.setDateReceiving(date_dateReceiving.getValue());
        invoice.setOrderId(text_orderId.getText());
        invoice.setOrderDate(date_orderDate.getValue());
        invoice.setPrice(Integer.valueOf(text_price.getText()));

        invoice.setStatusPayment(MemberUtils.paymentToBoolean(cmbBox_statusPayment.getSelectionModel().getSelectedItem().toString()));
        invoice.setStatusReceiving(MemberUtils.receiveToBoolean(cmbBox_statusReceiving.getSelectionModel().getSelectedItem().toString()));

        invoice.setComment(text_comment.getText());

        payment.clear();
        receive.clear();

        MemberUtils.alertDialog("Счет успешно обновлен!");
        closeWindow(actionEvent);
    }

    public void closeWindow(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }


}
