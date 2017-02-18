package com.m2dl.sma.infrastructure.ordonnanceur;

import com.m2dl.sma.infrastructure.EnumVitesse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrdonnanceurTest {
    @Mock
    private IStratOrdonnanceur strat;
    private Ordonnanceur ordonnaceur;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        ordonnaceur = new Ordonnanceur(strat);
    }

    @Test
    public void devrais_appeler_la_methode_ordonnancer_de_strategie() {
        ordonnaceur.ordonnancer();

        verify(strat, times(1)).ordonnancer();
    }

    @Test
    public void devrais_appeler_la_methode_changerVitesse_de_strategie() {
        EnumVitesse vitesse = EnumVitesse.VINGT_CINQ;
        ordonnaceur.changerVitesse(vitesse);

        verify(strat, times(1)).changerVitesse(eq(vitesse));
    }

    @Test
    public void devrais_arreter_l_ordonnancement() {
        ordonnaceur.arreterOrdonnancement();

        verify(strat, times(1)).arreterOrdonnancement();
    }

    @Test
    public void devrais_changer_la_strategie() {
        IStratOrdonnanceur istrat = mock(IStratOrdonnanceur.class);
        ordonnaceur.changerOrdonnancement(istrat);

        assertEquals(Whitebox.getInternalState(ordonnaceur, "stratOrdonnanceur"), istrat);
    }
}