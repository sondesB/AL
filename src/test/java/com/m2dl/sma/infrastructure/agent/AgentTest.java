package com.m2dl.sma.infrastructure.agent;

import com.m2dl.sma.infrastructure.etat.IEtat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AgentTest {
    @Mock
    private IEtat etatInitial;

    private Agent agent;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        agent = new Agent(etatInitial);
    }

    @Test
    public void devrais_faire_appel_a_setReferenceAgent_etatInitial(){
        verify(etatInitial).setReferenceAgent(any());
    }

    @Test
    public void devrais_retourner_un_reference_agent() {
        assertSame(agent.getReferenceAgent().getClass(), ReferenceAgent.class);
    }

    @Test
    public void devrais_retourner_l_etat_initial() {
        assertSame(agent.getEtatInitial(), etatInitial);
    }
}