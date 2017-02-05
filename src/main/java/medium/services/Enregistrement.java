package medium.services;

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
     */
    void addAgent(Agent agent);

    /**
     * Signal la disparition d'un agent.
     *
     * @param agent agent disparu
     */
    void removeAgent(Agent agent);
}
