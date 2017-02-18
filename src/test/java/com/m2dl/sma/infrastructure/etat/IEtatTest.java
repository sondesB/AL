package com.m2dl.sma.infrastructure.etat;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.fabrique.ISuicideService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class IEtatTest {

    private IEtat etat;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        etat =  mock(IEtat.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    public void devrait_instancier_etat() {
        class TestEtat extends IEtat {
            @Override
            public Optional<IEtat> executer() {
                return null;
            }
        }
        IEtat etat = new TestEtat();

        assertNull(etat.executer());
    }

    @Test
    public void devrais_recuperer_la_bonne_communication() throws Exception {
        ICommunication communication = mock(ICommunication.class);
        etat.setCommunication(communication);

        assertEquals(etat.getCommunication(), communication);
    }

    @Test
    public void devrais_recuperer_le_bon_suicide() throws Exception {
        ISuicideService suicide = mock(ISuicideService.class);
        etat.setSuicideService(suicide);

        assertEquals(etat.getSuicideService(), suicide);
    }

    @Test
    public void devrais_recuperer_le_bon_agent() throws Exception {
        ReferenceAgent agent = mock(ReferenceAgent.class);
        etat.setReferenceAgent(agent);

        assertEquals(etat.getReferenceAgent(), agent);
    }

}