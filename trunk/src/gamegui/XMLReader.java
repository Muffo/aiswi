/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamegui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    

    public void read(String fileName) {
        try {

            //finding local path
            File dir = new File (".");
            String projectPath = dir.getCanonicalPath();
            File file = new File(projectPath +"/src/xml/"+fileName);
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
                    int x = Integer.parseInt("" + ((Node) xNm.item(0)).getNodeValue());

                    /**
                     * Retriving y
                     */
                    NodeList yNmElmntLst = fstElmnt.getElementsByTagName("y");
                    Element yNmElmnt = (Element) yNmElmntLst.item(0);
                    NodeList yNm = yNmElmnt.getChildNodes();
                    System.out.println("y : " + ((Node) yNm.item(0)).getNodeValue());
                    int y = Integer.parseInt("" + ((Node) yNm.item(0)).getNodeValue());

                    /**
                     * Retriving color
                     */
                    NodeList colorNmElmntLst = fstElmnt.getElementsByTagName("color");
                    Element colorNmElmnt = (Element) colorNmElmntLst.item(0);
                    NodeList colorNm = colorNmElmnt.getChildNodes();
                    System.out.println("color : " + ((Node) colorNm.item(0)).getNodeValue());
                    String color = ("" + ((Node) colorNm.item(0)).getNodeValue());

                    /**
                     * Retriving figure
                     */
                    NodeList figureNmElmntLst = fstElmnt.getElementsByTagName("figure");
                    Element figureNmElmnt = (Element) figureNmElmntLst.item(0);
                    NodeList figureNm = figureNmElmnt.getChildNodes();
                    System.out.println("figure : " + ((Node) figureNm.item(0)).getNodeValue());
                    String figure = ("" + ((Node) figureNm.item(0)).getNodeValue());
                    ChessBoard.getInstance().updateBoardFromXml(x, y, color, figure);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToXML(Cell[][] c, String newFileName){
        String head = "<?xml version=\"1.0\"?>\n";
        String rootElement = "<chessboard>\n";
        String closeRootElement = "</chessboard>\n";
        File dir = new File(".");
        String projectPath = "";
        try {
            projectPath = dir.getCanonicalPath();
            File file = new File(projectPath + "/src/xml/" + newFileName);
            file.createNewFile();
            FileWriter fstream = new FileWriter(projectPath + "/src/xml/" + newFileName);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(head);
            out.write(rootElement);
            for (int i = 0; i < ChessBoard.DIM; i++) {
                for (int j = 0; j < ChessBoard.DIM; j++) {
                    String figure = c[i][j].getFigure();
                    String color = c[i][j].getColor();
                    String pos_x = "" + c[i][j].getPosX();
                    String pos_y = "" + c[i][j].getPosY();
                    String element = "\t<cell>\n"
                            + "\t\t<x>" + pos_x
                            + "</x>\n"
                            + "\t\t<y>" + pos_y
                            + "</y>\n"
                            + "\t\t<color>" + color
                            + "</color>\n"
                            + "\t\t<figure>" + figure
                            + "</figure>\n"
                            + "\t</cell>\n";
                    out.write(element);
                }
                
            }
            out.write(closeRootElement);
            out.close();
        }catch  (Exception ex) {
            ex.printStackTrace();
        }

    }
    
}
