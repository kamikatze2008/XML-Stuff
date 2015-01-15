package org.epam.trainings.projectthree.denysov.mysax;

import generated.Plant;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by asus on 07.01.2015.
 */
public class MySaxAnalyzer {
    public static ArrayList<Plant> parseSAX() {
        ArrayList<Plant> plants = null;
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            MyContentHandler myContentHandler = new MyContentHandler();
            xmlReader.setContentHandler(myContentHandler);
            if (myContentHandler != null) {
                xmlReader.parse("flower.xml");
            }
            plants=myContentHandler.getPlants();
        } catch (SAXException e) {
            e.printStackTrace();
       //} catch (ParserConfigurationException e) {
       //     e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }
}
