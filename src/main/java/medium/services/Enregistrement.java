package medium.services;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import interfaceswcomp.OCService;


/**
 * Interface Enregistrement. Service fourni par le Medium.
 * Permet à la Sonde de signaler au Medium l'arriver
 * ou la disparition d'un agent.
 */
public interface Enregistrement {

    /**
     * Signale l'arrivé d'un agent.
     *
     * @param RefAgent nouvel agent
     * @param service service de l'agent
     */
    void addAgent(ReferenceAgent RefAgent, OCService service);

    /**
     * Signal la disparition d'un agent.
     *
     * @param RefAgent agent disparu
     */
    void removeAgent(ReferenceAgent RefAgent);
}
