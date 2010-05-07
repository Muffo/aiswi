/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamegui;

import java.awt.Cursor;
import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author muffo
 */
public class Cell extends javax.swing.JPanel{

    final static public int DIM_IMG = 64;
    private javax.swing.JLabel lblIcon;
    private int x, y;
    private String color;
    private String figure;

    private static Dictionary<String, Object> catalogCF = new Hashtable<String, Object>();

     public Cell(int x, int y) {
         this(x, y, "default", "empty");
     }

    public Cell(int x, int y, String color, String figure) {
        super();
        this.x = x;
        this.y = y;
        
        this.setSize(DIM_IMG, DIM_IMG);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblIcon = new javax.swing.JLabel();

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setSize(new java.awt.Dimension(64, 64));

        this.setColor(color);
        this.setFigure(figure);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblIcon)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblIcon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
        );

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
    }


    

    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        setHighlight(true);
        ChessBoard.getInstance().addMove(x, y, color, figure);
       
    }

    public void setFigure(String figure) {
        this.figure = figure;
        if (figure.equals("empty")) {
            lblIcon.setIcon(null);
        }
        else {
            String figureFile = (String) Cell.catalogCF.get(figure);
            lblIcon.setIcon(new javax.swing.ImageIcon(figureFile));
        }

    }

    public void setColor(String color) {
        this.color = color;
        setBackground((java.awt.Color)Cell.catalogCF.get(color));
    }

    public void setHighlight(boolean highlight) {
        if (highlight)
            setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 3));
        else
            setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,  0, 0), 1));
        
    }

    public String getColor(){
        return this.color;
    }

    public String getFigure(){
        return this.figure;
    }

    public int getPosX(){
        return this.x;
    }

    public int getPosY(){
        return this.y;
    }

    
    public static void initDictionary() {
       File dir = new File (".");
        try{
            String projectPath = dir.getCanonicalPath();
            catalogCF.put("arm", projectPath + "/img/arm.png");
            catalogCF.put("arms", projectPath + "/img/arms-lancia.png");
            catalogCF.put("bin", projectPath + "/img/bin.png");
            catalogCF.put("book", projectPath + "/img/book.png");
            catalogCF.put("disk", projectPath + "/img/disk.png");
            catalogCF.put("ipod", projectPath + "/img/ipod.png");
            catalogCF.put("monkey", projectPath + "/img/monkey.png");
            catalogCF.put("mouse", projectPath + "/img/mouse.png");
            catalogCF.put("paper", projectPath + "/img/paper.png");
            catalogCF.put("pen", projectPath + "/img/pen.png");
            catalogCF.put("poison", projectPath + "/img/poison.png");
            catalogCF.put("skull", projectPath + "/img/skull-empty.png");
            catalogCF.put("star", projectPath + "/img/star.png");
            catalogCF.put("troll", projectPath + "/img/troll.png");
            catalogCF.put("martello", projectPath + "/img/martello.png");
            catalogCF.put("hammer", projectPath + "/img/martello.png");
            catalogCF.put("arrow", projectPath + "/img/arrow.png");
            catalogCF.put("default", new java.awt.Color(255, 255, 255));
            catalogCF.put("yellow", new java.awt.Color(255, 255, 0));
            catalogCF.put("giallo", new java.awt.Color(255,255,0));
            catalogCF.put("blue", new java.awt.Color(0,0,255));
            catalogCF.put("blue", new java.awt.Color(0,0,255));
            catalogCF.put("red", new java.awt.Color(255,0,0));
            catalogCF.put("rosso", new java.awt.Color(255,0,0));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
