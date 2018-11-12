package ru.model.src;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.model.src.Personal.PersonalInformation;
import ru.model.src.buh.Debt;

import javax.crypto.spec.DESedeKeySpec;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();

            Member member = session.get(Member.class, "111-001");
            //System.out.println(member.toString());
            System.out.println("????????????????????????????????????????????????????????????????????????????????");


            transaction.commit();
        }
        catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(e.getMessage());
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        finally {
            session.close();
            sessionFactory.close();
        }

    }

}
