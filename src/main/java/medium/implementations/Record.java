package medium.implementations;

import medium.interfaces.ListerAgents;
import medium.services.Enregistrement;
import stub.Agent;

import java.util.ArrayList;

/**
 * Record permet de stocker les agents disponibles.
 * La Sonde peut en effet déclarer les nouveaux agents et
 * les agents disparus via l'interface Enregistrement.
 */
public class Record implements ListerAgents, Enregistrement {

    /**
     * Liste des agents disponibles.
     */
    private ArrayList<Agent> agents;

    /**
     * Ajoute un agent disponible à la liste.
     *
     * @param agent nouvel agent
     */
    @Override
    public void addAgent(Agent agent) {
        this.agents.add(agent);
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
     * Retourne la liste des agents disponibles.
     *
     * @return liste des agents disponibles
     */
    @Override
    public ArrayList<Agent> getListAgents() {
        return this.agents;
    }
}
