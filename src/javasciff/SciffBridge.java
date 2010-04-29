package javasciff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import jpl.*;

/**
 * Classe per l'interfacciamento con SCIFF.
 * Consente di compilare sciff ed eseguire un progetto invocando gli opportuni comandi prolog.
 *
 * L'esecuzione dei comandi prolog viene effettuata tramite jpl.
 *
 * @author Andrea Grandi
 */
public class SciffBridge {

    /***
     * Percorso relativo della cartella contenente SCIFF
     */
    private String path;


    /***
     * Crea un nuovo oggetto SciffBridge cercando di compilare SCIFF
     * a partire dal percorso specificato.
     *
     * @param path percorso della cartella contenente SCIFF
     */
    public SciffBridge(String path) {
        this.path = path;
        compileSciff();
    }

    
    public SciffBridge() {
        this("");
    }

    /**
     * Esegue un progetto SCIFF e ritorna l'esito.
     * Il progetto deve essere precedentemente creato, cioè memorizzato su filesystem.
     *
     * @param project Progetto SCIFF
     * @return esito dell'esecuzione
     */
    public boolean runProject(Project project) {
        project.create();
        return runProject(project.getProjectName());
    }


    /**
     * Esegue il progetto SCIFF - il cui nome è pasato come parametro - e ritorna l'esito.
     * L'esecuzione avviene invocando i comandi prolog "project(nome)." e "run."
     *
     * @param project Nome del progetto SCIFF
     * @return esito dell'esecuzione
     */
    public boolean runProject(String projectName) {
        setDefaultPath();
        if(Query.hasSolution("project(" + projectName + ")"))
            return Query.hasSolution("run");

        return false;
    }

    /***
     * Esegue il comando prolog: "compile(sciff)"
     */
    private void compileSciff() {
        Query.hasSolution("compile(" + path + "sciff)");
    }


    /**
     * Inserisce all'interno del file "default.pl" il percorso corrente.
     * In questo modo sarà possibile eseguire correttamente i progetti creati.
     */
    private void setDefaultPath() {
        try {
            FileWriter fstream = new FileWriter(path + "/defaults.pl");
            BufferedWriter out = new BufferedWriter(fstream);
            System.getProperty("user.dir");
            out.write("default_dir('" + System.getProperty("user.dir") + "/').");
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    /***
     * @deprecated 
     * @param goal
     */
    private static void execute(String goal) {
        System.out.println(goal + ": " + Query.hasSolution(goal) + " - " + Query.oneSolution(goal));
    }
}
