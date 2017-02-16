package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;

public interface OrdonnanceurListener {

    void changementEtat(ReferenceAgent referenceAgent, IEtat nouvelEtat);
}
