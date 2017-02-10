package com.m2dl.sma.infrastructure;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.Annuaire;
import com.m2dl.sma.infrastructure.annuaire.AnnuaireImpl;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;
import com.m2dl.sma.infrastructure.fabrique.Fabrique;
import com.m2dl.sma.infrastructure.fabrique.ICreationService;
import com.m2dl.sma.infrastructure.fabrique.ISuicideService;
import com.m2dl.sma.infrastructure.ordonnanceur.IOrdonnanceur;
import com.m2dl.sma.infrastructure.ordonnanceur.IStratOrdonnanceur;
import com.m2dl.sma.infrastructure.ordonnanceur.Ordonnanceur;
import com.m2dl.sma.infrastructure.ordonnanceur.StrategieClassique;

import java.util.Optional;

public class Infrastructure implements ICreationService, ISuicideService, ICommunication, IOrdonnanceur {

    Fabrique fabrique;
    Ordonnanceur ordonnanceur;
    Annuaire annuaire;

    public Infrastructure() {
        ordonnanceur = new Ordonnanceur(new StrategieClassique());
        annuaire = new AnnuaireImpl();
        fabrique = new Fabrique(annuaire);
    }

    @Override
    public void seSuicider(ReferenceAgent agent) {
        fabrique.seSuicider(agent);
    }

    @Override
    public void ordonnancer() {
        ordonnanceur.ordonnancer();
    }

    @Override
    public void changerVitesse(EnumVitesse vitesse) {
        ordonnanceur.changerVitesse(vitesse);
    }

    @Override
    public void changerOrdonnancement(IStratOrdonnanceur stratOrdonnanceur) {
        ordonnanceur.changerOrdonnancement(stratOrdonnanceur);
    }

    @Override
    public void envoyerMessage(ReferenceAgent expediteur, ReferenceAgent destinataire, IMessageAgent IMessageAgent) {
        annuaire.envoyerMessage(expediteur, destinataire, IMessageAgent);
    }

    @Override
    public void diffuserMessage(ReferenceAgent expediteur, IMessageAgent IMessageAgent) {
        annuaire.diffuserMessage(expediteur, IMessageAgent);
    }

    @Override
    public Optional<IMessageAgent> recevoirMessage(ReferenceAgent destinataire) {
        return annuaire.recevoirMessage(destinataire);
    }

    @Override
    public ReferenceAgent creer(IEtat etatInitial) {
        return fabrique.creer(etatInitial);
    }
}
