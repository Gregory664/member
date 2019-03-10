package ru.src.logic.implementation;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.JDBCConnectionException;
import ru.src.model.Connection;

import java.sql.SQLException;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    public static boolean isActive = false;
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
                String username = connection.getUsername();
                String password = connection.getPassword();
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.url", url)
                        .setProperty("hibernate.connection.username", username)
                        .setProperty("hibernate.connection.password", password);
                try {
                    sessionFactory = configuration.configure().buildSessionFactory();
                } catch (Exception e) {
                    MemberUtils.warningDialog("Ошибка!\n" + e.getMessage());
                }
                isActive = true;
            }
        System.out.println(connection);
            return sessionFactory;
    }

    public static void closeSessionFactory() {
        isActive = false;
        sessionFactory.close();
    }
}
