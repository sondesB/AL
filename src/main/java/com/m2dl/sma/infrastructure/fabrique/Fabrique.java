package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.annuaire.IGestionAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;

/**
 * Created by valentin Chevalier on 10/02/17.
 */
public class Fabrique implements ICreationService, ISuicideService {

    IGestionAgent gestionAgent;

    @Override
    public Agent creer(IEtat etatInitial) {
        Agent agent = new Agent(etatInitial);
        gestionAgent.addAgent(agent);
        return agent;
    }

    @Override
    public void seSuicider(Agent agent) {
        gestionAgent.removeAgent(agent);
    }

}
