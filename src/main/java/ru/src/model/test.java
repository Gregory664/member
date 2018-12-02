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
import ru.src.model.Personal.Director;
import ru.src.model.Personal.Relate;
import ru.src.model.buh.AccoutingInformation;
import ru.src.model.buh.Debt;
import ru.src.model.buh.Invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListResourceBundle;

public class test {
    public static void main(String[] args) {

        Member member = DBConnection.getMember("111-001");
        Invoice invoice = new Invoice(member, 10000, LocalDate.of(2080, 12, 31), 100000);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);
        member.setInvoice(invoices);
        DBConnection.updateMember(member);
//        ArrayList<Member> members = getMembers(1, 2);
//
//        long startaddMember = System.currentTimeMillis();
//        for (Member member: members) {
//            DBConnection.addMember(member);
//        }
//        long stopaddMember = System.currentTimeMillis();

//        members.clear();
//
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

        //System.out.println("add member : " + (stopaddMember - startaddMember) + " ms");
//        System.out.println("get member : " + (stopGetMember - startGetMember) + " ms");
//        System.out.println("delete member : " + (stopDeleteMember - startDeleteMember) + " ms");
    }

    private static ArrayList<Member> getMembers(int length, int invoiceSize) {
        ArrayList<Member> members = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            Member member = new Member( "" + i, i,"test", LocalDate.now(), "test");
            AddressActual addressActual = new AddressActual(member, 0, "test", 394000, "test", "test", "test");
            AddressLegal addressLegal = new AddressLegal(member, 0, "test", 394000, "test", "test", "test");
            AccoutingInformation accoutingInformation = new AccoutingInformation(member, "1" + i, "1" + i, "1" + i);
            Debt debt = new Debt(member, "test");
            GeneralInformation generalInformation = new GeneralInformation(member, "test",
                    "test","test","test","test",
                    true,true,true, true,true,true,
                    true,true,true);
            Contact contact = new Contact(member, "88005553535", "test");
            Director director = new Director(member, "test", "test", "88005553535","test");
            Relate relate = new Relate(member, "100", 100, "test");

            member.setAddressActual(addressActual);
            member.setAddressLegal(addressLegal);
            member.setAccoutingInformation(accoutingInformation);
            member.setDebt(debt);
            member.setGeneralInformation(generalInformation);
            member.setContact(contact);
            member.setDirector(director);
            member.setRelate(relate);

            List<Invoice> invoices = new ArrayList<>();
//            for (int j = 0; j < invoiceSize; j++) {
//                Invoice invoice = new Invoice(member, j, new Date());
//                invoices.add(invoice);
//            }
            member.setInvoice(invoices);

            members.add(member);


        }
        long stop = System.currentTimeMillis();
        System.out.println("create members : " + (stop - start) + " ms");
        return members;
    }

}
