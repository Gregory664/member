package ru.src.logic.controllers.invoice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Member;
import ru.src.model.buh.Invoice;

import java.awt.*;

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
    public ComboBox<String> cmbBox_statusReceiving;
    @FXML
    public ComboBox<String> cmbBox_statusPayment;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnCancel;
    @FXML
    public Label label_alarm_invoiceUpdate;

    private Invoice invoice;

    private ObservableList<String> payment = FXCollections.observableArrayList();
    private ObservableList<String> receive = FXCollections.observableArrayList();

    public Invoice getInvoice() {
        clearText();
        clearStyle();
        return invoice;
    }

    @FXML
    public void initialize(){
        //TODO поправить форму - добавить слушатели к боксу
        MemberUtils.checkTextDigital(text_orderId, 5);
        MemberUtils.checkTextLength(text_comment, label_alarm_invoiceUpdate, 255);
        date_dateCreation.setStyle("-fx-opacity: 1");
        date_dateCreation.getEditor().setStyle("-fx-opacity: 1");
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
    }


    public void updateInvoice(ActionEvent actionEvent) {
        clearStyle();
        label_alarm_invoiceUpdate.setText(null);

        boolean checkFields = true;
        if (cmbBox_statusReceiving.getSelectionModel().getSelectedItem().equals("Получен") &&
                date_dateReceiving.getValue() == null) {
            label_alarm_invoiceUpdate.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_invoiceUpdate.setText("Заполните обязательные поля");
            date_dateReceiving.setStyle("-fx-border-color: rgb(" + MemberUtils.EMPTY_COLOR2 + ");");
            checkFields = false;
        }
        if (cmbBox_statusPayment.getSelectionModel().getSelectedItem().equals("Отплачен") &&
                (date_orderDate.getValue() == null ||
                text_orderId.getText() == null) ) {
            label_alarm_invoiceUpdate.setTextFill(MemberUtils.EMPTY_COLOR);
            label_alarm_invoiceUpdate.setText("Заполните обязательные поля");
            date_orderDate.setStyle("-fx-border-color: rgb(" + MemberUtils.EMPTY_COLOR2 + ");");
            text_orderId.setStyle("-fx-border-color: rgb(" + MemberUtils.EMPTY_COLOR2 + ");");
            checkFields = false;
        }

        if (checkFields) {
            invoice.setInvoiceNumber(Integer.valueOf(text_invoiceNumber.getText()));
            invoice.setDateCreation(date_dateCreation.getValue());
            invoice.setDateReceiving(date_dateReceiving.getValue());
            invoice.setOrderId(text_orderId.getText());
            invoice.setOrderDate(date_orderDate.getValue());
            invoice.setPrice(Integer.valueOf(text_price.getText()));

            invoice.setStatusPayment(MemberUtils.paymentToBoolean(cmbBox_statusPayment.getSelectionModel().getSelectedItem().toString()));
            invoice.setStatusReceiving(MemberUtils.receiveToBoolean(cmbBox_statusReceiving.getSelectionModel().getSelectedItem().toString()));

            invoice.setComment(text_comment.getText());

            clearText();
            clearStyle();

            MemberUtils.informationDialog("Счет успешно обновлен!");
            closeWindow(actionEvent);
        }
    }

    public void closeWindow(ActionEvent actionEvent) {
        clearText();
        clearStyle();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    private void clearStyle() {
        label_alarm_invoiceUpdate.setText(null);
        date_dateReceiving.setStyle(null);
        date_orderDate.setStyle(null);
        text_orderId.setStyle(null);
    }

    private void clearText() {
        text_orderId.setText(null);
        text_comment.setText(null);
        text_price.setText(null);
        text_invoiceNumber.setText(null);
        date_orderDate.setValue(null);
        date_dateCreation.setValue(null);
        date_dateReceiving.setValue(null);
        label_alarm_invoiceUpdate.setText(null);
        payment.clear();
        receive.clear();
    }

}
