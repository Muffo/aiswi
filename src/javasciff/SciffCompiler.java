/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javasciff;

import jpl.Query;

/**
 *
 * @author muffo
 */
public class SciffCompiler implements Runnable {

    private String sciffPath;

    public SciffCompiler(String sciffPath) {
        this.sciffPath = sciffPath;
    }

    public void run() {
        Query.hasSolution("compile(" + sciffPath + "sciff)");
    }





}
