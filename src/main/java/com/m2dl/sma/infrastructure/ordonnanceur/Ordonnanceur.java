package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
<<<<<<< HEAD
=======
import com.m2dl.sma.infrastructure.agent.Agent;

import java.util.List;
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332

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
<<<<<<< HEAD
        this.stratOrdonnanceur.arreterOrdonnancement();
        this.stratOrdonnanceur = stratOrdonnanceur;
    }
=======
        this.stratOrdonnanceur = stratOrdonnanceur;
    }

    @Override
    public List<Agent> arreterOrdonnancement() {
        return stratOrdonnanceur.arreterOrdonnancement();
    }
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
}
