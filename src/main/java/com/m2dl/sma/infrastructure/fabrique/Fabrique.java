package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IGestionAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;

public class Fabrique implements ICreationService, ISuicideService {

    IGestionAgent gestionAgent;

    @Override
    public ReferenceAgent creer(IEtat etatInitial) {
        Agent agent = new Agent(etatInitial);
        gestionAgent.addAgent(agent);
        return agent.getReferenceAgent();
    }

    @Override
    public void seSuicider(Agent agent) {
        gestionAgent.removeAgent(agent);
    }

}
