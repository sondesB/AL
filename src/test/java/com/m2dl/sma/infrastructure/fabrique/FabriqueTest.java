package com.m2dl.sma.infrastructure.fabrique;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import com.m2dl.sma.infrastructure.annuaire.Annuaire;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.annuaire.IGestionAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import com.m2dl.sma.infrastructure.etat.IEtat;

public class FabriqueTest {

    @Mock
    private Annuaire annuaire;
    @Mock
    private ICommunication communication;
    @Mock
    private ISuicideService suicideService;

    private Fabrique fabrique;

    @Before
    public void setUp() {
        initMocks(this);

        fabrique = new Fabrique(annuaire);
    }

    @Test
    public void devrais_appeler_setCommunication_etat_dans_creer() throws Exception {
        IEtat etat = mock(IEtat.class);
        fabrique.creer(etat);

        verify(etat, times(1)).setCommunication(eq(annuaire));
    }

    @Test
    public void devrais_appeler_setSuicideService_etat_dans_creer() throws Exception {
        IEtat etat = mock(IEtat.class);
        fabrique.creer(etat);

        verify(etat, times(1)).setSuicideService(eq(fabrique));
    }

    @Test
    public void devrais_appeler_addAgent_gestionAgent_dans_creer() throws Exception {
        IEtat etat = mock(IEtat.class);
        fabrique.creer(etat);

        verify(annuaire, times(1)).addAgent(any());
    }

    @Test
    public void devrais_appeler_removeAgent_gestionAgent_dans_seSuicider() throws Exception {
        ReferenceAgent referenceAgent = new ReferenceAgent();
        fabrique.seSuicider(referenceAgent);

        verify(annuaire, times(1)).removeAgent(referenceAgent);
    }

}