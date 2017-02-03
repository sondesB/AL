package log.implementations;

import log.interfaces.ILog;
import log.services.LogService;

/**
 * Created by seb on 03/02/17.
 */
public class LogImpl implements ILog {


    private LogService logService = new LogService();

    public void loggerDecision(OCService service1, OCService service2){

    }

    public void loggerComposant(OCService service1){

    }
}
