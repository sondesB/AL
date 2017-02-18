package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
<<<<<<< HEAD

public class StrategieClassique implements IStratOrdonnanceur {
    @Override
    public void ordonnancer() {

=======
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StrategieClassique implements IStratOrdonnanceur {

    private List<Agent> listOrdonnancement;
    private List<OrdonnanceurListener> listListenerPourOrdonnanceur;
    private int vitesse;
    private boolean run = true;

    public StrategieClassique(List<Agent> listAgents, List<OrdonnanceurListener> listListenerActuels){
        listOrdonnancement = listAgents;
        listListenerPourOrdonnanceur = listListenerActuels;
        changerVitesse(EnumVitesse.CENT);
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
        try {
            TimeUnit.MICROSECONDS.sleep(vitesse);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        etat.executer().ifPresent(iEtat -> cycleDeVie(agentCourantReference, iEtat));
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    }

    @Override
    public void changerVitesse(EnumVitesse vitesse) {
<<<<<<< HEAD

    }

    @Override
    public void arreterOrdonnancement() {

=======
        switch (vitesse){
            case CENT: this.vitesse = 10; break;
            case SOIXANTE_QUINZE: this.vitesse = 15; break;
            case CINQUANTE: this.vitesse = 20; break;
            case VINGT_CINQ: this.vitesse = 50; break;
            case DIX: this.vitesse = 100; break;
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
    }

    @Override
    public void agentRetire(Agent agent) {
        listOrdonnancement.remove(agent);
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    }
}
