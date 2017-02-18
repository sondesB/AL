package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;

import com.m2dl.sma.infrastructure.agent.Agent;

import java.util.List;

public interface IOrdonnanceur {
    void ordonnancer();

    void changerVitesse(EnumVitesse vitesse);

    void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur);


    List<Agent> arreterOrdonnancement();

}
