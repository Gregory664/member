package ru.src.logic.implementation;

import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class MemberUtils {
    private static final String  EMPTY_COLOR = "#de9396";

    public static String isImportExport(boolean value) {
        return value ? "Да" : "Нет";
    }

    public static String isInteresting(boolean value) {
        return value ? "Интересует" : "Не интересует";
    }

    public static String isReceive(boolean value) {
        return value ? "Получен" : "Не получен";
    }

    public static String isPayment(boolean value) {
        return value ? "Отплачен" : "Не отплачен";
    }

    public static String isDebt(boolean value) {
        return value ? "Имеется" : "Отсутствует";
    }

    public static boolean receiveToBoolean(String value) {
        boolean result = false;
        if(value.equals("Получен")) result =  true;
        if(value.equals("Не получен")) result = false;
        return result;
    }

    public static boolean paymentToBoolean(String value) {
        boolean result = false;
        if(value.equals("Отплачен")) result =  true;
        if(value.equals("Не отплачен")) result = false;
        return result;
    }

    public static boolean debtToBoolean(String value)  {
        boolean result = false;
        if(value.equals("Имеется")) result =  true;
        if(value.equals("Отсутствует")) result = false;
        return result;
    }

    public static boolean vedToBoolean(String value) {
        boolean result = false;
        if(value.equals("Да")) result =  true;
        if(value.equals("Нет")) result = false;
        return result;
    }

    public static boolean interestingToBoolean(String value) {
        boolean result = false;
        if(value.equals("Интересует")) result =  true;
        if(value.equals("Не интересует")) result = false;
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
        return id.substring(id.indexOf("(") + 3, id.length() - 1);
    }

    public static void informationDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static void alertDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.showAndWait();
    }




    public static void checkTextDigital(TextField textField, Label label, int maxLength) {
        Pattern p = Pattern.compile("\\d*");

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() <= maxLength) {
                label.setText(null);
                label.setStyle(null);

                if (!p.matcher(newValue).matches()) {
                    textField.setText(oldValue);
                    label.setText("Введите корректные символы");
                    label.setTextFill(Color.ORANGE);
                }

            } else {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);

                label.setText("Поле достигло максимального значения");
                label.setTextFill(Color.ORANGE);
            }
        });
    }

    public static void checkTextPhone(TextField textField, Label label) {
        Pattern p = Pattern.compile("\\d*");
        int maxLength = 11;

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() <= maxLength) {
                label.setText(null);
                label.setStyle(null);

                if (!p.matcher(newValue).matches()) {
                    textField.setText(oldValue);
                    label.setText("Введите номер в формате \"7XXXXXXX\"");
                    label.setTextFill(Color.ORANGE);
                }

            } else {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);

                label.setText("Поле достигло максимального значения");
                label.setTextFill(Color.ORANGE);
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



    public static boolean isEmptyField(TextField text, Label labelText) {
        boolean isEmpty;
        if(text.getText().length() == 0) {
            text.setStyle("-fx-background-color: " + EMPTY_COLOR + ";");
            labelText.setText("Обязательное поле");
            labelText.setTextFill(Color.valueOf(EMPTY_COLOR));
            isEmpty = true;
        } else {
            text.setStyle(null);
            labelText.setStyle(null);
            labelText.setText("");
            isEmpty = false;
        }
        return isEmpty;
    }

    public static boolean isEmptyField(TextArea text, Label labelText) {
        boolean isEmpty;
        if(text.getText().length() == 0) {
            text.setStyle("-fx-background-color: " + EMPTY_COLOR + ";");
            labelText.setText("Обязательное поле");
            labelText.setTextFill(Color.valueOf(EMPTY_COLOR));
            isEmpty = true;
        } else {
            text.setStyle(null);
            labelText.setStyle(null);
            labelText.setText("");
            isEmpty = false;
        }
        return isEmpty;
    }

    public static boolean isEmptyField(DatePicker date, Label labelText) {
        boolean isEmpty;
        if(date.getValue() == null) {
            labelText.setText("Обязательное поле");
            labelText.setTextFill(Color.valueOf(EMPTY_COLOR));
            isEmpty = true;
        } else {
            labelText.setStyle(null);
            labelText.setText("");
            isEmpty = false;
        }
        return isEmpty;
    }

    public static boolean isEmptyField(ComboBox comboBox, Label labelText) {
        boolean isEmpty;
        if(comboBox.getValue() == null) {
            labelText.setText("Обязательное поле");
            labelText.setTextFill(Color.valueOf(EMPTY_COLOR));
            isEmpty = true;
        }
        else {
            labelText.setStyle(null);
            labelText.setText("");
            isEmpty = false;
        }
        return isEmpty;
    }
}
