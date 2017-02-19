package medium.interfaces;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import interfaceswcomp.OCService;

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
    HashMap<ReferenceAgent, OCService> getListAgents();
}
