package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class StrategieEtatAEtatTest {

    private StrategieEtatAEtat strategieEtatAEtat;

    @Mock
    private List<Agent> listOrdonnancement;
    @Mock
    private List<OrdonnanceurListener> listListenerPourOrdonnanceur;

    @Before
    public void setup() {
        initMocks(this);
        strategieEtatAEtat = new StrategieEtatAEtat(listOrdonnancement, listListenerPourOrdonnanceur);
    }

    @Test
    public void devrais_changer_la_vitesse() {
        assertEquals(Whitebox.getInternalState(strategieEtatAEtat, "vitesse"), 10);

        strategieEtatAEtat.changerVitesse(EnumVitesse.DIX);
        assertEquals(Whitebox.getInternalState(strategieEtatAEtat, "vitesse"), 100);

        strategieEtatAEtat.changerVitesse(EnumVitesse.VINGT_CINQ);
        assertEquals(Whitebox.getInternalState(strategieEtatAEtat, "vitesse"), 50);

        strategieEtatAEtat.changerVitesse(EnumVitesse.CINQUANTE);
        assertEquals(Whitebox.getInternalState(strategieEtatAEtat, "vitesse"), 20);

        strategieEtatAEtat.changerVitesse(EnumVitesse.SOIXANTE_QUINZE);
        assertEquals(Whitebox.getInternalState(strategieEtatAEtat, "vitesse"), 15);
    }

    @Test
    public void devrait_mettre_run_a_false_et_retourner_la_listOrdonnancement() {
        List<Agent> listeAgent = strategieEtatAEtat.arreterOrdonnancement();

        assertEquals(Whitebox.getInternalState(strategieEtatAEtat, "run"), false);
        assertEquals(listeAgent, listOrdonnancement);
    }

    @Test
    public void devrait_faire_appel_a_add_de_listListenerPourOrdonnanceur() {
        OrdonnanceurListener ordonnanceurListenerMock = mock(OrdonnanceurListener.class);
        strategieEtatAEtat.addOrdonnaceurListener(ordonnanceurListenerMock);

        verify(listListenerPourOrdonnanceur, times(1)).add(ordonnanceurListenerMock);
    }

    @Test
    public void devrait_ajouter_l_agent_dans_la_hashmap_listEtatAgent() {
        Agent agentMock = mock(Agent.class);
        strategieEtatAEtat.agentAjoute(agentMock);

        Map<Agent, IEtat> listEtatAgent = (Map) Whitebox.getInternalState(strategieEtatAEtat, "listEtatAgent");
        assertEquals(listEtatAgent.size(), 1);
        assertTrue(listEtatAgent.containsKey(agentMock));
    }

    @Test
    public void devrait_enlever_l_agent_de_la_hashmap_listEtatAgent() {
        Agent agentMock = mock(Agent.class);
        strategieEtatAEtat.agentAjoute(agentMock);
        strategieEtatAEtat.agentRetire(agentMock);

        Map<Agent, IEtat> listEtatAgent = (Map) Whitebox.getInternalState(strategieEtatAEtat, "listEtatAgent");
        assertEquals(listEtatAgent.size(), 0);
    }

    @Test
    public void devrait_envoyer_aucune_erreur_si_agent_non_dans_hashmap_listEtatAgent() {
        Agent agentMock = mock(Agent.class);
        strategieEtatAEtat.agentRetire(agentMock);

        Map<Agent, IEtat> listEtatAgent = (Map) Whitebox.getInternalState(strategieEtatAEtat, "listEtatAgent");
        assertEquals(listEtatAgent.size(), 0);
    }

    @Test
    public void devrait_faire_appel_a_add_de_listOrdonnancement() {
        Agent agentMock = mock(Agent.class);
        strategieEtatAEtat.agentAjoute(agentMock);

        verify(listOrdonnancement, times(1)).add(agentMock);
    }

    @Test
    public void devrait_faire_appel_a_remove_de_listOrdonnancement() {
        Agent agentMock = mock(Agent.class);
        strategieEtatAEtat.agentAjoute(agentMock);
        strategieEtatAEtat.agentRetire(agentMock);

        verify(listOrdonnancement, times(1)).remove(agentMock);
    }

    @Test
    public void devrait_faire_appel_a_remove_sans_erreur_si_agent_nest_pas_dans_listOrdonnancement() {
        Agent agentMock = mock(Agent.class);
        strategieEtatAEtat.agentRetire(agentMock);

        verify(listOrdonnancement, times(1)).remove(agentMock);
    }
}