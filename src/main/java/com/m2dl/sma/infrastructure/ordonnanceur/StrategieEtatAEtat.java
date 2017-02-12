package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategieEtatAEtat implements IStratOrdonnanceur {

    private List<Agent> listOrdonnancement;
    private List<OrdonnanceurListener> listListenerPourOrdonnanceur;
    private Map<Agent, IEtat> listEtatAgent;
    private EnumVitesse vitesse;
    private boolean run = true;

    public StrategieEtatAEtat(List<Agent> listAgent, List<OrdonnanceurListener> listListenerActuels){
        listOrdonnancement = listAgent;
        listListenerPourOrdonnanceur = listListenerActuels;
        listEtatAgent = new HashMap<>();
        listOrdonnancement.forEach(agent -> listEtatAgent.put(agent, agent.getEtatInitial()));
        vitesse = EnumVitesse.CENT;
    }

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
        listListenerPourOrdonnanceur.forEach(ordonnanceurListener -> ordonnanceurListener.changementEtat(agentCourant.getReferenceAgent(), iEtat));
        listEtatAgent.put(agentCourant, iEtat);
    }

    @Override
    public void changerVitesse(EnumVitesse vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public List<Agent> arreterOrdonnancement() {
        run = false;
        return listOrdonnancement;
    }

    @Override
    public void addOrdonnaceurListener(OrdonnanceurListener ordonnanceurListener) {
        listListenerPourOrdonnanceur.add(ordonnanceurListener);
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
