package ru.src.logic.implementation;

import ru.src.model.Connection;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class ConnectionUtils {
    private static Connection connection;
    private static InputStream inputStream = ConnectionUtils.class.getResourceAsStream("/settings/connection.xml");
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private static XMLStreamReader READER;

    static synchronized Connection getConnection() {
        if (connection == null) {
            connection = Connection.initialize();
            try {
                READER = FACTORY.createXMLStreamReader(inputStream);
                while (READER.hasNext()) {

                    int event = READER.next();

                    if(event == XMLEvent.START_ELEMENT && "HOSTNAME".equals(READER.getLocalName())) {
                        connection.setHostname(READER.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "DATABASE".equals(READER.getLocalName())) {
                        connection.setDatabase(READER.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "PORT".equals(READER.getLocalName())) {
                        connection.setPort(READER.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "USERNAME".equals(READER.getLocalName())) {
                        connection.setUsername(READER.getElementText());
                    }
                    if(event == XMLEvent.START_ELEMENT && "PASSWORD".equals(READER.getLocalName())) {
                        connection.setPassword(READER.getElementText());
                    }
                }
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    static synchronized void setConnection(String hostname, String database, String port, String username, String password) {
        if(HibernateUtils.isActive) {
            HibernateUtils.closeSessionFactory();

            connection.setHostname(hostname);
            connection.setDatabase(database);
            connection.setPort(port);
            connection.setUsername(username);
            connection.setPassword(password);


                //TODO запишем в файл

        }
    }
}
