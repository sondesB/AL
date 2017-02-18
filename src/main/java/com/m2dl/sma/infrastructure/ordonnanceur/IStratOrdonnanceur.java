package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;

import com.m2dl.sma.infrastructure.annuaire.AgentListener;

import java.util.List;

public interface IStratOrdonnanceur extends AgentListener {

    void ordonnancer();

    void changerVitesse(EnumVitesse vitesse);


    List<Agent> arreterOrdonnancement();

    void addOrdonnaceurListener(OrdonnanceurListener ordonnanceurListener);

}
