package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;

public interface Annuaire extends ICommunication {

    void ajouterAgent(ReferenceAgent referenceAgent, Agent agent);

    void retirerAgent(ReferenceAgent referenceAgent);

    void ajouterListener(AnnuaireListener annuaireListener);

    void retirerListener(AnnuaireListener annuaireListener);
}
