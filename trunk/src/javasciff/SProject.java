package javasciff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Rappresenta un progetto SCIFF.
 *
 * Consente di creare un progetto tramite Java, specificando le regole e la traccia.
 *
 * @author Andrea Grandi
 */
public class SProject {

    /**
     * Nome del file che conterrà le regole
     */
    public static final String rulesFile = "rules.txt";

    /**
     * Nome del file che conterrà la traccia
     */
    public static final String traceFile = "trace.txt";

    /**
     * Nome del file che conterrà la base di conoscenza prolog
     */
    public static final String kbFile = "kb.pl";

    /**
     * Nome del file di configurazione del progetto
     */
    public static final String projectFile = "project.pl";

    /**
     * Lista di regole SCIFF
     */
    public String rules;

    /**
     * Lista contente la traccia, cioè le mosse effettuate
     */
    public List<String> trace;

    /**
     * Base di conoscenz prolog
     */
    public String kb;

    /**
     * 
     */
    public String project;

    /**
     * Nome del progetto. Coincide con il nome della cartella che conterrà il progetto
     */
    private String projectName;

    /**
     * Restituisce il nome del progetto
     * @return nome del progetto
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Crea un nuovo progetto con il nome specificato
     * @param projectName nome del progetto
     */
    public SProject(String projectName, String projectTemplate) {
        this.projectName = projectName;
        trace = new Vector<String>();
        kb = "";
        rules = readFileAsString(projectTemplate + "/" + rulesFile);
        project = readFileAsString(projectTemplate + "/" + projectFile);
    }

    
    /**
     * Memorizza il progetto su filesystem per permetterne l'esecuzione tramite SCIFF.
     *
     * Crea la cartella che conterrà il progetto e crea tutti i file necessari.
     */
    public void generateProject() {
        (new File(projectName)).mkdir();
        generateRulesFile();
        generateTraceFile();
        generateKBFile();
        generateProjectFile();
    }


    /**
     * Crea il file delle regole, a partire dalla relativa lista
     */
    private void generateRulesFile() {
        writeStringToFile(rules, projectName + "/" + rulesFile);
    }

    /**
     * Crea il file della traccia, a partire dalla relativa lista
     */
    private void generateTraceFile() {

        trace.add(0, "hap(start,0).\n");

        writeListToFile(trace, projectName + "/" + traceFile);
    }

    
    /**
     * Crea il file kb.pl, secondo il relativo modello
     */
    private void generateKBFile() {
         writeStringToFile("society_goal.\n%%%% TEORIA PROLOG %%%%\n\n" + kb, projectName + "/" + kbFile);
    }

    /**
     * Crea il file project.pl, secondo il relativo modello
     */
    private void generateProjectFile() {

        // dovrebbe essere
        // writeStringToFile(project, projectName + "/" + projectFile);

        try {
            FileWriter fstream = new FileWriter(projectName + "/" + projectFile);
            BufferedWriter out = new BufferedWriter(fstream);

            out.write(":- dynamic ics_file/1, sokb_file/1, history_file/1, required_option/2.\n");
            out.write("\n");
            out.write("history_file('" + traceFile + "').\n");
            out.write("ics_file('" + rulesFile + "').\n");
            out.write("sokb_file('kb.pl').\n");
            out.write("\n");
            out.write("%%%%%%%%%%%%%%%%%%%%%%% Constant Part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            out.write("build_prj(Path):-");
            out.write("    findall(F,ics_file(F),ICS_files), append_path(Path,ICS_files,IcsPathFiles),\n");
            out.write("    translate_ics_files(IcsPathFiles,'./ics.pl'),\n");
            out.write("    findall(F,history_file(F),Hist_files),  append_path(Path,Hist_files,HistPathFiles),\n");
            out.write("   translate_histories(HistPathFiles,'./history.pl'),\n");
            out.write("    findall(F,sokb_file(F),Sokb_files),     append_path(Path,Sokb_files,SokbPathFiles),\n");
            out.write("    convert_sokb(SokbPathFiles,'./sokb.pl'),\n");
            out.write("    compile(sokb), compile(history), compile(ics),\n");
            out.write("    findall([O,V],required_option(O,V),LOptions),\n");
            out.write("    set_options(LOptions).\n");
            out.write("\n");
            out.write("% Default:\n");
            out.write("run(_):- run.\n");
            out.write("run_open(_):- run_no_close.\n");
            out.write("run_closed(_):- run.\n");

            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    

    /**
     * Legge una stringa da un file.
     *
     * @param filePath      nome del file da aprire
     *                      
     */
    private String readFileAsString(String filePath) {
        try {
            StringBuffer fileData = new StringBuffer(1000);
            // BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filePath)));
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
            reader.close();
            return fileData.toString();
        } catch (IOException ex) {
            Logger.getLogger(SProject.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    /**
     * Scrive una stringa intera in un file
     * 
     * @param string
     * @param fileName
     */
    private void writeStringToFile(String string, String fileName) {
        try {
            FileWriter fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);

            out.write(string);
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Metodo di utilità che permette di scrivere il contenuto di una lista
     * all'interno di un file
     * 
     * @param list
     * @param fileName
     */
    private void writeListToFile(List<String> list, String fileName) {
        try {
            FileWriter fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);

            for (String el : list) {
                out.write(el + "\n");
                out.write("\n");
            }

            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
