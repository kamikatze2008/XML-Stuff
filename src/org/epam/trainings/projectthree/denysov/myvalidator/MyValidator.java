package org.epam.trainings.projectthree.denysov.myvalidator;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by asus on 08.01.2015.
 */
public class MyValidator {
    public static boolean validate() {
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("flower.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("flower.xml")));
        } catch (SAXException e){
            System.out.println("Exception: "+e.getMessage());
            return false;
        }catch (IOException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}
