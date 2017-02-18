package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
<<<<<<< HEAD

public interface IStratOrdonnanceur {
=======
import com.m2dl.sma.infrastructure.annuaire.AgentListener;

import java.util.List;

public interface IStratOrdonnanceur extends AgentListener {
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    void ordonnancer();

    void changerVitesse(EnumVitesse vitesse);

<<<<<<< HEAD
    void arreterOrdonnancement();
=======
    List<Agent> arreterOrdonnancement();

    void addOrdonnaceurListener(OrdonnanceurListener ordonnanceurListener);
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
}
