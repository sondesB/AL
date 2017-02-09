package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface ICreationService {
    void ajouterAgent(ReferenceAgent referenceAgent, Agent agent);
}
