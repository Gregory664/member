package ru.src.logic.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.src.logic.interfaces.MemberLogic;
import ru.src.model.*;
import ru.src.model.buh.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection implements MemberLogic {


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

    public static boolean isMemberExists(String id) {
        boolean result;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Member member = session.get(Member.class, id);
            transaction.commit();
            return member != null;
        }
        catch (Exception e) {
            result = false;
        }
        return result;
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

    public static boolean isInvoiceExists(String id) {
        boolean result;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Invoice invoice = session.get(Invoice.class, id);
            transaction.commit();
            result = invoice != null;
        }
        catch (Exception e) {
            result = true;
        }
        return result;
    }

    public static List<FindMember> getQueryList(String queryString) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        List<String> result;
        List<FindMember> findMembers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery(queryString);
            result = query.list();
            transaction.commit();

            for (Object o : result) {
                Object[] g = (Object[]) o;
                String memberId = g[0].toString();
                String memberSerial = g[1].toString();
                String memberPhone = g[2].toString();
                String memberStatus = g[3].toString();
                String memberShortName = g[4].toString();
                String email = g[5].toString();

                findMembers.add(new FindMember(memberId, memberSerial, memberPhone, memberStatus, memberShortName, email));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return findMembers;
    }

    public static ObservableList<DirectorCalendar> getDirectorCalendar(Integer month) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        ObservableList<DirectorCalendar> directorCalendars = FXCollections.observableArrayList();
        List<String> result;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryString =
                    "SELECT d.DIRECTOR_BIRTHDAY, " +
                    "d.DIRECTOR_FULL_NAME, " +
                    "m.MEMBER_ID, " +
                    "m.MEMBER_SHORT_NAME\n" +
                    "FROM MEMBER m, DIRECTOR d\n" +
                    "where m.MEMBER_ID = d.MEMBER_ID AND MONTH(d.DIRECTOR_BIRTHDAY) = " + month + ";";
            Query query = session.createSQLQuery(queryString);
            result = query.list();
            transaction.commit();

            for (Object o : result) {
                Object[] g = (Object[]) o;
                String[] date = g[0].toString().split("-");
                LocalDate birthday = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
                String fio = g[1].toString();
                String memberId = g[2].toString();
                String shortName = g[3].toString();
                directorCalendars.add(new DirectorCalendar(memberId, fio, shortName, birthday));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return directorCalendars;
    }

    public static ObservableList<DateOfCreationOrganization> getOrganizationCalendar(int month) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        ObservableList<DateOfCreationOrganization> organizations = FXCollections.observableArrayList();
        List<String> result;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryString =
                    "SELECT r.RELATE_DATE_OF_CREATION, " +
                            "m.MEMBER_ID, " +
                            "m.MEMBER_SHORT_NAME\n" +
                            "FROM MEMBER m, RELATE r\n" +
                            "where m.MEMBER_ID = r.MEMBER_ID AND MONTH(r.RELATE_DATE_OF_CREATION) = " + month + ";";
            Query query = session.createSQLQuery(queryString);
            result = query.list();
            transaction.commit();

            for (Object o : result) {
                Object[] g = (Object[]) o;
                String[] date = g[0].toString().split("-");
                LocalDate dateOfCreation = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
                String memberId = g[1].toString();
                String shortName = g[2].toString();
                organizations.add(new DateOfCreationOrganization(dateOfCreation, memberId,shortName));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return organizations;
    }

    public static Integer getCountOfOrganizationBirthdayToday() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Integer result = -1;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Integer currentMonth = LocalDate.now().getMonth().getValue();
            Integer currentDay = LocalDate.now().getDayOfMonth();
            String queryString =
                    "SELECT Count(*)\n" +
                    "FROM RELATE\n" +
                    "WHERE month(RELATE_DATE_OF_CREATION) = " + currentMonth +
                        " AND day(RELATE_DATE_OF_CREATION) = " + currentDay + ";";
            Query query = session.createSQLQuery(queryString);
            result = Integer.valueOf(query.list().get(0).toString());
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static Integer getCountOfDirectorBirthdayToday() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Integer result = -1;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Integer currentMonth = LocalDate.now().getMonth().getValue();
            Integer currentDay = LocalDate.now().getDayOfMonth();
            String queryString =
                    "SELECT Count(*)\n" + "FROM DIRECTOR\n" +
                    "WHERE month(DIRECTOR_BIRTHDAY) = " + currentMonth +
                    " AND day(DIRECTOR_BIRTHDAY) = " + currentDay + ";";
            Query query = session.createSQLQuery(queryString);
            result = Integer.valueOf(query.list().get(0).toString());
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public static User getUser(String login) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        User user = null;
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, login);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static void addUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Boolean isUserLoginExist(String login) {
        boolean isExist = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryString =
                    "SELECT COUNT(*)\n" +
                    "FROM USER\n" +
                    "WHERE USER.USER_LOGIN = '" + login + "';";
            Query query = session.createSQLQuery(queryString);
            int count = Integer.parseInt(query.list().get(0).toString());
            isExist = count == 1;
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isExist;
    }

    public static Boolean isUserPasswordExist(String login, String password) {
        boolean isExist = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String queryString = "SELECT COUNT(*)\n" +
                    "FROM USER\n" +
                    "WHERE USER.USER_LOGIN = '" + login + "'" +
                    " AND USER.USER_PASSWORD = '" + password + "';";
            Query query = session.createSQLQuery(queryString);
            Integer count = Integer.valueOf(query.list().get(0).toString());
            isExist = count == 1;
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isExist;
    }

    public static List<User> getAllUser() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        List<User> userList = new ArrayList<>();
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from User");
            userList = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;

    }

}

