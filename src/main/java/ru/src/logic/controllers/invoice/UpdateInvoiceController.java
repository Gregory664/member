package ru.src.logic.controllers.invoice;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.buh.Invoice;

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

    public Invoice getInvoice() {
        return invoice;
    }

    private Boolean invoiceUpdate = false;

    public Boolean isInvoiceUpdate() {
        return invoiceUpdate;
    }

    private ObservableList<String> payment = ListUtils.getPayment();

    private ObservableList<String> receive = ListUtils.getReceive();

    @FXML
    public void initialize() {
        MemberUtils.checkTextDigital(text_orderId, 5);
        MemberUtils.checkTextLength(text_comment, label_alarm_invoiceUpdate, 255);
        date_dateCreation.setStyle("-fx-opacity: 1");
        date_dateCreation.getEditor().setStyle("-fx-opacity: 1");

        cmbBox_statusPayment.setItems(payment);
        cmbBox_statusReceiving.setItems(receive);
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
        fillFields();
    }

    private void fillFields() {
        text_invoiceNumber.setText(invoice.getInvoiceNumber().toString());
        date_dateCreation.setValue(invoice.getDateCreation());
        cmbBox_statusReceiving.getSelectionModel().select(MemberUtils.isReceive(invoice.getStatusReceiving()));
        cmbBox_statusPayment.getSelectionModel().select(MemberUtils.isPayment(invoice.getStatusPayment()));
        text_price.setText(invoice.getPrice().toString());

        if (invoice.getDateReceiving() != null) date_dateReceiving.setValue(invoice.getDateReceiving());
        if (invoice.getOrderDate() != null) date_orderDate.setValue(invoice.getOrderDate());
        if (invoice.getOrderId() != null) text_orderId.setText(invoice.getOrderId());
        if (invoice.getComment() != null) text_comment.setText(invoice.getComment());
    }

    public void updateInvoice(ActionEvent actionEvent) {
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
                        text_orderId.getText() == null)) {
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

            invoice.setStatusPayment(MemberUtils.
                    paymentToBoolean(cmbBox_statusPayment.getSelectionModel().getSelectedItem()));
            invoice.setStatusReceiving(MemberUtils.
                    receiveToBoolean(cmbBox_statusReceiving.getSelectionModel().getSelectedItem()));

            invoice.setComment(text_comment.getText());
            invoiceUpdate = true;
            System.out.println();
            closeCurrentStage(actionEvent);
        }
    }

    public void closeCurrentStage(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
