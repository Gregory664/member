package ru.src.logic.implementation;

public class MemberUtils {
    public static String isImportExport(boolean value) {
        return value ? "Да" : "Нет";
    }

    public static String isInteresting(boolean value) {
        return value ? "Интересует" : "Не интересует";
    }
}
