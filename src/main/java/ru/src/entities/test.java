package ru.src.entities;

import org.hibernate.*;
import ru.src.logic.factory.HibernateUtils;

import java.util.List;

public class test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        List<Member> memberList;
        try (Session session = sessionFactory.openSession()) {
           

//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
//
//            Root<Member> root = criteriaQuery.from(Member.class);
//            criteriaQuery.select(root).where(criteriaBuilder.like(root.get("memberId"), "111-001"));
//            //Predicate[] predicates = new Predicate[1];
//            //predicates[0] = criteriaQuery.equals(root.get);
//
//            memberList = session.createQuery(criteriaQuery).getResultList();
           // memberList.forEach(System.out::println);
        } catch (HibernateException e) {

        }
    }
}
