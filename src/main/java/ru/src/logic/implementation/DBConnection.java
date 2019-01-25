package ru.src.logic.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.src.logic.interfaces.MemberLogic;
import ru.src.model.FindMember;
import ru.src.model.Member;
import ru.src.model.buh.Invoice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBConnection implements MemberLogic {


    public static void addMember(Member member) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(member);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeMember(Member member) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(member);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateMember(Member member) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(member);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Member> getAllMembers() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        List<Member> members = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Member");
            members = query.list();
            transaction.commit();
            for (Member member: members) {
                member.getInvoice().size();
                member.getContactPerson().size();
                member.getServices().size();
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return members;

    }

    public static Member getMember(String memberId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Member member = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            member = session.get(Member.class, memberId);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return member;
    }

    public static void addInvoice(Invoice invoice) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(invoice);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isInvoiceExists(String id) {
        boolean result = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Invoice invoice = session.get(Invoice.class, id);
            transaction.commit();
            result = true;
        }
        catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static boolean isMemberExists(String id) {
        boolean result = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Member member = session.get(Member.class, id);
            transaction.commit();
            if(member == null) result = false;
            else result = true;
        }
        catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static List<FindMember> getQueryList(String queryString) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        List<String> result = new ArrayList<>();
        List<FindMember> findMembers = new ArrayList<FindMember>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(queryString);
            result = query.list();
            transaction.commit();

            for (Object o : result) {
                Object[] g = (Object[]) o;
                findMembers.add(new FindMember(g[0].toString(), g[1].toString(), g[2].toString(), g[3].toString(), g[4].toString()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return findMembers;
    }
}

