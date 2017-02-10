package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StrategieEtatAEtat implements IStratOrdonnanceur {

    private List<Agent> listOrdonnancement;
    private Map<Agent, IEtat> listEtatAgent;
    private EnumVitesse vitesse;
    private boolean run = true;

    @Override
    public void ordonnancer() {
        run = true;
        Agent agentCourant;
        IEtat etatCourant;
        while(run){
            agentCourant = listOrdonnancement.get(0);
            etatCourant = listEtatAgent.get(agentCourant);
            changerEtatAgent(agentCourant, etatCourant.executer().orElseGet(agentCourant::getEtatInitial));
            listOrdonnancement.remove(agentCourant);
            listOrdonnancement.add(agentCourant);
        }
    }

    private void changerEtatAgent(Agent agentCourant, IEtat iEtat) {
        listEtatAgent.put(agentCourant, iEtat);
    }

    @Override
    public void changerVitesse(EnumVitesse vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public List<Agent> arreterOrdonnancement() {

        return listOrdonnancement;
    }

    @Override
    public void agentAjoute(Agent agent) {
        listOrdonnancement.add(agent);
        listEtatAgent.put(agent, agent.getEtatInitial());
    }

    @Override
    public void agentRetire(Agent agent) {
        listOrdonnancement.remove(agent);
        listEtatAgent.remove(agent);
    }
}
