package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;

public interface IOrdonnanceur {
    void ordonnancer();

    void changerVitesse(EnumVitesse vitesse);

    void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur);
}
