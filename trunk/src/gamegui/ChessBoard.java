/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChessBoard.java
 *
 * Created on 6-mag-2010, 15.46.34
 */

package gamegui;

import java.awt.Dialog;
import java.util.List;
import java.util.Vector;
import javasciff.SProject;
import javasciff.SciffBridge;
import org.xml.sax.SAXException;
import sun.security.action.OpenFileInputStreamAction;

/**
 *
 * @author muffo
 */
public class ChessBoard extends javax.swing.JFrame {

    final static public int DIM = 8;
    final static private String xmlFile = "game.xml";
    private static ChessBoard instance = new ChessBoard();

    Cell[][] cells = new Cell[DIM][DIM];
    List<String> trace = new Vector<String>();
    private int moveCounter = 0;
   




    /** Creates new form ChessBoard */
    public ChessBoard() {
        initComponents();
        initBoard();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Board = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRules = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTrace = new javax.swing.JTextArea();
        btnEval = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        Board.setBackground(new java.awt.Color(204, 102, 0));
        Board.setPreferredSize(new java.awt.Dimension(512, 512));

        org.jdesktop.layout.GroupLayout BoardLayout = new org.jdesktop.layout.GroupLayout(Board);
        Board.setLayout(BoardLayout);
        BoardLayout.setHorizontalGroup(
            BoardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 512, Short.MAX_VALUE)
        );
        BoardLayout.setVerticalGroup(
            BoardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 512, Short.MAX_VALUE)
        );

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 0));
        jSplitPane1.setDividerLocation(261);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );

        jSplitPane1.setTopComponent(jPanel4);

        txtRules.setColumns(20);
        txtRules.setRows(5);
        jScrollPane1.setViewportView(txtRules);

        jSplitPane1.setTopComponent(jScrollPane1);

        txtTrace.setColumns(20);
        txtTrace.setEditable(false);
        txtTrace.setRows(5);
        jScrollPane2.setViewportView(txtTrace);

        jSplitPane1.setRightComponent(jScrollPane2);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        btnEval.setText("Eval");
        btnEval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvalActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(Board, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(201, 201, 201)
                        .add(btnEval, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, Board, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(btnEval)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 0));

        jMenu1.setBackground(new java.awt.Color(255, 255, 0));
        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        jMenuItem1.setText("Load...");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        jMenuItem2.setText("Close");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(255, 255, 0));
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvalActionPerformed
        SProject project = new SProject("nuovo2", "project_template");


        project.kb = txtRules.getText();

        // Aggiunge la traccia degli eventi
        project.trace = trace;


        // Crea un nuovo SciffBridge per poter verificare il progetto
        SciffBridge sciff = new SciffBridge("sciff/");

        // Lo verifica e stampa l'esito su terminale
        txtRules.append("Result: " + sciff.runProject(project));
    }//GEN-LAST:event_btnEvalActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        //@TODO dialog

    }//GEN-LAST:event_jMenuItem1MouseClicked


    public static ChessBoard getInstance(){
        return instance;
    }

    
    private void initBoard() {

        Cell.initDictionary();

        for(int i=0; i<DIM; i++) {
            for(int j=0; j<DIM; j++) {
                cells[i][j] = new Cell(i, j, "blue", "martello");
                cells[i][j].setLocation(i * CellGraphic.DIM_IMG, j* CellGraphic.DIM_IMG);
                cells[i][j].setVisible(true);
                Board.add(cells[i][j]);
            }
        }
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ChessBoard.instance.setVisible(true);
                ChessBoard.instance.loadFromXML(xmlFile);

             }
        });
    }

    public void appendMove(String move) {
        trace.add("hap(" + move + "," + moveCounter + ").\n");
        moveCounter++;
        refreshTrace();
    }

    private void refreshTrace() {
        txtTrace.setText("");
        for (String moveStr : trace) {
            txtTrace.append(moveStr);
        }
    }

    private void loadFromXML(String path){
        XMLValidator validator = new XMLValidator();
        try{
            validator.Validate(xmlFile);
            XMLObj r = new XMLObj();
            r.read(path);
            r.writeToXML(cells, txtRules.getText(), "out.xml");
        }catch(SAXException sax){
            System.out.println("DOCUMENTO XML NON VALIDO: "+sax.getStackTrace().toString());
        }
    }

    public void updateBoardFromXml(int pos_x, int pos_y, String color, String figure) {
        System.out.println(""+pos_x + pos_y + color + figure);
        cells[pos_x][pos_y].setFigure(figure.toLowerCase());
        cells[pos_x][pos_y].setColor(color.toLowerCase());
    }

    public void updateRulesTextArea(String rules){
        txtRules.append(rules);

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Board;
    private javax.swing.JButton btnEval;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea txtRules;
    private javax.swing.JTextArea txtTrace;
    // End of variables declaration//GEN-END:variables



}
