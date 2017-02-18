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
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======
import com.m2dl.sma.infrastructure.etat.IEtat;
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
<<<<<<< HEAD
import com.m2dl.sma.infrastructure.communication.MessageAgent;
=======
import com.m2dl.sma.infrastructure.communication.IMessageAgent;
import org.mockito.internal.util.reflection.Whitebox;
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332

public class AnnuaireImplTest {

    @Mock private AgentListener agentListener;
<<<<<<< HEAD

    private Annuaire annuaire;
=======
    @Mock private ReferenceAgentListener referenceAgentListener;

    private AnnuaireImpl annuaire;
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        annuaire = new AnnuaireImpl();
        annuaire.ajouterAgentListener(agentListener);
    }

    @Test
    public void devrais_appeler_son_listener_quand_un_agent_est_ajoute() throws Exception {
        Agent agent = buildAgent();

        annuaire.addAgent(agent);

        verify(agentListener, times(1)).agentAjoute(eq(agent));
    }

    @Test
    public void devrais_appeler_son_listener_quand_un_agent_est_supprime() throws Exception {
        Agent agent = buildAgent();
        annuaire.addAgent(agent);

<<<<<<< HEAD
        annuaire.removeAgent(agent);
=======
        annuaire.removeAgent(agent.getReferenceAgent());
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332

        verify(agentListener, times(1)).agentRetire(eq(agent));
    }

    @Test
    public void devrais_pas_appeler_son_listener_quand_il_est_supprime() throws Exception {
        annuaire.retirerAgentListener(agentListener);
<<<<<<< HEAD

        annuaire.addAgent(buildAgent());
=======
        Agent agent = buildAgent();

        annuaire.addAgent(agent);
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332

        verify(agentListener, times(0)).agentAjoute(any());
    }

