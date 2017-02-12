package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StrategieEtatAEtat implements IStratOrdonnanceur {

    private List<Agent> listOrdonnancement;
    private List<OrdonnanceurListener> listListenerPourOrdonnanceur;
    private Map<Agent, IEtat> listEtatAgent;
    private int vitesse;
    private boolean run = true;

    public StrategieEtatAEtat(List<Agent> listAgent, List<OrdonnanceurListener> listListenerActuels){
        listOrdonnancement = listAgent;
        listListenerPourOrdonnanceur = listListenerActuels;
        listEtatAgent = new HashMap<>();
        listOrdonnancement.forEach(agent -> listEtatAgent.put(agent, agent.getEtatInitial()));
        changerVitesse(EnumVitesse.CENT);
    }

    @Override
    public void ordonnancer() {
        run = true;
        Agent agentCourant;
        IEtat etatCourant;
        while(run){
            agentCourant = listOrdonnancement.get(0);
            etatCourant = listEtatAgent.get(agentCourant);
            try {
                TimeUnit.MICROSECONDS.sleep(vitesse);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
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
        switch (vitesse){
            case CENT: this.vitesse = 10; break;
            case SOIXANTE_QUINZE: this.vitesse = 15; break;
            case CINQUANTE: this.vitesse = 20; break;
            case VINGT_CINQ: this.vitesse = 50; break;
            case DIX: this.vitesse = 100; break;
            default: this.vitesse = 10; break;
        }
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
