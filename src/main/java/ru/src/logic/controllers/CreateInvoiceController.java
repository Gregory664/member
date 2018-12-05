package ru.src.logic.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.omg.CORBA.INV_FLAG;
import ru.src.model.buh.Invoice;

public class CreateInvoiceController {
    @FXML
    public TextField text_invoiceId;
    @FXML
    public TextField text_invoice_price;
    @FXML
    public DatePicker date_invoice_dateCreation;
    @FXML
    public Button btnSave;
    @FXML
    public Button btnCancel;

    public void saveInvoice(ActionEvent actionEvent) {
    }

    public void closeWindow(ActionEvent actionEvent) {
    }
}
