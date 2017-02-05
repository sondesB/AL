package medium.implementations;

import medium.interfaces.EnvAnnonce;
import stub.Agent;
import stub.Annonce;
import stub.Communication;
import unifieur.services.Matching;

import java.util.ArrayList;

/**
 * Version Broadcast de MessageSender.
 * L'annonce reçu via le Mediator est envoyé à toute
 * la liste des agents disponibles.
 */
public class MessageSenderBroadcast implements EnvAnnonce {

    private Matching matching;
    private Communication communication;

    /**
     * Envoi l'annonce "ann" à tous les agents dans listAgents.
     *
     * @param listAgents liste d'agents possible destinataire
     * @param ann        annonce
     */
    @Override
    public void sendAnnonce(ArrayList<Agent> listAgents, Annonce ann) {
        for (Agent agent : listAgents) {
            communication.envoiSimple(ann, agent);
        }
    }
}
