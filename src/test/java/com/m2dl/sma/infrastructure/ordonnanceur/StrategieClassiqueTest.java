package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class StrategieClassiqueTest {

    private StrategieClassique strategieClassique;

    @Mock
    private List<Agent> listOrdonnancement;
    @Mock
    private List<OrdonnanceurListener> listListenerPourOrdonnanceur;

    @Before
    public void setup() {
        initMocks(this);
        strategieClassique = new StrategieClassique(listOrdonnancement, listListenerPourOrdonnanceur);
    }

    @Test
    public void devrais_changer_la_vitesse() {
        EnumVitesse vitesse = EnumVitesse.CINQUANTE;

        assertEquals(Whitebox.getInternalState(strategieClassique, "vitesse"), 10);

        strategieClassique.changerVitesse(vitesse);
        assertEquals(Whitebox.getInternalState(strategieClassique, "vitesse"), 20);
    }

    @Test
    public void devrait_faire_appel_a_add_de_listListenerPourOrdonnanceur() {
        OrdonnanceurListener ordonnanceurListenerMock = mock(OrdonnanceurListener.class);
        strategieClassique.addOrdonnaceurListener(ordonnanceurListenerMock);

        verify(listListenerPourOrdonnanceur, times(1)).add(ordonnanceurListenerMock);
    }

    @Test
    public void devrait_faire_appel_a_add_de_listOrdonnancement() {
        Agent agentMock = mock(Agent.class);
        strategieClassique.agentAjoute(agentMock);

        verify(listOrdonnancement, times(1)).add(agentMock);
    }

    @Test
    public void devrait_faire_appel_a_remove_de_listOrdonnancement() {
        Agent agentMock = mock(Agent.class);
        strategieClassique.agentAjoute(agentMock);
        strategieClassique.agentRetire(agentMock);

        verify(listOrdonnancement, times(1)).remove(agentMock);
    }

    @Test
    public void devrait_faire_appel_a_remove_sans_erreur_si_agent_nest_pas_dans_listOrdonnancement() {
        Agent agentMock = mock(Agent.class);
        strategieClassique.agentRetire(agentMock);

        verify(listOrdonnancement, times(1)).remove(agentMock);
    }

    @Test
    public void devrait_mettre_run_a_false_et_retourner_la_listOrdonnancement() {
        List<Agent> listeAgent = strategieClassique.arreterOrdonnancement();

        assertEquals(Whitebox.getInternalState(strategieClassique, "run"), false);
        assertEquals(listeAgent, listOrdonnancement);
    }
}