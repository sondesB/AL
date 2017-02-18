package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;

import com.m2dl.sma.infrastructure.agent.Agent;

import java.util.List;


public class Ordonnanceur implements IOrdonnanceur {

    private IStratOrdonnanceur stratOrdonnanceur;

    public Ordonnanceur(IStratOrdonnanceur stratOrdonnanceur){
        this.stratOrdonnanceur = stratOrdonnanceur;
    }

    @Override
    public void ordonnancer() {
        stratOrdonnanceur.ordonnancer();
    }

    @Override
    public void changerVitesse(EnumVitesse vitesse) {
        stratOrdonnanceur.changerVitesse(vitesse);
    }

    @Override
    public void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur) {

        this.stratOrdonnanceur = stratOrdonnanceur;
    }

    @Override
    public List<Agent> arreterOrdonnancement() {
        return stratOrdonnanceur.arreterOrdonnancement();
    }

}
