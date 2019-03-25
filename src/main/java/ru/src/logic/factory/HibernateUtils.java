package ru.src.logic.factory;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.src.logic.implementation.ConnectionUtils;
import ru.src.logic.implementation.MemberException;
import ru.src.logic.implementation.MemberUtils;
import ru.src.model.Connection;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private static boolean active = false;

    public static boolean isActive() {
        return active;
    }

    private HibernateUtils() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            Connection connection = ConnectionUtils.getConnection();
            String url = "jdbc:mysql://" +
                    connection.getHostname() + ":" +
                    connection.getPort() + "/" +
                    connection.getDatabase();

            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", url)
                    .setProperty("hibernate.connection.username", connection.getUsername())
                    .setProperty("hibernate.connection.password", connection.getPassword());

            try {
                sessionFactory = configuration.configure().buildSessionFactory();
                active = true;
            } catch (Exception e) {
                if(e instanceof HibernateException) {
                    MemberException.getCheckSqlException((HibernateException) e);
                } else {
                    //TODO throw new GetSessionFactoryException
                }
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
        active = false;
    }



}
