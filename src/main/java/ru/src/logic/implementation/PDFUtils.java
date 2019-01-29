package ru.src.logic.implementation;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;

import rst.pdfbox.layout.elements.ControlElement;
import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.Element;
import rst.pdfbox.layout.elements.Paragraph;

import java.io.*;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

public class PDFUtils {

    private static PDFont FONT;
    private static final float FONT_SIZE = 20;
    private static final float LEADING = -1.5f * FONT_SIZE;

//    public static void createPDF(String pathName, ArrayList<String> params) {
//        try (final PDDocument doc = new PDDocument()){
//
//            PDPage page = new PDPage();
//            doc.addPage(page);
//            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
//
//
//
//            FONT = PDType0Font.load(doc, new File(ClassLoader.getSystemClassLoader().getResource("fonts/times.ttf").getFile()));
//
//            PDRectangle mediaBox = page.getMediaBox();
//            float marginY = 60;
//            float marginX = 40;
//            float width = mediaBox.getWidth() - 2 * marginX;
//            float startX = mediaBox.getLowerLeftX() + marginX;
//            float startY = mediaBox.getUpperRightY() - marginY;
//
////            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
////                    " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
////                    " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
////                    " ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
////                    " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
////                    "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
////                    " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
//
//            contentStream.beginText();
//            for (int i = 0; i < params.size(); i++) {
//                if(i == 0) addParagraph(contentStream, width, startX, startY, params.get(i), true);
//                else if(!(i == params.size() - 1)) addParagraph(contentStream, width, 0, -FONT_SIZE, params.get(i));
//                else addParagraph(contentStream, width, 0, -FONT_SIZE, params.get(i), false);
//
//            }
//            contentStream.endText();
//            contentStream.close();
//
//            doc.save(new File(pathName));
//        } catch (IOException e){
//            System.err.println("Exception while trying to create pdf document - " + e);
//        }
//    }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text) throws IOException {
        addParagraph(contentStream, width, sx, sy, text, false);
    }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text, boolean justify) throws IOException {
        List<String> lines = parseLines(text, width);
        contentStream.setFont(FONT, FONT_SIZE);
        contentStream.newLineAtOffset(sx, sy);
        for (String line: lines) {
            float charSpacing = 0;
            if (justify){
                if (line.length() > 1) {
                    float size = FONT_SIZE * FONT.getStringWidth(line) / 1000;
                    float free = width - size;
                    if (free > 0 && !lines.get(lines.size() - 1).equals(line)) {
                        charSpacing = free / (line.length() - 1);
                    }
                }
            }
            contentStream.setCharacterSpacing(charSpacing);
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, LEADING);
        }
    }

    private static List<String> parseLines(String text, float width) throws IOException {
        List<String> lines = new ArrayList<String>();
        int lastSpace = -1;
        while (text.length() > 0) {
            int spaceIndex = text.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0)
                spaceIndex = text.length();
            String subString = text.substring(0, spaceIndex);
            float size = FONT_SIZE * FONT.getStringWidth(subString) / 1000;
            if (size > width) {
                if (lastSpace < 0){
                    lastSpace = spaceIndex;
                }
                subString = text.substring(0, lastSpace);
                lines.add(subString);
                text = text.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == text.length()) {
                lines.add(text);
                text = "";
            } else {
                lastSpace = spaceIndex;
            }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {

    }

    public static void saveToPDF(ArrayList<String> params, String pathName) {
        try {
            Document document = new Document(40, 50, 40, 60);
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("fonts/times.ttf");
            PDFont font = PDType0Font.load(document.getPDDocument(), inputStream);
            int fontSize = 12;
            OutputStream outputStream = new FileOutputStream(pathName);

            for (String oneParam : params) {
                Paragraph paragraph = new Paragraph();
                paragraph.addText(oneParam + "\n\n", fontSize, font);
                document.add(paragraph);
            }
            document.add(ControlElement.NEWPAGE);

            Paragraph paragraph = new Paragraph();
            paragraph.addText("new PAGE", fontSize, font);
            document.add(paragraph);
            document.save(outputStream);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException b) {
            b.getMessage();
        }

    }



//    public static void main(String[] args) throws IOException {
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage();
//        document.addPage(page);
//        PDPageContentStream contentStream = new PDPageContentStream(document, page);
//        PDImageXObject pdImage = PDImageXObject.createFromFile("/home/green/test/1.jpg", document);
//        //contentStream.beginText();
//
////        contentStream.newLineAtOffset(25, 700);
////        contentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
////        contentStream.setLeading(14.5f);
//
//        contentStream.drawImage(pdImage, 70, 500);
//
//       //contentStream.endText();
//
//        contentStream.close();
//
//        document.save("/home/green/test/test.pdf");
//        document.close();
//    }
}
