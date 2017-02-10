package medium.services;

import interfaceswcomp.OCService;
import stub.Agent;


/**
 * Interface Enregistrement. Service fourni par le Medium.
 * Permet à la Sonde de signaler au Medium l'arriver
 * ou la disparition d'un agent.
 */
public interface Enregistrement {

    /**
     * Signale l'arrivé d'un agent.
     *
     * @param agent nouvel agent
     * @param service service de l'agent
     */
    void addAgent(Agent agent, OCService service);

    /**
     * Signal la disparition d'un agent.
     *
     * @param agent agent disparu
     */
    void removeAgent(Agent agent);
}
