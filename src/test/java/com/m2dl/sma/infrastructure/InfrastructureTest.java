package com.m2dl.sma.infrastructure;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.Annuaire;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;
import com.m2dl.sma.infrastructure.etat.IEtat;
import com.m2dl.sma.infrastructure.fabrique.Fabrique;
import com.m2dl.sma.infrastructure.ordonnanceur.IStratOrdonnanceur;
import com.m2dl.sma.infrastructure.ordonnanceur.Ordonnanceur;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class InfrastructureTest {

    @Mock
    private Fabrique mockedFabrique;
    @Mock
    private Ordonnanceur mockedOrdonnanceur;
    @Mock
    private Annuaire mockedAnnuaire;

    private Infrastructure infrastructure;

    @Before
    public void setUp() {
        initMocks(this);
        infrastructure = new Infrastructure();
    }

    @Test
    public void devrais_appeler_se_suicider_de_fabrique() {
        Whitebox.setInternalState(infrastructure, "fabrique", mockedFabrique);

        ReferenceAgent agent = new ReferenceAgent();
        infrastructure.seSuicider(agent);

        verify(mockedFabrique, times(1)).seSuicider(eq(agent));
    }

    @Test
    public void devrais_appeler_ordonnancer_de_ordonnanceur() {
        Whitebox.setInternalState(infrastructure, "ordonnanceur", mockedOrdonnanceur);

        infrastructure.ordonnancer();

        verify(mockedOrdonnanceur, times(1)).ordonnancer();
    }

    @Test
    public void devrais_appeler_changerVitesse_de_ordonnanceur() {
        Whitebox.setInternalState(infrastructure, "ordonnanceur", mockedOrdonnanceur);

        EnumVitesse vitesse = EnumVitesse.CENT;
        infrastructure.changerVitesse(vitesse);

        verify(mockedOrdonnanceur, times(1)).changerVitesse(eq(vitesse));
    }

    @Test
    public void devrais_appeler_changerOrdonnancement_de_ordonnanceur() {
        Whitebox.setInternalState(infrastructure, "ordonnanceur", mockedOrdonnanceur);

        IStratOrdonnanceur stratOrdonnanceur = mock(IStratOrdonnanceur.class);
        infrastructure.changerOrdonnancement(stratOrdonnanceur);

        verify(mockedOrdonnanceur, times(1)).changerOrdonnancement(eq(stratOrdonnanceur));
    }

    @Test
    public void devrais_appeler_arreterOrdonnancement_de_ordonnanceur() {
        Whitebox.setInternalState(infrastructure, "ordonnanceur", mockedOrdonnanceur);

        IStratOrdonnanceur stratOrdonnanceur = mock(IStratOrdonnanceur.class);
        infrastructure.arreterOrdonnancement();

        verify(mockedOrdonnanceur, times(1)).arreterOrdonnancement();
    }

    @Test
    public void devrais_appeler_envoyerMessage_de_annuaire() {
        Whitebox.setInternalState(infrastructure, "annuaire", mockedAnnuaire);

        ReferenceAgent expediteur = new ReferenceAgent();
        ReferenceAgent destinataire = new ReferenceAgent();
        IMessageAgent messageAgent = mock(IMessageAgent.class);
        infrastructure.envoyerMessage(expediteur, destinataire, messageAgent);

        verify(mockedAnnuaire, times(1)).envoyerMessage(eq(expediteur), eq(destinataire), eq(messageAgent));
    }

    @Test
    public void devrais_appeler_diffuserMessage_de_annuaire() {
        Whitebox.setInternalState(infrastructure, "annuaire", mockedAnnuaire);

        ReferenceAgent expediteur = new ReferenceAgent();
        IMessageAgent messageAgent = mock(IMessageAgent.class);
        infrastructure.diffuserMessage(expediteur, messageAgent);

        verify(mockedAnnuaire, times(1)).diffuserMessage(eq(expediteur), eq(messageAgent));
    }

    @Test
    public void devrais_appeler_recevoirMessage_de_annuaire() {
        Whitebox.setInternalState(infrastructure, "annuaire", mockedAnnuaire);

        ReferenceAgent destinataire = new ReferenceAgent();
        infrastructure.recevoirMessage(destinataire);

        verify(mockedAnnuaire, times(1)).recevoirMessage(eq(destinataire));
    }

    @Test
    public void devrais_appeler_creer_de_fabrique() {
        Whitebox.setInternalState(infrastructure, "fabrique", mockedFabrique);

        IEtat etatInitial= mock(IEtat.class);
        infrastructure.creer(etatInitial);

        verify(mockedFabrique, times(1)).creer(eq(etatInitial));
    }
}