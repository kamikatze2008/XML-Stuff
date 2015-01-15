package org.epam.trainings.projectthree.denysov.mydom;

import generated.Plant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by asus on 06.01.2015.
 */
public class DOMLogic {
    public static ArrayList<Plant> parseDOM() {
        ArrayList<Plant> plants = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("flower.xml");
            Element root = document.getDocumentElement();
            plants = DOMAnalyzer.listBuilder(root);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }
}
