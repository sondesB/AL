package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.Agent;

public interface IGestionAgent {

    void addAgent(Agent agent);

    void removeAgent(Agent agent);
}
