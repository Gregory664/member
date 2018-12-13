package ru.src.logic.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.omg.CORBA.INV_FLAG;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Member;
import ru.src.model.buh.Invoice;

import javax.xml.soap.Text;
import java.awt.*;
import java.time.LocalDate;
import java.util.regex.Pattern;

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

    public Invoice getInvoice() {
        return invoice;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @FXML
    public void initialize(){
        Pattern p = Pattern.compile("\\d+");
        MemberUtils.checkDigital(text_invoiceNumber);
        MemberUtils.checkDigital(text_invoice_price);
    }

    public void saveInvoice(ActionEvent actionEvent) {



        boolean isEmpty = false;
        if(isEmpty(text_invoiceNumber)) {
            checkAlarm(text_invoiceNumber, label_alarm_invoiceNumber);
            isEmpty = true;
        } else {
            text_invoiceNumber.setStyle(null);
            label_alarm_invoiceNumber.setStyle(null);
            label_alarm_invoiceNumber.setText("");
        }

        if(isEmpty(text_invoice_price)) {
            checkAlarm(text_invoice_price, label_alarm_invoice_price);
            isEmpty = true;
        } else {
            text_invoice_price.setStyle(null);
            label_alarm_invoice_price.setStyle(null);
            label_alarm_invoice_price.setText("");
        }

        if(date_invoice_dateCreation.getValue() == null) {
            checkAlarm(date_invoice_dateCreation, label_alarm_invoice_dateCreation);
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

            MemberUtils.alertDialog("Счет успешно добавлен!");
            closeWindow(actionEvent);
        }
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

    private boolean isEmpty(TextField textField) {
        return textField.getText().length() == 0 ? true : false;
    }

    private void checkAlarm(Object textField, Label label) {
        String color = "-fx-background-color: #de9396;";
        if(textField instanceof TextField) {
            ((TextField) textField).setStyle(color);
        }
        if(textField instanceof DatePicker) {
            ((DatePicker) textField).setStyle(color);
        }
        label.setTextFill(Color.valueOf("#de9396"));
        label.setText("Обязательное поле");

    }


}
