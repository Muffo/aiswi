/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

/**
 *
 * @author baio
 */
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


public class XMLValidator {
  /**
   * Validate an xml file according to xml/game.xsd schema
   * @param fileNameToValidate
   * @throws SAXException
   */
  public void Validate(String fileNameToValidate) throws SAXException {
    
      // define the type of schema - we use W3C:
      String schemaLang = "http://www.w3.org/2001/XMLSchema";

      // get validation driver:
      SchemaFactory factory = SchemaFactory.newInstance(schemaLang);

      // create schema by reading it from an XSD file:
      Schema schema = factory.newSchema(new StreamSource("xml/game.xsd"));
      Validator validator = schema.newValidator();
        try {
            // at last perform validation:
            validator.validate(new StreamSource(fileNameToValidate));
        } catch (IOException ex) {
           
            ex.printStackTrace();
        }

    
    
  }
}