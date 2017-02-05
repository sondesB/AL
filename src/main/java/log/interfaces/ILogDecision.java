package log.interfaces;

import interfaceswcomp.OCService;

/**
 * Created by seb on 03/02/17.
 */
public interface ILogDecision {

    /**
     * Log la décision de connexion de services.
     * @param service1
     * @param service2
     */
    void logBinding(OCService service1, OCService service2);

    /**
     * Log la décision de deconnexion de services.
     * @param service1
     * @param service2
     */
    void logUnbinding(OCService service1, OCService service2);
}
