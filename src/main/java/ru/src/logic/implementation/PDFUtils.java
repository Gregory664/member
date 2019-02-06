package ru.src.logic.implementation;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import net.bytebuddy.asm.Advice;
import org.apache.pdfbox.io.IOUtils;
import ru.src.model.FindMember;


//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;
//import org.apache.pdfbox.pdmodel.font.*;
//
//import rst.pdfbox.layout.elements.ControlElement;
//import rst.pdfbox.layout.elements.Document;
//import rst.pdfbox.layout.elements.Element;
//import rst.pdfbox.layout.elements.Paragraph;

import java.io.*;
import java.lang.annotation.ElementType;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PDFUtils {

    public static void main(String[] args) throws IOException {
        //test();
    }

    public static void savePDFfromFindResult(String pathName, List<FindMember> findMembers, ArrayList<String[]> params) {

        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(pathName)));
            document.open();

            InputStream inputStream = ClassLoader.getSystemResourceAsStream("fonts/times.ttf");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            BaseFont baseFont = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, true, bytes, null);
            Font fontHeader = new Font(baseFont, 14);
            Font fontRow = new Font(baseFont, 12);

            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));


            PdfPTable selectedParams = new PdfPTable(2);
            selectedParams.setTotalWidth(new float[]{150, 400});
            selectedParams.setLockedWidth(true);
            params.forEach(strings -> {
                PdfPCell cell1 = new PdfPCell(new Phrase(strings[0], fontHeader));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell1.setGrayFill(0.9f);

                PdfPCell cell2 = new PdfPCell(new Phrase(strings[1], fontRow));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                selectedParams.addCell(cell1);
                selectedParams.addCell(cell2);
                selectedParams.completeRow();
            });
            document.add(selectedParams);

            document.newPage();
            Paragraph elements = new Paragraph("Данные на ".toUpperCase() +
                    currentDate + ", соответствующие выбранным критериям".toUpperCase(), fontHeader);
            elements.setAlignment(Element.ALIGN_CENTER);
            document.add(elements);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Количество организаций: ".toUpperCase() + findMembers.size(), fontRow));
            document.add(Chunk.NEWLINE);

            PdfPTable tableFindMembers = new PdfPTable(5);
            tableFindMembers.setTotalWidth(new float[]{50, 45, 80, 285, 90});
            tableFindMembers.setLockedWidth(true);

            PdfPCell columnNameMemberId = new PdfPCell(new Phrase("Номер\nбилета", fontRow));
            columnNameMemberId.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnNameMemberId.setVerticalAlignment(Element.ALIGN_MIDDLE);
            columnNameMemberId.setGrayFill(0.9f);
            tableFindMembers.addCell(columnNameMemberId);

            PdfPCell columnMemberSerial = new PdfPCell(new Phrase("Номер", fontRow));
            columnMemberSerial.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnMemberSerial.setVerticalAlignment(Element.ALIGN_MIDDLE);
            columnMemberSerial.setGrayFill(0.9f);
            tableFindMembers.addCell(columnMemberSerial);


            PdfPCell columnNameMemberStatus = new PdfPCell(new Phrase("Статус", fontRow));
            columnNameMemberStatus.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnNameMemberStatus.setVerticalAlignment(Element.ALIGN_MIDDLE);
            columnNameMemberStatus.setGrayFill(0.9f);
            tableFindMembers.addCell(columnNameMemberStatus);

            PdfPCell columnNameMemberShortName = new PdfPCell(new Phrase("Сокрашенное название организации", fontRow));
            columnNameMemberShortName.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnNameMemberShortName.setVerticalAlignment(Element.ALIGN_MIDDLE);
            columnNameMemberShortName.setGrayFill(0.9f);
            tableFindMembers.addCell(columnNameMemberShortName);

            PdfPCell columnNamePhone = new PdfPCell(new Phrase("Контактный\nтелефон", fontRow));
            columnNamePhone.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnNamePhone.setVerticalAlignment(Element.ALIGN_MIDDLE);
            columnNamePhone.setGrayFill(0.9f);
            tableFindMembers.addCell(columnNamePhone);
            tableFindMembers.completeRow();

            findMembers.forEach(findMember -> {

                ArrayList<PdfPCell> pdfPCells = new ArrayList<>();
                pdfPCells.add(new PdfPCell(new Phrase(findMember.getMemberId(), fontRow)));
                pdfPCells.add(new PdfPCell(new Phrase(findMember.getMemberSerial(), fontRow)));
                pdfPCells.add(new PdfPCell(new Phrase(findMember.getMemberStatus(), fontRow)));
                pdfPCells.add(new PdfPCell(new Phrase(findMember.getMemberShortName(), fontRow)));
                pdfPCells.add(new PdfPCell(new Phrase(findMember.getPhone(), fontRow)));

                pdfPCells.forEach(pdfPCell -> {
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableFindMembers.addCell(pdfPCell);
                });

                tableFindMembers.completeRow();
            });

            document.addTitle("PDF Table Demo");
            document.add(tableFindMembers);


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}

