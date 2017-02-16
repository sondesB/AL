package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface ReferenceAgentListener {

    void agentAjoute(ReferenceAgent referenceAgent);

    void agentRetire(ReferenceAgent referenceAgent);
}
