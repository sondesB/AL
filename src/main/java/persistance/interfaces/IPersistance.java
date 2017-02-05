package persistance.interfaces;

import interfaceswcomp.OCService;

/**
 * Created by seb on 03/02/17.
 */
public interface IPersistance {

    /**
     * Persiste la décision de connexion d'un agent.
     * @param service1
     * @param service2
     */
    void persisterDecisionBind(OCService service1, OCService service2);

    /**
     * Persiste la décision de déconnexion d'un agent.
     * @param service1
     * @param service2
     */
    void persisterDecisionUnbind(OCService service1, OCService service2);

}
