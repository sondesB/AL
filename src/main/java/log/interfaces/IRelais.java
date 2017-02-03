package log.interfaces;

import interfaceswcomp.OCService;
import utils.BindingType;

/**
 * Created by seb on 03/02/17.
 */
public interface IRelais {

    /**
     * Relaye la décision de connexion ou de déconnexion prise par l'agent.
     * @param serviceProvider Le service provider.
     * @param serviceRequire Le service require.
     * @param bindingType Le type de binding (bind, unbind).
     */
    public void relayer(OCService serviceProvider, OCService serviceRequire, BindingType bindingType);
}
