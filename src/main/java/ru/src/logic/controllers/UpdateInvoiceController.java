package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UpdateInvoiceController {
    @FXML
    public TextField text_invoiceId;
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

    public void updateInvoice(ActionEvent actionEvent) {
    }

    public void closeWindow(ActionEvent actionEvent) {
    }
}
