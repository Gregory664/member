package ru.src.logic.implementation;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.src.model.Connection;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static boolean active = false;
    private static Connection connection;

    private HibernateUtils() {
    }

    public static synchronized SessionFactory getSessionFactory() throws HibernateException{

            if (sessionFactory == null || sessionFactory.isClosed()) {
                connection = ConnectionUtils.getConnection();
                String url = "jdbc:mysql://" +
                        connection.getHostname() + ":" +
                        connection.getPort() + "/" +
                        connection.getDatabase();// + "?serverTimezone=UTC";
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.url", url)
                        .setProperty("hibernate.connection.username", connection.getUsername())
                        .setProperty("hibernate.connection.password", connection.getPassword());
                try {
                    sessionFactory = configuration.configure().buildSessionFactory();
                } catch (Exception e) {
                    MemberUtils.warningDialog("Ошибка!\n" + e.getMessage());
                }
                active = true;
            }
        System.out.println(connection);
            return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
        active = false;
    }

    public static boolean isActive() {
        return active;
    }

    public static void setActive(boolean isActive) {
        active = isActive;
    }
}
