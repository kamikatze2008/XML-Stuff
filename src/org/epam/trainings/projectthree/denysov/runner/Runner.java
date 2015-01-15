package org.epam.trainings.projectthree.denysov.runner;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import generated.Plant;
import org.epam.trainings.projectthree.denysov.mydom.DOMLogic;
import org.epam.trainings.projectthree.denysov.mysax.MySaxAnalyzer;
import org.epam.trainings.projectthree.denysov.mystax.MyStAXAnalyzer;
import org.epam.trainings.projectthree.denysov.mytransformator.MyTransformator;
import org.epam.trainings.projectthree.denysov.myvalidator.MyValidator;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by asus on 06.01.2015.
 */
public class Runner {
    public static void main(String[] args) {
        if(MyValidator.validate()) {
            System.out.println("XML is VALIDATED!\n\n");
            ArrayList<Plant> plants = DOMLogic.parseDOM();
            System.out.println("DOM Parser result is:\n" + plants + "\n*****\n"
                    + "SAX Parser result is:\n" + MySaxAnalyzer.parseSAX() + "\n*****\n"
                    + "StAX Parser result is:\n" + MyStAXAnalyzer.parseStAX() + "\n*****\n");
            Collections.sort(plants, new Comparator<Plant>() {
                @Override
                public int compare(Plant o1, Plant o2) {
                    return (int) Math.signum(o1.getGrowingTips().getTemperature() - o2.getGrowingTips().getTemperature());
                }
            });
            System.out.println("Sorted plants collection is\n" + plants);

            MyTransformator.transform();
        } else {
            System.out.println("XML isn't VALIDATED");
        }
    }
}
