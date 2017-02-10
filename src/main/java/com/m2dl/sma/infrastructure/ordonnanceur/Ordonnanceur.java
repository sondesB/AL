package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;

public class Ordonnanceur implements IOrdonnanceur {

    private IStratOrdonnanceur stratOrdonnanceur;
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
        this.stratOrdonnanceur.arreterOrdonnancement();
        this.stratOrdonnanceur = stratOrdonnanceur;
    }
}
