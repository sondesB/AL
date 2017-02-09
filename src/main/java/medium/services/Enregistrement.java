package medium.services;

import interfaceswcomp.OCService;
import stub.Agent;

import java.util.List;

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
     * @param listeServices liste des services de l'agent
     */
    void addAgent(Agent agent, List<OCService> listeServices);

    /**
     * Signal la disparition d'un agent.
     *
     * @param agent agent disparu
     */
    void removeAgent(Agent agent);
}
