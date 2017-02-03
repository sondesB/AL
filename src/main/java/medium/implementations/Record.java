package medium.implementations;

import medium.interfaces.ListerAgents;
import medium.services.Enregistrement;
import stub.Agent;

import java.util.ArrayList;

/**
 * Created by benja135 on 03/02/17.
 */
public class Record implements ListerAgents, Enregistrement {

    private ArrayList<Agent> agents;

    @Override
    public void addAgent(Agent agent) {
        this.agents.add(agent);
    }

    @Override
    public void removeAgent(Agent agent) {
        this.agents.remove(agent);
    }

    @Override
    public ArrayList<Agent> getListAgents() {
        return this.agents;
    }
}
