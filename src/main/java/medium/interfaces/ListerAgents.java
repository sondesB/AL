package medium.interfaces;

import interfaceswcomp.OCService;
import stub.Agent;

import java.util.HashMap;

/**
 * Interface interne du Medium.
 */
public interface ListerAgents {

    /**
     * Retourne une map d'agents associé à leurs services.
     *
     * @return liste d'agents et services
     */
    HashMap<Agent, OCService> getListAgents();
}
