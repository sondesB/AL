package com.m2dl.sma.infrastructure.visualisation;


import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.etat.IEtat;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import visualisation.abstractvisualisation.AbstractVisualisation;
import visualisation.implementation.Visualisation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.MockitoAnnotations.initMocks;


/**
 * Created by MarS on 19/02/2017.
 */
public class AffichageTest {

    @Mock
    private IEtat etatInitial;

    private Agent agent;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        initMocks(this);

        agent = new Agent(etatInitial);
        System.setOut(new PrintStream(outContent));

    }

    @Test
    public void test_methode_afficher_ajout_agent() throws Exception {

        //Instanciation du composant Visualisation
        AbstractVisualisation.Component visu = new Visualisation().newComponent();

        visu.notification().agentAjoute(agent);


        assertThat(outContent.toString(), containsString("Agent"));
    }

}