package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;

public interface IStratOrdonnanceur {
    void ordonnancer();

    void changerVitesse(EnumVitesse vitesse);

    void arreterOrdonnancement();
}
