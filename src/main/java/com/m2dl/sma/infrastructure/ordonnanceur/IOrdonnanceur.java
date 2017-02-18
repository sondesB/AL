package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
<<<<<<< HEAD
=======
import com.m2dl.sma.infrastructure.agent.Agent;

import java.util.List;
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332

public interface IOrdonnanceur {
    void ordonnancer();

    void changerVitesse(EnumVitesse vitesse);

    void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur);
<<<<<<< HEAD
=======

    List<Agent> arreterOrdonnancement();
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
}
