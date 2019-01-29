package ru.src.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.PrinterJob;
import net.bytebuddy.asm.Advice;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.printing.PDFPageable;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.src.logic.controllers.SelectController;
import ru.src.logic.implementation.DBConnection;
import ru.src.logic.implementation.ListUtils;
import ru.src.logic.implementation.MemberUtils;
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

import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class test {


    public static void main(String[] args) {
//
////        ArrayList<Member> list = new ArrayList<Member>();
////        for (int i = 0; i < 500; i++) {
////            list.add(getMember());
////        }
////
////        list.forEach(member -> DBConnection.addMember(member));
////        System.out.println();
////        try (PDDocument doc = new PDDocument()) {
////
////            PDPage myPage = new PDPage();
////            doc.addPage(myPage);
////
////            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {
////
////                cont.beginText();
////
////                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
////                cont.setLeading(14.5f);
////
////                cont.newLineAtOffset(5, 100);
////                String line1 = "PIDR";
////                cont.showText(line1);
////
////
////
////                cont.endText();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////
////            doc.save("/home/green/test/test.pdf");
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//
//
//
//    public void saveFile(String pathName) {
//        pathName = "/home/green/test/base_test.csv";
//        Charset charset = Charset.forName("UTF-8");
//
//        try {
//            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(pathName), charset);
//            //BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(pathName), charset);
//
//
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static Member getMember() {
        Random one = new Random();
        Integer id = one.nextInt(2000);
        Member member = new Member("111-" + id.toString(),
                one.nextInt(),
                ListUtils.getMemberStatusList().get(new Random().nextInt(ListUtils.getMemberStatusList().size())),
                getRandonDate(),
                "test (" + id + ")");

        GeneralInformation generalInformation = new GeneralInformation(member,
                ListUtils.getOrganizationForm().get(new Random().nextInt(ListUtils.getOrganizationForm().size())),
                ListUtils.getEconomicSector().get(new Random().nextInt(ListUtils.getEconomicSector().size())),
                ListUtils.getOwnershipForm().get(new Random().nextInt(ListUtils.getOwnershipForm().size())),
                ListUtils.getActivityType().get(new Random().nextInt(ListUtils.getActivityType().size())),
                ListUtils.getBusinessForm().get(new Random().nextInt(ListUtils.getBusinessForm().size())),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean(),
                new Random().nextBoolean());

        Debt debt = new Debt(member, new Random().nextBoolean());

        member.setGeneralInformation(generalInformation);
        member.setDebt(debt);

        return member;
    }

    private static LocalDate getRandonDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;

    }
}

