package com.m2dl.sma.infrastructure.agent;

import com.m2dl.sma.infrastructure.etat.IEtat;

public abstract class Agent {
    private final ReferenceAgent referenceAgent;
    private final IEtat etatInitial;

    public Agent(IEtat etatInitial) {
        this.etatInitial = etatInitial;
        this.referenceAgent = new ReferenceAgent();
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }

    public IEtat getEtatInitial() {
        return etatInitial;
    }
}
