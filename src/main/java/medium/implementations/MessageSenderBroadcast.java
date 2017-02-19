package medium.implementations;

import Agent.Agir.GenererMessage.Message.Annonce;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.ICommunication;
import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import unifieur.services.Matching;

import java.util.HashMap;
import java.util.Map;

/**
 * Version Broadcast de MessageSender.
 * L'annonce reçu via le Mediator est envoyé à toute
 * la liste des agents disponibles.
 */
public class MessageSenderBroadcast implements EnvAnnonce {

    private Matching matching;
    private ICommunication communication;

    /**
     * Envoi l'annonce "ann" à tous les agents de la map.
     *
     * @param agents map d'agents possible destinataire ainsi que leurs services
     * @param ann    annonce
     */
    @Override
    public void sendAnnonce(HashMap<ReferenceAgent, OCService> agents, Annonce ann) {
        for (Map.Entry<ReferenceAgent, OCService> agent : agents.entrySet()) {
            communication.diffuserMessage(agent.getKey(), ann);
        }
    }
}
