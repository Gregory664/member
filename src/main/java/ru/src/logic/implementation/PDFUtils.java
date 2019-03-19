package ru.src.logic.implementation;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.pdfbox.io.IOUtils;
import ru.src.model.FindMember;
import ru.src.model.Member;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PDFUtils {


    private static final InputStream inputStream = ClassLoader.getSystemResourceAsStream("fonts/times.ttf");
    private static Font FONT_HEADER;
    private static Font FONT_ROW;

    static {
        try {
            byte[] bytes = IOUtils.toByteArray(Objects.requireNonNull(inputStream));
            BaseFont BASE_SONT = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, true, bytes, null);
            FONT_HEADER = new Font(BASE_SONT, 14);
            FONT_ROW = new Font(BASE_SONT, 12);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void savePDFfromFindResult(String pathName, List<FindMember> findMembers, ArrayList<String[]> params) {

        Document document = new Document(PageSize.A4, 20, 20, 20, 20);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(pathName)));
            document.open();

//            byte[] bytes = IOUtils.toByteArray(inputStream);
//            BaseFont baseFont = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, true, bytes, null);


            String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));


            PdfPTable selectedParams = new PdfPTable(2);
            selectedParams.setTotalWidth(new float[]{150, 400});
            selectedParams.setLockedWidth(true);
            params.forEach(strings -> {
                selectedParams.addCell(getFillCell(strings[0], FONT_HEADER));
                selectedParams.addCell(getFillCell(strings[1], FONT_HEADER));
                selectedParams.completeRow();
            });
            document.add(selectedParams);

            document.newPage();

            Paragraph elements = new Paragraph("Данные на ".toUpperCase() +
                    currentDate + ", соответствующие выбранным критериям".toUpperCase(), FONT_HEADER);
            elements.setAlignment(Element.ALIGN_CENTER);
            document.add(elements);
            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Количество организаций: ".toUpperCase() + findMembers.size(), FONT_ROW));
            document.add(Chunk.NEWLINE);

            PdfPTable tableFindMembers = new PdfPTable(5);
            tableFindMembers.setTotalWidth(new float[]{50, 45, 80, 285, 90});
            tableFindMembers.setLockedWidth(true);

            tableFindMembers.addCell(getFillCell("Номер\nбилета", FONT_ROW));
            tableFindMembers.addCell(getFillCell("Номер", FONT_ROW));
            tableFindMembers.addCell(getFillCell("Статус", FONT_ROW));
            tableFindMembers.addCell(getFillCell("Сокрашенное название организации", FONT_ROW));
            tableFindMembers.addCell(getFillCell("Контактный\nтелефон", FONT_ROW));
            tableFindMembers.completeRow();

            findMembers.forEach(findMember -> {
                tableFindMembers.addCell(getCell(findMember.getMemberId(), FONT_ROW));
                tableFindMembers.addCell(getCell(findMember.getMemberSerial(), FONT_ROW));
                tableFindMembers.addCell(getCell(findMember.getMemberStatus(), FONT_ROW));
                tableFindMembers.addCell(getCell(findMember.getMemberShortName(), FONT_ROW));
                tableFindMembers.addCell(getCell(findMember.getPhone(), FONT_ROW));
                tableFindMembers.completeRow();
            });
            document.add(tableFindMembers);

            document.addTitle("PDF Table Demo");


        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void saveMemberToPDF(String pathName, Member member) {
        Document document = new Document(PageSize.A4, 20, 20, 20, 20);

        try {
            DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd.MM.YYYY");
            PdfWriter.getInstance(document, new FileOutputStream(new File(pathName)));
            document.open();

            Paragraph header = new Paragraph("Анкета члена ТПП Воронежской области", FONT_HEADER);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(Chunk.NEWLINE);

            PdfPTable memberBase = new PdfPTable(2);
            memberBase.setTotalWidth(new float[] {150, 400});
            memberBase.setLockedWidth(true);
            memberBase.addCell(getFillCell("Номер билета", FONT_HEADER));
            memberBase.addCell(getCell(member.getMemberId(), FONT_ROW));
            memberBase.completeRow();
            memberBase.addCell(getFillCell("Дата вступления", FONT_HEADER));
            memberBase.addCell(getCell(member.getMemberDate().format(datePattern), FONT_ROW));
            memberBase.completeRow();
            memberBase.addCell(getFillCell("Сокращенное название", FONT_HEADER));
            memberBase.addCell(getCell(member.getMemberShortName(), FONT_ROW));
            memberBase.completeRow();
            document.add(memberBase);

            PdfPTable relate = new PdfPTable(2);
            relate.setTotalWidth(new float[] {150, 400});
            relate.setLockedWidth(true);
            relate.addCell(getFillCell("Полное название организации", FONT_HEADER));
            relate.addCell(getCell(member.getRelate().getFullName(), FONT_ROW));
            relate.completeRow();
            relate.addCell(getFillCell("Дата основания организации", FONT_HEADER));
            if(member.getRelate().getDateOfCreation() != null) {
                relate.addCell(getCell(member.getRelate().getDateOfCreation().format(datePattern), FONT_ROW));
            } else {
                relate.addCell(getCell("", FONT_ROW));
            }
            relate.completeRow();
            relate.addCell(getFillCell("Количество работников", FONT_HEADER));
            relate.addCell(getCell(member.getRelate().getSize().toString(), FONT_ROW));
            relate.completeRow();
            relate.addCell(getFillCell("Вид деятельности/\nоказываемые услуги", FONT_HEADER));
            relate.addCell(getCell(member.getRelate().getServices(), FONT_ROW));
            relate.completeRow();
            document.add(relate);

            PdfPTable generalInformation = new PdfPTable(2);
            generalInformation.setTotalWidth(new float[] {150, 400});
            generalInformation.setLockedWidth(true);
            generalInformation.addCell(getFillCell("Форма организации", FONT_HEADER));
            generalInformation.addCell(getCell(member.getGeneralInformation().getOrganizationForm(), FONT_ROW));
            generalInformation.completeRow();
            generalInformation.addCell(getFillCell("Тип экономической деятельности", FONT_HEADER));
            generalInformation.addCell(getCell(member.getGeneralInformation().getEconomicSector(), FONT_ROW));
            generalInformation.completeRow();
            generalInformation.addCell(getFillCell("Тип формы собственности", FONT_HEADER));
            generalInformation.addCell(getCell(member.getGeneralInformation().getOwnershipForm(), FONT_ROW));
            generalInformation.completeRow();
            generalInformation.addCell(getFillCell("Тип вида деятельности", FONT_HEADER));
            generalInformation.addCell(getCell(member.getGeneralInformation().getActivityType(), FONT_ROW));
            generalInformation.completeRow();
            generalInformation.addCell(getFillCell("Тип формы предпринимательства", FONT_HEADER));
            generalInformation.addCell(getCell(member.getGeneralInformation().getBusinessForm(), FONT_ROW));
            generalInformation.completeRow();
            document.add(generalInformation);
            document.add(Chunk.NEWLINE);

            String checked = "✓";
            String unchecked = "-";

            PdfPTable interest = new PdfPTable(8);
            interest.setTotalWidth(new float[] {160, 20, 5, 160, 20, 5,  160, 20});
            interest.setLockedWidth(true);

            interest.addCell(getCell("Являются импортерами", FONT_ROW));
            if(member.getGeneralInformation().isVedImport()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Выездные бизнес миссии", FONT_ROW));
            if(member.getGeneralInformation().isBusinessMissionVisiting()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Участие в пилотных проектах", FONT_ROW));
            if(member.getGeneralInformation().isPilotProjects()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.completeRow();

            interest.addCell(getCell("Являются экспортерами", FONT_ROW));
            if(member.getGeneralInformation().isVedExport()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Региональные бизнес миссии", FONT_ROW));
            if(member.getGeneralInformation().isBusinessMissionRegional()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Антикоррупционная хартия", FONT_ROW));
            if(member.getGeneralInformation().isAntiCorruptionCharter()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.completeRow();

            interest.addCell(getCell("Участие Online", FONT_ROW));
            if(member.getGeneralInformation().isInteractionOffline()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Заинтересованность в MKAS", FONT_ROW));
            if(member.getGeneralInformation().isMkas()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Информационная рассылка", FONT_ROW));
            if(member.getGeneralInformation().isNewsletter()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.completeRow();

            interest.addCell(getCell("Участие Offline", FONT_ROW));
            if(member.getGeneralInformation().isInteractionOffline()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Потребность в молодых кадрах", FONT_ROW));
            if(member.getGeneralInformation().isNeedForYoungPersonnel()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Участие в комитетах", FONT_ROW));
            if(member.getGeneralInformation().isCommittees()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.completeRow();

            interest.addCell(getCell("Заинтересованность в B2B", FONT_ROW));
            if(member.getGeneralInformation().isB2b()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Заинтересованность в B2C", FONT_ROW));
            if(member.getGeneralInformation().isDiscounts()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Корпоративный член", FONT_ROW));
            if(member.getGeneralInformation().isCorporateMember()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.completeRow();

            interest.addCell(getCell("Заинтересованность в B2C", FONT_ROW));
            if(member.getGeneralInformation().isB2c()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.addCell(getCell("Реестр надежных партнеров", FONT_ROW));
            if(member.getGeneralInformation().isReliablePartners()) {
                interest.addCell(getCell(checked, FONT_HEADER));
            } else {
                interest.addCell(getCell(unchecked, FONT_HEADER));
            }
            interest.addCell(getEmptyFillCell());
            interest.completeRow();
            document.add(interest);
            document.add(new Paragraph("", FONT_ROW));

            document.add(new Paragraph("Руководство\n\n", FONT_HEADER));
            PdfPTable director = new PdfPTable(2);
            director.setTotalWidth(new float[] {150, 400});
            director.setLockedWidth(true);
            director.addCell(getFillCell("ФИО", FONT_HEADER));
            director.addCell(getCell(member.getDirector().getFullName(), FONT_ROW));
            director.completeRow();
            director.addCell(getFillCell("Должность", FONT_HEADER));
            director.addCell(getCell(member.getDirector().getPosition(), FONT_ROW));
            director.completeRow();
            director.addCell(getFillCell("Мобильный телефон", FONT_HEADER));
            director.addCell(getCell(member.getDirector().getPhoneMobile(), FONT_ROW));
            director.completeRow();
            director.addCell(getFillCell("Дополнительный телефон", FONT_HEADER));
            if(member.getDirector().getPhoneCity() != null) {
                director.addCell(getCell(member.getDirector().getPhoneCity(), FONT_ROW));
            }
            director.completeRow();
            director.addCell(getFillCell("Электронная почта", FONT_HEADER));
            director.addCell(getCell(member.getDirector().getEmail(), FONT_ROW));
            director.completeRow();
            document.add(director);
            document.newPage();

            document.add(new Paragraph("Контакты\n\n", FONT_HEADER));
            PdfPTable contact = new PdfPTable(2);
            contact.setTotalWidth(new float[] {150, 400});
            contact.setLockedWidth(true);
            contact.addCell(getFillCell("Телефон", FONT_HEADER));
            contact.addCell(getCell((member.getContact().getPhone()), FONT_ROW));
            contact.completeRow();
            contact.addCell(getFillCell("Факс", FONT_HEADER));
            contact.addCell(getCell((member.getContact().getFax()), FONT_ROW));
            contact.completeRow();
            contact.addCell(getFillCell("Сайт", FONT_HEADER));
            contact.addCell(getCell((member.getContact().getSite()), FONT_ROW));
            contact.completeRow();
            contact.addCell(getFillCell("Электронная почта", FONT_HEADER));
            contact.addCell(getCell((member.getContact().getEmail()), FONT_ROW));
            contact.completeRow();
            document.add(contact);
            document.add(new Paragraph("", FONT_ROW));

            document.add(new Paragraph("Реквизиты\n\n", FONT_HEADER));
            PdfPTable accoutingInformation = new PdfPTable(2);
            accoutingInformation.setTotalWidth(new float[] {150, 400});
            accoutingInformation.setLockedWidth(true);
            accoutingInformation.addCell(getFillCell("ОГРН", FONT_HEADER));
            accoutingInformation.addCell(getCell(member.getAccoutingInformation().getOgrn(), FONT_ROW));
            accoutingInformation.completeRow();
            accoutingInformation.addCell(getFillCell("КПП", FONT_HEADER));
            accoutingInformation.addCell(getCell(member.getAccoutingInformation().getKpp(), FONT_ROW));
            accoutingInformation.completeRow();
            accoutingInformation.addCell(getFillCell("ИНН", FONT_HEADER));
            accoutingInformation.addCell(getCell(member.getAccoutingInformation().getTin(), FONT_ROW));
            accoutingInformation.completeRow();
            document.add(accoutingInformation);
            document.add(new Paragraph("", FONT_ROW));

            document.add(new Paragraph("Юридический адрес\n\n", FONT_HEADER));
            PdfPTable addressLegal = new PdfPTable(2);
            addressLegal.setTotalWidth(new float[] {150, 400});
            addressLegal.setLockedWidth(true);
            addressLegal.addCell(getFillCell("Код региона", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getRegionId().toString(), FONT_ROW));
            addressLegal.completeRow();
            addressLegal.addCell(getFillCell("Регион", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getRegionName(), FONT_ROW));
            addressLegal.completeRow();
            addressLegal.addCell(getFillCell("Индекс", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getIndex().toString(), FONT_ROW));
            addressLegal.completeRow();
            addressLegal.addCell(getFillCell("Город", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getStreet(), FONT_ROW));
            addressLegal.completeRow();
            addressLegal.addCell(getFillCell("Улица", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getStreet(), FONT_ROW));
            addressLegal.completeRow();
            addressLegal.addCell(getFillCell("Дом", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getHouse(), FONT_ROW));
            addressLegal.completeRow();
            addressLegal.addCell(getFillCell("Офис", FONT_HEADER));
            addressLegal.addCell(getCell(member.getAddressLegal().getOffice(), FONT_ROW));
            addressLegal.completeRow();
            if(member.getAddressLegal().getDistrict() != null) {
                addressLegal.addCell(getFillCell("Район", FONT_HEADER));
                addressLegal.addCell(getCell(member.getAddressLegal().getDistrict(), FONT_ROW));
                addressLegal.completeRow();
            }
            document.add(addressLegal);

            document.add(new Paragraph("Фактический адрес\n\n", FONT_HEADER));
            PdfPTable addressActual = new PdfPTable(2);
            addressActual.setTotalWidth(new float[] {150, 400});
            addressActual.setLockedWidth(true);
            addressActual.addCell(getFillCell("Код региона", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getRegionId().toString(), FONT_ROW));
            addressActual.completeRow();
            addressActual.addCell(getFillCell("Регион", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getRegionName(), FONT_ROW));
            addressActual.completeRow();
            addressActual.addCell(getFillCell("Индекс", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getIndex().toString(), FONT_ROW));
            addressActual.completeRow();
            addressActual.addCell(getFillCell("Город", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getStreet(), FONT_ROW));
            addressActual.completeRow();
            addressActual.addCell(getFillCell("Улица", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getStreet(), FONT_ROW));
            addressActual.completeRow();
            addressActual.addCell(getFillCell("Дом", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getHouse(), FONT_ROW));
            addressActual.completeRow();
            addressActual.addCell(getFillCell("Офис", FONT_HEADER));
            addressActual.addCell(getCell(member.getAddressActual().getOffice(), FONT_ROW));
            addressActual.completeRow();
            if(member.getAddressActual().getDistrict() != null) {
                addressActual.addCell(getFillCell("Район", FONT_HEADER));
                addressActual.addCell(getCell(member.getAddressActual().getDistrict(), FONT_ROW));
                addressActual.completeRow();
            }
            document.add(addressActual);
            document.add(new Paragraph("", FONT_ROW));
            document.add(Chunk.NEWLINE);
            PdfPTable agree = new PdfPTable(2);
            agree.setTotalWidth(new float[] {50, 500});
            agree.setLockedWidth(true);
            agree.addCell(getCell("", FONT_ROW));
            agree.addCell(getCell("Даю свое согласие на обработку персональных данных", FONT_ROW));
            agree.completeRow();
            document.add(agree);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static PdfPCell getFillCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setGrayFill(0.9f);
        return cell;
    }
    private static PdfPCell getCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell;
    }

    private static PdfPCell getEmptyFillCell() {
        PdfPCell cell = new PdfPCell(new Phrase(""));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setGrayFill(0.1f);
        return cell;
    }
}