<<<<<<< HEAD
    private void setUpEnvoyerMessage(MessageAgent messageAgent, Agent destinataire) {

        Agent premierAgent = buildAgent();
        annuaire.addAgent(premierAgent);
        annuaire.addAgent(destinataire);

        annuaire.envoyerMessage(premierAgent.getReferenceAgent(), destinataire.getReferenceAgent(),
                messageAgent);
    }

    @Test
    public void devrais_recevoir_un_message_quand_un_message_est_envoye() throws Exception {
        MessageAgent messageAgent = buildMessageAgent();
        Agent destinataire = buildAgent();
        setUpEnvoyerMessage(messageAgent, destinataire);

        Optional<MessageAgent> messageAgentOptional = annuaire.recevoirMessage(
                destinataire.getReferenceAgent());

        assertTrue(messageAgentOptional.isPresent());
        assertThat(messageAgentOptional.get(), equalTo(messageAgent));
=======
    @Test
    public void devrais_recevoir_un_message_quand_un_message_est_envoye() throws Exception {
        IMessageAgent IMessageAgent = buildMessageAgent();
        Agent destinataire = buildAgent();
        setUpEnvoyerMessage(IMessageAgent, destinataire);

        Optional<IMessageAgent> messageAgentOptional = annuaire.recevoirMessage(
                destinataire.getReferenceAgent());

        assertTrue(messageAgentOptional.isPresent());
        assertThat(messageAgentOptional.get(), equalTo(IMessageAgent));
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    }

    @Test
    public void devrais_pas_recevoir_de_message_quand_un_message_a_deja_ete_lu() throws Exception {
<<<<<<< HEAD
        MessageAgent messageAgent = buildMessageAgent();
=======
        IMessageAgent messageAgent = buildMessageAgent();
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
        Agent destinataire = buildAgent();
        setUpEnvoyerMessage(messageAgent, destinataire);

        annuaire.recevoirMessage(destinataire.getReferenceAgent());
<<<<<<< HEAD
        Optional<MessageAgent> messageAgentOptional = annuaire.recevoirMessage(
=======
        Optional<IMessageAgent> messageAgentOptional = annuaire.recevoirMessage(
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
                destinataire.getReferenceAgent());

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
<<<<<<< HEAD
        List<Agent> agents = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Agent agent = buildAgent();
            agents.add(agent);
=======
        List<ReferenceAgent> agents = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Agent agent = buildAgent();
            agents.add(agent.getReferenceAgent());
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
            annuaire.addAgent(agent);
        }

        new Thread(() -> {
            for (int i = 1; i < 10000; i++) {
                annuaire.removeAgent(agents.get(i));
            }
        }).start();
        for (int i = 0; i < 1000; i++) {
<<<<<<< HEAD
            annuaire.diffuserMessage(agents.get(0).getReferenceAgent(), buildMessageAgent());
        }
    }

=======
            annuaire.diffuserMessage(agents.get(0), buildMessageAgent());
        }
    }

    @Test
    public void devrais_appeler_add_de_messageAgentListeners() {
        List<MessageAgentListener> mockedMessageAgentListeners = mock(List.class);
        Whitebox.setInternalState(annuaire, "messageAgentListeners", mockedMessageAgentListeners);

        MessageAgentListener messageAgentListener = mock(MessageAgentListener.class);
        annuaire.ajouterMessageAgentListener(messageAgentListener);

        verify(mockedMessageAgentListeners, times(1)).add(eq(messageAgentListener));
    }

    @Test
    public void devrais_appeler_remove_de_messageAgentListeners() {
        List<MessageAgentListener> mockedMessageAgentListeners = mock(List.class);
        Whitebox.setInternalState(annuaire, "messageAgentListeners", mockedMessageAgentListeners);

        MessageAgentListener messageAgentListener = mock(MessageAgentListener.class);
        annuaire.retirerMessageAgentListener(messageAgentListener);

        verify(mockedMessageAgentListeners, times(1)).remove(eq(messageAgentListener));
    }

    @Test
    public void devrais_appeler_add_de_referenceAgentListeners() {
        List<ReferenceAgentListener> mockedReferenceAgentListeners = mock(List.class);
        Whitebox.setInternalState(annuaire, "referenceAgentListeners", mockedReferenceAgentListeners);

        ReferenceAgentListener referenceAgentListener = mock(ReferenceAgentListener.class);
        annuaire.ajouterReferenceAgentListener(referenceAgentListener);

        verify(mockedReferenceAgentListeners, times(1)).add(eq(referenceAgentListener));
    }

    @Test
    public void devrais_appeler_remove_de_referenceAgentListeners() {
        List<ReferenceAgentListener> mockedReferenceAgentListeners = mock(List.class);
        Whitebox.setInternalState(annuaire, "referenceAgentListeners", mockedReferenceAgentListeners);

        ReferenceAgentListener referenceAgentListener = mock(ReferenceAgentListener.class);
        annuaire.retirerReferenceAgentListener(referenceAgentListener);

        verify(mockedReferenceAgentListeners, times(1)).remove(eq(referenceAgentListener));
    }

    @Test
    public void devrais_appeler_agentAjoute_de_tous_les_agentListeners() {
        ReferenceAgentListener referenceAgentListener1 = mock(ReferenceAgentListener.class);
        ReferenceAgentListener referenceAgentListener2 = mock(ReferenceAgentListener.class);

        Agent agent = buildAgent();

        annuaire.ajouterReferenceAgentListener(referenceAgentListener1);
        annuaire.ajouterReferenceAgentListener(referenceAgentListener2);
        annuaire.addAgent(agent);

        verify(referenceAgentListener1, times(1)).agentAjoute(any());
        verify(referenceAgentListener2, times(1)).agentAjoute(any());
    }

    @Test
    public void devrais_appeler_agentAjoute_de_tous_les_referenceAgentListeners() {
        AgentListener mockAgentListener1 = mock(AgentListener.class);
        AgentListener mockAgentListener2 = mock(AgentListener.class);

        Agent agent = buildAgent();

        annuaire.ajouterAgentListener(mockAgentListener1);
        annuaire.ajouterAgentListener(mockAgentListener2);
        annuaire.addAgent(agent);

        verify(mockAgentListener1, times(1)).agentAjoute(any());
        verify(mockAgentListener2, times(1)).agentAjoute(any());
    }

    @Test
    public void devrais_appeler_messageEnvoye_de_tous_les_messageAgentListeners() {

        MessageAgentListener mockMessageAgentListener1 = mock(MessageAgentListener.class);
        MessageAgentListener mockMessageAgentListener2 = mock(MessageAgentListener.class);

        Agent expediteur = new Agent(mock(IEtat.class));
        Agent destinataire = new Agent(mock(IEtat.class));
        IMessageAgent messageAgent = buildMessageAgent();

        annuaire.ajouterMessageAgentListener(mockMessageAgentListener1);
        annuaire.ajouterMessageAgentListener(mockMessageAgentListener2);
        setUpEnvoyerMessage(messageAgent, expediteur, destinataire);

        verify(mockMessageAgentListener1, times(1)).messageEnvoye(eq(expediteur.getReferenceAgent()), eq(destinataire.getReferenceAgent()), eq(messageAgent));
        verify(mockMessageAgentListener2, times(1)).messageEnvoye(eq(expediteur.getReferenceAgent()), eq(destinataire.getReferenceAgent()), eq(messageAgent));
    }

    @Test
    public void devrais_appeler_messageEnvoye_de_tous_les_messageAgentListeners_pour_notification() {

        MessageAgentListener mockMessageAgentListener1 = mock(MessageAgentListener.class);
        MessageAgentListener mockMessageAgentListener2 = mock(MessageAgentListener.class);

        ReferenceAgent expediteur = mock(ReferenceAgent.class);
        Agent destinataire = new Agent(mock(IEtat.class));
        annuaire.addAgent(destinataire);
        IMessageAgent messageAgent = buildMessageAgent();

        annuaire.ajouterMessageAgentListener(mockMessageAgentListener1);
        annuaire.ajouterMessageAgentListener(mockMessageAgentListener2);
        annuaire.diffuserMessage(expediteur, messageAgent);

        verify(mockMessageAgentListener1, times(1)).messageEnvoye(eq(expediteur), eq(destinataire.getReferenceAgent()), eq(messageAgent));
        verify(mockMessageAgentListener2, times(1)).messageEnvoye(eq(expediteur), eq(destinataire.getReferenceAgent()), eq(messageAgent));
    }

>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    private Agent buildAgent() {
        Agent agent = mock(Agent.class);
        when(agent.getReferenceAgent()).thenReturn(new ReferenceAgent());
        return agent;
    }

<<<<<<< HEAD
    private MessageAgent buildMessageAgent() {
        return mock(MessageAgent.class);
=======
    private IMessageAgent buildMessageAgent() {
        return mock(IMessageAgent.class);
    }

    private void setUpEnvoyerMessage(IMessageAgent messageAgent, Agent expediteur, Agent destinataire) {
        annuaire.addAgent(expediteur);
        annuaire.addAgent(destinataire);

        annuaire.envoyerMessage(expediteur.getReferenceAgent(), destinataire.getReferenceAgent(),
                messageAgent);
    }

    private void setUpEnvoyerMessage(IMessageAgent messageAgent, Agent destinataire) {

        Agent expediteur = buildAgent();
        annuaire.addAgent(expediteur);
        annuaire.addAgent(destinataire);

        annuaire.envoyerMessage(expediteur.getReferenceAgent(), destinataire.getReferenceAgent(),
                messageAgent);
>>>>>>> 710ad8f9961909014f7d03800a58e20b462cf332
    }
}