package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface IGestionAgent {

    void addAgent(Agent agent);

    void removeAgent(ReferenceAgent referenceAgent);
}
