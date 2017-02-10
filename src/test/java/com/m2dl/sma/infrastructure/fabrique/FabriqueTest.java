package com.m2dl.sma.infrastructure.fabrique;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IGestionAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.etat.IEtat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FabriqueTest {

    @Mock
    private IGestionAgent gestionAgent;
    @Mock
    private ICommunication communication;
    @Mock
    private ISuicideService suicideService;

    private Fabrique fabrique;

    @Before
    public void setUp() {
        initMocks(this);

        fabrique = new Fabrique(gestionAgent, communication, suicideService);
    }

    @Test
    public void devrais_appeler_setCommunication_etat_dans_creer() throws Exception {
        IEtat etat = mock(IEtat.class);
        fabrique.creer(etat);

        verify(etat, times(1)).setCommunication(eq(communication));
    }

    @Test
    public void devrais_appeler_setSuicideService_etat_dans_creer() throws Exception {
        IEtat etat = mock(IEtat.class);
        fabrique.creer(etat);

        verify(etat, times(1)).setSuicideService(eq(suicideService));
    }

    @Test
    public void devrais_appeler_addAgent_gestionAgent_dans_creer() throws Exception {
        IEtat etat = mock(IEtat.class);
        fabrique.creer(etat);

        verify(gestionAgent, times(1)).addAgent(any());
    }

    @Test
    public void devrais_appeler_removeAgent_gestionAgent_dans_seSuicider() throws Exception {
        Agent agent = mock(Agent.class);
        fabrique.seSuicider(agent);

        verify(gestionAgent, times(1)).removeAgent(agent);
    }

}