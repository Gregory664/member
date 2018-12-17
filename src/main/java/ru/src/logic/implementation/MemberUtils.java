package ru.src.logic.implementation;

import javafx.scene.control.*;
import javafx.scene.paint.Color;

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

    public static void checkTextDigital(TextField textField) {
        Pattern p = Pattern.compile("\\d*");

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches() && newValue.length() >= 0) textField.setText(oldValue);
        });
    }

    public static void checkTextDigital(TextField textField, int maxLength) {
        Pattern p = Pattern.compile("\\d*");

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() <= maxLength) {
                if (!p.matcher(newValue).matches()) textField.setText(oldValue);
            } else {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);
            }
        });
    }

    public static void checkTextPhone(TextField textField) {
        Pattern p = Pattern.compile("\\d*");
        int maxLength = 11;

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() <= maxLength) {
                if (!p.matcher(newValue).matches()) textField.setText(oldValue);
            } else {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);
            }
        });
    }

    public static void checkTextLength(TextField textField, Label label, int maxLength) {

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() >= maxLength) {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);
                label.setText("Поле достигло максимального значения");
                label.setTextFill(Color.ORANGE);
            } else {
                label.setText(null);
                label.setStyle(null);
            }
        });
    }

    public static void checkTextLength(TextArea textField, Label label, int maxLength) {

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() >= maxLength) {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);
                label.setText("Поле достигло максимального значения");
                label.setTextFill(Color.ORANGE);
            } else {
                label.setText(null);
                label.setStyle(null);
            }
        });
    }


    public static boolean isEmptyTextField(TextField textField) {
        return textField.getText().length() == 0 ? true : false;
    }

    public static void checkAlarm(Object textField, Label label) {
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
