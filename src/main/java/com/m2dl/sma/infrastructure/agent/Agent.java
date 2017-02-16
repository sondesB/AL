package com.m2dl.sma.infrastructure.agent;

import com.m2dl.sma.infrastructure.etat.IEtat;

public class Agent {
    private final ReferenceAgent referenceAgent;
    private final IEtat etatInitial;

    public Agent(IEtat etatInitial) {
        this.etatInitial = etatInitial;
        this.referenceAgent = new ReferenceAgent();

        this.etatInitial.setReferenceAgent(this.referenceAgent);
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }

    public IEtat getEtatInitial() {
        return etatInitial;
    }
}
