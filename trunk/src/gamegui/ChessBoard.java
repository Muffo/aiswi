/*
 * ChessBoard.java
 *
 * Created on 6-mag-2010, 15.46.34
 */

package gamegui;

import lib.*;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javasciff.SProject;
import javasciff.SciffBridge;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.xml.sax.SAXException;

/**
 *
 * @author Baioni, Grandi, Tallevi
 */

public class ChessBoard extends javax.swing.JFrame {

    final static public int DIM = 8;
    final static private String xmlFile = "game.xml";
    final static public File dir = new File(".");;
    public static String projectPath;
    public static String okIconPath;
    public static String ErrorIconPath;
    public static String WarningIconPath;
    public static String HelpIconPath;
    public static String ExitIconPath;
    private static ChessBoard instance = new ChessBoard();

    Cell[][] cells = new Cell[DIM][DIM];
    List<Move> trace = new Vector<Move>();
    SciffBridge sciff = new SciffBridge("sciff/");
    private int moveCounter = 0;
   

    /** Creates new form ChessBoard */
    public ChessBoard() {
        initComponents();
        initBoard();
        try {
            projectPath = dir.getCanonicalPath();
            okIconPath = projectPath +"/img/ok.png";
            ErrorIconPath = projectPath +"/img/error.png";
            WarningIconPath = projectPath +"/img/warning.png";
            HelpIconPath = projectPath +"/img/ass.png";
            ExitIconPath = projectPath + "/img/exit.png";
        } catch (IOException ex) {
           // Logger.getLogger(ChessBoard.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Errore: " + ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(WarningIconPath));
        }
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
        btnClear = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuProject = new javax.swing.JMenu();
        jMenuItemRun = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemUndoLast = new javax.swing.JMenuItem();
        jMenuClearAll = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sciff Game");
        setBounds(new java.awt.Rectangle(512, 250, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

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

        btnClear.setText("Clear Moves");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        btnUndo.setText("Undo Last Move");
        btnUndo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUndoMouseClicked(evt);
            }
        });

        jLabel1.setText("0");

        jLabel2.setText("1");

        jLabel3.setText("2");

        jLabel4.setText("3");

        jLabel5.setText("4");

        jLabel6.setText("5");

        jLabel7.setText("6");

        jLabel8.setText("7");

        jLabel9.setText("0");

        jLabel10.setText("1");

        jLabel11.setText("2");

        jLabel12.setText("3");

        jLabel13.setText("4");

        jLabel14.setText("5");

        jLabel15.setText("7");

