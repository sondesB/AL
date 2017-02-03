package log.implementations;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;
import log.interfaces.ILogComposant;
import log.interfaces.ILogDecision;
import log.services.LogService;
import utils.BindingType;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by seb on 03/02/17.
 */
public class LogImpl implements ILogComposant, ILogDecision {


    private LogService logService = new LogService();

    @Override
    public void logApparitionComposant(OCComponent ocComponent) {
        String log = String.format("%s %s - Apparition",this.getDateToString(), ocComponent.getComponentProperties());
        logService.ecrireLog(log);
    }

    @Override
    public void logDisparitionComposant(OCComponent ocComponent) {
        String log = String.format("%s %s - Disparition",this.getDateToString(), ocComponent.getComponentProperties());
        logService.ecrireLog(log);
    }

    @Override
    public void logDecisionBinding(OCService provider, OCService require, BindingType bindingType) {
        String providerName = provider.getServiceName();
        String requireName = require.getServiceName();

        String log = this.getDateToString() + " " + providerName + " " + " " + requireName + "-";

        switch(bindingType) {
            case BIND:
                log += "bind";
                break;
            case UNBIND:
                log += "unbind";
                break;
        }

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
}
