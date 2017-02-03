package log.interfaces;

import interfaceswcomp.OCService;
import utils.BindingType;

/**
 * Created by seb on 03/02/17.
 */
public interface ILogDecision {

    /**
     * Log la décision de de connexion ou de déconnexion de composants.
     * @param provider Le service provider.
     * @param require Le service require.
     * @param bindingType Le type de Binding (bind, unbind).
     */
    public void logDecisionBinding(OCService provider, OCService require, BindingType bindingType);
}
