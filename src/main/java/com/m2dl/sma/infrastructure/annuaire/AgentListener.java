package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.Agent;

/**
 * Created by clement on 10/02/2017.
 */
public interface AgentListener {

    void agentAjoute(Agent agent);

    void agentRetire(Agent agent);
}
