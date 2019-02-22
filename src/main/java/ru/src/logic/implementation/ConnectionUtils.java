package ru.src.logic.implementation;

import ru.src.model.Connection;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class ConnectionUtils {
    private static Connection connection;


    private static InputStream inputStream;
    private static OutputStream outputStream;

    private static XMLInputFactory readerFactory = XMLInputFactory.newInstance();
    private static XMLStreamReader reader;

    private static XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    private static XMLStreamWriter writer;
    private static String path = System.getProperty("user.home") + "/.member/connection.xml";




    public static synchronized Connection getConnection() {
        if (connection == null) {
            connection = Connection.initialize();
            try {

                inputStream = new FileInputStream(new File(path));
                reader = readerFactory.createXMLStreamReader(inputStream);
                while (reader.hasNext()) {

                    int event = reader.next();

                    if(event == XMLEvent.START_ELEMENT && "HOSTNAME".equals(reader.getLocalName())) {
                        connection.setHostname(reader.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "DATABASE".equals(reader.getLocalName())) {
                        connection.setDatabase(reader.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "PORT".equals(reader.getLocalName())) {
                        connection.setPort(reader.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "USERNAME".equals(reader.getLocalName())) {
                        connection.setUsername(reader.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "PASSWORD".equals(reader.getLocalName())) {
                        connection.setPassword(reader.getElementText());
                    }
                }
            } catch (XMLStreamException | FileNotFoundException e) {
                MemberUtils.warningDialog("Проверьте настройки соединения!");
            }
            finally {
                try {
                    inputStream.close();
                    reader.close();
                } catch (IOException | XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }

    public static synchronized void setConnection(String hostname, String database, String port, String username, String password) {

        connection.setHostname(hostname);
        connection.setDatabase(database);
        connection.setPort(port);
        connection.setUsername(username);
        connection.setPassword(password);

        try {


            outputStream = new FileOutputStream(new File(path));
            writer = outputFactory.createXMLStreamWriter(outputStream);

            writer.writeStartDocument("utf-8", "1.0");
            writer.writeStartElement("CONNECTION");

            writer.writeStartElement("HOSTNAME");
            writer.writeCharacters(connection.getHostname());
            writer.writeEndElement();

            writer.writeStartElement("DATABASE");
            writer.writeCharacters(connection.getDatabase());
            writer.writeEndElement();

            writer.writeStartElement("PORT");
            writer.writeCharacters(connection.getPort());
            writer.writeEndElement();

            writer.writeStartElement("USERNAME");
            writer.writeCharacters(connection.getUsername());
            writer.writeEndElement();

            writer.writeStartElement("PASSWORD");
            writer.writeCharacters(connection.getPassword());
            writer.writeEndElement();

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                outputStream.close();
            }
            catch (IOException | XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }
}
