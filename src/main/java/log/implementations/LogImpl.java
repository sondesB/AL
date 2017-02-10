package log.implementations;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;
import log.interfaces.ILogComposant;
import log.interfaces.ILogDecision;
import log.interfaces.ILogRestitution;
import log.services.LogService;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by seb on 03/02/17.
 */
public class LogImpl implements ILogComposant, ILogDecision, ILogRestitution {


    private LogService logService = new LogService();

    @Override
    public void logApparitionComposant(OCComponent ocComponent) {
        String log = String.format("%s %s - Apparition",this.getDateToString(), ocComponent.getComponentProperties());
        logService.ecrireLog(log);
    }

    @Override
    public void logBinding(OCService service1, OCService service2) {
        String log = String.format("%s %s %s - bind", this.getDateToString(), service1, service2);
        this.logService.ecrireLog(log);
    }

    @Override
    public void logUnbinding(OCService service1, OCService service2) {
        String log = String.format("%s %s %s - unbind", this.getDateToString(), service1, service2);
        this.logService.ecrireLog(log);
    }

    @Override
    public void logDisparitionComposant(OCComponent ocComponent) {
        String log = String.format("%s %s - Disparition",this.getDateToString(), ocComponent.getComponentProperties());
        logService.ecrireLog(log);
    }


    /**
     * Retourne la date actuelle sous forme yyyy-MM-dd HH:mm:ss
     * @return String
     */
    private String getDateToString() {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

	@Override
	public File getLog() {
		return logService.getLog();
	}
}
