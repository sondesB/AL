package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IGestionAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.etat.IEtat;

public class Fabrique implements ICreationService, ISuicideService {

    IGestionAgent gestionAgent;

    private final ICommunication communication;

    public Fabrique(IGestionAgent gestionAgent, ICommunication communication) {
        this.gestionAgent = gestionAgent;
        this.communication = communication;
    }

    @Override
    public ReferenceAgent creer(IEtat etatInitial) {
        Agent agent = new Agent(etatInitial);

        etatInitial.setCommunication(communication);
        etatInitial.setSuicideService(this);

        gestionAgent.addAgent(agent);
        return agent.getReferenceAgent();
    }

    @Override
    public void seSuicider(ReferenceAgent referenceAgent) {
        gestionAgent.removeAgent(referenceAgent);
    }

}
