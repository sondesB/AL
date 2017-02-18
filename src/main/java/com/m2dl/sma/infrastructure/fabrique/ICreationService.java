package com.m2dl.sma.infrastructure.fabrique;


import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;

public interface ICreationService {
    ReferenceAgent creer(IEtat etatInitial);

}
