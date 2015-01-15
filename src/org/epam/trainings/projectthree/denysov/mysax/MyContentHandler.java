package org.epam.trainings.projectthree.denysov.mysax;

import generated.MultiplyingType;
import generated.Plant;
import generated.SoilType;
import org.epam.trainings.projectthree.denysov.common.PlantEnum;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;


public class MyContentHandler implements ContentHandler {

    ArrayList<Plant> plants = new ArrayList<Plant>();
    Plant current = null;
    PlantEnum currentEnum = null;

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("plant")) {
            current = new Plant();
            current.setId(atts.getValue(0));
        }
        if (!"plant".equals(qName) && !"flower".equals(qName) && !"visual_parameters".equals(qName) && !"growing_tips".equals(qName)) {
            currentEnum = PlantEnum.valueOf(qName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("plant")) {
            plants.add(current);
        }
        currentEnum = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (currentEnum == null) return;
        switch (currentEnum) {
            case NAME:
                current.setName(value);
                break;
            case SOIL:
                current.setSoil(SoilType.fromValue(value));
                break;
            case ORIGIN:
                current.setOrigin(value);
                break;
            case STEM_COLOR:
                current.getVisualParameters().setStemColor(value);
                break;
            case FLOWER_COLOR:
                current.getVisualParameters().setFlowerColor(value);
                break;
            case AVERAGE_SIZE:
                current.getVisualParameters().setAverageSize(Float.parseFloat(value));
                break;
            case TEMPERATURE:
                current.getGrowingTips().setTemperature(Float.parseFloat(value));
                break;
            case PHOTOPHILOUS:
                current.getGrowingTips().setPhotophilous(Boolean.parseBoolean(value));
                break;
            case WATERING:
                current.getGrowingTips().setWatering(Double.parseDouble(value));
                break;
            case MULTIPLYING:
                current.setMultiplying(MultiplyingType.fromValue(value));
                break;
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
