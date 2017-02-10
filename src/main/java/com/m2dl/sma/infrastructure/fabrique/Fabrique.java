package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.Annuaire;
import com.m2dl.sma.infrastructure.etat.IEtat;

public class Fabrique implements ICreationService, ISuicideService {

    private final Annuaire annuaire;

    public Fabrique(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    @Override
    public ReferenceAgent creer(IEtat etatInitial) {
        Agent agent = new Agent(etatInitial);

        etatInitial.setCommunication(annuaire);
        etatInitial.setSuicideService(this);

        annuaire.addAgent(agent);
        return agent.getReferenceAgent();
    }

    @Override
    public void seSuicider(ReferenceAgent referenceAgent) {
        annuaire.removeAgent(referenceAgent);
    }

}
