package com.m2dl.sma.infrastructure.annuaire;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.AgentNotFoundException;
import com.m2dl.sma.infrastructure.communication.MessageAgent;

public class AnnuaireImplTest {

    @Mock private AnnuaireListener annuaireListener;

    private Annuaire annuaire;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        annuaire = new AnnuaireImpl();
        annuaire.ajouterListener(annuaireListener);
    }

    @Test
    public void devrais_appeler_son_listener_quand_un_agent_est_ajoute() throws Exception {
        ReferenceAgent referenceAgent = new ReferenceAgent();

        annuaire.ajouterAgent(referenceAgent, buildAgent());

        verify(annuaireListener, times(1)).agentAjoute(eq(referenceAgent));
    }

    @Test
    public void devrais_appeler_son_listener_quand_un_agent_est_supprime() throws Exception {
        ReferenceAgent referenceAgent = new ReferenceAgent();
        annuaire.ajouterAgent(referenceAgent, buildAgent());


        annuaire.retirerAgent(referenceAgent);

        verify(annuaireListener, times(1)).agentRetire(eq(referenceAgent));
    }

    @Test
    public void devrais_pas_appeler_son_listener_quand_il_est_supprime() throws Exception {
        ReferenceAgent referenceAgent = new ReferenceAgent();
        annuaire.retirerListener(annuaireListener);

        annuaire.ajouterAgent(referenceAgent, buildAgent());

        verify(annuaireListener, times(0)).agentAjoute(any());
    }

    @Test(expected = AgentNotFoundException.class)
    public void devrais_throw_agent_not_found_exception_quand_on_envois_un_message_a_un_destinataire_inexistant()
            throws Exception {
        ReferenceAgent expediteur = new ReferenceAgent();
        annuaire.ajouterAgent(expediteur, buildAgent());

        annuaire.envoyerMessage(expediteur, new ReferenceAgent(), buildMessageAgent());
    }

    private void setUpEnvoyerMessage(MessageAgent messageAgent,
            ReferenceAgent destinataire) throws AgentNotFoundException {
        ReferenceAgent expediteur = new ReferenceAgent();

        annuaire.ajouterAgent(expediteur, buildAgent());
        annuaire.ajouterAgent(destinataire, buildAgent());

        annuaire.envoyerMessage(expediteur, destinataire, messageAgent);
    }

    @Test
    public void devrais_recevoir_un_message_quand_un_message_est_envoye() throws Exception {
        MessageAgent messageAgent = buildMessageAgent();
        ReferenceAgent destinataire = new ReferenceAgent();
        setUpEnvoyerMessage(messageAgent, destinataire);

        Optional<MessageAgent> messageAgentOptional = annuaire.recevoirMessage(destinataire);

        assertTrue(messageAgentOptional.isPresent());
        assertThat(messageAgentOptional.get(), equalTo(messageAgent));
    }

    @Test
    public void devrais_pas_recevoir_de_message_quand_un_message_a_deja_ete_lu() throws Exception {
        MessageAgent messageAgent = buildMessageAgent();
        ReferenceAgent destinataire = new ReferenceAgent();
        setUpEnvoyerMessage(messageAgent, destinataire);

        annuaire.recevoirMessage(destinataire);
        Optional<MessageAgent> messageAgentOptional = annuaire.recevoirMessage(destinataire);

        assertFalse(messageAgentOptional.isPresent());
    }

    @Test
    public void devrais_pas_lever_une_exception_lors_de_la_reception_de_message_pour_un_agent_inexistant()
            throws Exception {
        ReferenceAgent destinataire = new ReferenceAgent();

        annuaire.recevoirMessage(destinataire);
    }

    @Test
    public void devrais_pouvoir_diffuser_un_message_sans_exception_pendant_une_suppression()
            throws Exception {
        List<ReferenceAgent> referenceAgents = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            ReferenceAgent referenceAgent = new ReferenceAgent();
            referenceAgents.add(referenceAgent);
            annuaire.ajouterAgent(referenceAgent, buildAgent());
        }

        new Thread(() -> {
            for (int i = 1; i < 10000; i++) {
                annuaire.retirerAgent(referenceAgents.get(i));
            }
        }).start();
        for (int i = 0; i < 1000; i++) {
            annuaire.diffuserMessage(referenceAgents.get(0), buildMessageAgent());
        }
    }

    private Agent buildAgent() {
        return mock(Agent.class);
    }

    private MessageAgent buildMessageAgent() {
        return mock(MessageAgent.class);
    }
}