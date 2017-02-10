package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.communication.ICommunication;

public interface Annuaire extends ICommunication, IGestionAgent {

    void ajouterAgentListener(AgentListener agentListener);

    void retirerAgentListener(AgentListener agentListener);
}
