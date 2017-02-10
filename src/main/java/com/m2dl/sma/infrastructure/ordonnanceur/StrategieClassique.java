package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.List;

public class StrategieClassique implements IStratOrdonnanceur {

    private List<Agent> listOrdonnancement;
    private EnumVitesse vitesse;
    private boolean run = true;
    
    @Override
    public void ordonnancer() {
        run = true;
        Agent agentCourant;
        while(run){
            agentCourant = listOrdonnancement.get(0);
            cycleDeVie(agentCourant);
            listOrdonnancement.remove(agentCourant);
            listOrdonnancement.add(agentCourant);
        }
    }

    private void cycleDeVie(Agent agentCourant) {
        IEtat etat = agentCourant.getEtatInitial();
        executerEtat(etat);
    }

    private void executerEtat(IEtat etat) {
        etat.executer().ifPresent(this::executerEtat);
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
    public void agentAjoute(Agent agent) {
        listOrdonnancement.add(agent);
    }

    @Override
    public void agentRetire(Agent agent) {
        listOrdonnancement.remove(agent);
    }
}
