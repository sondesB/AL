package log.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by seb on 03/02/17.
 */
public class LogService {

    File log;
    /**
     * Constructeur.
     * @param path Le chemin du fichier de log.
     */
    public LogService(String path) {
        this.log = new File(path);
    }

    /**
     * Constructeur.
     */
    public LogService() {
        this.log = new File("src"+File.separator+"main"+File.separator+"java"+File.separator+"log"+File.separator+"fichier"+File.separator+"file.txt");

        if(!this.log.exists()){
            try {
                this.log.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ecrit une ligne dans le fichier de log.
     * @param logLine La ligne à ecrire dans le fichier de log.
     */
    public void ecrireLog(String logLine) {
        try {
            PrintWriter pw = new PrintWriter(this.log);
            pw.println(logLine);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * getLog
     * @return File Le fichier de log.
     */
    public File getLog() {
		return this.log;
	}
}
