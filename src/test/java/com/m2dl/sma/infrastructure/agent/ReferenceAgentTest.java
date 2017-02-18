package com.m2dl.sma.infrastructure.agent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
<<<<<<< HEAD
=======
import static org.junit.Assert.assertFalse;
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReferenceAgentTest {

    @Test
    public void devrais_reconnaitre_deux_reference_differentes() throws Exception {
        ReferenceAgent premiereReferenceAgent = new ReferenceAgent();
        ReferenceAgent secondeReferenceAgent = new ReferenceAgent();

        assertThat(premiereReferenceAgent, not(equalTo(secondeReferenceAgent)));
    }

    @Test
<<<<<<< HEAD
=======
    public void devrais_retourner_false_si_null() throws Exception {
        ReferenceAgent premiereReferenceAgent = new ReferenceAgent();

        assertFalse(premiereReferenceAgent.equals(null));
    }

    @Test
    public void devrais_retourner_false_si_autre_type() throws Exception {
        ReferenceAgent premiereReferenceAgent = new ReferenceAgent();

        assertFalse(premiereReferenceAgent.equals(new String()));
    }

    @Test
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    public void devrais_reconnaitre_deux_reference_egales() throws Exception {
        ReferenceAgent referenceAgent = new ReferenceAgent();

        assertThat(referenceAgent, equalTo(referenceAgent));
    }

    @Test
    public void devrais_avoir_un_uuid_a_la_creation() throws Exception {
        ReferenceAgent referenceAgent = new ReferenceAgent();

        assertNotNull(referenceAgent.hashCode());
    }
}