package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.Agent;

public interface AgentListener {

    void agentAjoute(Agent agent);

    void agentRetire(Agent agent);
}
