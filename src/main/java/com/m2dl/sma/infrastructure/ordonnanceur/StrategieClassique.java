package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.ArrayList;
import java.util.List;

public class StrategieClassique implements IStratOrdonnanceur {

    private List<Agent> listOrdonnancement;
    private List<OrdonnanceurListener> listListenerPourOrdonnanceur;
    private EnumVitesse vitesse;
    private boolean run = true;

    public StrategieClassique(List<Agent> listAgents, List<OrdonnanceurListener> listListenerActuels){
        listOrdonnancement = listAgents;
        listListenerPourOrdonnanceur = listListenerActuels;
        vitesse = EnumVitesse.CENT;
    }

    @Override
    public void ordonnancer() {
        run = true;
        Agent agentCourant;
        while(run){
            agentCourant = listOrdonnancement.get(0);
            cycleDeVie(agentCourant.getReferenceAgent(), agentCourant.getEtatInitial());
            listOrdonnancement.remove(agentCourant);
            listOrdonnancement.add(agentCourant);
        }
    }

    private void cycleDeVie(ReferenceAgent agentCourantReference, IEtat etat) {
        listListenerPourOrdonnanceur.forEach(ordonnanceurListener -> ordonnanceurListener.changementEtat(agentCourantReference,etat));
        etat.executer().ifPresent(iEtat -> cycleDeVie(agentCourantReference, iEtat));
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
    }

    @Override
    public void agentRetire(Agent agent) {
        listOrdonnancement.remove(agent);
    }
}
