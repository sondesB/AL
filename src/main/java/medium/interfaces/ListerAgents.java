package medium.interfaces;

import interfaceswcomp.OCService;
import stub.Agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Interface interne du Medium.
 */
public interface ListerAgents {

    /**
     * Retourne une map d'agents associé à leurs services.
     *
     * @return liste d'agents et services
     */
    HashMap<Agent, List<OCService>> getListAgents();
}
