/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gamegui;

import java.awt.Color;
import java.io.File;
import javax.swing.border.Border;

/**
 *
 * @author muffo
 */
public class Cell extends javax.swing.JPanel{

    final static public int DIM_IMG = 64;
    private javax.swing.JLabel lblIcon;
    private int x, y;
    private Color color;
    private String figure;


    public Cell(int x, int y, Color color, String figure) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        this.figure = figure;
        String projectPath = "";
        
        //finding local path
        File dir = new File (".");
        try{
            projectPath = dir.getCanonicalPath();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        this.setBackground(Color.blue);
        this.setSize(DIM_IMG, DIM_IMG);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblIcon = new javax.swing.JLabel();

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(projectPath + "/src/img/martello.png")); // NOI18N
        lblIcon.setSize(new java.awt.Dimension(64, 64));

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
        return "sono(" + x + "," + y + "," + getColorString(color) + "," + figure + ")";
    }

    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ChessBoard.getInstance().appendMove(getPrologMove());
       
    }

    public void setIcon(String file) {
         lblIcon.setIcon(new javax.swing.ImageIcon(file));

    }

    private String getColorString(Color color) {
        return "blue";
    }

}
