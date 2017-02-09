package medium.implementations;

import interfaceswcomp.OCService;
import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
import unifieur.services.Matching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Version Broadcast de MessageSender.
 * L'annonce reçu via le Mediator est envoyé à toute
 * la liste des agents disponibles.
 */
public class MessageSenderBroadcast implements EnvAnnonce {

    private Matching matching;
    private Communication communication;

    /**
     * Envoi l'annonce "ann" à tous les agents de la map.
     *
     * @param agents map d'agents possible destinataire ainsi que leurs services
     * @param ann    annonce
     */
    @Override
    public void sendAnnonce(HashMap<Agent, List<OCService>> agents, Annonce ann) {
        for (Map.Entry<Agent, List<OCService>> agent : agents.entrySet()) {
            communication.envoiSimple(ann, agent.getKey());
        }
    }
}
