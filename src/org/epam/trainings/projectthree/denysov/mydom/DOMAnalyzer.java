package org.epam.trainings.projectthree.denysov.mydom;

import generated.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by asus on 06.01.2015.
 */
public class DOMAnalyzer {
    public static ArrayList<Plant> listBuilder(Element root) throws SAXException, IOException {
        ArrayList<Plant> plants = new ArrayList<Plant>();
        NodeList plantsNodes = root.getElementsByTagName("plant");
        Element plantElement;
        Plant plant;
        VisualParameters visualParameters;
        GrowingTips growingTips;
        for (int i = 0; i < plantsNodes.getLength(); i++) {
            plant = new Plant();
            plantElement = (Element) plantsNodes.item(i);

            plant.setId(plantElement.getAttribute("id"));
            plant.setName(getBabyValue(plantElement, "name"));
            plant.setSoil(SoilType.fromValue(getBabyValue(plantElement, "soil")));
            plant.setOrigin(getBabyValue(plantElement, "origin"));

            plant.getVisualParameters().setStemColor(getBabyValue(plantElement, "stem_color"));
            plant.getVisualParameters().setFlowerColor(getBabyValue(plantElement, "flower_color"));
            plant.getVisualParameters().setAverageSize(Float.parseFloat(getBabyValue(plantElement, "average_size")));

            plant.getGrowingTips().setTemperature(Float.parseFloat(getBabyValue(plantElement, "temperature")));
            plant.getGrowingTips().setPhotophilous(Boolean.parseBoolean(getBabyValue(plantElement, "photophilous")));
            plant.getGrowingTips().setWatering(Double.parseDouble(getBabyValue(plantElement, "watering")));

            plant.setMultiplying(MultiplyingType.fromValue(getBabyValue(plantElement, "multiplying")));
            plants.add(plant);
        }
        return plants;
    }

    private static Element getBaby(Element parent, String childName) {
        NodeList nodeList = parent.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }

    private static String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value;
    }
}
