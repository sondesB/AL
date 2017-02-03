package log.implementations;

import interfaceswcomp.OCComponent;
import interfaceswcomp.OCService;
import log.interfaces.ILogComposant;
import log.interfaces.ILogDecision;
import log.services.LogService;
import utils.BindingType;

/**
 * Created by seb on 03/02/17.
 */
public class LogImpl implements ILogComposant, ILogDecision {


    private LogService logService = new LogService();

    @Override
    public void logApparitionComposant(OCComponent ocComponent) {

    }

    @Override
    public void logDisparitionComposant(OCComponent component) {

    }

    @Override
    public void logDecisionBinding(OCService provider, OCService require, BindingType bindingType) {

    }
}
