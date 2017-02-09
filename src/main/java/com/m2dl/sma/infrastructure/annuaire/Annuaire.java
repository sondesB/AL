package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.fabrique.IFabrique;

public interface Annuaire extends ICommunication, IFabrique {

    void ajouterListener(AnnuaireListener annuaireListener);

    void retirerListener(AnnuaireListener annuaireListener);
}
