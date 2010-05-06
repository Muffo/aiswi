/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamegui;

import java.awt.Color;
import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.border.Border;

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


    public Cell(int x, int y, String color, String figure) {
        super();
        this.x = x;
        this.y = y;
        
        String projectPath = "";
        
        //finding local path
        File dir = new File (".");
        try{
            projectPath = dir.getCanonicalPath();
            
        }catch(Exception e){
            e.printStackTrace();
        }

        
        this.setSize(DIM_IMG, DIM_IMG);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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


    public String getPrologMove() {
        return "sono(" + x + "," + y + "," + color + "," + figure + ")";
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ChessBoard.getInstance().appendMove(getPrologMove());
       
    }

    public void setFigure(String figure) {
        this.figure = figure;
        String figureFile = (String) Cell.catalogCF.get(figure);

        System.out.println(figureFile);
        lblIcon.setIcon(new javax.swing.ImageIcon(figureFile));
    }

    public void setColor(String color) {
        this.color = color;
        setBackground((java.awt.Color)Cell.catalogCF.get(color));
    }

   

    public static void initDictionary() {
       File dir = new File (".");
        try{
            String projectPath = dir.getCanonicalPath();
            catalogCF.put("martello", projectPath + "/img/martello.png");
            catalogCF.put("hammer", projectPath + "/img/martello.png");
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
