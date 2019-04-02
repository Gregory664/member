package ru.src.logic.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.*;
import org.hibernate.query.Query;
import ru.src.entities.DateOfCreationOrganization;
import ru.src.entities.DirectorCalendar;
import ru.src.entities.FindMember;
import ru.src.entities.Personal.Director;
import ru.src.entities.Personal.Relate;
import ru.src.entities.buh.Debt;
import ru.src.logic.factory.HibernateUtils;
import ru.src.entities.*;
import ru.src.entities.buh.Invoice;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBConnection {
    public static Member getMember(String memberId) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        Member member = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            member = session.get(Member.class, memberId);
            transaction.commit();
            Objects.requireNonNull(member);
        } catch (NullPointerException e) {
            //TODO throw new MemberIsNotExistException
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new CanNotGetMemberFromDBException:#
        }
        return member;
    }

    public static void addMember(Member member) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(member);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new AddMemberToDBException
        }
    }

    public static void deleteMember(Member member) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(member);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new DeleteMemberFromDBException
        }
    }

    public static void updateMember(Member member) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(member);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new UpdateMemberException
        }
    }

    public static Long getMemberCount() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        Long memberCount = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Member");
            memberCount = (Long) query.getSingleResult();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetMemberCountException
        }
        return memberCount;
    }

    public static boolean isMemberExists(String id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Member member = session.get(Member.class, id);
            transaction.commit();
            return member != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Member> getAllMembers() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        List<Member> members = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Member");
            members = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetAllMembersException
        }
        return members;
    }

    public static List<Member> getMemberListPage(Integer pageNumber, Integer pageSize) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        List<Member> memberListPage = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("From Member");
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            memberListPage = query.list();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetMemberListPageException
        }
        return memberListPage;
    }

    public static ObservableList<Member> getMemberListBySearchParameter(SearchParameter parameter, String findParams) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        ObservableList<Member> memberList = FXCollections.observableArrayList();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
            CriteriaQuery<Member> memberCriteriaQuery = criteriaBuilder.createQuery(Member.class);
            EntityType<Member> memberEntityType = session.getEntityManagerFactory().getMetamodel().entity(Member.class);
            EntityType<Relate> relateEntityType = session.getEntityManagerFactory().getMetamodel().entity(Relate.class);
            EntityType<Director> directorEntityType = session.getEntityManagerFactory().getMetamodel().entity(Director.class);
            Root<Member> memberRoot = memberCriteriaQuery.from(Member.class);
            Root<Relate> relateRoot;
            Root<Director> directorRoot;

            switch (parameter) {
                case ID:
                    memberCriteriaQuery.select(memberRoot).where(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(
                                            memberRoot.get(memberEntityType.getSingularAttribute("memberId", String.class))
                                    ), "%" + findParams.toLowerCase() + "%"
                            ));
                    memberList.addAll(session.createQuery(memberCriteriaQuery).getResultList());
                    break;
                case FULL_NAME:
                    relateRoot = memberCriteriaQuery.from(Relate.class);
                    memberCriteriaQuery.select(memberRoot).where(
                            criteriaBuilder.and(
                                    criteriaBuilder.equal(
                                            memberRoot.get("memberId"), relateRoot.get("member"))
                                    ),
                                    criteriaBuilder.like(
                                            criteriaBuilder.lower(
                                                    relateRoot.get(relateEntityType.getSingularAttribute("fullName", String.class))
                                            ), "%" + findParams.toLowerCase() + "%"
                                    ));
                    memberList.addAll(session.createQuery(memberCriteriaQuery).getResultList());
                    break;
                case SHORT_NAME:
                   memberCriteriaQuery.select(memberRoot).where(
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(
                                            memberRoot.get(memberEntityType.getSingularAttribute("memberShortName", String.class))
                                    ), "%" + findParams.toLowerCase() + "%"
                            ));
                    memberList.addAll(session.createQuery(memberCriteriaQuery).getResultList());
                    break;
                case DIRECTOR_FULL_NAME:
                    directorRoot = memberCriteriaQuery.from(Director.class);
                    memberCriteriaQuery.select(memberRoot).where(
                            criteriaBuilder.and(
                                    criteriaBuilder.equal(
                                            memberRoot.get("memberId"), directorRoot.get("member"))
                            ),
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(
                                            directorRoot.get(directorEntityType.getSingularAttribute("fullName", String.class))
                                    ), "%" + findParams.toLowerCase() + "%"
                            ));
                    memberList.addAll(session.createQuery(memberCriteriaQuery).getResultList());
                    break;
                case SERVICES:
                    relateRoot = memberCriteriaQuery.from(Relate.class);
                    memberCriteriaQuery.select(memberRoot).where(
                            criteriaBuilder.and(
                                    criteriaBuilder.equal(
                                            memberRoot.get("memberId"), relateRoot.get("member"))
                            ),
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(
                                            relateRoot.get(relateEntityType.getSingularAttribute("services", String.class))
                                    ), "%" + findParams.toLowerCase() + "%"
                            ));
                    memberList.addAll(session.createQuery(memberCriteriaQuery).getResultList());
                    break;
            }
            return memberList;
        }
    }

    public static boolean isInvoiceExists(String id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Invoice invoice = session.get(Invoice.class, id);
            transaction.commit();
            return invoice != null;
        } catch (Exception e) {
            return true;
        }
    }

    public static List<FindMember> getFindMembers(String queryString) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        List<String> findMembersList;
        List<FindMember> findMembers = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(queryString);
            findMembersList = query.list();
            transaction.commit();

            for (Object oneFindMember : findMembersList) {
                Object[] oneFindMemberParams = (Object[]) oneFindMember;
                String memberId = oneFindMemberParams[0].toString();
                String memberSerial = oneFindMemberParams[1].toString();
                String memberPhone = oneFindMemberParams[2].toString();
                String memberStatus = oneFindMemberParams[3].toString();
                String memberShortName = oneFindMemberParams[4].toString();
                String email = oneFindMemberParams[5].toString();
                findMembers.add(new FindMember(memberId, memberSerial, memberPhone, memberStatus, memberShortName, email));
            }
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetFindMembersException
        }
        return findMembers;
    }

    public static ObservableList<DirectorCalendar> getDirectorCalendar(Integer month) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        ObservableList<DirectorCalendar> directorCalendars = FXCollections.observableArrayList();
        List<String> getDirectorCalendarList;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String queryString = "SELECT d.DIRECTOR_BIRTHDAY, " +
                    "d.DIRECTOR_FULL_NAME, " +
                    "m.MEMBER_ID, " +
                    "m.MEMBER_SHORT_NAME\n" +
                    "FROM MEMBER m, DIRECTOR d\n" +
                    "where m.MEMBER_ID = d.MEMBER_ID AND MONTH(d.DIRECTOR_BIRTHDAY) = " + month + ";";
            Query query = session.createSQLQuery(queryString);
            getDirectorCalendarList = query.list();
            transaction.commit();

            for (Object o : getDirectorCalendarList) {
                Object[] g = (Object[]) o;
                String[] date = g[0].toString().split("-");
                LocalDate birthday = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
                String fio = g[1].toString();
                String memberId = g[2].toString();
                String shortName = g[3].toString();
                directorCalendars.add(new DirectorCalendar(memberId, fio, shortName, birthday));
            }
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetDirectorCalendarException
        }
        return directorCalendars;
    }

    public static ObservableList<DateOfCreationOrganization> getOrganizationCalendar(int month) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        List<String> getOrganizationCalendarList;
        ObservableList<DateOfCreationOrganization> organizations = FXCollections.observableArrayList();
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String queryString = "SELECT r.RELATE_DATE_OF_CREATION, " +
                    "m.MEMBER_ID, " +
                    "m.MEMBER_SHORT_NAME\n" +
                    "FROM MEMBER m, RELATE r\n" +
                    "where m.MEMBER_ID = r.MEMBER_ID AND MONTH(r.RELATE_DATE_OF_CREATION) = " + month + ";";
            Query query = session.createSQLQuery(queryString);
            getOrganizationCalendarList = query.list();
            transaction.commit();

            for (Object oneOrganization : getOrganizationCalendarList) {
                Object[] oneOrganizationParams = (Object[]) oneOrganization;
                String[] date = oneOrganizationParams[0].toString().split("-");
                LocalDate dateOfCreation = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
                String memberId = oneOrganizationParams[1].toString();
                String shortName = oneOrganizationParams[2].toString();
                organizations.add(new DateOfCreationOrganization(dateOfCreation, memberId, shortName));
            }
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetOrganizationCalendarException
        }
        return organizations;
    }

    public static Integer getCountOfOrganizationBirthdayToday() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        Integer countOfOrganizationBirthdayToday = 0;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Integer currentMonth = LocalDate.now().getMonth().getValue();
            Integer currentDay = LocalDate.now().getDayOfMonth();
            String queryString = "SELECT Count(*)\n" +
                    "FROM RELATE\n" +
                    "WHERE month(RELATE_DATE_OF_CREATION) = " + currentMonth +
                    " AND day(RELATE_DATE_OF_CREATION) = " + currentDay + ";";
            Query query = session.createSQLQuery(queryString);
            transaction.commit();
            countOfOrganizationBirthdayToday = Integer.valueOf(query.list().get(0).toString());
            return countOfOrganizationBirthdayToday;
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetCountOfOrganizationBirthdayTodayException
        }
        return countOfOrganizationBirthdayToday;
    }

    public static Integer getCountOfDirectorBirthdayToday() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Integer currentMonth = LocalDate.now().getMonth().getValue();
            Integer currentDay = LocalDate.now().getDayOfMonth();
            String queryString =
                    "SELECT Count(*)\n" + "FROM DIRECTOR\n" +
                            "WHERE month(DIRECTOR_BIRTHDAY) = " + currentMonth +
                            " AND day(DIRECTOR_BIRTHDAY) = " + currentDay + ";";
            Query query = session.createSQLQuery(queryString);
            transaction.commit();
            return Integer.valueOf(query.list().get(0).toString());
        } catch (Exception e) {
            return -1;
            //TODO need to add correct error handling implementation
        }
    }

    public static User getUser(String login) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class, login);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetUserFromDBException
        }
        return user;
    }

    public static void addUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new AddUserToDBException
        }
    }

    public static void updateUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new UpdateUserException
        }
    }

    public static void deleteUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new DeleteUserException
        }
    }

    public static List<User> getAllUser() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Transaction transaction = null;
        List<User> userList = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User");
            userList = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            Objects.requireNonNull(transaction).rollback();
            //TODO throw new GetAllUserException
        }
        return userList;
    }
}

