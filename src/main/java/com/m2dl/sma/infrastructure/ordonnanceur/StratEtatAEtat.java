package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.List;
import java.util.Map;

public class StratEtatAEtat implements IStratOrdonnanceur {

    private Map<Agent, IEtat> etatAgent;
    private List<Agent> listeOrdonnancement;
    @Override
    public void ordonnancer() {

    }
}
