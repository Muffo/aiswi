/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamegui;

/**
 *
 * @author baio
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * A sample application which shows how to perform a
 * XML document validation.
 */

public class XMLValidator {
  public void Validate(String fileNameToValidate) throws SAXException {

      File dir = new File (".");
      String projectPath="";
        try {
            projectPath = dir.getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(XMLValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    
      // define the type of schema - we use W3C:
      String schemaLang = "http://www.w3.org/2001/XMLSchema";

      // get validation driver:
      SchemaFactory factory = SchemaFactory.newInstance(schemaLang);

      // create schema by reading it from an XSD file:
      Schema schema = factory.newSchema(new StreamSource(projectPath+"/xml/game.xsd"));
      Validator validator = schema.newValidator();
        try {
            // at last perform validation:
            validator.validate(new StreamSource(fileNameToValidate));
        } catch (IOException ex) {
           // Logger.getLogger(XMLValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
  }
}