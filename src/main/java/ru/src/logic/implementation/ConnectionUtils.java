package ru.src.logic.implementation;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import ru.src.model.Connection;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.*;

public class ConnectionUtils {

    private static Connection connection = Connection.initialize();

    private static final String path = System.getProperty("user.home") + "/.member/connection.xml";
    private static XMLStreamReader reader;
    private static XMLStreamWriter writer;

    public static Connection getConnection() {
        try (InputStream inputStream = new FileInputStream(new File(path))) {
            reader = XMLInputFactory.newInstance().createXMLStreamReader(inputStream);
            while (reader.hasNext()) {

                int event = reader.next();

                if (event == XMLEvent.START_ELEMENT) {
                    String readerName = reader.getLocalName();
                    switch (readerName) {
                        case "HOSTNAME":
                            connection.setHostname(reader.getElementText());
                            break;
                        case "DATABASE":
                            connection.setDatabase(reader.getElementText());
                            break;
                        case "PORT":
                            connection.setPort(reader.getElementText());
                            break;
                        case "USERNAME":
                            connection.setUsername(reader.getElementText());
                            break;
                        case "PASSWORD":
                            connection.setPassword(reader.getElementText());
                            break;
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            MemberUtils.warningDialog("Проверьте настройки соединения!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void setConnection(String hostname, String database, String port, String username, String password) {

        connection.setHostname(hostname);
        connection.setDatabase(database);
        connection.setPort(port);
        connection.setUsername(username);
        connection.setPassword(password);

        try (OutputStream outputStream = new FileOutputStream(new File(path))) {
            writer = XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream);

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
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }

    public static void activateConnection() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    }
}
