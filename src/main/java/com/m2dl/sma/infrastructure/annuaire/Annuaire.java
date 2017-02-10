package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.communication.ICommunication;

public interface Annuaire extends ICommunication, IGestionAgent {

    void ajouterListener(AnnuaireListener annuaireListener);

    void retirerListener(AnnuaireListener annuaireListener);
}
