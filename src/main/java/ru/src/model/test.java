package ru.src.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.bytebuddy.asm.Advice;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.Organizations;
import ru.src.model.Address.AddressActual;
import ru.src.model.Address.AddressLegal;
import ru.src.model.General.GeneralInformation;
import ru.src.model.Personal.Contact;
import ru.src.model.Personal.ContactPerson;
import ru.src.model.Personal.Director;
import ru.src.model.Personal.Relate;
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;
import ru.src.model.buh.Invoice;

import java.time.LocalDate;
import java.util.*;

public class test {


    public static void main(String[] args) {

//       List<Member> members = getMembers(5, 3);
//
//        long startaddMember = System.currentTimeMillis();
//        for (Member member: members) {
//            DBConnection.addMember(member);
//        }
//        long stopaddMember = System.currentTimeMillis();
//        System.out.println();
//        members.clear();

//        long startGetMember = System.currentTimeMillis();
//        List<Member> members1 = DBConnection.getAllMembers();
//        long stopGetMember = System.currentTimeMillis();
//
//
//        long startDeleteMember = System.currentTimeMillis();
//        for (Member member: members1) {
//            DBConnection.removeMember(member);
//        }
//        long stopDeleteMember = System.currentTimeMillis();
////////
//System.out.println("add member : " + (stopaddMember - startaddMember) + " ms");
//         System.out.println("get member : " + (stopGetMember - startGetMember) + " ms");
//        System.out.println("delete member : " + (stopDeleteMember - startDeleteMember) + " ms");
    }

    private static ArrayList<Member> getMembers(int length, int invoiceSize) {

        ArrayList<Member> members = new ArrayList<>();
        long start = System.currentTimeMillis();

        int number = 0;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            Member member = new Member( "" + i, i,"test", LocalDate.now(), "test");
            AddressActual addressActual = new AddressActual(member, 0, "test", 394000, "test", "test", "test");
            AddressLegal addressLegal = new AddressLegal(member, 0, "test", 394000, "test", "test", "test");
            AccoutingInformation accoutingInformation = new AccoutingInformation(member, "1" + i, "1" + i, "1" + i);
            Debt debt = new Debt(member, "test");
            GeneralInformation generalInformation = new GeneralInformation(member, "test" + i,
                    "test" + i,"test" + i,                    "test" + i,
                    "test" + i,false,true,
                    false,
                    true,true,true, true,true,true);
            Contact contact = new Contact(member, "880055535" + i, "test");
            Director director = new Director(member, "test" + i, "test" + i, "88005553535","test");
            Relate relate = new Relate(member, "100", 100 + i, "test");

            member.setAddressActual(addressActual);
            member.setAddressLegal(addressLegal);
            member.setAccoutingInformation(accoutingInformation);
            member.setDebt(debt);
            member.setGeneralInformation(generalInformation);
            member.setContact(contact);
            member.setDirector(director);
            member.setRelate(relate);

            List<Invoice> invoices = new ArrayList<>();
            for (int j = 0; j < invoiceSize; j++) {
                Invoice invoice = new Invoice(member, ++number, LocalDate.of(2020 + j, 12, 30), ++sum);
                invoices.add(invoice);
            }
            member.setInvoice(invoices);

            List<ContactPerson> contactPeople = new ArrayList<>();
            contactPeople.add(new ContactPerson(member, "А А Дюма 1" + i, "Директор", "88005550001", "ad@ad.ru"));
            contactPeople.add(new ContactPerson(member, "А А Дюма 2" + i, "Директор", "88005550002", "asdfasd@ad.ru"));
            member.setContactPerson(contactPeople);

            members.add(member);

        }
        long stop = System.currentTimeMillis();
        System.out.println("create members : " + (stop - start) + " ms");
        return members;
    }

}
