package ru.src.logic.implementation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.src.model.Connection;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    public static boolean isActive = false;


    private HibernateUtils() {
    }

    static synchronized SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Connection connection = ConnectionUtils.getConnection();
            String url = "jdbc:mysql://" +
                    connection.getHostname() + ":" +
                    connection.getPort() + "/" +
                    connection.getDatabase() + "?serverTimezone=UTC";
            String username = connection.getUsername();
            String password = connection.getPassword();
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", url)
                    .setProperty("hibernate.connection.username", username)
                    .setProperty("hibernate.connection.password", password);
            sessionFactory = configuration.configure().buildSessionFactory();
            isActive = true;
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        isActive = false;
        sessionFactory.close();
    }
}
