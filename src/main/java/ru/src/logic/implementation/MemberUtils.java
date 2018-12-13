package ru.src.logic.implementation;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class MemberUtils {
    public static String isImportExport(boolean value) {
        return value ? "Да" : "Нет";
    }

    public static String isInteresting(boolean value) {
        return value ? "Интересует" : "Не интересует";
    }

    public static String isReceive(boolean value) {
        return value ? "Получен" : "Не получен";
    }

    public static boolean receiveToBoolean(String value) {
        boolean result = false;
        if(value.equals("Получен")) result =  true;
        if(value.equals("Не получен")) result = false;
        return result;
    }

    public static String isPayment(boolean value) {
        return value ? "Отплачен" : "Не отплачен";
    }

    public static boolean paymentToBoolean(String value) {
        boolean result = false;
        if(value.equals("Отплачен")) result =  true;
        if(value.equals("Не отплачен")) result = false;
        return result;
    }

    public static String dateToString(LocalDate localDate) {
        String result;
        if(localDate != null) {
            result = localDate.getDayOfMonth() + "." +
                    localDate.getMonth().getValue() + "." +
                    localDate.getYear();
        }
        else result = "Не указана";
        return result;
    }

    public static String extractId(String id) {
        return id.substring(id.indexOf("d") + 1, id.length() - 1);
    }

    public static void alertDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static void checkDigital(TextField textField) {
        Pattern p = Pattern.compile("\\d+");

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) textField.setText(oldValue);
        });
    }
}
