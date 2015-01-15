package org.epam.trainings.projectthree.denysov.mystax;

import generated.MultiplyingType;
import generated.Plant;
import generated.SoilType;
import org.epam.trainings.projectthree.denysov.common.PlantEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by asus on 07.01.2015.
 */
public class MyStAXLogic {

    ArrayList<Plant> plants = new ArrayList<Plant>();
    Plant current = null;
    PlantEnum currentEnum = null;

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void parse(InputStream inputStream) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        try {
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
            process(xmlStreamReader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void process(XMLStreamReader xmlStreamReader) throws XMLStreamException {
        int type;
        String name;
        String value;
        while (xmlStreamReader.hasNext()) {
            type = xmlStreamReader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = xmlStreamReader.getLocalName();
                    if ("plant".equals(name)) {
                        current = new Plant();
                        current.setId(xmlStreamReader.getAttributeValue(0));
                    }
                    if (!"plant".equals(name) && !"flower".equals(name) && !"visual_parameters".equals(name) && !"growing_tips".equals(name)) {
                        currentEnum = PlantEnum.valueOf(name.toUpperCase());
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name=xmlStreamReader.getLocalName();
                    if("plant".equals(name)) {
                        plants.add(current);
                    }
                    currentEnum=null;
                    break;
                case XMLStreamConstants.CHARACTERS:
                    value=xmlStreamReader.getText();
                    if (currentEnum == null) continue;
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
                    break;
            }
        }
    }
}

