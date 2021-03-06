package ru.src.logic.implementation;

import javafx.scene.control.*;
import javafx.scene.paint.Color;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MemberUtils {
    //private static final String  EMPTY_COLOR = "#de9396";
    public static final Color EMPTY_COLOR = Color.rgb(255, 0, 0);
    public static final String EMPTY_COLOR2 = "255,0,0";

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
        return value.equals("Получен");
    }

    public static boolean paymentToBoolean(String value) {
        return value.equals("Отплачен");
    }

    public static boolean debtToBoolean(String value)  {
        return value.equals("Имеется");
    }

    public static String extractId(String id) {
        return id.substring(id.lastIndexOf("(") + 3, id.length() - 1);
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

    public static void warningDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.setTitle("Ошибка!");
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
                    label.setTextFill(EMPTY_COLOR);
                }

            } else {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);

                label.setText("Поле достигло максимального значения");
                label.setTextFill(EMPTY_COLOR);
            }
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
                    label.setTextFill(EMPTY_COLOR);
                }

            } else {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);

                label.setText("Поле достигло максимального значения");
                label.setTextFill(EMPTY_COLOR);
            }
        });
    }

    public static void checkTextLength(TextField textField, Label label, int maxLength) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(textField.getText().length() >= maxLength) {
                String s = textField.getText().substring(0, maxLength);
                textField.setText(s);
                label.setText("Поле достигло максимального значения");
                label.setTextFill(EMPTY_COLOR);
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
                label.setTextFill(EMPTY_COLOR);
            } else {
                label.setText(null);
                label.setStyle(null);
            }
        });
    }


    public static boolean isEmptyField(TextField text) {
        if(text.getText().isEmpty()) {
            text.setStyle("-fx-border-color: rgb(" + EMPTY_COLOR2 + ");");
            return true;
        } else {
            text.setStyle(null);
            return false;
        }
    }

    public static boolean isEmptyField(TextArea text) {
        if(text.getText().isEmpty()) {
            text.setStyle("-fx-border-color: rgb(" + EMPTY_COLOR2 + ");");
            return true;
        } else {
            text.setStyle(null);
            return false;
        }
    }

    public static boolean isEmptyField(DatePicker date) {
        if(date.getValue() == null) {
            date.setStyle("-fx-border-color: rgb(" + EMPTY_COLOR2 + ");");
            return true;
        } else {
            date.setStyle(null);
            return false;
        }
    }

    public static boolean isEmptyField(ComboBox comboBox) {
        if(comboBox.getValue() == null) {
            comboBox.setStyle("-fx-border-color: rgb(" + EMPTY_COLOR2 + ");");
            return true;
        } else {
            comboBox.setStyle(null);
            return false;
        }
    }

    public static boolean checkBoxIDToBoolean(CheckBox checkBox) {
        String checkBoxID = checkBox.getId();
        String last = checkBoxID.substring(checkBoxID.length() - 1);
        return last.equals("1");
    }

    public static String getPasswordHash(String password) {
        SHA3.Digest512 digest512 = new SHA3.Digest512();
        byte[] digest = digest512.digest(password.getBytes());
        return Hex.toHexString(digest);
    }
}
