package ru.src.logic.implementation;

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

    public static String isPayment(boolean value) {
        return value ? "Отплачен" : "Не отплачен";
    }
}
