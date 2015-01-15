package org.epam.trainings.projectthree.denysov.myvalidator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Created by asus on 08.01.2015.
 */
public class MyErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("WARNING: " + e.toString());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("ERROR: " + e.toString());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("FATAL ERROR: " + e.toString());
    }
}
