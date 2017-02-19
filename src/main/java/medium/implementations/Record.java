package medium.implementations;

import interfaceswcomp.OCService;
import medium.interfaces.ListerAgents;
import medium.services.Enregistrement;
import stub.Agent;

import java.util.HashMap;

/**
 * Record permet de stocker les agents disponibles.
 * La Sonde peut en effet déclarer les nouveaux agents et
 * les agents disparus via l'interface Enregistrement.
 */
public class Record implements ListerAgents, Enregistrement {

    /**
     * Liste des agents disponibles associés à leurs services.
     */
    private HashMap<Agent, OCService> agents = new HashMap<>();

    /**
     * Ajoute un agent disponible à la liste.
     *
     * @param agent nouvel agent
     * @param service service de l'agent
     */
    @Override
    public void addAgent(Agent agent, OCService service) {
        this.agents.put(agent, service);
    }

    /**
     * Enléve l'agent "agent" de la liste des agents disponibles.
     *
     * @param agent agent disparu
     */
    @Override
    public void removeAgent(Agent agent) {
        this.agents.remove(agent);
    }

    /**
     * Retourne la map des agents disponibles et leurs services associé.
     *
     * @return liste d'agents et services
     */
    @Override
    public HashMap<Agent, OCService> getListAgents() {
        return this.agents;
    }
}