        jLabel16.setText("6");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(btnEval, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnClear)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnUndo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel2)
                                .add(54, 54, 54)
                                .add(jLabel3)
                                .add(56, 56, 56)
                                .add(jLabel4)
                                .add(60, 60, 60)
                                .add(jLabel5)
                                .add(57, 57, 57)
                                .add(jLabel6)
                                .add(56, 56, 56)
                                .add(jLabel7)
                                .add(58, 58, 58)
                                .add(jLabel8)
                                .add(46, 46, 46))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, Board, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel8)
                    .add(jLabel7)
                    .add(jLabel6)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, Board, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                            .add(btnUndo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnClear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnEval, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 44, Short.MAX_VALUE)
                        .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(43, 43, 43)
                        .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(36, 36, 36)
                        .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(47, 47, 47)
                        .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(43, 43, 43)
                        .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(41, 41, 41)
                        .add(jLabel16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(43, 43, 43)
                        .add(jLabel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(109, 109, 109))))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 0));

        jMenu1.setBackground(new java.awt.Color(255, 255, 0));
        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconOpen.png"))); // NOI18N
        jMenuItem1.setText("Load XML...");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconSave.png"))); // NOI18N
        jMenuItem3.setText("Export to XML...");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        jMenuItem2.setText("Close");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenuProject.setBackground(new java.awt.Color(255, 255, 0));
        jMenuProject.setText("Project");
        jMenuProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvalActionPerformed(evt);
            }
        });

        jMenuItemRun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.META_MASK));
        jMenuItemRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconRun.png"))); // NOI18N
        jMenuItemRun.setText("Run Project...");
        jMenuItemRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvalActionPerformed(evt);
            }
        });
        jMenuProject.add(jMenuItemRun);
        jMenuProject.add(jSeparator1);

        jMenuItemUndoLast.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.META_MASK));
        jMenuItemUndoLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconUndo.png"))); // NOI18N
        jMenuItemUndoLast.setText("Undo Last Move");
        jMenuItemUndoLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUndoLastActionPerformed(evt);
            }
        });
        jMenuProject.add(jMenuItemUndoLast);

        jMenuClearAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.META_MASK));
        jMenuClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconDelete.gif"))); // NOI18N
        jMenuClearAll.setText("Clear All Moves");
        jMenuClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClearAllActionPerformed(evt);
            }
        });
        jMenuProject.add(jMenuClearAll);

        jMenuBar1.add(jMenuProject);

        jMenu2.setBackground(new java.awt.Color(255, 255, 0));
        jMenu2.setText("Help");

        jMenuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconHelp.gif"))); // NOI18N
        jMenuHelp.setText("Help");
        jMenuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuHelpActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuHelp);
        jMenu2.add(jSeparator2);

        jMenuAbout.setText("About Sciff Game...");
        jMenuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAboutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuAbout);

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

    private void initBoard() {

        Cell.initDictionary();

        for(int i=0; i<DIM; i++) {
            for(int j=0; j<DIM; j++) {
                cells[i][j] = new Cell(i, j);
                cells[i][j].setLocation(i * CellGraphic.DIM_IMG, j* CellGraphic.DIM_IMG);
                cells[i][j].setVisible(true);
                Board.add(cells[i][j]);
            }
        }
    }

    /**
     * Get the only one Chessboard instance created in the system
     * @return CHessBoard
     */
    public static ChessBoard getInstance(){
        return instance;
    }

     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ChessBoard.instance.setVisible(true);
                ChessBoard.instance.loadFromXML(xmlFile, false);

             }
        });
    }

    private void btnEvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvalActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        try {
           
            SProject project = new SProject("gameProj", "project_template");
            project.kb = txtRules.getText();
            if (trace.isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "Errore: non hai selezionato un percorso", "Result", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(WarningIconPath));
                return;
            }
            project.trace = trace;


            String iconPath;
            String txtResult;
            Boolean bool = sciff.runProject(project);
            System.out.println(bool);
            if(bool){
                txtResult = "Percorso corretto";
                iconPath = okIconPath;
            }else{
                txtResult = "Percorso errato";
                iconPath = ErrorIconPath;
            }
            
            JOptionPane.showMessageDialog(new JFrame(), "Result: " + txtResult, "Result", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(iconPath));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Errore: " + e.getMessage(), "Result", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(WarningIconPath));
        }
        finally {
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_btnEvalActionPerformed

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        clearMoves();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnUndoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUndoMouseClicked
        undoMove();

    }//GEN-LAST:event_btnUndoMouseClicked

    private void jMenuItemUndoLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUndoLastActionPerformed
        undoMove();
    }//GEN-LAST:event_jMenuItemUndoLastActionPerformed

    private void jMenuClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClearAllActionPerformed
        clearMoves();
    }//GEN-LAST:event_jMenuClearAllActionPerformed

    private void jMenuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuHelpActionPerformed
        String message = "È troppo facile...\nnon ti posso aiutare ";
        JOptionPane.showMessageDialog(null, message,"Help",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(HelpIconPath));
    }//GEN-LAST:event_jMenuHelpActionPerformed

    private void jMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAboutActionPerformed
        String message = "Realizzato da:\n Enrico Baioni\n Andrea Grandi\n Simone Tallevi Diotallevi";
        JOptionPane.showMessageDialog(null, message,"About Sciff Game",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(HelpIconPath));
    }//GEN-LAST:event_jMenuAboutActionPerformed

    private void jMenuItem3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseReleased
        String wd = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(wd);
        int rc = fc.showDialog(null, "Export Xml Game File");
        if (rc == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getAbsolutePath();
            XMLObj r = new XMLObj();
            r.writeToXML(cells, txtRules.getText(), fileName);
        }
    }//GEN-LAST:event_jMenuItem3MouseReleased

    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        String message = "Uscire dal programma?";
        int answer = JOptionPane.showConfirmDialog(this, message,"Uscita",JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, new ImageIcon(ExitIconPath));
        if (answer == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
        else if (answer == JOptionPane.NO_OPTION) {
        return;
        }
    }//GEN-LAST:event_jMenuItem2MouseReleased

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        String wd = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(wd);
        int rc = fc.showDialog(null, "Select Xml Game File");
        if (rc == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getAbsolutePath();
            loadFromXML(fileName, true);
        }
    }//GEN-LAST:event_jMenuItem1MouseReleased

    /**
     * Return the trace list
     * @return List<Move>
     */
    public List<Move> getTrace(){
        return trace;
    }

    /**
     * Add a move to trace list
     * @param x
     * @param y
     * @param color
     * @param figure
     */
    public void addMove(int x, int y, String color, String figure) {
        trace.add(new Move(x, y, color, figure, moveCounter));
        moveCounter++;
        refreshTrace();
    }

    /**
     * undo last move
     */
    public void undoMove() {
        if (trace.isEmpty()){
            return;
        }
        moveCounter--;
        Move lastMove = trace.get(trace.size()-1);
        trace.remove(trace.size()-1);
        refreshTrace();
        //System.out.println(lastMove);
        int x = lastMove.getX();
        int y = lastMove.getY();
        cells[x][y].setHighlight(false);
    }

    private void clearMoves() {
        for (Move move : trace) {
            int x = move.getX();
            int y = move.getY();
            cells[x][y].setHighlight(false);
            
        }
        trace.removeAll(trace);
        moveCounter = 0;
        refreshTrace();
    }

    private void refreshTrace() {
        txtTrace.setText("");
        for (Move move : trace) {
            txtTrace.append(move.toString() + "\n");
        }
    }

    private void loadFromXML(String fileName, boolean isFullPath){
        XMLValidator validator = new XMLValidator();
        try{
            String fileNameComplete;
            if (isFullPath==false)
                fileNameComplete = "xml/"+fileName;
            else
                fileNameComplete = fileName;
            System.out.println(fileNameComplete);
            validator.Validate(fileNameComplete);
            XMLObj r = new XMLObj();
            r.read(fileNameComplete);
        }catch(SAXException sax){
            JOptionPane.showMessageDialog(new JFrame(), "XML "+fileName+" NON VALIDO: "+sax.getMessage(), "Error", JOptionPane.WARNING_MESSAGE, new ImageIcon(WarningIconPath));
        }

    }

    /**
     * Update a chessboard cell
     * @param pos_x
     * @param pos_y
     * @param color
     * @param figure
     */
    public void updateBoardFromXml(int pos_x, int pos_y, String color, String figure) {
        cells[pos_x][pos_y].setFigure(figure.toLowerCase());
        cells[pos_x][pos_y].setColor(color.toLowerCase());
    }

    /**
     * Set the rules box text
     * @param rules
     */
    public void updateRulesTextArea(String rules){
        txtRules.setText(rules);

    }

   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Board;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEval;
    private javax.swing.JButton btnUndo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuClearAll;
    private javax.swing.JMenuItem jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemRun;
    private javax.swing.JMenuItem jMenuItemUndoLast;
    private javax.swing.JMenu jMenuProject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea txtRules;
    private javax.swing.JTextArea txtTrace;
    // End of variables declaration//GEN-END:variables



}
