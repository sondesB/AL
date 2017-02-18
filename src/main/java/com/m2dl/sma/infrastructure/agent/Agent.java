package com.m2dl.sma.infrastructure.agent;

import com.m2dl.sma.infrastructure.etat.IEtat;

public class Agent {
    private final ReferenceAgent referenceAgent;
    private final IEtat etatInitial;

    public Agent(IEtat etatInitial) {
        this.etatInitial = etatInitial;
        this.referenceAgent = new ReferenceAgent();
<<<<<<< HEAD
=======

        this.etatInitial.setReferenceAgent(this.referenceAgent);
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    }

    public ReferenceAgent getReferenceAgent() {
        return referenceAgent;
    }

    public IEtat getEtatInitial() {
        return etatInitial;
    }
}
