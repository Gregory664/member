package ru.src.logic.implementation;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;

public class MemberException {
    public static void getCheckSqlException(HibernateException e) {
        Throwable cause = e.getCause();
        if(cause instanceof JDBCException) {
            switch (((JDBCException) cause).getErrorCode()) {
                case 0:
                    MemberUtils.warningDialog("Настройки соединения некорректны!");
                    break;
                case 330:
                    MemberUtils.warningDialog("Настройки соединения некорректны!");
                    break;
                case 1045:
                    MemberUtils.warningDialog("Некорректный логин/пароль!");
                    break;
                case 1049:
                    MemberUtils.warningDialog("Некорректное название БД!");
                    break;
            }
        }
    }
}
