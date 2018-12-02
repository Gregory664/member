package ru.src.logic.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

class HibernateUtils {
    private static SessionFactory sessionFactory;

    private HibernateUtils() {
    }


    static synchronized SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
