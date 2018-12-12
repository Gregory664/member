package ru.src.logic.implementation;

import java.time.LocalDate;

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
}
