/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author baio
 */
public class XMLReader {

    public static void main(String argv[]) {

        try {

            //finding local path
            File dir = new File (".");
            String projectPath = dir.getCanonicalPath();
            File file = new File(projectPath +"/src/xml/xml.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element " + doc.getDocumentElement().getNodeName());
            NodeList nodeLst = doc.getElementsByTagName("cell");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element fstElmnt = (Element) fstNode;

                    /**
                     * Retriving x
                     */
                    NodeList xNmElmntLst = fstElmnt.getElementsByTagName("x");
                    Element xNmElmnt = (Element) xNmElmntLst.item(0);
                    NodeList xNm = xNmElmnt.getChildNodes();
                    System.out.println("x : " + ((Node) xNm.item(0)).getNodeValue());

                    /**
                     * Retriving y
                     */
                    NodeList yNmElmntLst = fstElmnt.getElementsByTagName("y");
                    Element yNmElmnt = (Element) yNmElmntLst.item(0);
                    NodeList yNm = yNmElmnt.getChildNodes();
                    System.out.println("y : " + ((Node) yNm.item(0)).getNodeValue());

                    /**
                     * Retriving color
                     */
                    NodeList colorNmElmntLst = fstElmnt.getElementsByTagName("color");
                    Element colorNmElmnt = (Element) colorNmElmntLst.item(0);
                    NodeList colorNm = colorNmElmnt.getChildNodes();
                    System.out.println("color : " + ((Node) colorNm.item(0)).getNodeValue());

                    /**
                     * Retriving figure
                     */
                    NodeList figureNmElmntLst = fstElmnt.getElementsByTagName("figure");
                    Element figureNmElmnt = (Element) figureNmElmntLst.item(0);
                    NodeList figureNm = figureNmElmnt.getChildNodes();
                    System.out.println("figure : " + ((Node) figureNm.item(0)).getNodeValue());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
