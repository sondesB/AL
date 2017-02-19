package medium.implementations;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import interfaceswcomp.OCService;
import medium.interfaces.ListerAgents;
import medium.services.Enregistrement;

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
    private HashMap<ReferenceAgent, OCService> agents = new HashMap<>();

    /**
     * Ajoute un agent disponible à la liste.
     *
     * @param agent nouvel agent
     * @param service service de l'agent
     */
    @Override
    public void addAgent(ReferenceAgent agent, OCService service) {
        this.agents.put(agent, service);
    }

    /**
     * Enléve l'agent "agent" de la liste des agents disponibles.
     *
     * @param agent agent disparu
     */
    @Override
    public void removeAgent(ReferenceAgent agent) {
        this.agents.remove(agent);
    }

    /**
     * Retourne la map des agents disponibles et leurs services associé.
     *
     * @return liste d'agents et services
     */
    @Override
    public HashMap<ReferenceAgent, OCService> getListAgents() {
        return this.agents;
    }
}
