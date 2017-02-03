package log.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by seb on 03/02/17.
 */
public class LogService {

    File log;

    public LogService(String path) {
        this.log = new File(path);
    }

    public LogService() {
        this.log = new File("log");
    }

    public void ecrireLog(String logLine) {
        try {
            PrintWriter pw = new PrintWriter(this.log);
            pw.write(logLine);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
